package MyTurtlePackageUsingCommandDesignPattern;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MoveBackwardCommandTest {

	@Test
	void testExecute() {
		Turtle t1 = new Turtle();
		Command cm = new MoveBackwardCommand(t1,9);
		t1.doCommand(cm);
		assertEquals(-9, t1.getXPosition());
		assertEquals(0, t1.getYPosition());
	}
	
	@Test
	void testToString() {
		 Turtle t1 = new Turtle();
		 Command cm = new MoveBackwardCommand(t1,3);
		 assertEquals(cm.toString(), "moveBackward 3");
		
	}

}
