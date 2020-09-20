package entity;

public class Observer {

    private Observable observable;
    private boolean waiting = false;
    private boolean staring = false;
    private boolean talking = true;
    private final String name;

    public Observer(String name) {
        this.name = name;
    }

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
        System.out.printf("Observer %s is looking at %s\n", name, observable.getName());
    }

    public void stopLooking() {
        this.staring = false;
        this.talking = true;
        this.waiting = false;
        System.out.printf("Observer %s has stopped looking at %s\n", name, observable.getName());
        this.observable = null;
    }

}
