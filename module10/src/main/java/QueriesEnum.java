/**
 * Created by alt-hanny on 13.09.2016.
 */
public enum QueriesEnum {
    /** Creates database, if the database not exists.*/
    CREATE_DB {
        @Override
        public String getQuery() {
            return "CREATE DATABASE IF NOT EXISTS module10";
        }
    },
    DROP_TABLES {
        @Override
        public String getQuery() {
            return "DROP TABLE IF EXISTS users, friendships, posts, likes";
        }
    },
    CREATE_USERS_TABLE{
        @Override
        public String getQuery() {
            return "CREATE TABLE IF NOT EXISTS users (id INT AUTO_INCREMENT NOT NULL," +
                    "name VARCHAR(50) NOT NULL, surname VARCHAR(50) NOT NULL, " +
                    "birthdate Date NOT NULL, PRIMARY KEY (id))";
        }
    },
    CREATE_FRIENDSSHIPS_TABLE {
        @Override
        public String getQuery() {
            return "CREATE TABLE IF NOT EXISTS friendships (userId1 INT NOT NULL REFERENCES users(id)," +
                    "userId2 INT NOT NULL REFERENCES users(id), timestamp TIMESTAMP NOT NULL, PRIMARY KEY (userId1, userId2))";
        }
    },
    CREATE_POSTS_TABLE {
        @Override
        public String getQuery() {
            return "CREATE TABLE IF NOT EXISTS posts (id INT AUTO_INCREMENT NOT NULL," +
                    "userId INT NOT NULL, text VARCHAR(100) NOT NULL, timestamp TIMESTAMP NOT NULL, " +
                    "PRIMARY KEY (id))";
        }
    },
    CREATE_LIKES_TABLE {
        @Override
        public String getQuery() {
            return "CREATE TABLE IF NOT EXISTS likes (postId INT NOT NULL, userId INT NOT NULL, timestamp TIMESTAMP NOT NULL)";}
    },

    INSERT_USER {
        @Override
        public String getQuery() {
            return "INSERT INTO users (name, surname, birthdate) VALUES (?,?,?)";
        }
    },
    INSERT_FRIENDSHIP {
        @Override
        public String getQuery() {
            return "INSERT INTO friendships (userId1, userId2, timestamp) VALUES(?,?,?)";
        }
    },
    INSERT_POST {
        @Override
        public String getQuery() {
            return "INSERT INTO posts (userId, text, timestamp) VALUES(?,?,?)";
        }
    },
    INSERT_LIKE {
        @Override
        public String getQuery() {
            return "INSERT INTO likes (postId, userId, timestamp) VALUES (?,?,?)";
        }
    },
    RESULT_QUERY {
        @Override
        public String getQuery() {
            return " select * from \n" +
                    " (\n" +
                    "\tselect userLikes.user_id, userLikes.user_name, userLikes.user_surname, userLikes.likes_count, COUNT(userLikes.user_id) as friends_count \n" +
                    "\tfrom \n" +
                    "\t(\n" +
                    "\t\tselect u.id as user_id, u.name as user_name, u.surname as user_surname, \n" +
                    "\t\tCOUNT(u.id) as likes_count\n" +
                    "\t\tfrom posts as p\n" +
                    "\t\tinner join likes as l on l.postid = p.id\n" +
                    "\t\tinner join users as u on p.userId = u.id\n" +
                    "\t\twhere l.timestamp >= '2015-01-01 00:00:00' and l.timestamp <= '2015-12-31 23:59:59'\n" +
                    "\t\tgroup by u.id\n" +
                    "\t) as userLikes\n" +
                    "\tinner join friendships as f on f.userid1 = userLikes.user_id\n" +
                    "\tgroup by userLikes.user_id\n" +
                    " ) as result\n" +
                    " where result.likes_count > 20 and result.friends_count > 90\n" +
                    " order by result.likes_count desc, result.friends_count desc";
        }
    }
    ;
    /** Gets query. */
    public abstract String getQuery ();
}
