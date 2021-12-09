package hm;

import java.util.ArrayList;
import java.util.Calendar;

//Класс работников
public class Employee implements Runnable{

    @Override
    public void run() {
        while(tasks.stream().count() > 0){
            for (int i = 0; i < tasks.stream().count(); i++){
                taskInProgress(tasks.get(i));
            }
        }
    }

    private  ArrayList<Task> tasks = new ArrayList<Task>();
    private String  name;
    private String lastName;
    private String middleName;
    private Calendar date;
    private String post;
    private String city;
    private long salary;
    private Calendar hiringDate;
    private Boolean working = false;
    private int count;

    public Employee(String name, String lastName, String middleName, Calendar date, String city, long salary, String post){
        this.name = name;
        this.lastName = lastName;
        this.middleName = middleName;
        this.date = date;
        this.city = city;
        this.salary = salary;
        this.post = post;
    }

    //Getters
    public String getName() {
        return name;
    }
    public String getLastName() {
        return lastName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public Calendar getDate() {
        return date;
    }
    public String getPost() {
        return post;
    }
    public String getCity() {
        return city;
    }
    public Long getSalary() {
        return salary;
    }
    public Calendar getHiringDate() {
        return hiringDate;
    }
    public Boolean getWorking() {
        return working;
    }
    public ArrayList<Task> getTasks() {
        return tasks;
    }
    public int getCount(){
        return count;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public void setDate(Calendar date) {
        this.date = date;
    }
    public void setPost(String post) {
        this.post = post;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setSalary(Long salary) {
        this.salary = salary;
    }
    public void setHiringDate(Calendar hiringDate) {
        this.hiringDate = hiringDate;
    }
    public void setWorking(Boolean working) {
        this.working = working;
    }


    public void addTask(Task task){
        tasks.add(task);
        count = tasks.size();
    }
    //Метод, сокращающий время задания
    public void taskInProgress(Task task){
        if(task.getTaskTime() > 0){
            task.taskTimeReduction();
        }
        else{
            System.out.println("Сотрудник "+ name +" сообщает, что задание выполнено!");
            task.setTaskDone(true);
            salary += task.getTaskPrice();
            tasks.remove(task);
        }
    }

    public void showInfo(){
        System.out.println(name + " " + lastName + " " + middleName + "\n");
    }

}
