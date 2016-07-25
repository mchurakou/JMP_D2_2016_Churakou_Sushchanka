package com.company.person.services;

/**
 * Created by alt-hanny on 25.07.2016.
 */
enum QueriesEnum {
    CREATE_TABLE {
        @Override
        public String getQuery() {
            return "CREATE TABLE PERSON(ID INT, NAME VARCHAR(255), AGE INT);";
        }
    },
    GET_PERSON {
        @Override
        public String getQuery() {
            return "SELECT * FROM PERSON";
        }
    },
    SAVE_PERSON {
        @Override
        public String getQuery() {
            return "INSERT INTO person (id, name, age) VALUES (?,?,?)";
        }
    },
    GET_PERSON_BY_NAME {
        @Override
        public String getQuery() {
            return "SELECT * FROM person WHERE NAME = ?";
        }
    };

    public abstract String getQuery ();
}
