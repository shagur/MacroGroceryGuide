package edu.metrostate.ics.macrogroceryguide.model;

public class Assessment {

    enum Gender {
        M, F;

    }

    private User user;
    private double pal; //physical activity level
    private Gender gen;
    private int age; //in years
    private int height; //in cm
    private int weight; //in kg
    private double rmrResult;
    private double tdeeResult;


    public Assessment(User user, Gender gen, int age, int height, int weight, double pal){

        this.user = user;
        this.gen = gen;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.pal = pal;
         calculateRMR();
         calcTDEE();
    }

    public User getUser() {
        return user;
    }

    public double getPal() {
        return pal;
    }

    public Gender getGen() {
        return gen;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public double getRmrResult() {
        return rmrResult;
    }

    public double getTdeeResult() {
        return tdeeResult;
    }

    /**
     * Calculates RMR (Resting metabolic rate) using Mifflin-St.Jeor equation
     *
     * @precondition weight in kg, height in cm and age in years
     */
    public void calculateRMR() {
        if (this.gen == Gender.F) {
            //Mifflin-St.Jeor equation for female
            rmrResult = ((((10 * weight) + (6.25 * height)) - (5 * age)) - 161);

        } else {
            //Mifflin-St.Jeor equation for male
            rmrResult = ((((10 * weight) + (6.25 * height)) - (5 * age)) + 5);

        }
    }
    /**
     * Calculate TDEE(Total Daily Energy Expenditure) using RMR X PAL (Physical Activity Level).
     * The TDEE will be the calories needed to maintain weight.
     * @precondition rmr has to be already calculated
     */
    public void calcTDEE(){
        tdeeResult = rmrResult * pal;
    }


}
