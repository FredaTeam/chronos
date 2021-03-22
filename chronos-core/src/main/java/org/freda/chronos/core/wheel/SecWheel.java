package org.freda.chronos.core.wheel;

import org.freda.chronos.core.listener.TaskExeListener;

import java.util.ArrayList;

public class SecWheel extends Wheel {


    private static final int SEC_TEETH_COUNT = 60;


    public SecWheel() {

        super.tasks = new ArrayList[SEC_TEETH_COUNT];

        super.registerListener(new TaskExeListener());
    }
}
