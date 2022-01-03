package MyTurtlePackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ReplayCommandTest {

	@Test
	void testExecute() {
		Turtle t1 = new Turtle();
		Command cm = new MoveForwardCommand(t1,10);
		Command cm1 = new MoveForwardCommand(t1,10);
		Command cm2 = new ReplayCommand(t1, 0, 0);
		t1.doCommand(cm);
		t1.doCommand(cm1);
		t1.doCommand(cm2);
		assertEquals(30, t1.getXPosition());
		assertEquals(0, t1.getYPosition());
	}

	@Test
	void testToString() {
		Turtle t1 = new Turtle();
		Command cm = new ReplayCommand(t1, 1, 2);
		assertEquals(cm.toString(), "replay 1 2");

	}

}
