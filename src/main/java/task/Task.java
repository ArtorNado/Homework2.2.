package task;

public class Task implements Copyable, TaskMenegment {
    private Integer taskId;
    private Integer developerId;
    private Integer testerId;
    private String text;
    private String error;

    State state;


    public Task()  {
        this.state = new StateDraft(this);
        this.taskId = TaskId.getNewId();
    }

    public Task(Task task){
        this.taskId = task.taskId;
        this.developerId = task.developerId;
        this.testerId = task.testerId;
        this.text = task.text;
        this.error = task.error;
        this.state = task.state;
    }

    public Object copy(){
        return new Task(this);
    }

    public Integer getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(Integer developerId) {
        this.developerId = developerId;
    }

    public Integer getTesterId() {
        return testerId;
    }

    public void setTesterId(Integer testerId) {
        this.testerId = testerId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void up(Object... param){
        state.up(param[0]);
    }

    public void down(Object... param){
        state.down(param[0]);
    }

    public int getTaskId() {
        return taskId;
    }
}
