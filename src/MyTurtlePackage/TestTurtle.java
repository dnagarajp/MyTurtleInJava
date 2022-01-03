package MyTurtlePackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestTurtle {

	Turtle turtle;
	

	@BeforeEach
	void setUp() throws Exception {

		// Default constructor
		turtle = new Turtle();

	}

	/**
	 * Test initialValues of x,y,direction based on default constructor is called
	 * initiated gets the x,y,direction points should be to 0,0,0 respectively.
	 */
	@Test
	void testInitialValue() {
		assertEquals(0, turtle.getXPosition());
		assertEquals(0, turtle.getYPosition());
		assertEquals(0, turtle.getDirection());
	}

	/**
	 * test X and Y based on the MoveTo method with negative values as an argument,
	 * should contain given values to x and y respectively with -
	 */
	@Test
	void testMoveToWithNegativeValues() {
		turtle.moveTo(-4, -5);
		assertEquals(-4, turtle.getXPosition());
		assertEquals(-5, turtle.getYPosition());
	}

	/**
	 * test X and Y based the moveTo method with positive values as an argument.
	 * should contain given values to x and y respectively with +
	 */
	@Test
	void testMoveToWithPositiveValues() {
		turtle.moveTo(4, 5);
		assertEquals(4, turtle.getXPosition());
		assertEquals(5, turtle.getYPosition());
	}

	/**
	 * tests the direction can be set from 0-359 positive values towards clockwise.
	 * direction. should show exactly what the direction if its in positive Numbers
	 */
	@Test
	void testSetDirectionClockwise() {
		turtle.setDirection(12);
		assertEquals(12, turtle.getDirection());
	}

	/**
	 * tests the direction can be set from 0-359 negative values towards anti
	 * clockwise. direction. should show exactly what the direction [calculated with
	 * "360 - directionValue" if its in negative Numbers.s
	 */
	@Test
	void testSetDirectionAntiClockwise() {
		turtle.setDirection(-12); // values means go from antiClockWise direction. starts from 360
		assertEquals(348, turtle.getDirection()); // direction pointing to 348 degree because 360-12 = 348.
	}

	/**
	 * With direction is 0, should move towards angle 0 degree, where x will
	 * increment and y is still default i.e, 0
	 */
	@Test
	void testMove() {
		turtle.moveForward(10);
		assertEquals(10, turtle.getXPosition());
		assertEquals(0, turtle.getYPosition());
	}

	/**
	 * Test negative values so that as a value to move should traverse back on the
	 * same line
	 */
	@Test
	void testMoveNegative() {
		turtle.moveForward(10);
		turtle.moveForward(-10);
		assertEquals(0, turtle.getXPosition());
		assertEquals(0, turtle.getYPosition());
	}

	/**
	 * Turtle is facing towards 1st quadrant perpendicular to x axis and y axis move
	 * 10 steps towards 90 degree, should show the values x=0 and y=10
	 */
	@Test
	void testMoveForward90() {
		turtle.setDirection(90);
		turtle.moveForward(10); //
		assertEquals(90, turtle.getDirection());
		assertEquals(0, turtle.getXPosition());
		assertEquals(10, turtle.getYPosition());
	}

	/**
	 * Turtle is facing towards 1st quadrant (+ +) with angle 45 degree and move
	 * forward and should show the x and y positions as 7, 7 .calculated based on
	 * trigonometric formula with the help of radius.
	 */
	@Test
	void testMoveForward1stQuadrant() {
		turtle.setDirection(45);
		turtle.moveForward(10);
		assertEquals(45, turtle.getDirection());
		assertEquals(7, turtle.getXPosition());
		assertEquals(7, turtle.getYPosition());
	}

	/**
	 * Turtle is facing towards 2nd quadrant (- +) with angle 110 degree and move
	 * forward and should show the x and y positions as -3, 9 .calculated based on
	 * trigonometric formula with the help of radius.
	 */
	@Test
	void testMoveForward2ndQuadrant() {
		turtle.setDirection(110);
		turtle.moveForward(10);
		assertEquals(110, turtle.getDirection());
		assertEquals(-3, turtle.getXPosition());
		assertEquals(9, turtle.getYPosition());
	}

	/**
	 * Turtle is facing towards 3rd quadrant (- -) with angle 195 degree and move
	 * forward and should show the x and y positions as -8, -2 .calculated based on
	 * trigonometric formula with the help of radius.
	 */
	@Test
	void testMoveForward3rdQuadrant() {
		turtle.setDirection(195);
		turtle.moveForward(8);
		assertEquals(195, turtle.getDirection());
		assertEquals(-8, turtle.getXPosition());
		assertEquals(-2, turtle.getYPosition());
	}

	/**
	 * turtle is facing towards 4th quadrant (+ -) with angle 277 degree and move
	 * forward and should show the x and y positions as 1, -5 .calculated based on
	 * trigonometric formula with the help of radius.
	 */
	@Test
	void testMoveForward4thQuadrant() {
		turtle.setDirection(277);
		turtle.moveForward(5);
		assertEquals(277, turtle.getDirection());
		assertEquals(1, turtle.getXPosition());
		assertEquals(-5, turtle.getYPosition());
	}

	/**
	 * Turtle is facing towards 1st quadrant perpendicular to x axis and y axis move
	 * 10 steps backward in the 90 degree angle, should show the values x=0 and
	 * y=-10.
	 */
	@Test
	void testMoveBackward90() {
		turtle.setDirection(90);
		turtle.moveBackward(10);
		assertEquals(90, turtle.getDirection());
		assertEquals(0, turtle.getXPosition());
		assertEquals(-10, turtle.getYPosition());
	}

	/**
	 * Turtle is facing towards 4th quadrant (+ -) with angle 315 degree and move
	 * forward then backward to see the x and y values are still in 4th
	 * quadrant.should show the x and y positions as 1, -5 .calculated based on
	 * trigonometric formula with the help of radius.
	 */
	@Test
	void testMoveBackward4thQuadrantWithinQuadrant() {
		turtle.setDirection(315);
		turtle.moveForward(15);
		turtle.moveBackward(5);
		assertEquals(315, turtle.getDirection());
		assertEquals(7, turtle.getXPosition());
		assertEquals(-7, turtle.getYPosition());
	}

	/**
	 * Turtle is facing towards 4th quadrant (+ -) with angle 320 degree and move
	 * backward to see the x and y values are crossing and coming to 2nd Quadrant (-
	 * +) from 4th quadrant.should show the x and y positions as -14, 12 .calculated
	 * based on trigonometric formula with the help of radius.
	 */
	@Test
	void testMoveBackward4thQuadrantWithoutQuadrant() {
		turtle.setDirection(320);
		turtle.moveBackward(18);
		assertEquals(320, turtle.getDirection());
		assertEquals(-14, turtle.getXPosition());
		assertEquals(12, turtle.getYPosition());
	}

	/**
	 * Turtle is facing towards 3rd quadrant (- -) with angle 250 degree and move
	 * forward then backward to see the x and y values are still in 3rd
	 * quadrant.should show the x and y positions as -2, -5 .calculated based on
	 * trigonometric formula with the help of radius.
	 */
	@Test
	void testMoveBackward3rdQuadrant() {
		turtle.setDirection(250);
		turtle.moveForward(15);
		turtle.moveBackward(10);
		assertEquals(250, turtle.getDirection());
		assertEquals(-2, turtle.getXPosition());
		assertEquals(-5, turtle.getYPosition());
	}

	/**
	 * Turtle is facing towards 2nd quadrant (- +) with angle 165 degree and move
	 * forward then backward to see the x and y values are still in 2nd
	 * quadrant.should show the x and y positions as -9, -3 .calculated based on
	 * trigonometric formula with the help of radius.
	 */
	@Test
	void testMoveBackward2ndQuadrant() {
		turtle.setDirection(165);
		turtle.moveForward(18);
		turtle.moveBackward(8);
		assertEquals(165, turtle.getDirection());
		assertEquals(-9, turtle.getXPosition());
		assertEquals(3, turtle.getYPosition());
	}

	/**
	 * Turtle is facing towards 1st quadrant (+ +) with angle 83 degree and move
	 * forward then backward to see the x and y values are still in 1st
	 * quadrant.should show the x and y positions as 1, 15. calculated based on
	 * trigonometric formula with the help of radius.
	 */
	@Test
	void testMoveBackward1stQuadrant() {
		turtle.setDirection(83);
	//	turtle.moveForward(20);
		turtle.moveBackward(5);
		assertEquals(83, turtle.getDirection());
		assertEquals(1, turtle.getXPosition());
		assertEquals(15, turtle.getYPosition());
	}

	/**
	 * Turtle is moving to 0,0 in 0 degree angle.then angle changed to 90,then move
	 * 10 steps, replay setDirection and moveForward again by specifying the start
	 * number and end number which will iterate. should show x,y,angle,size as
	 * 0,20,90,6 respectively
	 */
	@Test
	void testReplay() {
		
		turtle.doCommand(new MoveToCommand(turtle, 0, 0));
		turtle.doCommand(new SetDirectionCommand(turtle, 90));
		turtle.doCommand(new MoveForwardCommand(turtle, 10));
		turtle.doCommand(new ReplayCommand(turtle, 1,2));
	
		assertEquals(0, turtle.x);
		assertEquals(20, turtle.y);
		assertEquals(90, turtle.direction);
		assertEquals(4, turtle.getCommands().size());
	}

	/**
	 * Turtle is moving to 0,0 in 0 degree angle.then angle changed to 90,then move
	 * 10 steps, replay setDirection and moveForward again by specifying the start
	 * number and end number, again replay 0 to 3 which calls reply twice and
	 * iterates it. should show x,y,angle,size as 0,20,90,13 respectively. ArraySize
	 * for replay will keep changing based on startNumber and EndNumber.
	 */
	@Test
	void testReplayTwice() {

		turtle.moveTo(0, 0);
		turtle.setDirection(90);
		turtle.moveForward(10);
		turtle.replay(1, 2);
		turtle.replay(0, 3);
		assertEquals(0, turtle.x);
		assertEquals(20, turtle.y);
		assertEquals(90, turtle.direction);
		assertEquals(5, turtle.arrayLog.size());
	}

	/**
	 * Turtle is moving to -9,3 in 0 degree angle.then angle changed to 90,then move
	 * 10 steps, reverse moveForward with 10 more steps and setDirection to 90. by
	 * specifying the endNumber start number which will iterate. should show
	 * x,y,angle,size as -9,23,90,6 respectively
	 */
	@Test
	void testYalperWithMoveToNegationValues() {

		turtle.moveTo(-9, 3);
		turtle.setDirection(90);
		turtle.moveForward(10);
		turtle.yalper(2, 1);
		assertEquals(-9, turtle.x);
		assertEquals(23, turtle.y);
		assertEquals(90, turtle.direction);
		assertEquals(4, turtle.arrayLog.size());
	}

	/**
	 * Turtle is moving to 0,0 in 0 degree angle.then angle changed to 90,then move
	 * 10 steps, reverse moveForward with 10 more steps and setDirection to 90.again
	 * do reverse from index 3 to 0. by should show x,y,angle,size as 0,40,90,12
	 * respectively
	 */
	@Test
	void testYalperTwice() {

		turtle.moveTo(0, 0);
		turtle.setDirection(90);
		turtle.moveForward(10);
		turtle.yalper(2, 1);
		turtle.yalper(3, 1);
		assertEquals(0, turtle.x);
		assertEquals(40, turtle.y);
		assertEquals(90, turtle.direction);
		assertEquals(5, turtle.arrayLog.size());
	}

	/**
	 * Verifies the array is empty when there is no command executed.
	 */
	@Test
	void testListisEmpty() {
		assertEquals(0, turtle.commands.size());
	}

	/**
	 * Verifies the array contains a single value.
	 */
	@Test
	void testListContains() {
		turtle.moveTo(3, 8);
		assertEquals(1, turtle.commands.size());
	}

	/**
	 * Turn right side angle 0-89 = -89, then convert it to right angle, negative
	 * value rights operation which 360-89=271
	 */
	@Test
	void testTurnRight() {
		turtle.turnRight(89);
		assertEquals(271, turtle.direction);
	}

	/**
	 * Sets the direction 0 + 47 = 47 angle for first time then turn right with 89,
	 * which means 47-89 = -42 now calculate the right angle, since its mine should
	 * show the angle to 318 degree. and make some movement and my X and Y should be
	 * 9 -2.
	 */
	@Test
	void testTurnRightWithSetDirection() {
		turtle.setDirection(47);
		turtle.moveTo(8, -1);
		turtle.turnRight(89);
		turtle.moveForward(2);
		assertEquals(318, turtle.direction);
		assertEquals(9, turtle.x);
		assertEquals(-2, turtle.y);
	}

	/**
	 * Turn left side angle 0+90 = 90, then convert it to left angle, positive value
	 * left operation which is 360+90 =450. 450 % 360 = which is 90 degree angle
	 */
	@Test
	void testTurnLeft() {
		turtle.turnLeft(90);
		assertEquals(90, turtle.direction);
	}

	/**
	 * Turn left side angle 0+45 = 45,move some some position which is x=8 and y=4
	 * then turn to left with angle 20 , positive value left operation which is
	 * 45+20 =65. 65 % 360 which is 65 degree angle
	 */
	@Test
	void testTurnLeftWithSetDirection() {
		turtle.setDirection(45);
		turtle.moveTo(8, 4);
		turtle.turnLeft(20);
		turtle.moveForward(2);
		assertEquals(65, turtle.direction);
		assertEquals(9, turtle.x);
		assertEquals(6, turtle.y);
	}

	@Test
	void testReplayManyTimes() {

		turtle.setDirection(90);
		turtle.moveForward(10);
		turtle.turnRight(90);
		turtle.replay(1, 2);
		turtle.replay(3, 3);
		turtle.replay(3, 4);
		turtle.replay(4, 4);
		turtle.replay(2, 6);
		assertEquals(0, turtle.x);
		assertEquals(10, turtle.y);
		assertEquals(90, turtle.direction);
	}

	@Test
	void testRTimes() {

		turtle.moveForward(10);
		turtle.moveForward(10);
		turtle.moveForward(10);
		turtle.replay(0, 2);
		assertEquals(60, turtle.x);
		assertEquals(0, turtle.y);
		assertEquals(0, turtle.direction);
	}

	@Test
	void testRYTimes() {
		turtle.moveForward(10);
		turtle.moveForward(10);
		turtle.moveForward(10);
		turtle.replay(0, 2);
		turtle.yalper(3, 0);
		assertEquals(120, turtle.x);
		assertEquals(0, turtle.y);
		assertEquals(0, turtle.direction);
	}

	@Test
	void testmoveee() {
		turtle.moveTo(1, 3);
		turtle.moveTo(1, 3);
		assertEquals(1, turtle.x);
		assertEquals(3, turtle.y);
		assertEquals(0, turtle.direction);
	}

//	@Test
//	void testForwardAndUndo() {
//    	Command c= new MoveForwardCommand(turtle, 3);
//		turtle.doCommand(c);
//		turtle.doCommandUndo(c);
//		assertEquals(0, turtle.x);
//		assertEquals(0, turtle.y);
//		assertEquals(0, turtle.direction);
//	}
//
//	@Test
//	void testBackwardAndUndo() {
//    	Command c= new MoveBackwardCommand(turtle, 3);
//		turtle.doCommand(c);
//		turtle.doCommandUndo(c);
//		assertEquals(0, turtle.x);
//		assertEquals(0, turtle.y);
//		assertEquals(0, turtle.direction);
//	}

	
}
