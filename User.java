package edu.metrostate.ics.macrogroceryguide.model;

/**
 * User is the person using the application. Certain criteria needs to be collected before
 * other features of the app will work. This class holds that information gender, age, height,
 * weight.
 */
public class User {

    private Assessment assesment;
    private MacroTotals macroTotals;

    private String username;
    private String password;
    private String firstName;
    private String lastName;

    //macro totals



    public User(String username, String password, String firstName, String lastName) {

        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;

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
}
