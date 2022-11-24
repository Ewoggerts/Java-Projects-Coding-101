import java.util.Scanner;
public class Main
{
   public static void main(String[] args)
   {
      int number1 =(int) (Math.random() * 10);
      int number2 =(int) (Math.random() * 10);
      
      Scanner input = new Scanner(System.in);
      if (number1 < number2)
         {
         System.out.println("What is the difference of  "+number2+"-"+number1 +"? ");
         int answer = input.nextInt();
            if (answer == (number2-number1))
            {
               System.out.println("You got it! "+number2+" - " + number1 +" = "+answer);
            }
            else
            {
               System.out.println("Wrong."+number2+" - "+number1+" is not "+answer);
            }  
         }
      else
         {
         System.out.println("What is the difference of  "+number1+"-"+number2 +"? ");
         int answer = input.nextInt();
            if (answer == (number1-number2))
            {
               System.out.println("You got it! "+number1+" - " + number2 +" = "+answer);
            }
            else
            {
               System.out.println("Wrong."+number1+" - "+number2+" is not "+answer);
            }
         } 
       
  }
}
          
