package api;

import org.apache.commons.lang3.RandomStringUtils;

public class User {
    private String email;
    private String password;
    private String name;

    public User (){
    }

    public User(String email, String password, String name){
        this.email = email;
        this.password = password;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static User randomUser() {
        final String email = RandomStringUtils.randomAlphanumeric(10) + "@mail.ru";
        final String password = RandomStringUtils.randomAlphanumeric(10);
        final String name = RandomStringUtils.randomAlphanumeric(10);
        return new User(email, password, name);
    }

    public static User forLogin(String email, String password) {
        return new User(email, password, null);
    }
}