import java.util.ArrayList;

public class Turtle {

	public static void main(String[] args) {

	}

	public int x;
	public int y;
	public int angle;
	public ArrayList<String> arrayLog;

	public Turtle() {
		this.x = 0;
		this.y = 0;
		this.angle = 0;
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

		arrayLog.add("setAngle()" + angleValue);

		angle = angleValue;

	}

	public void moveForward(int steps) {
		// only expects 0,90,180 and 270
		arrayLog.add("moveForward()" + steps);
		if (angle == 0) {
			this.moveEast(steps);
		} else if (angle <= 90 && angle > 0) {
			this.moveNorth(steps);
		} else if (angle == 180) {
			this.moveWest(steps);
		} else {
			this.moveSouth(steps);
		}
	}

	public void moveBackward(int steps) {
		// only expects 0,90,180 and 270
		arrayLog.add("moveBackward()" + steps);
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
		arrayLog.add("moveLeft()" + steps);
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
		arrayLog.add("moveRight()" + steps);
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

		arrayLog.add("goToPosition()" + xValue + yValue);
		x = xValue;
		y = yValue;
	}

	public Object getHistory() {
		// TODO Auto-generated method stub
		return null;
	}

	public void replay(int startNumber, int endNumber) {
		
		//arrayLog.add("replay()"+ startNumber + endNumber);
		if(endNumber<=this.arrayLog.size())
		{
	       for(int i=startNumber ; i<=endNumber ; i++)
		   {
			  String arrayElement = this.arrayLog.get(i);
			  this.executeArrayLogElement(arrayElement);
		   }
		}
	}

	public void executeArrayLogElement(String element) {
		String elementMethodName = element.split(())t;
		String argumentName;
		if(storeElement.contains(element))
		{
			
		}
		
	}
}
