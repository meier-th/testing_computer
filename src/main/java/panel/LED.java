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
    }

    public Mode getMode() {
        return this.mode;
    }

}
