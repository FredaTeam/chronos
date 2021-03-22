package org.freda.chronos.core.wheel;

import org.freda.chronos.core.listener.TaskExeListener;
import org.freda.chronos.core.listener.TaskInitListener;

import java.util.ArrayList;

public class MinWheel extends Wheel {


    private static final int MIN_TEETH_COUNT = 60;

    public MinWheel() {

        super.tasks = new ArrayList[MIN_TEETH_COUNT];

        super.registerListener(new TaskInitListener());
    }
}
