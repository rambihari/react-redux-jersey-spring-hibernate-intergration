package com.ram.MyProj.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;


@Entity
public class Child {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name="FirstName")
    private String firstName;
    @Column(name="LastName")
    private String lastName;
    private String dob;
    private String Gender;
    private int age;
    //Mapping the relationship between child and profile
    //Setting cascadeType.All to make sure profile entity doesn't need to persisted individually
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="profile_id")
    private Profile profile;

    public void setId(int id) {
        Id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return Id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDob() {
        return dob;
    }

    public String getGender() {
        return Gender;
    }

    public int getAge() {
        return age;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
