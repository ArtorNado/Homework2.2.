package task;

public class StateInProgress extends State {

    public StateInProgress(Task task) {
        super(task);
    }

    @Override
    public Object copy() {
        return new StateInProgress(task);
    }

    @Override
    void up(Object... param) {
        getContext().setState(new StateResolved(task));
    }

    @Override
    void down(Object... param) {
        getContext().setState(new StateAssigned(task));
    }
}
