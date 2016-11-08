package com.company.springmvc.interfaces;

import com.company.springmvc.model.beans.Note;
import com.company.springmvc.impls.DAOException;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by alt-hanny on 23.10.2016.
 */
public interface INoteDAO {
    void add (Note note) throws DAOException, SQLException;
    void setNoteStatus(int id, int status) throws DAOException;
    void setNoteFile(int id, String file) throws DAOException;
    List<Note> listUserNotes(int userId, Date date, int status) throws DAOException;
    List<Note> listUserNotesByStatus(int userId, int status) throws DAOException;
    void deleteNote(int id) throws DAOException;
    void setNoteTodayDate(int id) throws DAOException;
}
