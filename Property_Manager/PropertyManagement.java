public class PropertyManagement
{  
   private double PropertyCost;
   private double PropertyCost2;
   private String PropertyName;
   private String PropertyName2;
   private static String DatePurchase1;
   private static String DatePurchase2;
   public String PropertyOwner;
   private String Password;
   private double CashBalance;
   private int CashBalanceThousand;
   private String password = null;
   private double total;
   private double cashleftover;
public PropertyManagement()
{
Password = "missing";
CashBalance = (0.0);
PropertyOwner = "missing";
}
public PropertyManagement(String initializeName, String initializePassword, double enterCashValue )
{  
PropertyOwner = initializeName;
Password = initializePassword;
CashBalance = enterCashValue;
}
public void Property1(String enterPropertyName, double enterPropertyCost)
{
PropertyName = enterPropertyName;
PropertyCost = enterPropertyCost;
}
public void Property2(String enterPropertyName2, double enterPropertyCost2)
{
PropertyName2 = enterPropertyName2;
PropertyCost2 = enterPropertyCost2;
}
public static void Date1(String enterDate1)
{
DatePurchase1 = enterDate1;
}
public static void Date2(String enterDate2)
{
DatePurchase2 = enterDate2;
}
public void deposit(double depositCash)
{
CashBalance = CashBalance + depositCash;
}
public void withdraw(double withdrawCash)
{
CashBalance = CashBalance-withdrawCash;
}
public void roundCashBalanceThousand()
{
CashBalanceThousand =  (int)Math.round(CashBalance/1000)*1000;
CashBalanceThousand =  Math.abs(CashBalanceThousand);
}
public void resetName(String newName)
{
PropertyOwner = newName;
}
public void resetPass(String newPass)
{
Password = newPass;
}
public void printtotalManagementInfo()
{
System.out.println("Here is your account password: " + Password);
System.out.println("Here is your account username: " + PropertyOwner);
System.out.println("Here are your two properties: " + PropertyName + ": " + PropertyCost + ", " + PropertyName2 + " : " + PropertyCost2); 
System.out.println("Here is your account cash balance: " + CashBalance);
System.out.println("Here is your account cash balance estimate: " + CashBalanceThousand);
}
public void printAccountManagementInfo()
{
System.out.println("Here is your account password: " + Password);
System.out.println("Here is your account username: " + PropertyOwner);
}

//Extra fucntions
public void calculator(double newint1, double newint2)
{
total = newint1 + newint2;
}
//cash left after property
public void cashleftafterpropertycost(double totalpropertycost)
{
cashleftover = CashBalance - totalpropertycost;
if(cashleftover<0&&cashleftover!=0)
{
System.out.println("You are negative, you are in debt ");
}
else
{
System.out.println("This is the amount left after properties, withdrawals, and deposits: " + cashleftover);
}
}
}

   
