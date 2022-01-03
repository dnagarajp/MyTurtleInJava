package MyTurtlePackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TurnRightCommandTest {

	@Test
	void testExecute() {
		Turtle t1 = new Turtle();
		Command cm = new TurnRightCommand(t1,90);
		t1.doCommand(cm);
		assertEquals(270, t1.getDirection());
	}
	
	@Test
	void testToString() {
		 Turtle t1 = new Turtle();
		 Command cm = new TurnRightCommand(t1,3);
		 assertEquals(cm.toString(), "turnRight 3");
		
	}

}
