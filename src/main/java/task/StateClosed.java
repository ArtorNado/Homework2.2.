package task;

public class StateClosed extends State {
    public StateClosed(Task task) {
        super(task);
    }
    @Override
    public Object copy() {
        return new StateClosed(task);
    }

    @Override
    void up(Object... param) {
    }

    @Override
    void down(Object... param) {
    }
}
