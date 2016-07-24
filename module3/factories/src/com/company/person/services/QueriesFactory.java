package com.company.person.services;

/**
 * Created by alt-hanny on 25.07.2016.
 */
public class QueriesFactory {
    public String getQuery (String queryName) throws IllegalArgumentException {
        QueriesEnum queryByName = QueriesEnum.valueOf(queryName);
        return queryByName.getQuery();
    }
}
