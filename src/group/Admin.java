package group;

public class Admin {
    private long id;
    private String firstName = "Nurislam";
    private String lastName = "Toigonbaev";
    private String email = "admin@gmail.com";
    private String password = "admin123";

    public Admin() {
    }

    public Admin(long id, String firstName, String lastName, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
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

    @Override
    public String toString() {
        return "Admin: \n" +
                "id =         " + id + "\n" +
                "firstName =  " + firstName + '\'' + "\n" +
                "lastName =   " + lastName + '\'' + "\n" +
                "email =      " + email + '\'' + "\n" +
                "password=    " + password + '\'';
    }
}
