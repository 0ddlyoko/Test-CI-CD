package me.oddlyoko.testcicd;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(macToSSID("20:0c:c8:25:1d:ed"));
        System.out.println(macToPassword("20:0c:c8:25:1d:ed"));
    }

    public static String macToSSID(String mac) throws NoSuchAlgorithmException {
        String mac2 = String.format("0x%s", mac.replace(":", "").toUpperCase(Locale.ENGLISH));
        byte[] md5 = md5(mac2);
        // Testeeee

        StringBuilder result = new StringBuilder("VOO-");
        for (int i = 0; i < 6; i++)
            result.append((md5[i] & 0xFF) % 10);
        return result.toString();
    }

    public static String macToPassword(String mac) throws NoSuchAlgorithmException {
        String mac2 = String.format("0x%s", mac.replace(":", "").toUpperCase(Locale.ENGLISH));
        byte[] md5 = md5(mac2);

        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < 8; i++) {
            int value = ((md5[5 + i] & 0xFF) % 26) + 'A';
            result.append((char) value);
        }
        return result.toString();
    }

    public static byte[] md5(String str) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(str.getBytes());
        return md.digest();
    }
}
