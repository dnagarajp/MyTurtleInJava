import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestTurtle {

	Turtle turtle;

	@BeforeEach
	void setUp() throws Exception {
		turtle = new Turtle(-9, -5, 0);

	}

	/**
	 * test initialValues of X and Y based on constructor if Negative values it
	 * resets the X and Y points to 0. if no requirement of moving the x y , default
	 * should be 0
	 */
	@Test
	void testInitialValueOfXY() {
		assertEquals(0, turtle.getXPosition());
		assertEquals(0, turtle.getYPosition());
	}

	/**
	 * test X and Y based on the MoveTo method With negative values as an argument,
	 * should contain given values to x and y respectively
	 */
	@Test
	void testMoveToWithNegativeValues() {
		turtle.moveTo(-4, -5);
		assertEquals(-4, turtle.getXPosition());
		assertEquals(-5, turtle.getYPosition());
	}

	/**
	 * test X and Y based the method using MoveTo should set the X and Y as per the
	 * new values
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
	 * "360 - directionValue" if its in negative Numbers
	 */
	@Test
	void testSetDirectionAntiClockwise() {
		turtle.setDirection(-12); // values means go from antiClockWise direction. starts from 360
		assertEquals(348, turtle.getDirection()); // direction pointing to 348 degree because 360-12 = 348.
	}

	/**
	 * With direction is 0, should move towards angle 0 degree, where x will
	 * increment and y is constant i.e, 0
	 */
	@Test
	void testMove() {
		turtle.moveForward(10);
		assertEquals(10, turtle.getXPosition());
		assertEquals(0, turtle.getYPosition());
	}

	/**
	 * test negative values so that as a value to move should traverse back on the
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
	 * turtle is facing towards 1st quadrant perpendicular to x axis and y axis move
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
	 * turtle is facing towards 1st quadrant (+ +) with angle 45 degree and move
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
	 * turtle is facing towards 2nd quadrant (- +) with angle 110 degree and move
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
	 * turtle is facing towards 3rd quadrant (- -) with angle 195 degree and move
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
	 * turtle is facing towards 1st quadrant perpendicular to x axis and y axis move
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
	 * turtle is facing towards 4th quadrant (+ -) with angle 315 degree and move
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
	 * turtle is facing towards 4th quadrant (+ -) with angle 320 degree and move
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
	 * turtle is facing towards 3rd quadrant (- -) with angle 250 degree and move
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
	 * turtle is facing towards 2nd quadrant (- +) with angle 165 degree and move
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
	 * turtle is facing towards 1st quadrant (+ +) with angle 83 degree and move
	 * forward then backward to see the x and y values are still in 1st
	 * quadrant.should show the x and y positions as 1, 15. calculated based on
	 * trigonometric formula with the help of radius.
	 */
	@Test
	void testMoveBackward1stQuadrant() {
		turtle.setDirection(83);
		turtle.moveForward(20);
		turtle.moveBackward(5);
		assertEquals(83, turtle.getDirection());
		assertEquals(1, turtle.getXPosition());
		assertEquals(15, turtle.getYPosition());
	}

	@Test
	void testReplay() {

		turtle.moveTo(0, 0);
		turtle.setDirection(90);
		turtle.moveForward(10);
		turtle.replay(1, 2);
		assertEquals(0, turtle.x);
		assertEquals(20, turtle.y);
		assertEquals(90, turtle.direction);
		assertEquals(6, turtle.arrayLog.size());
	}

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
		assertEquals(13, turtle.arrayLog.size());
	}
	
	
	@Test
	void testYalper() {

		turtle.moveTo(0, 0);
		turtle.setDirection(90);
		turtle.moveForward(10);
		turtle.yalper(2,1); 
		assertEquals(0, turtle.x);
		assertEquals(20, turtle.y);
		assertEquals(90, turtle.direction);
		assertEquals(6, turtle.arrayLog.size());
	}
	
	
	@Test
	void testYalperTwice() {

		turtle.moveTo(0, 0);
		turtle.setDirection(90);
		turtle.moveForward(10);
		turtle.yalper(2, 1); 
		turtle.yalper(3, 1); 
		turtle.getList();
		assertEquals(0, turtle.x);
		assertEquals(30,turtle.y);
		assertEquals(90,turtle.direction);
		assertEquals(9, turtle.arrayLog.size());
	}
	

	@Test
	void testListisEmpty() {
		assertEquals(0, turtle.arrayLog.size());
	}

	@Test
	void testListContains() {
		turtle.moveTo(3, 8);
		turtle.getList();
		assertEquals(1, turtle.arrayLog.size());
	}


}
