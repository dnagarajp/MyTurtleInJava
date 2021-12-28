import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestTurtle {

	Turtle turtle;

	@BeforeEach
	void setUp() throws Exception {
		turtle = new Turtle(0, 0, 0);

	}

	@Test
	void testGoToPosition() {

		turtle.goToPosition(5, 6);
		assertEquals(5, turtle.x);
		assertEquals(6, turtle.y);
	}

	@Test
	void testInitialPosition() {

		assertEquals(0, turtle.x);
		assertEquals(0, turtle.y);
	}

	@Test
	void testMoveSouth() {
		turtle.moveSouth(3);
		assertEquals(0, turtle.x);
		assertEquals(-3, turtle.y);
	}

	@Test
	void testMoveNorth() {
		turtle.moveNorth(5);
		assertEquals(0, turtle.x);
		assertEquals(5, turtle.y);
	}

	@Test
	void testMoveEast() {
		turtle.moveEast(4);
		assertEquals(4, turtle.x);
		assertEquals(0, turtle.y);
	}

	@Test
	void testMoveWest() {
		turtle.moveWest(2);
		assertEquals(-2, turtle.x);
		assertEquals(0, turtle.y);
	}

	@Test
	void testInitiallAngle() {
		assertEquals(0, turtle.angle);

	}

	@Test
	void testSetAngle() {
		turtle.setAngle(35);
		assertEquals(35, turtle.angle);
	}

	@Test
	void testMoveForward() {
		turtle.setAngle(45);
		turtle.moveForward(5);
		assertEquals(0, turtle.x);
		assertEquals(5, turtle.y);

	}

	@Test
	void testMoveBackward() {
		turtle.setAngle(90);
		turtle.moveBackward(5);
		assertEquals(0, turtle.x);
		assertEquals(-5, turtle.y);
	}

	@Test
	void testMoveLeft() {
		turtle.setAngle(180);
		turtle.moveLeft(5);
		assertEquals(0, turtle.x);
		assertEquals(-5, turtle.y);
	}

	@Test
	void testMoveRight() {
		turtle.setAngle(270);
		turtle.moveRight(5);
		assertEquals(-5, turtle.x);
		assertEquals(0, turtle.y);
	}

	@Test
	void testLog() {
		turtle.setAngle(270);
		turtle.moveRight(5);
		assertEquals(2, turtle.arrayLog.size());
		assertEquals("setAngle() 270", turtle.arrayLog.get(0));
		assertEquals("moveRight() 5", turtle.arrayLog.get(1));

	}

	@Test
	void testReplay() {

		turtle.goToPosition(0, 0);
		turtle.setAngle(90);
		turtle.moveForward(10);
		turtle.replay(1, 2); // totally the size is 3 together commands here. 1 is reply and 1st - setangle,
								// 2nd forward()
		assertEquals(0, turtle.x);
		assertEquals(20, turtle.y);
		assertEquals(90, turtle.angle);
		assertEquals(6, turtle.arrayLog.size());
	}

	@Test
	void testReplayTwice() {

		turtle.goToPosition(0, 0);
		turtle.setAngle(90);
		turtle.moveForward(10);
		turtle.replay(1, 2); // totally the size is 3 together commands here. 
		turtle.replay(0, 3); // this contains 7 commands in total
		assertEquals(0, turtle.x);
		assertEquals(20, turtle.y);
		assertEquals(90, turtle.angle);
		assertEquals(13, turtle.arrayLog.size());
	}

	@Test
	void testListisEmpty() {
		assertEquals(0, turtle.arrayLog.size());
	}

	@Test
	void testList() {
		turtle.goToPosition(3, 8);
		assertEquals(1, turtle.arrayLog.size());
	}

}
