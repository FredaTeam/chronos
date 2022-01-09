package org.freda.chronos.core.init;

import org.freda.chronos.core.wheel.WheelEnum;

import java.util.Calendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 系统初始化
 *
 * 1. 轮初始化
 * 2. 时间初始化
 * 3. 监听初始化
 * 4. run
 */
public class SystemTimeInitialization implements Initialization, Runnable {

    private static final ScheduledExecutorService POOL = Executors.newScheduledThreadPool(1);

    private boolean isNeedInit = true;

    @Override
    public void init(){

        WheelFactory.buildAllWheels(Calendar.getInstance());

        isNeedInit = false;

    }

    @Override
    public void run() {

        if (isNeedInit) {

            init();
        }

        POOL.scheduleAtFixedRate(() -> WheelEnum.getMain().next(),

                0, 1000, TimeUnit.MILLISECONDS);
    }
}
