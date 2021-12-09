package hm;

import java.util.ArrayList;

public class Log {
    private static ArrayList<String> logHistory = new ArrayList<>(); //храним записи

    public static void writeInto(String message){
        System.out.println(message);
        logHistory.add(message);
    }
    public static ArrayList<String> getLogHistory(){
        return logHistory; // сюда обращается поток
        // автосохранения чтобы получить
        // историю логов
    }
}
