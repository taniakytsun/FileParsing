package com.softserve.javaweb.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import resources.LocalDateDeserializer;
import resources.LocalDateSerializer;

@Valid
public class Person {

    private long id;

    @Size(min = 3, max = 50, message = "The \"Name\" field must have a length greater than 3 characters")
    private String name;

    @Past(message = "Date of birth should be in the past!")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate birthDay;

    private int age;

    private String address;

    @Email(message = "Invalid email format")
    private String email;
    @Pattern(regexp = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}", message = "Invalid phone number")
    private String phoneNumber;
    private String specialization;
    private List<Experience> experience = new ArrayList<>();

    public Person() {

    }

    public Person(long id) {
	this.id = id;

    }

    public Person(String name, int age, LocalDate birthDay, String address, String email, String phoneNumber,
	    String specialization, List<Experience> experience) {
	this.name = name;
	this.age = age;
	this.birthDay = birthDay;
	this.address = address;
	this.email = email;
	this.phoneNumber = phoneNumber;
	this.specialization = specialization;
	this.experience = experience;
    }

    public Person(String name, LocalDate dateBirth, String specialization, List<Experience> experience) {
	super();
	this.name = name;
	this.birthDay = dateBirth;
	this.specialization = specialization;
	this.experience = experience;
    }

    public Person(
	    @Size(min = 3, max = 50, message = "The \"Name\" field must have a length greater than 3 characters") String name,
	    @Past(message = "Date of birth should be in the past!") LocalDate birthDay, int age, String address,
	    @Email(message = "Invalid email format") String email,
	    @Pattern(regexp = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}", message = "Invalid phone number") String phoneNumber,
	    String specialization) {
	super();
	this.name = name;
	this.birthDay = birthDay;
	this.age = age;
	this.address = address;
	this.email = email;
	this.phoneNumber = phoneNumber;
	this.specialization = specialization;
    }

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public int getAge() {
	return age;
    }

    public void setAge(int age) {
	this.age = age;
    }

    public String getAddress() {
	return address;
    }

    public void setAddress(String address) {
	this.address = address;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getPhoneNumber() {
	return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
    }

    public LocalDate getBirthDay() {
	return birthDay;
    }

    public void setBirthDay(LocalDate birthDate) {
	this.birthDay = birthDate;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getSpecialization() {
	return specialization;
    }

    public void setSpecialization(String specialization) {
	this.specialization = specialization;
    }

    public List<Experience> getExperience() {
	return experience;
    }

    public void setExperience(List<Experience> experience) {
	this.experience.addAll(experience);
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((address == null) ? 0 : address.hashCode());
	result = prime * result + age;
	result = prime * result + ((birthDay == null) ? 0 : birthDay.hashCode());
	result = prime * result + ((email == null) ? 0 : email.hashCode());
	result = prime * result + ((experience == null) ? 0 : experience.hashCode());
	result = prime * result + (int) (id ^ (id >>> 32));
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
	result = prime * result + ((specialization == null) ? 0 : specialization.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Person other = (Person) obj;
	if (address == null) {
	    if (other.address != null)
		return false;
	} else if (!address.equals(other.address))
	    return false;
	if (age != other.age)
	    return false;
	if (birthDay == null) {
	    if (other.birthDay != null)
		return false;
	} else if (!birthDay.equals(other.birthDay))
	    return false;
	if (email == null) {
	    if (other.email != null)
		return false;
	} else if (!email.equals(other.email))
	    return false;
	if (experience == null) {
	    if (other.experience != null)
		return false;
	} else if (!experience.equals(other.experience))
	    return false;
	if (id != other.id)
	    return false;
	if (name == null) {
	    if (other.name != null)
		return false;
	} else if (!name.equals(other.name))
	    return false;
	if (phoneNumber == null) {
	    if (other.phoneNumber != null)
		return false;
	} else if (!phoneNumber.equals(other.phoneNumber))
	    return false;
	if (specialization == null) {
	    if (other.specialization != null)
		return false;
	} else if (!specialization.equals(other.specialization))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "Person [name=" + name + ", birthDay=" + birthDay + ", age=" + age + ", address=" + address + ", email="
		+ email + ", phoneNumber=" + phoneNumber + ", specialization=" + specialization + ", experience="
		+ experience + "]";
    }

}
