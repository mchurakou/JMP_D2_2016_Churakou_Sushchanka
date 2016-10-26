package com.company.springmvc.model.utils;

/**
 * Created by alt-hanny on 23.10.2016.
 */
public enum NoteSQLQueriesEnum {

    INSERT_NOTE {
        @Override
        public String getQuery() {
            return "INSERT INTO notes (userId, task, date) VALUES (?,?,?)";
        }
    };

    public abstract String getQuery();
}
