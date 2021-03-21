package org.freda.chronos.core.wheel;

import org.freda.chronos.core.listener.TaskInitListener;

import java.util.ArrayList;

public class HourWheel extends Wheel {

    private static final int HOUR_TEETH_COUNT = 60;

    public HourWheel(int index, Wheel nextWheel) {

        super(index, nextWheel);

        super.tasks = new ArrayList[HOUR_TEETH_COUNT];

        super.registerListener(new TaskInitListener());
    }
}
