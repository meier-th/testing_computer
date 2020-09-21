import computer.System;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import panel.FrontPanel;
import panel.LED;
import panel.Panel;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FrontPanelTest {

    @ParameterizedTest
    @DisplayName(value = "Front panel name test")
    @ValueSource(strings = {"Panel1", "ferfreg", "-1", "null"})
    public void testName(String name) {
        FrontPanel panel = new FrontPanel(name);
        assertEquals(panel.getName(), name);
    }

    @ParameterizedTest
    @DisplayName(value = "Front panel state test")
    @EnumSource
    public void testState(System.State state) {
        FrontPanel panel = new FrontPanel("panel", new LED());
        panel.setState(state);
        switch (state) {
            case OFF -> assertEquals(Panel.SideEffect.NONE, panel.getSideEffect());
            case WORKING -> assertEquals(Panel.SideEffect.SHINING, panel.getSideEffect());
            case TERMINATING, TESTING -> assertEquals(Panel.SideEffect.BLINKING, panel.getSideEffect());
        }
    }

    @ParameterizedTest
    @DisplayName(value = "Front panel without LEDs test")
    @EnumSource
    public void testNoLedsState(System.State state) {
        FrontPanel panel = new FrontPanel("name");
        panel.setState(state);
        assertEquals(Panel.SideEffect.NONE, panel.getSideEffect());
    }

    @ParameterizedTest
    @DisplayName(value = "Front panel LED test")
    @EnumSource
    public void testLEDState(System.State state) {
        LED led1 = new LED();
        LED led2 = new LED();
        FrontPanel panel = new FrontPanel("name", led1, led2);
        panel.setState(state);
        switch (state) {
            case OFF -> {
                assertEquals(LED.Mode.DISABLED, led1.getMode());
                assertEquals(LED.Mode.DISABLED, led2.getMode());
            }
            case WORKING -> {
                assertEquals(LED.Mode.ENABLED, led1.getMode());
                assertEquals(LED.Mode.ENABLED, led2.getMode());
            }
            case TERMINATING, TESTING -> {
                assertEquals(LED.Mode.BLINKING, led1.getMode());
                assertEquals(LED.Mode.BLINKING, led2.getMode());
            }
        }
    }

}
