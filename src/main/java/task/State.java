package task;

public abstract class State {

    Task task;

    public State(Task task) {
        this.task = task;
    }

    public abstract State copy(Task task);

    public Task getContext(){
        return task;
    }

    abstract void up(Object... param);
    abstract void down(Object... param);
}
