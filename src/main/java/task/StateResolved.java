package task;

public class StateResolved extends State {

    public StateResolved(Task task) {
        super(task);
    }

    @Override
    public State copy(Task task) {
        return new StateResolved(task);
    }

    @Override
    void up(Object... param) {
        getContext().setState(new StateInTesting(task));
        getContext().setTesterId((Integer) param[1]);
    }

    @Override
    void down(Object... param) {
        getContext().setState(new StateInProgress(task));
    }
}
