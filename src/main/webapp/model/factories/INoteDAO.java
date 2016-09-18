package factories;

import java.sql.SQLException;
import java.util.List;

import beans.Note;
import implementations.DAOException;

public interface INoteDAO {
	void add(Note note) throws DAOException, SQLException;

	void setNoteStatus(int id, int status) throws DAOException;
	
	void setNoteFile (int id, String file) throws DAOException;

	List<Note> listUserNotes(int userId, java.util.Date date, int status) throws DAOException;
	
	List<Note> listUserNotesByStatus(int userId, int status) throws DAOException;
	
	void deleteNote(int id) throws DAOException;

	void setNoteTodayDate(int id) throws DAOException;

}
