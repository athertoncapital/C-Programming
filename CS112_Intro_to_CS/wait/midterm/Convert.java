import java.util.Scanner;
public class Convert
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner( System.in );
        System.out.printf( "Enter the number of seconds: " );
        float sec = input.nextFloat();
        float year;
        float minutes;
        float hours;
        float days;
        minutes=sec/60;
        sec=sec % 60;
        hours=sec/3600;
        days=sec/86400;
       
        
        
        System.out.printf("%.0f days%n", days);
        System.out.printf("%.0f hours%n", hours);
        System.out.printf("%.0f minutes%n", minutes);
        System.out.printf("%.1f seconds%n", sec);
    }
}
