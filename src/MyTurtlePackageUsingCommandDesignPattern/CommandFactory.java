package MyTurtlePackageUsingCommandDesignPattern;

public class CommandFactory {

	public static Command fromString(Turtle t1, String input) {

		String string = input;
		String[] parts = string.split(" ");
		String methodName = parts[0];
		int value1 = 0;
		try {
			value1 = Integer.parseInt(parts[1]);
		} catch (NumberFormatException e) {
			System.out.println("Integer give values are allowed");
			// i--; continue;

		}
		if (methodName.compareTo("setDirection") == 0) {
			return new SetDirectionCommand(t1, value1);
		} else if (methodName.compareTo("moveForward") == 0) {
			return new MoveForwardCommand(t1, value1);
		} else if (methodName.compareTo("moveBackward") == 0) {
			return new MoveBackwardCommand(t1, value1);
		} else if (methodName.compareTo("turnLeft") == 0) {
			return new TurnLeftCommand(t1, value1);
		} else if (methodName.compareTo("turnRight") == 0) {
			return new TurnRightCommand(t1, value1);
		} else if (methodName.compareTo("moveTo") == 0) {
			int value2 = Integer.parseInt(parts[2]);
			return new MoveToCommand(t1, value1, value2);
		} else if (methodName.compareTo("replay") == 0) {
			int value2 = Integer.parseInt(parts[2]);
			return new ReplayCommand(t1, value1, value2);
		} else if (methodName.compareTo("yalper") == 0) {
			int value2 = Integer.parseInt(parts[2]);
			return new YalplerCommand(t1, value2, value1);
		} else if (methodName.compareTo("getList") == 0) {
			t1.getList();
		} else {
			System.out.println("Invalid method name");
		}

		System.out.println("x = " + t1.x + " " + "y = " + t1.y + " " + "angle = " + t1.direction + "\n");
		return null;
	}
}
