package panel;

public class LED {

    public enum Mode {
        DISABLED,
        ENABLED,
        BLINKING
    }

    private Mode mode = Mode.DISABLED;

    public void setMode(Mode mode) {
        this.mode = mode;
        System.out.println("LED is "+mode.name());
    }

    public Mode getMode() {
        return this.mode;
    }

}
