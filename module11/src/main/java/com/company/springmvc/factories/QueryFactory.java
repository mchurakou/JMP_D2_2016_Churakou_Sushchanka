package com.company.springmvc.factories;

import com.company.springmvc.utils.NoteSQLQueriesEnum;
import com.company.springmvc.utils.UserSQLQueriesEnum;

/**
 * Created by alt-hanny on 23.10.2016.
 */
public class QueryFactory {
    public String getNoteQuery(String queryName) {
        NoteSQLQueriesEnum query = NoteSQLQueriesEnum.valueOf(queryName);
        return query.getQuery();
    }

    public String getUserQuery(String queryName) {
        UserSQLQueriesEnum query = UserSQLQueriesEnum.valueOf(queryName);
        return query.getQuery();
    }
}
