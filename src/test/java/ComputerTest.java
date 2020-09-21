import computer.Computer;
import computer.System;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import panel.CommunicationPanel;
import panel.FrontPanel;
import panel.LED;
import panel.Panel;

import static org.junit.jupiter.api.Assertions.*;

public class ComputerTest {

    @ParameterizedTest
    @DisplayName(value = "Computer name test")
    @ValueSource(strings = {"pc", "12", "null", "/dev/null"})
    public void testName(String name) {
        Computer computer = new Computer(name);
        assertEquals(name, computer.getName());
    }

    @Test
    @DisplayName(value = "Computer OS test")
    public void testOS() {
        Computer computer = new Computer("name");
        assertNotNull(computer.getOs());
    }

    @Test
    @DisplayName(value = "Computer turn on test")
    public void turnOnTest() {
        Panel panel = new CommunicationPanel("panel");
        Panel panel1 = new FrontPanel("panel1", new LED());
        Computer computer = new Computer("name", panel, panel1);
        assertEquals(System.State.OFF, computer.getOs().getState());
        assertEquals(Panel.SideEffect.NONE, panel.getSideEffect());
        assertEquals(Panel.SideEffect.NONE, panel1.getSideEffect());
        computer.turnOn();
        assertEquals(System.State.WORKING, computer.getOs().getState());
        assertEquals(Panel.SideEffect.HUMMING, panel.getSideEffect());
        assertEquals(Panel.SideEffect.SHINING, panel1.getSideEffect());
    }

    @Test
    @DisplayName(value = "Computer turn off test")
    public void turnOffTest() {
        Panel panel = new CommunicationPanel("panel");
        Panel panel1 = new FrontPanel("panel1", new LED());
        Computer computer = new Computer("name", panel, panel1);
        computer.turnOn();
        computer.turnOff();
        assertEquals(System.State.OFF, computer.getOs().getState());
        assertEquals(Panel.SideEffect.NONE, panel.getSideEffect());
        assertEquals(Panel.SideEffect.NONE, panel1.getSideEffect());
    }

}
