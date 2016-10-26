package com.company.springmvc.model.utils;

/**
 * Created by alt-hanny on 23.10.2016.
 */
public enum NoteSQLQueriesEnum {
    DELETE_NOTE {
        @Override
        public String getQuery() {
            return "DELETE FROM notes where id=?";
        }
    },
    INSERT_NOTE {
        @Override
        public String getQuery() {
            return "INSERT INTO notes (userId, task, date) VALUES (?,?,?)";
        }
    },
    SELECT_NOTE {
        @Override
        public String getQuery() {
            return "SELECT id, task, date, file, status FROM notes WHERE userId = ? AND date <= ? AND date >= ? and status = ?";
        }
    },
    SELECT_NOTE_WITH_STATUS {
        @Override
        public String getQuery() {
            return "SELECT * FROM notes WHERE userId = ? AND status = ?";
        }
    },
    UPDATE_NOTES_DATE {
        @Override
        public String getQuery() {
            return "UPDATE notes SET date=? WHERE id=?";
        }
    },
    UPDATE_NOTES_STATUS {
        @Override
        public String getQuery() {
            return "UPDATE notes SET status=? WHERE id=?";
        }
    },
    UPDATE_NOTES_FILE {
        @Override
        public String getQuery() {
            return "UPDATE notes SET file=? WHERE id=?";
        }
    };

    public abstract String getQuery();
}
