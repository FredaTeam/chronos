package org.freda.chronos.core.wheel;

import org.freda.chronos.core.init.WheelFactory;

import java.util.Arrays;

public enum WheelEnum {

    SEC(SecWheel.class, MinWheel.class, true),

    MIN(MinWheel.class, HourWheel.class, false),

    HOUR(HourWheel.class, null, false);

    private Class<? extends Wheel> clazz;

    private Class<? extends Wheel> next;

    private boolean isMain;

    WheelEnum(Class<? extends Wheel> clazz, Class<? extends Wheel> next, boolean isMain) {

        this.clazz = clazz;

        this.next = next;

        this.isMain = isMain;
    }

    public Class<? extends Wheel> getClazz() {
        return clazz;
    }

    public Class<? extends Wheel> getNext() {
        return next;
    }

    public boolean isMain() {
        return isMain;
    }

    public static Wheel getFont(Class<? extends Wheel> clazz) {

        WheelEnum wheelEnum = Arrays.stream(WheelEnum.values()).filter( t -> t.getNext().equals(clazz)).findFirst().orElse(null);

        return WheelEnum.getInstance(wheelEnum);
    }

    public static Wheel getMain() {

        WheelEnum wheelEnum = Arrays.stream(WheelEnum.values()).filter( t -> t.isMain).findFirst().orElse(null);

        return WheelEnum.getInstance(wheelEnum);
    }

    public static Wheel getInstance(WheelEnum wheelEnum) {

        return null == wheelEnum ? null : WheelFactory.getWheelInstance(wheelEnum.getClazz());
    }
}
