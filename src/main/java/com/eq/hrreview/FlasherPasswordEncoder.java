package com.eq.hrreview;

//import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//@Component
public class FlasherPasswordEncoder {
        /*implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        String salt = "QxL0IOkvKA";
        String original = rawPassword + salt;
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return original;
        }
        md.update(original.getBytes());
        byte[] digest = md.digest();
        StringBuffer sbmd5 = new StringBuffer();
        for (byte b : digest) {
            sbmd5.append(String.format("%02x", b & 0xff));
        }
        //logger.info("Random password " + sbmd5.toString() + " generated");
        return sbmd5.toString();
        //return new Md5PasswordEncoder().encodePassword(rawPassword.toString(), AppConstants.MD5_PASSWORD_ENCODER_SALT);

    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        String salt = "QxL0IOkvKA";
        String original = rawPassword + salt;
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
           // return original;
        }
        md.update(original.getBytes());
        byte[] digest = md.digest();
        StringBuffer sbmd5 = new StringBuffer();
        for (byte b : digest) {
            sbmd5.append(String.format("%02x", b & 0xff));
        }
        return sbmd5.equals(encodedPassword);

        /*return new Md5PasswordEncoder().encodePassword(rawPassword.toString(), "QxL0IOkvKA")
                .equals(encodedPassword);*/
 //   }

/*    public static String md5Password(String pass) {
        String salt = "QxL0IOkvKA";
        String original = pass + salt;
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return pass;
        }
        md.update(original.getBytes());
        byte[] digest = md.digest();
        StringBuffer sbmd5 = new StringBuffer();
        for (byte b : digest) {
            sbmd5.append(String.format("%02x", b & 0xff));
        }
        //logger.info("Random password " + sbmd5.toString() + " generated");
        return sbmd5.toString();
    }
    public static boolean PasswordValidator(String password) {
        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).{8,15})";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }*/
}