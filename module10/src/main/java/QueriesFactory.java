/**
 * Factory for the queries.
 * Created by alt-hanny on 25.07.2016.
 */
public class QueriesFactory {
    /**
     * Gets queries.
     * @param queryName Name of the query.
     * @return Query by the name.
     * @throws IllegalArgumentException
     */
         public String getQuery (String queryName) throws IllegalArgumentException {
        QueriesEnum queryByName = QueriesEnum.valueOf(queryName);
        return queryByName.getQuery();
    }
}
