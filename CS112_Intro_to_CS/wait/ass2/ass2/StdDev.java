import java.util.Scanner;

public class StdDev {
    public static void main(String args[]) {
	Scanner conin = new Scanner(System.in);

	int count = 0;
	float sum = 0.0f;
	float ssum =0.0f;
    float k;

	System.out.println("Enter numbers to calculate the results. At the end of the data typing, please enter 'done' or 'Q'");

        
        while (conin.hasNext()) {
            if (conin.hasNextFloat()) {
                k=conin.nextFloat();
                sum += k;
                ssum += (k * k);
                count++;
            } else {
                String str = conin.next();
                if (str.equals("done")||str.equals("Q"))
                    break;
                else {
                    System.out.println("Data format error.");
                    return;
                }
            }
        }

    
	System.out.println("Count is " + count);
	System.out.println("Average is " + sum / count);
	System.out.println("Standard deviation is " + Math.sqrt(((ssum-((sum*sum) / count))/(count-1))));
    
    }
}
