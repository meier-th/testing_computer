import computer.Computer;
import computer.System;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import panel.CommunicationPanel;
import panel.FrontPanel;
import panel.LED;
import panel.Panel;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SystemTest {

    @Test
    @DisplayName(value = "OS start test")
    public void testStart() {
        Computer computer = new Computer("comp");
        System system = computer.getOs();
        assertEquals(System.State.OFF, system.getState());
        system.load();
        assertEquals(System.State.WORKING, system.getState());
    }

    @Test
    @DisplayName(value = "OS stop test")
    public void stopTest() {
        Computer computer = new Computer("comp");
        System system = computer.getOs();
        system.load();
        system.terminate();
        assertEquals(System.State.OFF, system.getState());
    }

    @Test
    @DisplayName(value = "OS computer API test")
    public void testSideEffects() {
        CommunicationPanel panel = new CommunicationPanel("com_panel");
        FrontPanel panel1 = new FrontPanel("dd", new LED());
        Computer computer = new Computer("comp", panel, panel1);
        System os = computer.getOs();
        assertEquals(Panel.SideEffect.NONE, panel.getSideEffect());
        assertEquals(Panel.SideEffect.NONE, panel1.getSideEffect());
        os.load();
        assertEquals(Panel.SideEffect.HUMMING, panel.getSideEffect());
        assertEquals(Panel.SideEffect.SHINING, panel1.getSideEffect());
        os.terminate();
        assertEquals(Panel.SideEffect.NONE, panel.getSideEffect());
        assertEquals(Panel.SideEffect.NONE, panel1.getSideEffect());
    }

}
