package demoqa.utils;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

public class PandomUtils {

    public static void main(String[] args) {
        System.out.println(randomInt(10, 99));
        System.out.println(randomString(10));
        System.out.println(randomEmail());

        String[] names = {"a", "b", "c", "d", "e", "f", "g", "h"};
        System.out.println(randomItems(names));
    }

    public static int randomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String randomString(int length) {
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);
        for(int i = 0; i < length; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public static String randomEmail() {
        String usernameChars = "abcdefghijklmnopqrstuvwxyz-_";
        String domainChars = "abcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();

        StringBuilder username = new StringBuilder(10);
        for(int i = 0; i < username.capacity(); i++)
            username.append(usernameChars.charAt(rnd.nextInt(usernameChars.length())));

        StringBuilder domain = new StringBuilder(6);
        for(int i = 0; i < domain.capacity(); i++)
            domain.append(domainChars.charAt(rnd.nextInt(domainChars.length())));

        return username + "@" + domain + ".com";
    }

    public static String randomItems(String[] items) {
        int rndIndex = randomInt(0, items.length - 1);
        return items[rndIndex];
    }

}
