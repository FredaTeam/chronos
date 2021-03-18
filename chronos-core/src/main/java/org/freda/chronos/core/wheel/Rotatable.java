package org.freda.chronos.core.wheel;

/**
 * 可转动
 */
public interface Rotatable {

    /**
     * 转动到下一个tick
     *
     * @return 当前tick
     */
    int next();
}
