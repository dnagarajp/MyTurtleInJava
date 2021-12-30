import java.util.ArrayList;

public class Turtle {

	public static void main(String[] args) {

	}

	// declare variables
	protected int x;
	protected int y;
	protected int direction;
	protected ArrayList<String> arrayLog;

	/**
	 * Object Constructor initialization
	 * 
	 * @param x         position value
	 * @param y         position value
	 * @param direction or angle of the circle in degrees
	 */
	public Turtle(int x, int y, int direction) {
		if (x < 0) {
			x = 0;
		}
		if (y < 0) {
			y = 0;
		}
		this.x = x;
		this.y = y;
		this.direction = direction;
		arrayLog = new ArrayList<String>();

	}

	// return the current x position
	public int getXPosition() {
		return this.x;

	}

	// return the current y position
	public int getYPosition() {
		return this.y;

	}

	// return the current direction or angle
	public int getDirection() {
		return this.direction;
	}

	/**
	 * set the direction in [0-359]
	 * 
	 * @param direction positive numbers goes with clockwise direction, Negative
	 *                  numbers goes with backward direction
	 */
	public void setDirection(int direction) {
		arrayLog.add("setDirection()" + " " + direction);
		direction = (direction % 360);
		if (direction < 0) {
			direction = direction + 360;
		}

		this.direction = direction;
	}

	public void moveTo(int x, int y) {
		arrayLog.add("moveTo()" + " " + x + " " + y);
		this.x = x;
		this.y = y;

	}

	/**
	 * Makes a turtle move forward with respect to its current angle
	 * 
	 * @param amount The distance for the turtle to move. This number is taken and
	 *               conversion from degree to radius is stored and used to
	 *               calculate the x and y positions by adding the old x and y
	 *               values.
	 */
	public void moveForward(int step) {
		arrayLog.add("moveForward()" + " " + step);
		double dirRads = Math.PI * (this.direction / 180.0);
		int xStep = x + (int) Math.round(Math.cos(dirRads) * step);
		int yStep = y + (int) Math.round(Math.sin(dirRads) * step);
		this.x = xStep;
		this.y = yStep;
	}

	/**
	 * Makes a turtle move backward with respect to its current angle
	 * 
	 * @param amount The distance for the turtle to move. This number is taken and
	 *               conversion from degree to radius is stored and used to
	 *               calculate the x and y positions by subtracting the old x and
	 *               old y values.
	 */
	public void moveBackward(int step) {
		arrayLog.add("moveBackward()" + " " + step);
		double dirRads = Math.PI * (this.direction / 180.0);
		int endXStep = x - (int) Math.round(Math.cos(dirRads) * step);
		int endYStep = y - (int) Math.round(Math.sin(dirRads) * step);
		this.x = endXStep;
		this.y = endYStep;

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

				case "setDirection()":
					this.setDirection(attribute);
					break;
				case "moveTo()":
					String getPosition2 = parts[2];
					int position2 = Integer.parseInt(getPosition2);
					this.moveTo(attribute, position2);
					break;
				case "moveForward()":
					this.moveForward(attribute);
					break;
				case "moveBackward()":
					this.moveBackward(attribute);
					break;
				case "replay()":
					String attributeValue2 = parts[2];
					int attribute2 = Integer.parseInt(attributeValue2);
					this.replay(attribute, attribute2);
					break;
				default:
					System.out.println("Invalid method name");
				}
			}
		} else {
			System.out.println("End Number is greater than the arrayLog size");
		}
	}

	public void getList() {
		System.out.println("Array Size is :=  " + this.arrayLog.size() + "\n" + "Commands executed are : ");
		for (int i = 0; i < this.arrayLog.size(); i++) {
			System.out.println(this.arrayLog.get(i));
		}
		System.out.println("\n");

	}

	public void yalper(int endNumber, int startNumber) {
		arrayLog.add("yalper()" + " " + endNumber + " " + startNumber);
		if (endNumber < this.arrayLog.size()) {
			for (int i = endNumber; i >= startNumber; i--) {
				String string = this.arrayLog.get(i);
				String[] parts = string.split(" ");
				String methodName = parts[0];
				String attributeValue = parts[1];
				int attribute = Integer.parseInt(attributeValue);

				switch (methodName) {

				case "setDirection()":
					this.setDirection(attribute);
					break;
				case "moveTo()":
					String getPosition2 = parts[2];
					int position2 = Integer.parseInt(getPosition2);
					this.moveTo(attribute, position2);
					break;
				case "moveForward()":
					this.moveForward(attribute);
					break;
				case "moveBackward()":
					this.moveBackward(attribute);
					break;
				case "replay()":
					String attributeValue2 = parts[2];
					int attribute2 = Integer.parseInt(attributeValue2);
					this.replay(attribute, attribute2);
					break;
				default:
					System.out.println("Invalid method name");

				}
			}
		} else {
			System.out.println("End Number is greater than the arrayLog size");
		}
	}

	/**
     * Undo the last command.
     */
    public void undo()
    {
	return;
    }
    
    
    
    public void turnRight(int angle) {
    	direction -= angle;
    	direction = (direction + 360) % 360;
    }
    
    
    public void turnLeft(int angle) {
    	direction += angle;
    	direction = (direction +360) % 360;
    }
}