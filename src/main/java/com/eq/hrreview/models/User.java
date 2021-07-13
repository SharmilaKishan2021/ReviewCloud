package com.eq.hrreview.models;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "users")
public class User implements Serializable {

   @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "fname")
    private String fname;

    @Column(name = "lname")
    private String lname;

    @Column(name = "job_title")
    private String job_title;

    @Column(name = "phone")
    private String phone;

    @Column(name = "employee_id")
    private String employee_id;

    @Column(name = "company_id")
    private String company_id;

    @Column(name = "company_name")
    private String company_name;

    @Column(name = "user_type", nullable = false)
    private String user_type;

    @Column(name = "joining_date")
    private Date joining_date;

    @Column(name = "address1")
    private String address1;

    @Column(name = "address2")
    private String address2;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Column(name = "zip")
    private String zip;

    @Column(name = "permission", nullable = false)
    private String permission;

    @Column(name = "branch_id")
    private String branch_id;

    @Column(name = "created")
    private Date created;

    @Column(name = "modified")
    private Date modified;

    @Column(name = "profile_pic_name")
    private String profilePicName;

    @Column(name = "welcome_email_sent_date")
    private Date welcomeEmailSentDate;

    @Column(name = "welcome_email_sent_by_user_id")
    private String welcomeEmailSentByUserId;

    @Column(name = "last_login")
    private Long lastLogin;

    @Column(name = "terms")
    private Long terms;

    @Transient
    private Date lastLoginDate;

    @Transient
    private String termsString;

    @Transient
    private boolean welcomeEmailSent = false;

    @Transient
    private boolean passwordNeedsReset = false;

    public User() { /* blank for JPA */ }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public Date getJoining_date() {
        return joining_date;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(String branch_id) {
        this.branch_id = branch_id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setJoining_date(Date joining_date) {
        this.joining_date = joining_date;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    /**
     * @return the lastLogin
     */
    public Long getLastLogin() {
        return lastLogin;
    }

    /**
     * @param lastLogin the lastLogin to set
     */
    public void setLastLogin(Long lastLogin) {
        this.lastLogin = lastLogin;
    }

    /**
     * @return the terms
     */
    public Long getTerms() {
        return terms;
    }

    /**
     * @param terms the terms to set
     */
    public void setTerms(Long terms) {
        this.terms = terms;
    }

    /**
     * @return the profilePicName
     */
    public String getProfilePicName() {
        return profilePicName;
    }

    /**
     * @param profilePicName the profilePicName to set
     */
    public void setProfilePicName(String profilePicName) {
        this.profilePicName = profilePicName;
    }

    public Date getLastLoginDate() {
        if (lastLogin != null) {
            DateTime dateTime = new DateTime(lastLogin, DateTimeZone.forOffsetHours(0));
            return dateTime.toDate();
        }
        return null;
    }


    public String getTermsString() {
        return termsString;
    }

    public boolean isWelcomeEmailSent() {
        return welcomeEmailSent;
    }

    public void setWelcomeEmailSent(boolean welcomeEmailSent) {
        this.welcomeEmailSent = welcomeEmailSent;
    }

    public boolean isPasswordNeedsReset() {
        return passwordNeedsReset;
    }

    public void setPasswordNeedsReset(boolean passwordNeedsReset) {
        this.passwordNeedsReset = passwordNeedsReset;
    }

    public void setTermsString(String termsString) {
        this.termsString = termsString;
    }

    public Date getWelcomeEmailSentDate() {
        return welcomeEmailSentDate;
    }

    public void setWelcomeEmailSentDate(Date welcomeEmailSentDate) {
        this.welcomeEmailSentDate = welcomeEmailSentDate;
    }

    public String getWelcomeEmailSentByUserId() {
        return welcomeEmailSentByUserId;
    }

    public void setWelcomeEmailSentByUserId(String welcomeEmailSentByUserId) {
        this.welcomeEmailSentByUserId = welcomeEmailSentByUserId;
    }

    public String getWelcomeEmailSentDateString() {
        if (this.welcomeEmailSentDate != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("MMM-dd-yyyy hh:mm:ss");
            return sdf.format(this.welcomeEmailSentDate);
        }
        return "";
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id='").append(id).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", fname='").append(fname).append('\'');
        sb.append(", lname='").append(lname).append('\'');
        sb.append(", job_title='").append(job_title).append('\'');
        sb.append(", company_id='").append(company_id).append('\'');
        sb.append(", company_name='").append(company_name).append('\'');
        sb.append(", user_type='").append(user_type).append('\'');
        sb.append(", welcomeEmail='").append(welcomeEmailSentDate).append('\'');
        sb.append('}');
        return sb.toString();
    }


    /**
     * Due to how some users have been processed, utilizing both
     * ID and email. Some accounts may not have an e-mail? All will
     * have an ID due to MySQL primary key setup.
     *
     * @param o Object.
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!id.equals(user.id)) return false;
        return email != null ? email.equals(user.email) : user.email == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
