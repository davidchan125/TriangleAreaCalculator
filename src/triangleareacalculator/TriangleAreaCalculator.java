/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triangleareacalculator;

import java.util.Scanner;
import java.math.*;
        
/**
 *
 * @author davidchan
 */
public class TriangleAreaCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Area of a triangle = sqrt(p(p-a)(p-b)(p-c)), where p = 1/2 * perimeter
        Scanner input = new Scanner(System.in);
        double side1 = 0, side2 = 0, side3 = 0;
        boolean side1Entered = false, side2Entered = false, side3Entered = false;
        
        while (!side1Entered || !side2Entered || !side3Entered) {
            try {
                if (!side1Entered) {
                    System.out.println("Enter the length of the 1st side: ");
                    side1 = input.nextDouble();
                    side1Entered = true;
                }
                if (!side2Entered) {
                    System.out.println("Enter the length of the 2nd side: ");
                    side2 = input.nextDouble();
                    side2Entered = true;
                }
                if (!side3Entered) {
                    System.out.println("Enter the length of the 3rd side: ");
                    side3 = input.nextDouble();
                    side3Entered = true;
                }
            } catch (Exception e) {
                System.out.println("Value for side entered is invalid.");
                // Moves the cursor to a new line so the Scanner doesn't loop-read the last entered value
                input.nextLine();
            }
        }
        
        System.out.println("The area of the triangle is: ");
        double perimeter = side1 + side2 + side3;
        double p = perimeter/2.0;
        double a = p - side1;
        double b = p - side2;
        double c = p - side3;
        double toBeSquareRooted = p * a * b * c;
        double areaOfTriangle = Math.sqrt(toBeSquareRooted);
        System.out.println(areaOfTriangle);
        if (areaOfTriangle == 0 || Double.isNaN(areaOfTriangle)) {
            double largestSide = side1;
            double smallestSide1 = side2;
            double smallestSide2 = side3;
            if (side2 - largestSide > 0) {
                largestSide = side2;
                smallestSide1 = side1;
                smallestSide2 = side3;
            }
            if(side3 - largestSide > 0) {
                largestSide = side3;
                smallestSide1 = side1;
                smallestSide2 = side2;
            }
            
            System.out.println("\nThe answer above is technically correct - according to triangle inequalities, any one side taken from a triangle must be smaller than the sum of the two remaining sides.");
            if (areaOfTriangle == 0) {
                System.out.println("E.g. " + smallestSide1 + " + " + smallestSide2 + " = " + largestSide);
            } else {
                System.out.println("E.g. " + smallestSide1 + " + " + smallestSide2 + " < " + largestSide);
            }
        }
    }
    
}
