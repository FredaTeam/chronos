package org.freda.chronos.core.listener;

import org.freda.chronos.core.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 执行当前任务
 */
public class TaskExeListener implements Listener {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskExeListener.class);

    @Override
    public void fire(int index, List<Task> tasks) {

        //LOGGER.info("fire index={}, tasks= {}", index, tasks);
    }
}
