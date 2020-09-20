package entity;

public class Observer {

    private Observable observable;
    private boolean waiting = false;
    private boolean staring = false;
    private boolean talking = true;

    public Observable lookingAt() {
        return observable;
    }

    public boolean isWaiting() {
        return waiting;
    }

    public boolean isStaring() {
        return staring;
    }

    public boolean isTalking() {
        return talking;
    }

    public void lookAt(Observable observable) {
        this.observable = observable;
        this.waiting = true;
        this.staring = true;
        this.talking = false;
    }

    public void stopLooking() {
        this.staring = false;
        this.talking = true;
        this.waiting = false;
        this.observable = null;
    }

}
