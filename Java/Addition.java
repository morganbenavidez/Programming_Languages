
import java.util.Scanner;

public class Addition {
    
    public static void main(String[] args){
   
    double x = 12.3798146;
        System.out.printf("%.2f\n", x);
        
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter first integer: ");
    int number1= input.nextInt();
    
    System.out.print("Enter second integer: ");
    int number2= input.nextInt();
    
    if (number1 == number2){
            System.out.printf("%d == %d%n", number1, number2);
    }
    if (number1 != number2){
            System.out.printf("%d != %d%n", number1, number2);
    }
    if (number1 < number2){
            System.out.printf("%d < %d%n", number1, number2);
    }
    if (number1 > number2){
            System.out.printf("%d > %d%n", number1, number2);
    }
    if (number1 <= number2){
            System.out.printf("%d <= %d%n", number1, number2);
    }
    if (number1 >= number2){
            System.out.printf("%d >= %d%n", number1, number2);
    }
    
        int a = 4;
        int b = 12;
        int c = 37;
        int d = 51;
        int result = d % a * c + a % b + a;
                
            
  }
}