public class Person {
    private String firstName;
    private String lastName;
    private int age;
    public Person(String first, String last, int age)
    {
	firstName = first;
	lastName = last;
        if (age<=0){
        throw new IllegalArgumentException("Age must be positive");
    }
        this.age = age;
    }
    public Person(Person aPerson)
    {
        this(aPerson.getLast(), aPerson.getFirst(), aPerson.getAge());
    }
    public String getLast()
    {
        return lastName;
    }
    public String getFirst()
    {
        return firstName; // return value of part_description to caller
    }
    public int getAge()
    {
        return age; // return value of part_description to caller
    }
    public String toString()
    {
	return String.format("First Name: %s, Last Name: %s, Age: %d\n", firstName, lastName, age);
    }

}
/*
public class PersonTest {
    public static void main(String[] args)
    {
	Person p1=new Person("John","Smith", 19);
	System.out.println(p1);
    }
}*/
