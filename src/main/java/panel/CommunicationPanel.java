package panel;

import computer.System;

public class CommunicationPanel implements Panel {

    private SideEffect sideEffect = SideEffect.NONE;
    private final String name;

    public CommunicationPanel(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public SideEffect getSideEffect() {
        return sideEffect;
    }

    public void setState(System.State state) {
        switch (state) {
            case OFF, TESTING -> this.sideEffect = SideEffect.NONE;
            case TERMINATING, WORKING -> this.sideEffect = SideEffect.HUMMING;
        }
        if (sideEffect == SideEffect.HUMMING)
            java.lang.System.out.printf("Communication panel %s is humming\n", name);
        else
            java.lang.System.out.printf("Communication panel %s went silent\n", name);
    }
}
