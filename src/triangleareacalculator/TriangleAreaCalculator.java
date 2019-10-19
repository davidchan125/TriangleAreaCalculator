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
        
        System.out.println("Enter the length of the 1st side: ");
        double side1 = input.nextDouble();
        System.out.println("Enter the length of the 2nd side: ");
        double side2 = input.nextDouble();
        System.out.println("Enter the length of the 3rd side: ");
        double side3 = input.nextDouble();
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
