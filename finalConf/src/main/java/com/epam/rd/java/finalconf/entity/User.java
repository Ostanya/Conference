package com.epam.rd.java.finalconf.entity;

import java.util.Objects;

public class User {

    private long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;

    public User() {}

    public User(String username, String password, String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    private User(UBuilder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.password = builder.password;
        this.username = builder.username;
        this.role = builder.role;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static UBuilder builder() {
        return new UBuilder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                username.equals(user.username) &&
                firstName.equals(user.firstName) &&
                lastName.equals(user.lastName) &&
                email.equals(user.email) &&
                role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, firstName, lastName, email, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }

    public static class UBuilder{
        private long id;
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private String username;
        private Role role;


        public UBuilder withId(long id) {
            this.id = id;
            return this;
        }

        public UBuilder withUsername(String username) {
            this.username = username;
            return this;
        }

        public UBuilder withFirstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public UBuilder withSecondName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public UBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public UBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public UBuilder withRole(Role role) {
            this.role = role;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
