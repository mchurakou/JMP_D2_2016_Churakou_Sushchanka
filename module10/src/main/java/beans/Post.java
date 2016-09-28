package beans;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by alt-hanny on 25.09.2016.
 */
public class Post implements Serializable {
    private int userId;
    private String text;
    private Timestamp timestamp;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder("Post: ");
        stringBuilder.append(" userId=").append(userId);
        stringBuilder.append(" text=").append(text);
        stringBuilder.append(" timestamp=").append(timestamp);
        return stringBuilder.toString();
    }
}
