import entity.Observable;
import entity.Observer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import panel.CommunicationPanel;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ObserverTest {

    @ParameterizedTest
    @DisplayName(value = "Observer look at test")
    @MethodSource("observableFactory")
    public void testLookAt(Observable observable) {
        Observer observer = new Observer("name");
        assertTrue(observer.isTalking());
        assertFalse(observer.isStaring());
        assertFalse(observer.isWaiting());
        observer.lookAt(observable);
        assertFalse(observer.isTalking());
        assertTrue(observer.isWaiting());
        assertTrue(observer.isStaring());
    }

    @ParameterizedTest
    @DisplayName(value = "Observer stop looking test")
    @MethodSource("observableFactory")
    public void testDtopLooking(Observable observable) {
        Observer observer = new Observer("name");
        observer.lookAt(observable);
        observer.stopLooking();
        assertTrue(observer.isTalking());
        assertFalse(observer.isStaring());
        assertFalse(observer.isWaiting());
    }

    public static Stream<Observable> observableFactory() {
        return Stream.of(new CommunicationPanel("name"));
    }

}
