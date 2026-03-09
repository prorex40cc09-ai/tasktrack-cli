package com.tasktrack;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private List<Task> tasks = new ArrayList<>();

    public void addTask(String description) {
        tasks.add(new Task(description));
    }

    public void listTasks() {

        for (int i = 0; i < tasks.size(); i++) {

            Task task = tasks.get(i);

            String status = task.isCompleted() ? "[x]" : "[ ]";

            System.out.println(i + " " + status + " " + task.getDescription());
        }
    }

    public void completeTask(int index) {
        tasks.get(index).complete();
    }
}
