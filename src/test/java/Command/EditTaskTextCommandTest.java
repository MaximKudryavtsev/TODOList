package Command;

import Task.TODOListManager;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class EditTaskTextCommandTest {
    private EditTaskTextCommand command = new EditTaskTextCommand(new ArrayList<String>() {{
        add("1"); add("1"); add("NewText");
    }});

    @Test
    public void getMinRequiredArgsCount() throws Exception {
        assertEquals(3, command.getMinRequiredArgsCount());
    }

    @Test
    public void getMaxOptionalArgsCount() throws Exception {
        assertEquals(3, command.getMaxOptionalArgsCount());
    }

    @Test
    public void execute() throws Exception {
        command.execute(new TODOListManager().getController());
    }

    @Test
    public void getType() throws Exception {
        assertEquals(InputCommandType.EDIT_TASK_TEXT, command.getType());
    }

    @Test
    public void setArguments() throws Exception {
    }
}
