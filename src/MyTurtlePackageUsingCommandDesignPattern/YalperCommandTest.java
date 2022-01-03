package MyTurtlePackageUsingCommandDesignPattern;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class YalperCommandTest {

	@Test
	void testExecute() {
		Turtle t1 = new Turtle();
		Command cm = new MoveForwardCommand(t1,10);
		Command cm1 = new MoveForwardCommand(t1,10);
		Command cm2 = new YalplerCommand(t1, 1, 0);
		t1.doCommand(cm);
		t1.doCommand(cm1);
		t1.doCommand(cm2);
		assertEquals(40, t1.getXPosition());
		assertEquals(0, t1.getYPosition());
	}

	@Test
	void testToString() {
		Turtle t1 = new Turtle();
		Command cm = new YalplerCommand(t1, 1,0 );
		assertEquals(cm.toString(), "yalper 1 0");

	}

}
