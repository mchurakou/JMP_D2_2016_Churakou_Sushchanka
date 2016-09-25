package main.java.beans;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by alt-hanny on 25.09.2016.
 */
public class User implements Serializable {
    private int id;
    private String firstName;
    private String lastName;
    private Timestamp birthday;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }
}
