package com.company.springmvc.model.utils;

/**
 * Created by alt-hanny on 23.10.2016.
 */
public enum UserSQLQueriesEnum {
    QWER {
        @Override
        public String getQuery() {
            return null;
        }
    };

    public abstract String getQuery();
}
