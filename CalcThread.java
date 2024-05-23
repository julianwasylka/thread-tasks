package org.example;

public class CalcThread extends Thread {
    private TaskStorage taskStorage;
    private ResultStorage resultStorage;
    private int i;
    private Task currTask;

    public CalcThread(TaskStorage taskStorage, ResultStorage resultStorage) {
        this.taskStorage = taskStorage;
        this.resultStorage = resultStorage;
        i = 0;
    }

    @Override
    public void run() {
        try {
            while (true) {
                currTask = taskStorage.getTask();
                i = 1;

                int n = currTask.getNum();
                for (i = 1; i <= n; i++) {
                    currTask.Leibniz(i);
                    //Symulacja złożoności obliczeń
                    Thread.sleep(100);
                }
                currTask.setPercent((i / n * 100));
                resultStorage.addResult(currTask);
            }
        } catch (InterruptedException e) {
            if (i > 0 && currTask.getPercent() < 100) {
                currTask.setPercent(((i * 100 / currTask.getNum())));
                resultStorage.addResult(currTask);
            }
            Thread.currentThread().interrupt();
        }
    }
}

