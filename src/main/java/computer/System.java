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
        java.lang.System.out.printf("OS of %s is terminating...\n", computer.getName());
        setState(State.TERMINATING);
        try {
            Thread.sleep(500);
        } catch (InterruptedException ignored) {}
        finally {
            java.lang.System.out.printf("OS of %s is turned off\n", computer.getName());
            setState(State.OFF);
        }
    }

    public void load() {
        try {
            java.lang.System.out.printf("OS of %s is loading...\n", computer.getName());
            test();
            setState(State.WORKING);
            java.lang.System.out.printf("OS of %s is loaded\n", computer.getName());
        } catch(InterruptedException error) {
            java.lang.System.out.printf("OS of %s has failed to start\n", computer.getName());
            setState(State.OFF);
        }
    }

    public void test() throws InterruptedException {
        java.lang.System.out.printf("OS of %s is testing...\n", computer.getName());
        setState(State.TESTING);
        Thread.sleep(500);
    }

    public State getState() {
        return state;
    }

}
