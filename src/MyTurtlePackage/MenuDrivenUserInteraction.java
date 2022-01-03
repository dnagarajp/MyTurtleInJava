package MyTurtlePackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


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

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Numbers of command you like to execute here: ");
		int n;
		n = Integer.parseInt(br.readLine());
		System.out.print("Here are the Command List which are available:" + "\n" + "\n" + "setDirection <value> \n"
				+ "moveForward <value> \n" + "moveBackward <value> \n" + "turnLeft <value> \n" + "turnRight <value> \n"
				+ "moveTo <value1> <value2>\n" + "replay <startvalue1> <startvalue2>\n"
				+ "yalper <endValue> <startValue> \n");
		for (int i = 1; i <= n; i++) {

			System.out.print("\n" + "Write a command you wish to execute " + "\n");
			String string = br.readLine();
			Command newCommand = CommandFactory.fromString(t1, string);
			t1.doCommand(newCommand);
			
		}
		br.close();
		//t1.getList();
		System.out.println("x = " + t1.x + " " + "y = " + t1.y + " " + "angle = " + t1.direction + "\n");
	}
}
