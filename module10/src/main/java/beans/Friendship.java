package beans;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by alt-hanny on 25.09.2016.
 */
public class Friendship implements Serializable {
    private int userId1;
    private int userId2;
    private Timestamp timestamp;

    public int getUserId1() {
        return userId1;
    }

    public void setUserId1(int userId1) {
        this.userId1 = userId1;
    }

    public int getUserId2() {
        return userId2;
    }

    public void setUserId2(int userId2) {
        this.userId2 = userId2;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder("Friendship: ");
        stringBuilder.append("userId1=").append(userId1);
        stringBuilder.append(" userId2=").append(userId2);
        stringBuilder.append(" timestamp=").append(timestamp);
        return  stringBuilder.toString();
    }
}

