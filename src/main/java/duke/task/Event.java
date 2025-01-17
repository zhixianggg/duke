package duke.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Event class object.
 */
public class Event extends Task {

    private LocalDateTime dateTime;

    public Event(String taskName, LocalDateTime dateTime) {
        super(taskName);
        this.dateTime = dateTime;
    }

    @Override
    public String getType() {
        return "E";
    }

    public String getDateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yyyy HHmm");
        return this.dateTime.format(dtf);
    }


    @Override
    public String toString() {
        return String.format("[%s][%s] %s (at: %s) (%s)",
                this.getType(), isDone ? "1" : "0",
                this.taskName, this.getDateTime(), getPriorityString());
    }
}
