package beans;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by alt-hanny on 25.09.2016.
 */
public class User implements Serializable {
    private int id;
    private String firstName;
    private String lastName;
    private Date birthday;

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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getLastName() {
        return lastName;

    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder("User: ");
        stringBuilder.append("id=").append(id);
        stringBuilder.append(" firstName=").append(firstName);
        stringBuilder.append(" lastName=").append(lastName);
        stringBuilder.append(" birthdate=").append(birthday);
        return stringBuilder.toString();
    }
}
