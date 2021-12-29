import java.lang.reflect.Method;
import java.util.ArrayList;

public class Turtle {

	public static void main(String[] args) {

	}

	public int x;
	public int y;
	public int angle;
	public ArrayList<String> arrayLog;

	public Turtle(int x, int y, int angle) {
		this.x = x;
		this.y = y;
		this.angle = angle;
		arrayLog = new ArrayList<String>();

	}

	public void moveSouth(int steps) {

		y = y - steps;
	}

	public void moveNorth(int steps) {

		y = y + steps;

	}

	public void moveEast(int steps) {

		x = x + steps;

	}

	public void moveWest(int steps) {

		x = x - steps;

	}

	public void setAngle(int angleValue) {

		arrayLog.add("setAngle()" + " " + angleValue);

		angle = angleValue;

	}

	public void moveForward(int steps) {
		// only expects 0,90,180 and 270
		arrayLog.add("moveForward()" + " " + steps);
		if (angle == 0) {
			this.moveEast(steps);
		} else if (angle <= 90) {
			this.moveNorth(steps);
		} else if (angle == 180) {
			this.moveWest(steps);
		} else {
			this.moveSouth(steps);
		}
	}

	public void moveBackward(int steps) {
		// only expects 0,90,180 and 270
		arrayLog.add("moveBackward()" + " " + steps);
		if (angle == 0) {
			this.moveWest(steps);
		} else if (angle == 90) {
			this.moveSouth(steps);
		} else if (angle == 180) {
			this.moveEast(steps);
		} else {
			this.moveNorth(steps);
		}
	}

	public void moveLeft(int steps) {
		// only expects 0,90,180 and 270
		arrayLog.add("moveLeft()" + " " + steps);
		if (angle == 0) {
			this.moveNorth(steps);
		} else if (angle == 90) {
			this.moveWest(steps);
		} else if (angle == 180) {
			this.moveSouth(steps);
		} else {
			this.moveEast(steps);
		}
	}

	public void moveRight(int steps) {
		// only expects 0,90,180 and 270
		arrayLog.add("moveRight()" + " " + steps);
		if (angle == 0) {
			this.moveSouth(steps);
		} else if (angle == 90) {
			this.moveEast(steps);
		} else if (angle == 180) {
			this.moveNorth(steps);
		} else {
			this.moveWest(steps);
		}
	}

	public void goToPosition(int xValue, int yValue) {

		arrayLog.add("goToPosition()" + " " + xValue + " " + yValue);
		x = xValue;
		y = yValue;
	}

	public void replay(int startNumber, int endNumber) {

		arrayLog.add("replay()" + " " + startNumber + " " + endNumber);
		if (endNumber < this.arrayLog.size()) {
			for (int i = startNumber; i <= endNumber; i++) {
				String string = this.arrayLog.get(i);
				String[] parts = string.split(" ");
				String methodName = parts[0];
				String attributeValue = parts[1];
				int attribute = Integer.parseInt(attributeValue);

				switch (methodName) {
				case "moveForward()":
					this.moveForward(attribute);
					break;
				case "moveBackward()":
					this.moveBackward(attribute);
					break;
				case "moveLeft()":
					this.moveLeft(attribute);
					break;
				case "moveRight()":
					this.moveRight(attribute);
					break;
				case "setAngle()":
					this.setAngle(attribute);
					break;
				case "replay()":
					String attributeValue2 = parts[2];
					int attribute2 = Integer.parseInt(attributeValue2);
					this.replay(attribute, attribute2);
					break;
				case "goToPosition()":
					String getPosition2 = parts[2];
					int position2 = Integer.parseInt(getPosition2);
					this.goToPosition(attribute, position2);
					break;
				default:
					System.out.println("Invalid method name");
				}
			}
		}
		else
		{
			System.out.println("End Number is greater than the arrayLog size");
		}
	}

	public void list() {
		for (int i = 0; i <= this.arrayLog.size(); i++) {
			System.out.println(this.arrayLog.get(i));
		}

	}
}
