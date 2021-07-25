package edu.metrostate.ics.macrogroceryguide.model;

/**
 * User is the person using the application. Certain criteria needs to be collected before
 * other features of the app will work. This class holds that information gender, age, height,
 * weight.
 * @author Macro Grocery Guide Group 4
 */
public class User {
    public enum Gender {
        M, F;

    }
    //variables
    private Assessment assessment = null;
    private MacroTotals macroTotals;
    private String firstName;
    private String emailAddress;
    private static User singleton;


    /**
     * Default no argument constructor.
     */
    private User(){

    }

    /**
     * Get an instance of the User. Will create a new instance if one has not already been created.
     * @return user class instance
     */
    public static User getInstance(){
        if(singleton == null){
             singleton = new User();
        }
        return singleton;
    }

    /**
     * Sets the initial information needed for a user. This should be set before a user completes
     * an assessment. Currently retrieved from the google account used to sign in.
     * @param firstName
     * @param emailAddress
     */
    public void createUser(String firstName, String emailAddress) {

        this.firstName = firstName;
        this.emailAddress = emailAddress;

    }

    /**
     * Get the first name of the user.
     * @return first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Get the email address of the user.
     * @return email address
     */
    public String getEmailAddress() {
        return this.emailAddress;
    }

    /**
     * Get the assessment taken by the user. Set after the Assessment is created.
     * @return assessment
     */
    public Assessment getAssesment() {
        return assessment;
    }

    /**
     * Sets the assessment for the user.
     * @param assesment
     */
    public void setAssesment(Assessment assesment) {
        this.assessment = assesment;
    }

    /**
     * Gets the macro totals for the user. Calculated after the user takes the assessment and sets
     * a weight goal.
     * @return instance of macro totals
     */
    public MacroTotals getMacroTotals() {
        return macroTotals;
    }

    /**
     * Sets the instance of macro totals for the user.
     * @param macroTotals
     */
    public void setMacroTotals(MacroTotals macroTotals) {
        this.macroTotals = macroTotals;
    }

}
