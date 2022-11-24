import java.util.Scanner;
class Main{
   public static void main(String[]args) {
      Scanner truefalse = new Scanner (System.in);
      System.out.println("Are you converting to farenheit to celsius otherwise it will default to celsius to farenheit. Answer yes  or no.");
      String bool = truefalse.nextLine();
      if (bool .equals("yes")){
        Scanner scan = new Scanner (System.in);
        System.out.println("Enter temperature in Fahrenheit:");
        double f = scan.nextDouble();
        System.out.println(f + " degrees farenheit is " + (f-32)*5/9+ "degree celsius");
      }
      else{
        Scanner scan = new Scanner (System.in);
        System.out.println("Enter temperature in celsius:");
        double c = scan.nextDouble();
        System.out.println(c + " degrees celsius is " + (((c*9)/5)+32) + "degree farenheit");
      }

  }
}
