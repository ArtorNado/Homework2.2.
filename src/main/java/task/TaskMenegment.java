package task;

public interface TaskMenegment {

    void up(Object... param);

    void down(Object... param);

    int getTaskId();

    State getState();
}
