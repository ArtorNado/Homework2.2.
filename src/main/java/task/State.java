package task;

public abstract class State implements Copyable {

    Task task;

    public State(Task task) {
        this.task = task;
    }

    public abstract Object copy();

    public Task getContext(){
        return task;
    }

    abstract void up(Object... param);
    abstract void down(Object... param);
}
