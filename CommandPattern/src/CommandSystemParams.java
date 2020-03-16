import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommandSystemParams implements Command {
	DateFormat df = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
	Date dateobj = new Date();
	@Override
	public void execute() {
		System1.configdata.stack_push("Batuhan stinkt am "+df.format(dateobj));

	}

	@Override
	public void redo() {
		System1.configdata.stack_push(System1.configdata.stack_peek());
		
	}

	@Override
	public void undo() {
		System1.configdata.stack_pop();
		
	}

}
