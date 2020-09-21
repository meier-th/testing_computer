package computer;

import entity.Observable;
import panel.Panel;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Computer implements Observable {

    private final System os;
    private final List<Panel> panels;
    private final String name;

    public Computer(String name, Panel... panels) {
        this.os = new System(this);
        this.name = name;
        this.panels = Stream.of(panels).collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public void turnOn() {
        java.lang.System.out.printf("Computer %s is turning on...\n", name);
        this.os.load();
    }

    public void turnOff() {
        java.lang.System.out.printf("Computer %s is turning off...\n", name);
        this.os.terminate();
    }

    public System getOs() {
        return os;
    }

    void indicateState(System.State state) {
        panels.forEach(panel -> panel.setState(state));
    }


}
