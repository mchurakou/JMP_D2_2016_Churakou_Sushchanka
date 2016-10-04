package factories;

import implementations.DAOException;
import implementations.NoteImplDAO;

public class NoteFactory {
	public static INoteDAO getClassFromFactory() throws DAOException {
		return new NoteImplDAO();
	}
}
