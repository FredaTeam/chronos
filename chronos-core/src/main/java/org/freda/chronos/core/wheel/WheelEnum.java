package org.freda.chronos.core.wheel;

import org.freda.chronos.core.init.WheelFactory;

import java.util.Arrays;

public enum WheelEnum {

    SEC(SecWheel.class, MinWheel.class),

    MIN(MinWheel.class, HourWheel.class),

    HOUR(HourWheel.class, null);

    private Class<? extends Wheel> clazz;

    private Class<? extends Wheel> next;

    WheelEnum(Class<? extends Wheel> clazz, Class<? extends Wheel> next) {

        this.clazz = clazz;

        this.next = next;
    }

    public Class<? extends Wheel> getClazz() {
        return clazz;
    }

    public Class<? extends Wheel> getNext() {
        return next;
    }

    public static Wheel getFont(Class<? extends Wheel> clazz) {

        WheelEnum wheelEnum = Arrays.stream(WheelEnum.values()).filter( t -> t.getNext().equals(clazz)).findFirst().orElse(null);

        return WheelFactory.getWheelInstance(null != wheelEnum ? wheelEnum.getClazz() : null);
    }
}
