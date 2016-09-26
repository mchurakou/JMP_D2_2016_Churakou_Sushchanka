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
                    "name VARCHAR(250) NOT NULL, surname VARCHAR(250) NOT NULL, " +
                    "birthday Date NOT NULL, PRIMARY KEY (id), UNIQUE INDEX id_unique (id ASC))";
        }
    },
    CREATE_FRIENDSSHIPS_TABLE {
        @Override
        public String getQuery() {
            return "CREATE TABLE IF NOT EXISTS friendships (userId1 INT NOT NULL REFERENCES users(id)," +
                    "userId2 INT NOT NULL REFERENCES users(id), timestamp TIMESTAMP NOT NULL, PRIMARY KEY (userId1, userId2)," +
                    "UNIQUE INDEX userId1_unique (userId1 ASC))";
        }
    },
    CREATE_POSTS_TABLE {
        @Override
        public String getQuery() {
            return "CREATE TABLE IF NOT EXISTS posts (id INT AUTO_INCREMENT NOT NULL," +
                    "userId INT NOT NULL, text VARCHAR(1000) NOT NULL, timestamp TIMESTAMP NOT NULL, " +
                    "PRIMARY KEY (id), UNIQUE INDEX id_unique (id ASC))";
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
            return "INSERT INTO friendships (userId1, userId2, timestamp) SELECT DISTINCT id, id, ? FROM users";
        }
    };
    /** Gets query. */
    public abstract String getQuery ();
}
