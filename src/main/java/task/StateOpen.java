package task;

public class StateOpen extends State {
    public StateOpen(Task task) {
        super(task);
    }

    @Override
    public State copy(Task task) {
        return new StateOpen(task);
    }

    @Override
    void up(Object... param) {
        getContext().setState(new StateAssigned(task));
        getContext().setDeveloperId(Integer.parseInt((String) param[0]));
    }

    @Override
    void down(Object... param) {
        getContext().setState(new StateBackLog(task));
    }
}
