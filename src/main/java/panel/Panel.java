package panel;

import computer.System;
import entity.Observable;

public interface Panel extends Observable {

    enum SideEffect {
        HUMMING,
        BLINKING,
        SHINING,
        NONE
    }

    SideEffect getSideEffect();

    void setState(System.State state);

}
