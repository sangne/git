package basic;
import java.util.Scanner;

public class DetermineCharacter {

	  public static void main(String[] args)
	    {
	        Scanner in = new Scanner(System.in);

	        System.out.print("Input a alphabet: ");
	        String input = in.next().toLowerCase();
	        in.close();
	        //System.out.println(input);

	       // boolean uppercase = input.charAt(0) >= 65 && input.charAt(0) <= 90;
	       // boolean lowercase = input.charAt(0) >= 97 && input.charAt(0) <= 122;
	       boolean vowels = input.equals("a") || input.equals("e") || input.equals("i")
	                || input.equals("o") || input.equals("u");

	        if (input.length() > 1)
	        {
	            System.out.println("Error. Not a single character.");
	        }
	        else if (vowels)
	        {
	            System.out.println("Input letter is Vowel");
	        }
	        else
	        {
	            System.out.println("Input letter is Consonant");
	        }
	    }
	}
