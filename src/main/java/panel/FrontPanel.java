package panel;

import computer.System;

import java.util.List;

public class FrontPanel implements Panel {

    private SideEffect sideEffect = SideEffect.NONE;
    private final List<LED> leds;
    private final String name;

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

    public FrontPanel(String name, LED... leds) {
        this.name = name;
        this.leds = List.of(leds);
    }

    public String getName() {
        return this.name;
    }

    public SideEffect getSideEffect() {
        return sideEffect;
    }

    public void setState(System.State state) {
        if (!leds.isEmpty()) {
            switch (state) {
                case OFF -> {
                    this.sideEffect = SideEffect.NONE;
                    java.lang.System.out.printf("Front panel %s is switched off\n", name);
                }
                case TESTING, TERMINATING -> {
                    this.sideEffect = SideEffect.BLINKING;
                    java.lang.System.out.printf("Front panel %s is blinking\n", name);
                }
                case WORKING -> {
                    this.sideEffect = SideEffect.SHINING;
                    java.lang.System.out.printf("Front panel %s is shining\n", name);
                }
            }
            setLedsMode(state);
        }
    }
}
