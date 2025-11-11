/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.model;

/**
 *
 * @author Admin
 */
public abstract class Customer {
    private String username;
    private String password;
    private String fullName;
    private String email;
    private String phone;
    private int id;
    private long cccd;
    private int codeCustomer;

    public Customer() {}


    public Customer(String username, String password, String fullName, String email, String phone, int id, long cccd, int codeCustomer) { // <--- ĐÃ SỬA
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.id = id;
        this.cccd = cccd;
        this.codeCustomer = codeCustomer;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public long getCccd() { // <--- ĐÃ SỬA
        return cccd;
    }


    public void setCccd(long cccd) { // <--- ĐÃ SỬA
        this.cccd = cccd;
    }

    public int getCodeCustomer() {
        return codeCustomer;
    }

    public void setCodeCustomer(int codeCustomer) {
        this.codeCustomer = codeCustomer;
    }
}