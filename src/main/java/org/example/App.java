package org.example;
import java.util.Scanner;

/**
 * UCF COP3330 Fall 2021 Assignment 1 Solution
 * Copyright 2021 Yeshwanth Mandava
 *
 */
public class App 
{
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public static void main( String[] args )
    {
        final double BAC = 0.08;
        final double RatioMen = 0.73;
        final double RatioWomen = 0.66;
        Scanner input = new Scanner(System.in);

        double AlcRatio;
        double Weight;
        double AlcConsumed;
        int Time;

        while (true){
            System.out.print("What is your gender -> (Enter 1 for male and 2 for female): ");
            String MF = input.nextLine();
            if (isNumeric(MF)){
                int Gender = Integer.parseInt(MF);
                AlcRatio = Gender == 1 ? RatioMen : RatioWomen;
                break;
            }
            else{
                System.out.print("Sorry the value that you entered is non-numeric. Please try again.\n");
            }
        }

        while (true){
            System.out.print("Enter your body weight (in pounds): ");
            String Pounds = input.nextLine();
            if (isNumeric(Pounds)){
                Weight = Double.parseDouble(Pounds);
                break;
            }
            else{
                System.out.print("Sorry the value that you entered is non-numeric. Please try again.\n");
            }
        }

        while (true){
            System.out.print("How many ounces of alcohol have you consumed:  ");
            String Alc = input.nextLine();
            if (isNumeric(Alc)){
                AlcConsumed = Double.parseDouble(Alc);
                break;
            }
            else{
                System.out.print("Sorry the value that you entered is non-numeric. Please try again.\n");
            }
        }

        while (true){
            System.out.print("How many hours has it been since you had your last drink: ");
            String Hours = input.nextLine();
            if (isNumeric(Hours)){
                Time = Integer.parseInt(Hours);
                break;
            }
            else{
                System.out.print("Sorry the value that you entered is non-numeric. Please try again.\n");
            }
        }

        double B_A_C = ((AlcConsumed*5.14)/(Weight*AlcRatio) - (0.015 * Time));
        if (B_A_C >= BAC){
            System.out.printf("Your BAC is %.2f \nIt is not legal for you to drive", B_A_C);
        }
        else{
            System.out.printf("Your BAC is %.2f \nIt is legal for you to drive.", B_A_C);
        }

    }
}
