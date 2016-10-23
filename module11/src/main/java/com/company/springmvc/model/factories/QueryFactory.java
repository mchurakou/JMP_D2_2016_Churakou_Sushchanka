package com.company.springmvc.model.factories;

import com.company.springmvc.model.utils.TaskSQLQueriesEnum;
import com.company.springmvc.model.utils.UserSQLQueriesEnum;

/**
 * Created by alt-hanny on 23.10.2016.
 */
public class QueryFactory {
    public String getTaskQuery(String queryName) {
        TaskSQLQueriesEnum query = TaskSQLQueriesEnum.valueOf(queryName);
        return query.getQuery();
    }

    public String getUserQuery(String queryName) {
        UserSQLQueriesEnum query = UserSQLQueriesEnum.valueOf(queryName);
        return query.getQuery();
    }
}
