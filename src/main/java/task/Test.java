package task;

import interpreter.Interpreter;

public class Test {

    Task task;

    public static void main(String[] args) {
        TaskProxy proxy = new TaskProxy(new Task());
        proxy.up("1233");
        proxy.up("12");
        System.out.println(proxy.getState().toString() + "  " + proxy.getTaskId());
        /*task.getState().up();
        InterpreterTask interpreterTask = new InterpreterTask();
        interpreterTask.doCommand("up <1> <12>");
        System.out.println(task.getState().toString());
        System.out.println(task.getDeveloperId()+ " developer id in original task");
        State orig = new StateInProgress(task);
        State fake = (State) orig.copy();
        System.out.println();*/
    }
}
