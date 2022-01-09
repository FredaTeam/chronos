package org.freda.chronos.core.wheel;

import org.freda.chronos.core.init.SystemTimeInitialization;
import org.junit.jupiter.api.Test;

public class WheelTest {

    @Test
    public void secArrayTest() throws Exception{

        new SystemTimeInitialization().run();

        Thread.sleep(100000);
    }
}
