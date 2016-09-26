package beans;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by alt-hanny on 25.09.2016.
 */
public class Like implements Serializable {
    private int userId;
    private int postId;
    private Timestamp timestamp;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder("Like: ");
        stringBuilder.append("userId=").append(userId);
        stringBuilder.append(" postId=").append(postId);
        stringBuilder.append(" timestamp=").append(timestamp);
        return stringBuilder.toString();
    }
}
