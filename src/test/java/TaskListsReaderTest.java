import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class TaskListsReaderTest {
    @org.junit.Test
    public void read() throws Exception {
        // 1. Create file with xml content.
        writeXmlData("temp.xml");
        // 2. Read tasks from it.
        ArrayList<TaskList> taskLists = TaskListsReader.read("temp.xml");
        assertEquals(2, taskLists.size());
        assertEquals(1, taskLists.get(0).toArrayList().size());
        assertEquals(1, taskLists.get(1).toArrayList().size());
        Task task1 = taskLists.get(0).toArrayList().get(0);
        Task task2 = taskLists.get(1).toArrayList().get(0);
        assertEquals("Do something", task1.getText());
        assertEquals(1, task1.getId());
        assertEquals(TaskStatus.IN_PROGRESS, task1.getStatus());
        assertEquals(task1.getText(), task2.getText());
        assertEquals(task1.getId(), task2.getId());
        assertEquals(task1.getStatus(), task2.getStatus());
    }

    private void writeXmlData(final String filePath) throws Exception {
        File file = new File(filePath);
        PrintStream stream = new PrintStream(file);
        stream.println("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" +
                "<Root>\n" +
                "    <TaskList id=\"1\" name=\"TODO List Number One\">\n" +
                "        <Task id=\"1\" status=\"in progress\">Do something</Task>\n" +
                "    </TaskList>\n" +
                "    <TaskList id=\"2\" name=\"TODO List Number Two\">\n" +
                "        <Task id=\"1\" status=\"in progress\">Do something</Task>\n" +
                "    </TaskList>\n" +
                "</Root>");
    }
}