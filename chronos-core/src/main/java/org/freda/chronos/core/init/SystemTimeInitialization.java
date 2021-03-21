package org.freda.chronos.core.init;

import org.freda.chronos.core.wheel.HourWheel;
import org.freda.chronos.core.wheel.MinWheel;
import org.freda.chronos.core.wheel.SecWheel;
import org.freda.chronos.core.wheel.Wheel;

import java.util.Calendar;

/**
 * 系统初始化
 *
 * 1. 轮初始化
 * 2. 时间初始化
 * 3. 监听初始化
 * 4. run
 */
public class SystemTimeInitialization implements Initialization {

    private boolean isRun = true;

    @Override
    public void init() {

        Calendar calendar = Calendar.getInstance();
        //1. 初始化轮及时间
        Wheel sec = new SecWheel(calendar.get(Calendar.SECOND),
                        new MinWheel(calendar.get(Calendar.MINUTE),
                            new HourWheel(calendar.get(Calendar.HOUR), null)));

        //2. 增加特殊监听

       //3. run
        new Thread(() -> {

            while (isRun) {

                try {

                    sec.next();

                    Thread.sleep(1000);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }).start();
    }
}
