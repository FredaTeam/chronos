package org.freda.chronos.core.wheel;

import org.freda.chronos.core.listener.TaskExeListener;

import java.util.ArrayList;

public class HourWheel extends Wheel {

    private static final int HOUR_TEETH_COUNT = 24;

    public HourWheel() {

        super.tasks = new ArrayList[HOUR_TEETH_COUNT];

        super.registerListener(new TaskExeListener());
    }
}
