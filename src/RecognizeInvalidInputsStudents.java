import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * Andrew Calabro-Cavin
 * Program that will recognize invalid inputs when the user requests information about students in a class
 * Incorporate IndexOutOfBoundsException
 * 
 */

public class RecognizeInvalidInputsStudents {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String cont = "y";

		int[] studID = { 1, 2, 3, 4 };
		String[] name = { "Black Francis", "Kim Deal", "Joey Santiago", "David Lovering" };
		String[] instrument = { "guitar and sings", "bass and sings", "lead guitar", "drums" };
		String[] hairStyle = { "no", "long", "short", "short" };

		System.out.println("Welcome to the Pixies student database!");

		while (cont.equalsIgnoreCase("y")) { // as long as cont is y, will exec. at least once

			try {
				System.out.println("Which Pixies member would you like to learn more about? (Enter 1-4) ");
				int userNum = scan.nextInt();
				scan.nextLine(); // garbage line
				// System.out.println("Entered: " + userNum);

				System.out.println("Student " + userNum + " is " + name[userNum - 1]);
				System.out.println("What would you like to know about " + name[userNum - 1]
						+ "? (Enter \"instrument\" or \"hairstyle\")");
				String userQuery = scan.nextLine();
				String queryChoice1 = "instrument";
				String queryChoice2 = "hairstyle";
				
				if (queryChoice1.equalsIgnoreCase(userQuery)) {
					System.out.println(name[userNum - 1] + " plays " + instrument[userNum - 1] + ".");
				}
				if (queryChoice2.equalsIgnoreCase(userQuery)) {
					System.out.println(name[userNum - 1] + " has " + hairStyle[userNum - 1] + " hair.");
				}

			} catch (InputMismatchException e) {

				System.out.println("That isn't a valid entry!");
				// e.printStackTrace(); // might print this to a log file
				scan.nextLine(); // this will clear out the incorrect value entered into the scanner
				continue; // this will take the program back to the top of the while loop

			} catch (IndexOutOfBoundsException b) {
				System.out.println("There aren't that many band members!");
				//scan.nextLine(); // this will clear out the incorrect value entered into the scanner
				continue;
				
			} catch (IllegalArgumentException c) {  // FIXME: This is not working
				System.out
						.println("That data does not exist. Please try again. (Enter \"instrument\" or \"hairstyle\")");
				scan.nextLine(); // this will clear out the incorrect value entered into the scanner
				continue;

			}

			catch (Exception e) { // this is possible to include second because Exception is a parent class of
									// InputMismatchException
				// the parent must follow the child; the child must precede the parent
				System.out.println("Hey, I'm not sure what happened -- some error occurred.");
				scan.nextLine(); // this will clear out the incorrect value entered into the scanner
				continue; // this will take the program back to the top of the while loop
			}

			System.out.println("Would you like to know more? (Enter \"y\" or \"n\")");
			cont = scan.nextLine();

		}

		// let the user know the program has closed
		System.out.println("Thanks!");

		scan.close();

	}
}
