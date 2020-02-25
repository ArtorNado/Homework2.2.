package task;

public class StateBackLog extends State {

    public StateBackLog(Task task) {
        super(task);
    }

    @Override
    public State copy(Task task) {
        return new StateBackLog(task);
    }

    @Override
    void up(Object... param) {
        getContext().setState(new StateOpen(this.task));
    }

    @Override
    void down(Object... param) {
    }
}
