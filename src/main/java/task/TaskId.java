package task;

public class TaskId {

    private static int taskId = 0;

    public static int getNewId(){
        return ++taskId;
    }
}
