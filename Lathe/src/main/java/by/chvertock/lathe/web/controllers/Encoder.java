package by.chvertock.lathe.web.controllers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encoder implements org.springframework.security.crypto.password.PasswordEncoder {

    private MessageDigest md;

    public String encode(CharSequence rawPassword) {

        try {
            md = MessageDigest.getInstance("SHA");
        } catch (NoSuchAlgorithmException e) {
            // TODO:log
            throw new RuntimeException(e);
        }

        if (md == null) {
            return rawPassword.toString();
        }

        md.update(rawPassword.toString().getBytes());

        byte byteData[] = md.digest();

        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < byteData.length; ++i) {
            String hex = Integer.toHexString(0xff & byteData[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }

        return hexString.toString();
    }

    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encode(rawPassword).equals(encodedPassword);
    }

//    public static void main(String[] args) {
//        Encoder encoder = new Encoder();
//
//        System.out.println(encoder.encode("admin"));
//        System.out.println(encoder.encode("user"));
//        System.out.println(encoder.encode("manager"));
//    }
}
