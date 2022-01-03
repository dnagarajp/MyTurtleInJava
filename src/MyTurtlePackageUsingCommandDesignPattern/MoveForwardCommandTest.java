package MyTurtlePackageUsingCommandDesignPattern;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MoveForwardCommandTest {

	@Test
	void testExecute() {
		Turtle t1 = new Turtle();
		Command cm = new MoveForwardCommand(t1,9);
		t1.doCommand(cm);
		assertEquals(9, t1.getXPosition());
		assertEquals(0, t1.getYPosition());
	}
	
	@Test
	void testToString() {
		 Turtle t1 = new Turtle();
		 Command cm = new MoveForwardCommand(t1,3);
		 assertEquals(cm.toString(), "moveForward 3");
		
	}
}
