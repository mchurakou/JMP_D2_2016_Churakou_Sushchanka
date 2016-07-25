package com.company.person.creators;

import com.company.person.beans.Person;
import com.company.person.services.DBFactoryDAO;
import com.company.person.services.QueriesFactory;
import com.company.person.services.dbconnection.ConnectionDBImpl;

import java.sql.*;

/**
 * Created by alt-hanny on 25.07.2016.
 */
public class PersonCreatorDB implements PersonCreatorI {
    private static final String GET_PERSON = "GET_PERSON";
    private static final String SAVE_PERSON = "SAVE_PERSON";
    private static final String GET_PERSON_BY_NAME = "GET_PERSON_BY_NAME";
    private static final String CREATE_TABLE = "CREATE_TABLE";

    private ConnectionDBImpl connectionDAO = new DBFactoryDAO().getDAO();
    private QueriesFactory queriesFactory = new QueriesFactory();

    public boolean isTableExists() throws SQLException {
        DatabaseMetaData meta = connectionDAO.getConnection().getMetaData();
        ResultSet resultSet = meta.getTables(null, null, "person", new String[] { "TABLE" });
        return resultSet.next() ? true : false;
    }

    public void createTable() throws SQLException {
        String query = queriesFactory.getQuery(CREATE_TABLE);
        try ( Connection connection = connectionDAO.getConnection();
              PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.executeUpdate();
        }
    }

    public void writePerson(Person person) {
        String query = queriesFactory.getQuery(SAVE_PERSON);

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

    public Person readPerson() {
        String query = queriesFactory.getQuery(GET_PERSON);
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

    public Person readPerson(String name) {
        String query = queriesFactory.getQuery(GET_PERSON_BY_NAME);

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

    private Person createPerson (ResultSet rs) throws SQLException {
        Person person = new Person();
        person.setId(rs.getInt("ID"));
        person.setName(rs.getString("NAME"));
        person.setAge(rs.getInt("AGE"));
        return person;
    }
}
