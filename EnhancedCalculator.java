import java.util.*;
import java.lang.Math;

public class EnhancedCalculator {

    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int choice;

        do{
                System.out.println("Enhanced Calculator");
                System.out.println("1) Addition");
                System.out.println("2) Substraction");
                System.out.println("3) Multiplication");
                System.out.println("4) Division");
                System.out.println("5) Square Root");
                System.out.println("6) Power");
                System.out.println("7) Temprature Conversion");
                System.out.println("8) Currency Conversion");
                System.out.println("9) Division");
                System.out.println("10) Enter Your Choice");

                choice = sc.nextInt();

                switch(choice){
                    case 1:
                    System.out.println("Enter two Numbers");
                    double a=sc.nextDouble();
                    double b=sc.nextDouble();
                    System.out.println("Result is :" +(a+b));
                    break;

                    case 2:
                    System.out.println("Enter two Numbers");
                    double a1=sc.nextDouble();
                    double b1=sc.nextDouble();
                    System.out.println("Result is :" +(a1-b1));
                    break;

                    case 3:
                    System.out.println("Enter two Numbers");
                    double a2=sc.nextDouble();
                    double b2=sc.nextDouble();
                    System.out.println("Result is :" +(a2*b2));
                    break;

                    case 4:
                    System.out.println("Enter Numerator and Denominator");
                    double numerator=sc.nextDouble();
                    double denominator=sc.nextDouble();
                    if(denominator != 0){
                        System.out.println("result is:" +numerator/denominator);

                    }else{
                        System.out.println("Cannot be divide by zero ");
                    }
                    break;

                    case 5:
                    System.out.println("Enter Number ");
                    double num=sc.nextDouble();
                    if(num>=0){
                        System.out.println("Square Root of a given number is"  +Math.sqrt(num));
                    }else{
                        System.out.println("Square root of a negative number is not real");
                    }
                    break;

                    case 6:
                    System.out.println("Enter base and power");
                    double base=sc.nextDouble();
                    double power=sc.nextDouble();
                    System.out.println("Result is:" +Math.pow(base, power));
                    break;

                    case 7:
                    System.out.println("1. Celsius to Fahrenheit");
                    System.out.println("2. Fahrenheit to Celsius");
                    int tempchoice = sc.nextInt();
                    System.out.println("Enter Tempreture: ");
                    double temp = sc.nextDouble();
                    if(tempchoice==1){
                        System.out.println("Fahrenheit = " +((temp*9/5)+32));
                    }else if(tempchoice==2){
                        System.out.println("Celsius = " + ((temp-32)*5/9));
                    }else{
                        System.out.println("Invalid Option");
                    }
                    break;

                    case 8:
                    System.out.println("Enter amount in INR : ");
                    double in=sc.nextDouble();
                    double usd=0.012;
                    System.out.println("Amount in USD = " +(in*usd));
                    break;

                    case 9:
                    System.out.println("Exiting Calculator");
                    break;

                    default:
                    System.out.println("Invalid Choice");
                }
            }while(choice !=9);
            sc.close();
        }

}






                
                

                



        
    

    

