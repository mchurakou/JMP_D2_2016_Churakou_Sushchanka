package com.company.person.creators;

import com.company.person.beans.Person;
import com.company.person.constants.Constants;
import com.company.person.services.DBFactoryDAO;
import com.company.person.services.QueriesFactory;
import com.company.person.services.dbconnection.ConnectionDBImpl;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/**
 * Implements the creator with database.
 */
public class PersonCreatorDBImpl implements PersonCreatorI {
    /** Constant for the reading person query. */
    private static final String READ_PERSON = "READ_PERSON";
    /** Constant for the writing person query. */
    private static final String WRITE_PERSON = "WRITE_PERSON";
    /** Constant for the reading person by name query. */
    private static final String READ_PERSON_BY_NAME = "READ_PERSON_BY_NAME";
    /** Constant for the creating table query.*/
    private static final String CREATE_TABLE = "CREATE_TABLE";

    /** Gets connection. */
    private ConnectionDBImpl connectionDAO = new DBFactoryDAO().getDAO();
    /** Queries factory. */
    private QueriesFactory queriesFactory = new QueriesFactory();

    /**
     * Checks if the table exists.
     * @return false if table not exists.
     * @throws SQLException
     */
    public boolean isTableExists() throws SQLException {
        DatabaseMetaData meta = connectionDAO.getConnection().getMetaData();
        ResultSet resultSet = meta.getTables(null, null, "person", new String[] { "TABLE" });
        return resultSet.next() ? true : false;
    }

    /**
     * Creates table.
     * @throws SQLException
     */
    public void createTable() throws SQLException {
        String query = queriesFactory.getQuery(CREATE_TABLE);
        try (Connection connection = connectionDAO.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.executeUpdate();
        }
    }

    /**
     * Writes the person to database.
     * @param person Person.
     */
    public void writePerson(Person person) {
        String query = queriesFactory.getQuery(WRITE_PERSON);

        try ( Connection connection = connectionDAO.getConnection();
              PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, person.getId());
            preparedStatement.setString(2, person.getName());
            preparedStatement.setInt(3, person.getAge());
            preparedStatement.executeUpdate();
        } catch (SQLException | IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Reads the person from database.
     * @return Person.
     */
    public Person readPerson() {
        String query = queriesFactory.getQuery(READ_PERSON);
        Person person = null;
        try ( Connection connection = connectionDAO.getConnection();
              PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    person = createPerson(resultSet);
                }
            }
        } catch (SQLException | IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
        return person;
    }

    /**
     * Reads the person by name from database.
     * @param name Person's name.
     * @return Object Person.
     */
    public Person readPerson(String name) {
        String query = queriesFactory.getQuery(READ_PERSON_BY_NAME);

        Person person = null;

        try ( Connection connection = connectionDAO.getConnection();
              PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, name);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    person = createPerson(resultSet);
                }
            }
        } catch (SQLException | IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
        return person;
    }

    /**
     * Creates the person.
     * @param resultSet result set.
     * @return Person.
     * @throws SQLException
     */
    private Person createPerson (ResultSet resultSet) throws SQLException {
        Person person = new Person();
        person.setId(resultSet.getInt(Constants.PERSON_ID));
        person.setName(resultSet.getString(Constants.PERSON_NAME));
        person.setAge(resultSet.getInt(Constants.PERSON_AGE));
        return person;
    }
}
