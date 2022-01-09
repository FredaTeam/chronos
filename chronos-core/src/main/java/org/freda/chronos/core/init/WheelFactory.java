package org.freda.chronos.core.init;

import org.freda.chronos.core.wheel.HourWheel;
import org.freda.chronos.core.wheel.MinWheel;
import org.freda.chronos.core.wheel.SecWheel;
import org.freda.chronos.core.wheel.Wheel;
import org.freda.chronos.core.wheel.WheelEnum;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WheelFactory {

    private static final Map<Class<?>, Wheel> WHEEL_MAP = new ConcurrentHashMap<>();

    /**
     * 获取轮的实例
     *
     * @param clazz
     * @return
     * @throws Exception
     */
    public static Wheel getWheelInstance(Class<? extends Wheel> clazz)  {

        if (null == clazz) {
            return null;
        }

        if (!WHEEL_MAP.containsKey(clazz)) {

            synchronized (WHEEL_MAP) {

                if (!WHEEL_MAP.containsKey(clazz)) {

                    try {
                        WHEEL_MAP.put(clazz, clazz.newInstance());

                    } catch (Exception e) {

                        e.printStackTrace();
                    }
                }
            }
        }
        return WHEEL_MAP.get(clazz);
    }

    public static void buildAllWheels(Calendar calendar) {

        Arrays.stream(WheelEnum.values())
                .forEach( t ->
                    WheelFactory.getWheelInstance(t.getClazz())
                            .setNextWheel(WheelFactory.getWheelInstance(t.getNext())));

        WHEEL_MAP.forEach( (k, v) -> {

            if (k.equals(SecWheel.class)) {
                v.setIndex(calendar.get(Calendar.SECOND));

            } else if (k.equals(MinWheel.class)) {
                v.setIndex(calendar.get(Calendar.MINUTE));

            } else if (k.equals(HourWheel.class)) {
                v.setIndex(calendar.get(Calendar.HOUR));
            }
        });
    }
}
