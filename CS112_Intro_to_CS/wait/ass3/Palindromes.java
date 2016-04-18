import java.util.Scanner;
public class Palindromes
{public static boolean is_palindrome(String s){
        if(s.length() == 0 || s.length() == 1)
            return true; 
        if(s.charAt(0) == s.charAt(s.length()-1))
            return is_palindrome(s.substring(1, s.length()-1));
        return false;}
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        System.out.println("type a word to check if its a palindrome or not");
        String x = sc.nextLine();
        if(is_palindrome(x))
            System.out.println(x + " is a palindrome");
        else
            System.out.println(x + " is not a palindrome");}}