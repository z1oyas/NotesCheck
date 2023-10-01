package Instuments;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class RandomIntGenerator {

    public static String intID(){
        int len = 5;
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder newString = new StringBuilder();
        for (int i = 0; i < len; i++)
        {
            int randomIndex = random.nextInt(chars.length());
            newString.append(chars.charAt(randomIndex));
        }
        return newString.toString();
    }
}
