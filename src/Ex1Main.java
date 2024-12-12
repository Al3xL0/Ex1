import java.util.Arrays;
import java.util.Scanner;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 *
 */
public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2="", quit = "quit";
        String[] numbers = new String[4];
        int base, multiply, add;
        boolean isNumber1, isNumber2;
        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();
            if (!num1.equals("quit")) {
                // add your code here
                isNumber1 = Ex1.isNumber(num1);
                System.out.println("num1 = " + num1 + " is number: " + isNumber1 + ", value: " + Ex1.number2Int(num1));
                if(!isNumber1) {
                    System.out.println("ERR: num1 is in the wrong format! (" + num1 + ")" );
                    //restart the loop to get user input again.
                    continue;
                }
                numbers[0] = num1;
                System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
                num2 = sc.next();
                if(!num2.equals("quit")) {
                    isNumber2 = Ex1.isNumber(num2);
                    System.out.println("num2 = " + num2 + " is number: " + isNumber2 + ", value: " + Ex1.number2Int(num2));
                    if (!isNumber2) {
                        System.out.println("ERR: num2 is in the wrong format! (" + num2 + ")");
                        //restart the loop to get user input again.
                        continue;
                    }
                    numbers[1] = num2;
                    System.out.println("Enter a base for output : (a number between [2,16])");
                    base = sc.nextInt();
                    add = Ex1.number2Int(num1) + Ex1.number2Int(num2);
                    numbers[2] = Ex1.int2Number(add, base);
                    System.out.println(num1 + "+" + num2 + " = " + numbers[2]);
                    multiply = Ex1.number2Int(num1) * Ex1.number2Int(num2);
                    numbers[3] = Ex1.int2Number(multiply, base);
                    System.out.println(num1 + "*" + num2 + " = " + numbers[3]);

                    System.out.println("Max number over " + Arrays.toString(numbers) + " is:" + numbers[Ex1.maxIndex(numbers)] );
                }
                /////////////////////
            }
        }
        System.out.println("quiting now...");
    }
}