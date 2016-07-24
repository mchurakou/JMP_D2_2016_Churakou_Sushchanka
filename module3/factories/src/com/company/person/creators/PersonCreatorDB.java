package com.company.person.creators;

import com.company.person.beans.Person;
import com.company.person.services.DBFactoryDAO;
import com.company.person.services.QueriesFactory;
import com.company.person.services.dbconnection.ConnectionDBImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by alt-hanny on 25.07.2016.
 */
public class PersonCreatorDB implements PersonCreater {
    private static final String GET_PERSON = "GET_PERSON";
    private static final String SAVE_PERSON = "SAVE_PERSON";
    private static final String GET_PERSON_BY_NAME = "GET_PERSON_BY_NAME";

    private ConnectionDBImpl connectionDAO = new DBFactoryDAO().getDAO();;
    private QueriesFactory queriesFactory = new QueriesFactory();

    public void writePerson(Person person) {

        Object lock = new Object();
        String query = queriesFactory.getQuery(SAVE_PERSON);

        try ( Connection connection = connectionDAO.getConnection();
              PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            synchronized (lock) {
                preparedStatement.setInt(1, person.getId());
                preparedStatement.setString(2, person.getName());
                preparedStatement.setInt(3, person.getAge());
                preparedStatement.executeUpdate();
            }
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

        person.setName(rs.getString("NAME"));
        person.setAge(rs.getInt("AGE"));

        return person;
    }
}
