package panel;

import computer.System;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FrontPanel implements Panel {

    private SideEffect sideEffect = SideEffect.NONE;
    private final List<LED> leds;
    private final String name;

    private void setLedsMode(System.State state) {
        LED.Mode mode = LED.Mode.DISABLED;
        switch (state) {
            case TESTING:
            case TERMINATING: mode = LED.Mode.BLINKING; break;
            case WORKING: mode = LED.Mode.ENABLED; break;
        }
        LED.Mode finalMode = mode;
        leds.forEach(led -> led.setMode(finalMode));
    }

    public FrontPanel(String name, LED... leds) {
        this.name = name;
        this.leds = Stream.of(leds).collect(Collectors.toList());
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
                case OFF: {
                    this.sideEffect = SideEffect.NONE;
                    java.lang.System.out.printf("Front panel %s is switched off\n", name);
                    break;
                }
                case TESTING:
                case TERMINATING: {
                    this.sideEffect = SideEffect.BLINKING;
                    java.lang.System.out.printf("Front panel %s is blinking\n", name);
                    break;
                }
                case WORKING: {
                    this.sideEffect = SideEffect.SHINING;
                    java.lang.System.out.printf("Front panel %s is shining\n", name);
                    break;
                }
            }
            setLedsMode(state);
        }
    }
}
