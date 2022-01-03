package MyTurtlePackageUsingCommandDesignPattern;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SetDirectionCommandTest {

	@Test
	void testExecute() {
		Turtle t1 = new Turtle();
		Command cm = new SetDirectionCommand(t1,9);
		t1.doCommand(cm);
		assertEquals(9, t1.getDirection());

	}
	
	@Test
	void testToString() {
		 Turtle t1 = new Turtle();
		 Command cm = new SetDirectionCommand(t1,3);
		 assertEquals(cm.toString(), "setDirection 3");
		
	}

}
