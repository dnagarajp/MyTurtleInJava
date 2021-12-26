
public class Turtle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int x;
	public int y;
	public int angle;

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

		angle = angleValue;

	}

	public void moveForward(int steps) {
		// only expects 0,90,180 and 270
		if (angle == 0) {
			this.moveEast(steps);
		} else if (angle == 90) {
			this.moveNorth(steps);
		} else if (angle == 180) {
			this.moveWest(steps);
		} else {
			this.moveSouth(steps);
		}
	}

	public void moveBackward(int steps) {
		// only expects 0,90,180 and 270
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
		x= xValue;
		y= yValue;
	}

}
