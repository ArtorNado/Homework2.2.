package task;

public class StateInTesting extends State {
    public StateInTesting(Task task) {
        super(task);
    }

    @Override
    public State copy(Task task) {
        return new StateInTesting(task);
    }

    @Override
    void up(Object... param) {
        getContext().setState(new StateClosed(task));
        getContext().setTesterId(null);
        getContext().setDeveloperId(null);
    }

    @Override
    void down(Object... param) {
        getContext().setState(new StateAssigned(task));
        getContext().setError((String)param[1]);
    }
}
