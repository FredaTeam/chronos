package org.freda.chronos.core.listener;

import org.freda.chronos.core.Task;

import java.util.List;

public interface Listener {
    /**
     * 触发事件
     *
     * @param index
     * @param tasks
     */
    void fire(int index, List<Task> tasks);
}
