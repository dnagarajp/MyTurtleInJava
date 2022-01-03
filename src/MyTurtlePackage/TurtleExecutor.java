package MyTurtlePackage;
import java.util.ArrayList;
import java.util.List;

public class TurtleExecutor {

	private final List<Command> commandOperation = new ArrayList<>();

	public void executeOperation(Command comma) {
		commandOperation.add(comma);
		comma.execute();
			}
}
