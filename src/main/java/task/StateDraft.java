package task;

public class StateDraft extends State {

    public StateDraft(Task task) {
        super(task);
    }

    @Override
    public Object copy() {
        return new StateDraft(task);
    }

    @Override
    void up(Object... param) {
        getContext().setState(new StateOpen(task));
    }

    @Override
    void down(Object... param) {
    }
}