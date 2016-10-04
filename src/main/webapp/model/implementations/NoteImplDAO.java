package implementations;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import beans.Note;
import factories.INoteDAO;

public class NoteImplDAO implements INoteDAO{

	@Override
	public void add(Note note) throws DAOException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNoteStatus(int id, int status) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNoteFile(int id, String file) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Note> listUserNotes(int userId, Date date, int status) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Note> listUserNotesByStatus(int userId, int status) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteNote(int id) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNoteTodayDate(int id) throws DAOException {
		// TODO Auto-generated method stub
		
	}

}
