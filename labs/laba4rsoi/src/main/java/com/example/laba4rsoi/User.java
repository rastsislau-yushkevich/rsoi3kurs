package com.example.laba4rsoi;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String surname;
    private String name;
    private String fatherName;
    private String dateOfBirth;
    private String sex;
    private String passport;
    private String email;
    private String position;

    public User() {
    }

    public User(String surname, String name, String fatherName, String dateOfBirth, String sex, String passport, String email, String position) {
        this.surname = surname;
        this.name = name;
        this.fatherName = fatherName;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.passport = passport;
        this.email = email;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String isSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", sex=" + sex +
                ", passport='" + passport + '\'' +
                ", email='" + email + '\'' +
                ", position='" + position + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return sex == user.sex && Objects.equals(id, user.id) && Objects.equals(surname, user.surname) && Objects.equals(name, user.name) && Objects.equals(fatherName, user.fatherName) && Objects.equals(dateOfBirth, user.dateOfBirth) && Objects.equals(passport, user.passport) && Objects.equals(email, user.email) && Objects.equals(position, user.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, surname, name, fatherName, dateOfBirth, sex, passport, email, position);
    }


}
