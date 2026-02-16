package com.example.integer;

public class User {

    private String login;
    private String password;
    private String lastName;
    private String firstName;
    private String middleName;
    private String birthDate;
    private String email;
    private String phone;

    public static User currentUser = new User("1", "1", "Чугунова",
            "Екатерина", "Дмитриевна", "21.04.2006",
            "dandelvan666@mail.ru", "89000000000");
    public User(String login,
                String password,
                String lastName,
                String firstName,
                String middleName,
                String birthDate,
                String email,
                String phone) {

        this.login = login;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.email = email;
        this.phone = phone;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

