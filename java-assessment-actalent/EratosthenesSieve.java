import java.util.Scanner;

/**
 * 
 * @author phyll
 * 
 * This application takes in an integer greater than or equal to 2 (the smallest prime) 
 * and prints out all primes up to the limit input, using the Sieve of Eratosthenes algorithm. 
 *
 */
public class EratosthenesSieve {

	public static void main(String[] args) {
		System.out.println("Welcome to Sieve of Eratosthenes");
		Scanner userIn = new Scanner(System.in);
		
		boolean conti = true;
		int limit;
		while (conti)
		{
			// Input Entry and Validation
			try 
			{
				System.out.print("Enter limit of prime numbers: ");
				limit = Integer.parseInt(userIn.nextLine().trim());
				System.out.println();
				if (limit < 2)
				{
					System.out.println("Limit must be an integer greater than or equal to 2");
					continue;
				}
			} catch (NumberFormatException nfe)
			{
				System.out.println("Invalid input: please enter an integer as the limit");
				continue;
			} catch (Exception e)
			{
				System.out.println("Invalid input: please try again");
				continue;
			}
			
			printPrimes(limit);
			
			// Continue Program
			while (true)
			{
				System.out.print("Would you like to check a new limit? (Y/n): ");
				String response = userIn.nextLine().trim();
				System.out.println();
				if (response.equalsIgnoreCase("Y"))
				{
					conti = true;
					break;
				} else if(response.equalsIgnoreCase("N"))
				{
					conti = false;
					System.out.println("End of Sieve of Eratosthenes");
					break;
				} else
				{
					System.out.println("Invalid input: please try again");
					continue;
				}
			}
		}
		userIn.close();
	}
	
	public static void printPrimes(int limit)
	{
		boolean[] numbers = new boolean[limit];
		int primeCounter = 0;
		System.out.println("The list of primes from 2 to " + limit + " are:");

		int p = 2;
		while(p<=limit && !numbers[p-1])
		{
			// print current prime
			System.out.print(p + "  ");
			if (++primeCounter%20 == 0)
				System.out.println(); // line break for readability
			
			// redundant but mark current prime as not composite
			numbers[p-1] = false;
	
			// mark multiples of prime less than the limit as composite
			for(int i=2; i*p < limit+1; i++)
				numbers[(i*p)-1] = true;
			
			// find next prime
			do {
				p++;
			} while(p < limit && numbers[p-1]);
		}
		System.out.println();
		System.out.println("Total of " + primeCounter + " prime numbers found");
	}
	
}
