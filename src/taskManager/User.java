package taskManager;

import java.io.Serializable;

public class User implements Serializable{

    private String firstName;
    private String lastName;
    private String userName;

    public User(String firstName, String lastName, String userName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return "FirstName: " + firstName + " LastName: " + lastName + " UserName: " + userName;
    }

    @Override
    public boolean equals(Object o) {
        return this.userName.equals(((User)o).getUserName());
    }

}
