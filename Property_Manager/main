public class Main
{ 
   public static void main(String[] args)
   {
   double firstProperty1; 
   firstProperty1 = 221001.0;
   double firstProperty2;
   firstProperty2 = 699000.0;
   double secondProperty1;
   secondProperty1 = 966000.0;
   double secondProperty2;
   secondProperty2 = 100999.0;
   int highestcostofproperty = Integer.MAX_VALUE;
   final int milliontester = 1000000;
   //two accounts
   PropertyManagement m1 = new PropertyManagement("Joe", "2246", 1000000);
   PropertyManagement m2 = new PropertyManagement("Amy", "2396", 2000000);
   //calculate your property
   if(firstProperty1+firstProperty2 == 1000000)
   {
      m1.Property1("\\Baltic Avenue\\", firstProperty1);
      m1.Property2("Vermont Avenue", firstProperty2);
      m1.Date1("Jun. 1st 2019");
      m1.Date2("Feb. 21st 2018");
   }
   if(secondProperty1+secondProperty2 == 1000000) 
   {
      m2.Property1("Broadway",secondProperty1);
      m2.Property2("Mediterranean Avenue", secondProperty2);
      m2.Date1("Mar. 12th 2020");
      m2.Date2("Aug. 31st 2017");
   }
   //account information
   System.out.println("********");
   m1.printAccountManagementInfo();
   m2.printAccountManagementInfo();
   System.out.println("+++++");
   //deposit
   System.out.println("********");
   m1.deposit(500000);
   m2.deposit(600000);
   System.out.println("+++++");
   //full info
   System.out.println("********");
   m1.printtotalManagementInfo();
   m2.printtotalManagementInfo();
   System.out.println("+++++");
   //withdraw
   System.out.println("********");
   m1.withdraw(100);
   m2.withdraw(35);
   System.out.println("+++++");
   //roundedcashbalance
   System.out.println("********");
   m1.roundCashBalanceThousand();
   m2.roundCashBalanceThousand();
   System.out.println("+++++");
   //account name change
   System.out.println("********");
   m1.resetName("Joey");
   m2.resetName("Jamey");
   System.out.println("+++++");
   //password change
   System.out.println("********");
   m1.resetPass("LOL");
   m2.resetPass("hello");
   System.out.println("+++++");
   //account info
   System.out.println("********");
   m1.printAccountManagementInfo();
   m2.printAccountManagementInfo();
   System.out.println("+++++");
   System.out.println("This is testing if joe can buy more property. Does he have enough money for $1000000 Propert?");
   //if statements
   System.out.println("********");
   m1.cashleftafterpropertycost((firstProperty1+firstProperty2));
   m2.cashleftafterpropertycost((secondProperty1+secondProperty2));
   System.out.println("+++++");
   //tostring 
   System.out.println(m1.toString());
   //random String method
   System.out.println((m1.PropertyOwner).length());
     } 
}
