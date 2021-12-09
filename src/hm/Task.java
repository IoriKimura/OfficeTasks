package hm;

import java.util.Random;

public class Task {
    private Random Random = new Random();
    private int taskTime;
    private Long taskPrice;
    private boolean taskDone = false;

    public Task(){
        this.taskTime = Random.nextInt(1, 10000);
        this.taskPrice = Random.nextLong(10, 999999999);
    }
    public Task(int time, Long price){
        this.taskTime = time;
        this.taskPrice = price;
    }

    public void taskTimeReduction(){
        taskTime--;
    }

    //Getters
    public int getTaskTime() {
        return taskTime;
    }
    public Long getTaskPrice() {
        return taskPrice;
    }
    public boolean isTaskDone() {
        return taskDone;
    }

    //Setters
    public void setTaskTime(int taskTime) {
        this.taskTime = taskTime;
    }
    public void setTaskPrice(Long taskPrice) {
        this.taskPrice = taskPrice;
    }
    public void setTaskDone(boolean taskDone) {
        this.taskDone = taskDone;
    }
}
