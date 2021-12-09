package hm;

import java.util.GregorianCalendar;
import java.util.Random;

public class GenerateLogic implements  Runnable{

    static private String[] workersNames = {"Alex","James","Sofia","Anna","David","Eve"};
    static private String[] workersLastNames = {"Brown","Smith","Stacy","Jostar","Penivers","Black"};
    static private String[] workersMiddleNames = {"Blacke","John","Grave","Bruh"};
    static private String[] workersCities = {"L.A.","California","New-York","London","Paris","Moscow","Texas"};
    static private String[] workersPosts = {"C#-developer","Java-developer","Team Leader","New Blood","Web-developer"};

    //Getters
    public String[] getWorkersNames() {
        return workersNames;
    }
    public String[] getWorkersLastNames() {
        return workersLastNames;
    }
    public String[] getWorkersMiddleNames() {
        return workersMiddleNames;
    }
    public String[] getWorkersCities() {
        return workersCities;
    }

    //Setters
    public void setWorkersNames(String[] workersNames) {
        this.workersNames = workersNames;
    }
    public void setWorkersLastNames(String[] workersLastNames) {
        this.workersLastNames = workersLastNames;
    }
    public void setWorkersMiddleNames(String[] workersMiddleNames) {
        this.workersMiddleNames = workersMiddleNames;
    }
    public void setWorkersCities(String[] workersCities) {
        this.workersCities = workersCities;
    }

    static public void creation(){
        Random random = new Random();
        for(int i = 0; i<10;i++){
            Main.workers.add(new Employee(workersNames[random.nextInt(workersNames.length)],workersLastNames[random.nextInt(workersLastNames.length)],
                    workersMiddleNames[random.nextInt(workersMiddleNames.length)], new GregorianCalendar(random.nextInt(1990,2001),
                    random.nextInt(1,13),random.nextInt(1,27)), workersCities[random.nextInt(workersCities.length)],
                    (long)random.nextInt(30000,300000), workersPosts[random.nextInt(workersPosts.length)]));
        }
    }

    static public void giveTask(){
        Random random = new Random();
        for (Employee emp : Main.workers) {
            int howManyTasks = random.nextInt(1,5);
            for (int i = 0; i < howManyTasks; i++){
                if(Main.tasks == null) return;
                emp.addTask(Main.tasks.get(random.nextInt(0,Main.tasks.size())));
                System.out.println(emp.getName() + " " + emp.getLastName() + " получил новое задание!");
            }
        }
    }
    private void work(){
        for (Employee emp : Main.workers ) {
            emp.run();
        }
    }

    @Override
    public void run() {
        creation();
        System.out.println("Работники получают свои задания:");
        giveTask();
        System.out.println();
        System.out.println("Работники получили свои задания и сели за них!");
        work();
    }
}
