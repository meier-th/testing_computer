package computer;

public class System {

    public enum State {
        WORKING,
        TESTING,
        TERMINATING,
        OFF
    }

    private State state = State.OFF;
    private final Computer computer;

    private void setState(State state) {
        this.state = state;
        computer.indicateState(state);
    }

    public System(Computer computer) {
        this.computer = computer;
    }

    public void terminate() {
        setState(State.TERMINATING);
        try {
            Thread.sleep(500);
        } catch (InterruptedException ignored) {}
        finally {
            setState(State.OFF);
        }
    }

    public void load() {
        try {
            test();
            setState(State.WORKING);
        } catch(InterruptedException error) {
            setState(State.OFF);
        }
    }

    public void test() throws InterruptedException {
        setState(State.TESTING);
        Thread.sleep(500);
    }

    public State getState() {
        return state;
    }

}
