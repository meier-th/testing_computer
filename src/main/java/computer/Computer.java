package computer;

import entity.Observable;
import panel.Panel;

import java.util.List;

public class Computer implements Observable {

    private final System os;
    private final List<Panel> panels;

    public Computer(Panel... panels) {
        this.os = new System(this);
        this.panels = List.of(panels);
    }

    public void turnOn() {
        this.os.load();
    }

    public void turnOff() {
        this.os.terminate();
    }

    public void indicateState(System.State state) {
        panels.forEach(panel -> panel.setState(state));
    }


}
