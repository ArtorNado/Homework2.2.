package task;

import org.apache.commons.logging.Log;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TaskProxy implements TaskMenegment {

    private TaskMenegment menegment;
    static Logger LOGGER;

    public TaskProxy(TaskMenegment menegment) {
        this.menegment = menegment;
    }

    @Override
    public void up(Object... param) {
        LOGGER.log(Level.INFO, "Пользователь вызвал метод up для Таска:" + menegment.getTaskId());
        getState().up(param[0]);
    }

    @Override
    public void down(Object... param) {
        LOGGER.log(Level.INFO, "Пользователь вызвал метод down для Таска:" + menegment.getTaskId());
        getState().down(param[0]);
    }

    @Override
    public int getTaskId() {
        LOGGER.log(Level.INFO, "Пользователь вызвал метод getTaskId для Таска:" + menegment.getTaskId());
        return menegment.getTaskId();
    }

    @Override
    public State getState() {
        LOGGER.log(Level.INFO, "Пользователь вызвал метод getState для Таска:" + menegment.getTaskId());
        return menegment.getState();
    }

}
