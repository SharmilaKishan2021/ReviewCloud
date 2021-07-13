package com.eq.hrreview.services;

import com.eq.hrreview.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
@Service
public class MyUserDetails implements UserDetails {
    public String userName;
    public String password;
    public User user=new User();
    public MyUserDetails(String userName) {
        this.userName=userName;

    }
    public MyUserDetails(User user) {
        this.userName=user.getEmail();
        this.password=user.getPassword();
        this.user=user;
       /* this.userName=user.getFname();
        this.userName=user.getLname();
        this.userName=user.getAddress1();
        this.userName=user.getAddress2();
        this.userName=user.getCity();
        this.userName=user.getBranch_id();
        this.userName=user.getCompany_id();
        this.userName=user.getCompany_name();
        this.userName=user.getCountry();
        this.userName=user.getEmployee_id();
        this.userName=user.getJob_title();
        this.userName=user.getJoining_date();
        this.userName=user.getLastLogin();
        this.userName=user.getLastLoginDate();
        this.userName=user.getModified();
        this.userName=user.getPermission();
        this.userName=user.getPhone();
        this.userName=user.getProfilePicName();
        this.userName=user.getState();
        this.userName=user.getTermsString();
        this.userName=user.getTerms();
        this.userName=user.getUser_type();*/

    }
    public MyUserDetails() {
    }
    public User getUser(){
        return user;
    }
    public void setUser(User user){
        this.user=user;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

       return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
