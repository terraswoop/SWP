import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommandSystemData implements Command {
	@Override
	public void execute() {
		System1.commanddata.stack_push(System.currentTimeMillis());

	}

	@Override
	public void redo() {
		System1.commanddata.stack_push(System1.commanddata.stack_peek());
		
	}

	@Override
	public void undo() {
		System1.commanddata.stack_pop();
		
	}

}
