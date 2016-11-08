package com.company.springmvc.impls;

import com.company.springmvc.model.beans.Note;
import com.company.springmvc.connections.IConnectionDBDAO;
import com.company.springmvc.factories.DBConnectionFactory;
import com.company.springmvc.factories.QueryFactory;
import com.company.springmvc.interfaces.INoteDAO;
import com.company.springmvc.utils.CalendarUtil;
import com.company.springmvc.utils.Constants;
import com.company.springmvc.utils.NoteSQLQueriesEnum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        String queryInsertNote = queryFactory.getNoteQuery(NoteSQLQueriesEnum.INSERT_NOTE.name());
        try (Connection connection = connectionDAO.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(queryInsertNote)) {
            preparedStatement.setInt(1, note.getUserId());
            preparedStatement.setString(2, note.getTask());
            preparedStatement.setDate(3, note.getDate());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException(Constants.ERROR_SQL);
        }
    }

    @Override
    public void setNoteStatus(int id, int status) throws DAOException {
        String queryUpdateNotesStatus = queryFactory.getNoteQuery(NoteSQLQueriesEnum.UPDATE_NOTES_STATUS.name());
        try (Connection connection = connectionDAO.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(queryUpdateNotesStatus)){
            preparedStatement.setInt(1, status);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException(Constants.ERROR_SQL);
        }
    }

    @Override
    public void setNoteFile(int id, String file) throws DAOException {
        String queryUpdateNotesFile = queryFactory.getNoteQuery(NoteSQLQueriesEnum.UPDATE_NOTES_FILE.name());
        try (Connection connection = connectionDAO.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(queryUpdateNotesFile)){
            preparedStatement.setString(1, file);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException(Constants.ERROR_SQL);
        }
    }

    @Override
    public List<Note> listUserNotes(int userId, Date date, int status) throws DAOException {
        List<Note> notesList = new ArrayList<>();
        java.sql.Date startTime = new java.sql.Date(CalendarUtil.createStartTime(date).getTime());
        java.sql.Date endTime = new java.sql.Date(CalendarUtil.createEndTime(
                date).getTime());
        String querySelectUserNotes = queryFactory.getNoteQuery(NoteSQLQueriesEnum.SELECT_NOTE.name());
        try (Connection connection = connectionDAO.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(querySelectUserNotes)) {
            preparedStatement.setInt(1, userId);
            preparedStatement.setDate(2, endTime);
            preparedStatement.setDate(3, startTime);
            preparedStatement.setInt(4, status);
            notesList.addAll(addNotesToList(preparedStatement, userId));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException(Constants.ERROR_SQL);
        }
        return notesList;
    }

    @Override
    public List<Note> listUserNotesByStatus(int userId, int status) throws DAOException {
        List<Note> notesList = new ArrayList<>();
        String querySelectUserNotesWithStatus = queryFactory.getNoteQuery(NoteSQLQueriesEnum.SELECT_NOTE_WITH_STATUS.name());
        try (Connection connection = connectionDAO.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(querySelectUserNotesWithStatus)) {
                preparedStatement.setInt(1, userId);
                preparedStatement.setInt(2, status);
                notesList.addAll(addNotesToList(preparedStatement, userId));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException(Constants.ERROR_SQL);
        }
        return notesList;
    }

    @Override
    public void deleteNote(int id) throws DAOException {
        String queryDeleteNote = queryFactory.getNoteQuery(NoteSQLQueriesEnum.DELETE_NOTE.name());
        try (Connection connection = connectionDAO.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(queryDeleteNote)){
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException(Constants.ERROR_SQL);
        }
    }

    @Override
    public void setNoteTodayDate(int id) throws DAOException {
        String queryUpdateNotesDate = queryFactory.getNoteQuery(NoteSQLQueriesEnum.UPDATE_NOTES_DATE.name());
        try (Connection connection = connectionDAO.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(queryUpdateNotesDate)){
            preparedStatement.setDate(1, new java.sql.Date(new java.util.Date().getTime()));
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException(Constants.ERROR_SQL);
        }
    }

    private List<Note> addNotesToList (PreparedStatement preparedStatement, int userId) throws DAOException {
        List<Note> notesList = new ArrayList<>();
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next() && resultSet != null) {
                int id = resultSet.getInt(Constants.KEY_ID);
                String rsTask = resultSet.getString(Constants.KEY_TASK);
                java.sql.Date rsDate = resultSet
                        .getDate(Constants.KEY_DATE_TASK);
                String rsFile = resultSet.getString(Constants.KEY_FILE);
                int rsStatus = resultSet.getInt(Constants.KEY_STATUS);
                notesList.add(createNote(id, userId, rsTask, rsDate, rsFile,
                        rsStatus));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException(Constants.ERROR_SQL);
        }
        return notesList;
    }


}
