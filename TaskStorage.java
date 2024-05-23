package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class TaskStorage {
    private Queue<Task> tasks = new LinkedList<>();

    public synchronized void addTask(Task task) {
        tasks.add(task);
        //Info do threadów o nowym tasku
        notify();
    }

    public synchronized Task getTask() throws InterruptedException {
        while (tasks.isEmpty()) {
            wait();
        }
        return tasks.poll();
    }
}
