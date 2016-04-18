public class CoinTest {
    public static void main(String[] args)
    {
	Coin dim = new Coin(10,"Dim");
	Coin nickel = new Coin(5,"Nickel");
	System.out.println(dim);
	System.out.println(nickel);
	System.out.println(dim.equals(nickel));
    }
}
