package org.freda.chronos.core.wheel;

import org.freda.chronos.core.init.WheelFactory;
import org.freda.chronos.core.listener.TaskExeListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class SecWheel extends Wheel {


    private static final int SEC_TEETH_COUNT = 60;

    private static final Logger LOGGER = LoggerFactory.getLogger(SecWheel.class);


    public SecWheel() {

        super.tasks = new ArrayList[SEC_TEETH_COUNT];

        super.registerListener(new TaskExeListener());
    }

    @Override
    public int next() {

        LOGGER.info("Wheel time {}", String.format("%02d",WheelFactory.getWheelInstance(HourWheel.class).getIndex()) + "-"
                + String.format("%02d",WheelFactory.getWheelInstance(MinWheel.class).getIndex()) + "-" + String.format("%02d",this.getIndex()));

        return super.next();
    }
}
