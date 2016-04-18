public class Account
{
    private static int number=10000;
    private Person person;
    private int id;

    public Account(Person person)
    {
	this.person = person;
	id = number;
	number++;
    }
    public String toString()
    {
	return String.format("Account id: %d \n Person: %s", id, person); 

    }


}
