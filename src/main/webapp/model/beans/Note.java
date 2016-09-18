package beans;

import java.io.Serializable;
import java.sql.Timestamp;

public class Note implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 201618091633L;
	
	private int id;
	private int userId;
	private String message;
	private int noteStatus;
	private byte[] image;
	private Timestamp date;
	
}
