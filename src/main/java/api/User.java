package api;
import com.github.javafaker.Faker;

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
        Faker faker = new Faker();
        final String email = faker.internet().emailAddress();
        final String password = faker.internet().password();
        final String name = faker.name().fullName();
        return new User(email, password, name);
    }

    public static User forLogin(String email, String password) {
        return new User(email, password, null);
    }
}