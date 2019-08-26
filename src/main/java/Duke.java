import duke.command.Command;
import duke.logic.DukeException;
import duke.logic.Parser;
import duke.storage.Storage;
import duke.logic.TaskList;
import duke.ui.Ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;


public class Duke {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Duke(String filePath) throws FileNotFoundException {
        ui = new Ui();
        storage = new Storage(filePath);

        tasks = new TaskList(storage.load());

    }

    public void run() throws IOException, DukeException {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine();
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (DukeException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }

    public static void main(String[] args) throws DukeException,IOException {
        Class dukeClass = Duke.class;
        ClassLoader loader = dukeClass.getClassLoader();
        URL myURL = loader.getResource("resources/duke.txt");
        String path = myURL.getPath();
        path = path.replaceAll("%20", " ");

        Duke duke = new Duke(path);
        duke.run();
    }

}
