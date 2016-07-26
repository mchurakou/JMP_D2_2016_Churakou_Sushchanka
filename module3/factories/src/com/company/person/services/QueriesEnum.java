package com.company.person.services;

/**
 * Created by alt-hanny on 25.07.2016.
 */
enum QueriesEnum {
    /** Creates the table in database, if the table not exists.*/
    CREATE_TABLE {
        @Override
        public String getQuery() {
            return "CREATE TABLE PERSON(ID INT, NAME VARCHAR(255), AGE INT);";
        }
    },
    /** Reads persons from database. */
    READ_PERSON {
        @Override
        public String getQuery() {
            return "SELECT * FROM PERSON";
        }
    },
    /** Writes the person fo database. */
    WRITE_PERSON {
        @Override
        public String getQuery() {
            return "INSERT INTO person (id, name, age) VALUES (?,?,?)";
        }
    },
    /** Reads the person from database by name. */
    READ_PERSON_BY_NAME {
        @Override
        public String getQuery() {
            return "SELECT * FROM person WHERE NAME = ?";
        }
    };
    /** Gets query. */
    public abstract String getQuery ();
}
