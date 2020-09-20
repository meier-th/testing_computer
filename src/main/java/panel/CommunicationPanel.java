package panel;

import computer.System;

public class CommunicationPanel implements Panel {

    private SideEffect sideEffect = SideEffect.NONE;

    public SideEffect getSideEffect() {
        return sideEffect;
    }

    public void setState(System.State state) {
        switch (state) {
            case OFF, TESTING -> this.sideEffect = SideEffect.NONE;
            case TERMINATING, WORKING -> this.sideEffect = SideEffect.HUMMING;
        }
    }
}
