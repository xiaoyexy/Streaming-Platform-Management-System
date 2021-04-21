//package edu.gatech.streamingwars.entity;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import java.sql.Date;
//
//@Entity
//@Table(name = "demographic_group")
//public class User {
//    // define fields
//
//    @Column(name = "first_name")
//    private String firstName;
//
//    @Column(name = "last_name")
//    private String lastName;
//
//    @Id
//    @Column(name = "email")
//    private String email;
//
//    @Column(name = "start_date")
//    private Date startDate;
//
//    @Column(name = "role")
//    private String role;
//
//    @Column(name = "phone_num")
//    private String phoneNum;
//
//    @Column(name = "password")
//    private String password;
//
//    // define constructors
//    public User() {
//
//    }
//
//    // define getter/setter
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public Date getStartDate() {
//        return startDate;
//    }
//
//    public void setStartDate(Date startDate) {
//        this.startDate = startDate;
//    }
//
//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }
//
//    public String getPhoneNum() {
//        return phoneNum;
//    }
//
//    public void setPhoneNum(String phoneNum) {
//        this.phoneNum = phoneNum;
//    }
//
//
//    // define toString
//
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", email='" + email + '\'' +
//                ", startDate=" + startDate +
//                ", role=" + role +
//                ", phoneNum='" + phoneNum + '\'' +
//                '}';
//    }
//}
