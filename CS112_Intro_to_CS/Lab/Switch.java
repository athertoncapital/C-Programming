public class Switch {
    public static void main(String arg[])
    {
	
	int i = 0;
	switch (i ) {
	case 0 : System.out.println("zero ");
	case 1 : System.out.println("one ");
	case 2 : System.out.println("two ");
            
    for (i=1;i<11;i++)
    {
        
        if ((i%2)==0){continue;}
        if ((i%4)==0){break;}
        System.out.printf("%d ",i);
    }
            
	}
    }
}

//there are some redundant codes will trick you
//every thought should be exmined before you accepted and used it