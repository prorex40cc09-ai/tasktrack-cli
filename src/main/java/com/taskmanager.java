package com.tasktrack;

import java.util.List;

public class TaskManager {

    private List<Task> tasks;
    private FileStorage storage;

    public TaskManager() {
        storage = new FileStorage();
        tasks = storage.loadTasks();
    }

    public void addTask(String description) {

    Task task = new Task(description);
    tasks.add(task);

    storage.saveTasks(tasks);

    System.out.println("Task added: " + description);
}

    public void listTasks() {

        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }

        for (int i = 0; i < tasks.size(); i++) {

            Task task = tasks.get(i);

            String status = task.isCompleted() ? "[x]" : "[ ]";

            System.out.println(i + " " + status + " " + task.getDescription());
        }
    }

    public void completeTask(int index) {

        if (index < 0 || index >= tasks.size()) {
            System.out.println("Invalid task number.");
            return;
        }

        tasks.get(index).complete();

        storage.saveTasks(tasks);

        System.out.println("Task marked as completed.");
    }

    public void deleteTask(int index) {

        if (index < 0 || index >= tasks.size()) {
            System.out.println("Invalid task number.");
            return;
        }

        Task removed = tasks.remove(index);

        storage.saveTasks(tasks);

        System.out.println("Task deleted: " + removed.getDescription());
    }
}
