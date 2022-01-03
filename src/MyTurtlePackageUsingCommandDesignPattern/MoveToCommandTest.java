package MyTurtlePackageUsingCommandDesignPattern;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MoveToCommandTest {

	@Test
	void testExecute() {
		Turtle t1 = new Turtle();
		Command cm = new MoveToCommand(t1,9,3);
		t1.doCommand(cm);
		assertEquals(9, t1.getXPosition());
		assertEquals(3, t1.getYPosition());
	}
	
	@Test
	void testToString() {
		 Turtle t1 = new Turtle();
		 Command cm = new MoveToCommand(t1,9,3);
		 assertEquals(cm.toString(), "moveTo 9 3");
		
	}


}
