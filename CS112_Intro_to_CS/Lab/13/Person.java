public class Person {
    private String firstName;
    private String lastName;
    private int age;
    public Person(String first, String last, int age)
    {
	firstName = first;
	lastName = last;
	this.age = age;
    }
    public String toString()
    {
	return String.format("First Name: %s, Last Name: %s, Age: %d\n", firstName, lastName,age);
    }

}
