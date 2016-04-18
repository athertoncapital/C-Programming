public class CastOperator {
 
    public static void main(String args[]) {
     
	byte b =0;
	int i = 358;
	double d = 462.142;
 
	System.out.println("Conversion of int to byte: ");
	b = (byte) i;
	System.out.println("i = "+ i +" and b = "+ b);
 
	System.out.println();
   
	System.out.println("Conversion of double to int: ");
	i = (int) d;
	System.out.println("d = "+ d +" and i = "+ i);
   
	System.out.println();
   
	System.out.println("Conversion of double to byte: ");
	b = (byte) d;
	System.out.println("d = "+ d +" and b = "+ b);
    }
}