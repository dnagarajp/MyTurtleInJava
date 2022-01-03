package MyTurtlePackageWithStringOperation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This Class is defined in order to use the turtle commands by user by giving a
 * list of implemented commands.
 * 
 * @author deepa
 *
 */
public class MenuDrivenUserInteraction {

	public static void main(String args[]) throws IOException {
		Turtle t1 = new Turtle();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter Numbers of command you like to execute here: ");
			int n;
			n = Integer.parseInt(br.readLine());
			System.out.print("Here are the Command List which are available:" + "\n"+ "\n" + "setDirection <value> \n"+ "moveForward <value> \n"
					+ "moveBackward <value> \n" + "turnLeft <value> \n" + "turnRight <value> \n" + "moveTo <value1> <value2>\n"
					+ "replay <startvalue1> <startvalue2>\n" + "yalper <startvalue1> <startvalue2> \n" + "getList \n");
			for (int i = 1; i <= n; i++) {

				System.out.print("\n" + "Write a command you wish to execute " + "\n");
				String string = br.readLine();

				String[] parts = string.split(" ");
				String methodName = parts[0];
				int value1 = Integer.parseInt(parts[1]);
				if (methodName.compareTo("setDirection") == 0) {
					t1.setDirection(Integer.valueOf(value1));
				} else if (methodName.compareTo("moveForward") == 0) {
					t1.moveForward(Integer.valueOf(value1));
				} else if (methodName.compareTo("moveBackward") == 0) {
					t1.moveBackward(Integer.valueOf(value1));
				} else if (methodName.compareTo("turnLeft") == 0) {
					t1.turnLeft(Integer.valueOf(value1));
				} else if (methodName.compareTo("turnRight") == 0) {
					t1.turnRight(Integer.valueOf(value1));
				} else if (methodName.compareTo("moveTo") == 0) {
					int value2 = Integer.parseInt(parts[2]);
					t1.moveTo(Integer.valueOf(value1), Integer.valueOf(value2));
				} else if (methodName.compareTo("replay") == 0) {
					int value2 = Integer.parseInt(parts[2]);
					t1.replay(Integer.valueOf(value1), Integer.valueOf(value2));
				} else if (methodName.compareTo("yalper") == 0) {
					int value2 = Integer.parseInt(parts[2]);
					t1.yalper(Integer.valueOf(value1), Integer.valueOf(value2));
				} else if (methodName.compareTo("getList") == 0) {
					t1.getList();
				} else {
					System.out.println("Invalid method name");
				}


				System.out.println("x = " + t1.x + " " + "y = " + t1.y + " " + "angle = " + t1.direction + "\n");
			}
		}  catch (Exception e) {

			System.out.println("There is an expection occurred look at the trace here");
			e.printStackTrace();
		}
	}
}