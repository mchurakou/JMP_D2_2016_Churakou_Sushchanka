import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by alt-hanny on 12.10.2016.
 */
public class UserTest {
    @Test
    public void getFirstName() {
        String firstNameExpected = "Hanna";
        User user = new User();
        user.setFirstName("Hanna");
        Assert.assertEquals(firstNameExpected, user.getFirstName());
    }
}
