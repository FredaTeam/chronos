package org.freda.chronos.core.wheel;

import org.freda.chronos.core.listener.Listener;
import org.freda.chronos.core.Task;

import java.util.ArrayList;
import java.util.List;

public abstract class Wheel implements Rotatable {

    /**
     * 标尺
     */
    protected List<Task>[] tasks;

    /**
     * 下标
     */
    private int index = 0;

    /**
     * 传动轮
     */
    private Wheel nextWheel;
    /**
     * 观察者监听
     */
    private final List<Listener> listeners = new ArrayList<>();

    /**
     * 传动
     *
     * @return 当前转动的坐标
     */
    public int next() {

        index ++;
        //轮如果转到最后,则重新开始循环
        if (index >= tasks.length) {
            //如果有传动轮,则转动一周后,转动一次传动轮
            if (null != nextWheel) {

                nextWheel.next();
            }
            index = 0;
        }
        this.notifyListener();

        return index;
    }

    /**
     * 发布跳动消息.
     *
     */
    private void notifyListener() {



        this.listeners.forEach(t -> t.fire(this.index, this.getTasks()));
    }

    /**
     * 注册监听
     * @param listener 监听
     */
    public void registerListener(Listener listener) {

        this.listeners.add(listener);
    }

    /**
     * 删除监听
     * @param listener 监听
     */
    public void removeListener(Listener listener) {

        this.listeners.remove(listener);
    }

    public int getIndex() {
        return index;
    }

    public Wheel getNextWheel() {
        return nextWheel;
    }

    public void setNextWheel(Wheel nextWheel) {
        this.nextWheel = nextWheel;
    }

    public List<Task> getTasks() {

        return tasks[index];
    }

    /**
     * 将任务添加至轮中.
     *
     * @param task 目标任务
     * @param index 轮上刻度
     */
    public void addTask(Task task, int index) {

        if (index < 0 || index >= tasks.length) {

            throw new IllegalArgumentException("index out of bounds.");
        }

        tasks[index].add(task);
    }

}
