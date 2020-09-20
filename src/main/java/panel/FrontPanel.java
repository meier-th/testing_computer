package panel;

import computer.System;

import java.util.List;

public class FrontPanel implements Panel {

    private SideEffect sideEffect = SideEffect.NONE;
    private final List<LED> leds;

    private void setLedsMode(System.State state) {
        LED.Mode mode = LED.Mode.DISABLED;
        switch (state) {
            case OFF -> {
            }
            case TESTING, TERMINATING -> mode = LED.Mode.BLINKING;
            case WORKING -> mode = LED.Mode.ENABLED;
        }
        LED.Mode finalMode = mode;
        leds.forEach(led -> led.setMode(finalMode));
    }

    public FrontPanel(LED... leds) {
        this.leds = List.of(leds);
    }

    public SideEffect getSideEffect() {
        return sideEffect;
    }

    public void setState(System.State state) {
        switch (state) {
            case OFF -> this.sideEffect = SideEffect.NONE;
            case TESTING, TERMINATING -> this.sideEffect = SideEffect.BLINKING;
            case WORKING -> this.sideEffect = SideEffect.SHINING;
        }
    }
}
