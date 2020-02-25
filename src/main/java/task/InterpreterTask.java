package task;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InterpreterTask {

    private Task task;
    private String[] subStr;
    private String delimiter = "<";
    private int taskId;
    private String argument;

    public int doCommand(String command) {
        if (command.startsWith("new task <Колонизация марса>")) {
            return newTask();
        }
        if (command.startsWith("up")) {
            upTask(command);
        }
        if (command.startsWith("down")) {
            downTask(command);
        }
        return 0;
    }

    private int newTask() {
        Task task = new Task();
        return task.getTaskId();
    }

    private void upTask(String command) {
        subStr = splitSubStr(command);
        argument = subStr[1];
        task = getTask(subStr[0]);
        task.getState().up(argument);
    }

    private void downTask(String command){
        subStr = splitSubStr(command);
        argument = subStr[1];
        task = getTask(subStr[0]);
        task.getState().down(argument);
    }

    private Task getTask(String id){
        taskId = Integer.parseInt(subStr[0]);
        argument = subStr[1];
        return TasksStorage.getTask(taskId);
    }

    private String[] splitSubStr(String command){
        delimiter = "<";
        subStr = command.split(delimiter);
        return takeOff(subStr);
    }

    private String[] takeOff(String[] subStr) {
        String regex = "(.*)(?=>)";
        Pattern p = Pattern.compile(regex);
        int i = 0;
        for (String s : subStr) {
            Matcher m = p.matcher(s);
            if (m.find()) {
                subStr[i] = m.group(1);
                i++;
            }
        }
        return subStr;
    }
}
