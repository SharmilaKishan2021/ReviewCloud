package com.eq.hrreview.services;

import com.eq.hrreview.models.User;
import com.eq.hrreview.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
@Service
public class MyUserDetailsService implements  UserDetailsService {
    @Autowired
    UserJpaRepository userJpaRepository;

    public User user=new User();

    public static String md5Password(String pass) {
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

    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        // User user=userJpaRepository.findByEmail("naren.parimi@gmail.com1");
        System.out.println("helloooooooooooooooo ..");
        try {
            user = userJpaRepository.findByEmail(userName);
            // return false;
        }
        catch (Exception e){

        }
        //System.out.println(user);
        // User user= (User) userDetailsService.loadUserByUsername(userName);// loadUserByUsername(userName);
        // return new User("jmohrman@kidwellinc.com","04b20be63db19c012dcba4b290e7ac4a",new ArrayList<>());
        return new MyUserDetails(user);
    }

    public User saveUserDetails(User user)
    {
        userJpaRepository.save(user);
        return userJpaRepository.findByEmail(user.getEmail());
    }
}
