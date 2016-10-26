package com.company.springmvc.model.impls;

import com.company.springmvc.model.beans.Note;
import com.company.springmvc.model.connections.IConnectionDBDAO;
import com.company.springmvc.model.factories.DBConnectionFactory;
import com.company.springmvc.model.factories.QueryFactory;
import com.company.springmvc.model.interfaces.INoteDAO;
import com.company.springmvc.model.utils.NoteSQLQueriesEnum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by alt-hanny on 23.10.2016.
 */
public class NoteImplDAO implements INoteDAO {
    private IConnectionDBDAO connectionDAO = new DBConnectionFactory().getConnection();
    private QueryFactory queryFactory = new QueryFactory();

    private Note createNote(int id, int userId, String task,
                            java.sql.Date date, String file, int status) {
        return new Note(id, userId, task, date, file, status);
    }

    @Override
    public void add(Note note) throws DAOException, SQLException {
        String query = queryFactory.getNoteQuery(NoteSQLQueriesEnum.INSERT_NOTE.name());
        try (Connection connection = connectionDAO.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(0, note.getUserId());
            preparedStatement.setString(1, note.getTask());
            preparedStatement.setDate(2, note.getDate());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void setNoteStatus(int id, int status) throws DAOException {

    }

    @Override
    public void setNoteFile(int id, String file) throws DAOException {

    }

    @Override
    public List<Note> listUserNotes(int userId, Date date, int status) throws DAOException {
        return null;
    }

    @Override
    public List<Note> listUserNotesByStatus(int userId, int status) throws DAOException {
        return null;
    }

    @Override
    public void deleteNote(int id) throws DAOException {

    }

    @Override
    public void setNoteTodayDate(int id) throws DAOException {

    }


}
