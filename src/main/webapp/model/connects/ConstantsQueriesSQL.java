package connects;

public class ConstantsQueriesSQL {
	final static String CREATE_DB = "CREATE DATABASE IF NOT EXISTS module11";
	final static String CREATE_USERS_TABLE = "CREATE TABLE IF NOT EXISTS users (id INT AUTO_INCREMENT NOT NULL, login VARCHAR(250) NOT NULL, password VARCHAR(250) NOT NULL,"
			+ "PRIMARY KEY (id), UNIQUE INDEX id_unique (id ASC))";
	final static String CREATE_NOTES_TABLE = "CREATE TABLE IF NOT EXISTS notes (id INT AUTO_INCREMENT NOT NULL, userId INT NOT NULL REFERENCES users(id),"
			+ "message VARCHAR(250) NOT NULL, timestamp TIMESTAMP NOT NULL, status INT NOT NULL, file  VARCHAR(250), UNIQUE INDEX id_unique (id ASC) ) ";
}
