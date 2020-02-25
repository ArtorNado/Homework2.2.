package task;

public class StateClosed extends State {
    public StateClosed(Task task) {
        super(task);
    }

    @Override
    public State copy(Task task) {
        return new StateClosed(task);
    }

    @Override
    void up(Object... param) {
    }

    @Override
    void down(Object... param) {
    }
}
