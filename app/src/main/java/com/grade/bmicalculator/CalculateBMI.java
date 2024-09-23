package com.grade.bmicalculator;

import java.util.HashMap;

public class CalculateBMI {
    BMIModel BMIModel = new BMIModel();
    HashMap<Double, String> BMIResultHash = new HashMap<>();
    Double BMI;

    CalculateBMI(double weight, double height){
        this.BMIModel.setWeight(weight);
        this.BMIModel.setHeight(height);
    }

    public HashMap<Double, String> BMIResult(){
        BMI = BMIModel.getWeight()/Math.pow((BMIModel.getHeight()/100),2);

        String category;
        if (BMI < 18.5) {
            category = "Underweight";
        } else if (BMI >= 18.5 && BMI < 24.9) {
            category = "Normal weight";
        } else if (BMI >= 25 && BMI < 29.9) {
            category = "Overweight";
        } else {
            category = "Obese";
        }

        BMIResultHash.put(BMI,category);

        return BMIResultHash;
    }
}
