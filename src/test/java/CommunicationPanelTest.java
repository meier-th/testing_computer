import computer.System;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import panel.CommunicationPanel;
import panel.Panel;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommunicationPanelTest {

    @ParameterizedTest
    @DisplayName(value = "Communication panel name test")
    @ValueSource(strings = {"Panel", "___", "123", "@@@@@vbh__443"})
    public void testName(String name) {
        CommunicationPanel panel = new CommunicationPanel(name);
        assertEquals(name, panel.getName());
    }

    @ParameterizedTest
    @DisplayName(value = "Communication panel state test")
    @EnumSource
    public void testState(System.State state){
        CommunicationPanel panel = new CommunicationPanel("name");
        panel.setState(state);
        switch (state) {
            case OFF, TESTING -> assertEquals(Panel.SideEffect.NONE, panel.getSideEffect());
            case WORKING, TERMINATING -> assertEquals(Panel.SideEffect.HUMMING, panel.getSideEffect());
        }
    }

}
