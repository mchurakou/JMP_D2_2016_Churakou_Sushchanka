package com.company.sushchanka.PowerMock;
import java.security.SecureRandom;

/**
 * Created by alt-hanny on 26.09.2016.
 */
public class RandomTextGenerator {
    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom random = new SecureRandom();

    public static String randomString(int length){
        StringBuilder sb = new StringBuilder(length);
        for(int i = 0; i < length; i++)
            sb.append(AB.charAt(random.nextInt(AB.length()) ) );
        return sb.toString();
    }
}
