package task;

import java.util.ArrayList;

public class TasksStorage {
    
    private static ArrayList<Task> storage = new ArrayList<>();
    
    public static void addTask(Task task){
        storage.add(task);
    }
    
    public static Task getTask(int taskId){
        for (Task t: storage) {
            if (t.getTaskId() == taskId) return t;
        }
        return null;
    }
}
