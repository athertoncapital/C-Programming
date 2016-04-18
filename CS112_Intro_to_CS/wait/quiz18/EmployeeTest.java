public class EmployeeTest {
    public static void main(String[] args)
    {
	
	Executive cio=new Executive("Tim",20000,"Head Office");
	BasePlusCommissionEmployee salesRep = new BasePlusCommissionEmployee("Jim",2000.0, 0.03, 300000.0);
	Manager director = new Manager("Kim",5000,"Accounting"); 
	System.out.println(cio);
	System.out.printf("Pay: %.2f\n", cio.pay());
	System.out.println(salesRep);
	System.out.printf("Pay: %.2f\n", salesRep.pay());
	System.out.println(director);
	System.out.printf("Pay: %.2f\n", director.pay());
    }
}