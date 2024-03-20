package group;

import enums.Gender;

import java.util.Objects;

public class Student {
    private long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;
    private Gender gender;

    public Student() {
    }

    public Student(long id, String firstName, String lastName, String phoneNumber, String email, String password, Gender gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return ": " +
                "id=" + id +
                " firstName='" + firstName + '\'' +
                " lastName='" + lastName + '\'' +
                " phoneNumber='" + phoneNumber + '\'' +
                " email='" + email + '\'' +
                " password='" + password + '\'' +
                " gender=" + gender + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == (student.id) && Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName) && Objects.equals(phoneNumber, student.phoneNumber) && Objects.equals(email, student.email) && Objects.equals(password, student.password) && gender == student.gender;    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, firstName, lastName, phoneNumber, email, password, gender);
        return result;
    }
}
