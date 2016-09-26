import beans.Friendship;
import beans.Like;
import beans.Post;
import utils.RandomTextGenerator;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import static java.sql.Timestamp.valueOf;

/**
 * Created by alt-hanny on 14.09.2016.
 */
public class DBUtils {
    private static final int AMOUNT_USERS = 1000;

    public static Timestamp generateRandomTimastamp(String beginning, String ending ) {
        long offset = valueOf(beginning).getTime();
        long end = valueOf(ending).getTime();
        long diff = end - offset + 1;
        Timestamp randomTimestamp = new Timestamp(offset + (long)(Math.random() * diff));
        return randomTimestamp;
    }

    public static Date generateRandomDate(int beginning, int ending) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.set(GregorianCalendar.DAY_OF_YEAR, 1);
        calendar.set(GregorianCalendar.YEAR, beginning);
        long offset = calendar.getTimeInMillis();
        calendar.set(GregorianCalendar.DAY_OF_YEAR, 1);
        calendar.set(GregorianCalendar.YEAR, ending);
        long end = calendar.getTimeInMillis();
        long diff = end - offset + 1;
        Timestamp randomTimestamp = new Timestamp(offset + (long)(Math.random() * diff));
        return new Date(randomTimestamp.getTime());
    }

    public static List<Friendship> generateFriendships() {
        List<Friendship> friendshipsList = new ArrayList<>();
        for(int i = 1; i <= AMOUNT_USERS; i++) {
            for (int j = 1; j <= AMOUNT_USERS; j++) {
                if (i != j) {
                    Friendship friendship = new Friendship();
                    friendship.setUserId1(i);
                    friendship.setUserId2(j);
                    friendship.setTimestamp(generateRandomTimastamp("2010-01-01 00:00:00","2016-09-26 00:00:00"));
                    friendshipsList.add(friendship);
                }
            }
        }
        return friendshipsList;
    }
    
    public static List<Post> generatePosts() {
        List<Post> postsList = new ArrayList<>();
        String text = RandomTextGenerator.randomString(new Random().nextInt(100));
        for (int i = 1; i < AMOUNT_USERS; i++) {
            Post post = new Post();
            post.setUserId(i);
            post.setText(text);
            post.setTimestamp(DBUtils.generateRandomTimastamp("2010-01-01 00:00:00","2016-09-26 00:00:00"));
            postsList.add(post);
        }
        return postsList;
    }

    public static List<Like> generateLikes() {
        List<Like> likesList = new ArrayList<>();
        for (int i = 1; i < AMOUNT_USERS; i++) {
            for (int j = 1; j < AMOUNT_USERS; j++){
                if (i != j) {
                    Like like = new Like();
                    like.setPostId(i);
                    like.setUserId(j);
                    like.setTimestamp(DBUtils.generateRandomTimastamp("2010-01-01 00:00:00","2016-09-26 00:00:00"));
                    likesList.add(like);
                }
            }
        }
        return likesList;
    }

}
