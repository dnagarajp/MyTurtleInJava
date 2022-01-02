package MyTurtlePackage;

import java.util.Scanner;

/**
 * This Class is defined in order to use the turtle commands by user by giving a
 * list of implemented commands.
 * 
 * @author deepa
 *
 */
public class MenuDrivenUserInteraction {

	public static void main(String[] args) {

		Turtle t1 = new Turtle();

		int choice;
		try (Scanner scanner = new Scanner(System.in)) {

			System.out.println("Hello!!! Welcome to User interface to play with Turtle commands" + "\n");
			// Creating infinite while loop
			while (true) {
				// Creating menu
				System.out.println("Press 1 : setDirection");
				System.out.println("Press 2 : moveForward");
				System.out.println("Press 3 : moveBackward");
				System.out.println("Press 4 : turnLeft");
				System.out.println("Press 5 : turnRight");
				System.out.println("Press 6 : moveTo");
				System.out.println("Press 7 : replay");
				System.out.println("Press 8 : yalper");
				System.out.println("Press 9 : getList");
				System.out.println("Press 10 : Exit\n \n ");
				// Asking user to make choice
				System.out.println("Make your choice");
				choice = scanner.nextInt();

				// Creating switch case branch
				switch (choice) {

				// First case for finding the addition
				case 1:

					System.out.println("Enter a value for the direction to move your turtle");
					t1.setDirection(scanner.nextInt());
					break;

				case 2:

					System.out.println("Enter the step of move forward");
					t1.moveForward(scanner.nextInt());
					break;

				case 3:

					System.out.println("Enter the step of move backward");
					t1.moveBackward(scanner.nextInt());
					break;

				case 4:

					System.out.println("Enter the angle to turn Left");
					t1.turnLeft(scanner.nextInt());
					break;

				case 5:

					System.out.println("Enter the angle to turn Right");
					t1.turnRight(scanner.nextInt());
					break;

				case 6:

					System.out.println("Enter the step of moveTo");
					t1.moveTo(scanner.nextInt(), scanner.nextInt());
					break;

				case 7:

					System.out.println("Enter the step of replay");
					t1.replay(scanner.nextInt(), scanner.nextInt());
					break;

				case 8:

					System.out.println("Enter the step of yalper");
					t1.yalper(scanner.nextInt(), scanner.nextInt());
					break;
					
				case 9:
					
					t1.getList();
					break;

				// case to quit the program
				case 10:
					System.out.println("Thank you for using the program! you're now exited.  ");
					System.exit(0);

					// default case to display the message invalid choice made by the user

				default:
					System.out.println("Invalid choice!!! Please make a valid choice. \\n\\n");
				}
				t1.getList();
				System.out.println("x = " + t1.x + " " + "y = " + t1.y + " " + "angle = " + t1.direction + "\n\n\n");

			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(" Array size exception is captured");
		} catch (NullPointerException e) {
			System.out.println(" we have a null value in variable");

		}
	}
}
