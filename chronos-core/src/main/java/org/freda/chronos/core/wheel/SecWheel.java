package org.freda.chronos.core.wheel;

import org.freda.chronos.core.listener.TaskExeListener;

import java.util.ArrayList;

public class SecWheel extends Wheel {


    private static final int SEC_TEETH_COUNT = 60;


    public SecWheel(int index, Wheel nextWheel) {

        super(index, nextWheel);

        super.tasks = new ArrayList[SEC_TEETH_COUNT];

        super.registerListener(new TaskExeListener());
    }
}
