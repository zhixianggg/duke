package duke.logic;

import duke.task.Task;

import java.util.ArrayList;

/**
 * TaskList stores ArrayList of Task(s).
 */
public class TaskList {

    private ArrayList<Task> arr;

    public TaskList() {
        this.arr = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> taskList) {
        this.arr = taskList;
    }

    public void add(Task t) {
        arr.add(t);
    }

    public void delete(int num) {
        assert num < arr.size() && num >= 0;
        arr.remove(num);
    }

    public ArrayList<Task> getArr() {
        return this.arr;
    }

    public Task getLast() {
        return this.arr.get(arr.size() - 1);
    }

    public int getSize() {
        return this.arr.size();
    }

    public void markAsDone(int index) {
        this.arr.get(index).markAsDone();
    }

    public Task getTask(int index) {
        return this.arr.get(index);
    }

    /**
     * Returns new array of matching words Tasks.
     * @param findText the text that contains the words to be found.
     * @return a new ArrayList filled with Tasks.
     */
    public ArrayList<Task> getMatchingWordsList(String findText) {

        assert findText != null : "findText is null";
        ArrayList<Task> matchingWordsList = new ArrayList<>();
        String[] stringArr = findText.split(" ");

        for (Task t : arr) {
            for (String str: stringArr) {
                if (t.getTaskName().contains(str)) {
                    matchingWordsList.add(t);
                    break;
                }
            }
        }

        return matchingWordsList;
    }


    public void setPriority(int index, int taskPriority) {
        this.arr.get(index).setPriority(taskPriority);
    }
}
