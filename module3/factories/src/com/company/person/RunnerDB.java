package com.company.person;

import com.company.person.creators.PersonCreatorDB;
import com.company.person.creators.PersonCreatorI;
import com.company.person.factories.PersonCreatorAbctractFactory;
import com.company.person.factories.PersonCreatorDBFactory;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by alt-hanny on 25.07.2016.
 */
public class RunnerDB {
    public static void main(String[] args) {
        PersonCreatorAbctractFactory creatorDBFactory = new PersonCreatorDBFactory();
        PersonCreatorDB creatorDB = new PersonCreatorDB();
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
