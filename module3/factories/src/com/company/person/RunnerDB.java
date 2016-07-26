package com.company.person;

import com.company.person.creators.PersonCreatorDBImpl;
import com.company.person.creators.PersonCreatorI;
import com.company.person.factories.PersonCreatorAbctractFactory;
import com.company.person.factories.PersonCreatorDBFactory;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Runner for the work with database.
 * Created by alt-hanny on 25.07.2016.
 */
public class RunnerDB {
    public static void main(String[] args) {
        PersonCreatorAbctractFactory creatorDBFactory = new PersonCreatorDBFactory();
        PersonCreatorDBImpl creatorDB = new PersonCreatorDBImpl();
        try {
            if (creatorDB.isTableExists()) {
                creatorDB.createTable();
            }
            PersonCreatorI personCreatorDB = creatorDBFactory.makePersonCreator();
            MainLogic.execute(personCreatorDB);
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
