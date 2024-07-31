package com.example.orderEat.application.dto;

public class AccountRegistrationDto {
    private String name;
    private String account;
    private String password;
    private String role;

    public AccountRegistrationDto() {
    }

    public AccountRegistrationDto(String name, String account, String password, String role) {
        this.name = name;
        this.account = account;
        this.password = password;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
