package task;

public class StateAssigned extends State {

    public StateAssigned(Task task) {
        super(task);
    }

    @Override
    public Object copy() {
        return new StateAssigned(task);
    }

    @Override
    void up(Object... param) {
        getContext().setState(new StateInProgress(task));
    }

    @Override
    void down(Object... param) {
        task.setDeveloperId(null);
        getContext().setState(new StateOpen(task));
    }
}
