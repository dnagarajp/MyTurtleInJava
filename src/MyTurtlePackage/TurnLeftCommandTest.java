package MyTurtlePackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TurnLeftCommandTest {

	@Test
	void testExecute() {
		Turtle t1 = new Turtle();
		Command cm = new TurnLeftCommand(t1,90);
		t1.doCommand(cm);
		assertEquals(90, t1.getDirection());
	}
	
	@Test
	void testToString() {
		 Turtle t1 = new Turtle();
		 Command cm = new TurnLeftCommand(t1,3);
		 assertEquals(cm.toString(), "turnLeft 3");
		
	}

}
