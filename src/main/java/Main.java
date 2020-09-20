import computer.Computer;
import entity.Observer;
import panel.CommunicationPanel;
import panel.FrontPanel;
import panel.LED;
import panel.Panel;

public class Main {

    public static void main(String[] args) {
        Observer pete = new Observer();
        Observer jack = new Observer();
        Observer jessica = new Observer();
        Computer computer = buildComputer();
        pete.lookAt(computer);
        jack.lookAt(computer);
        jessica.lookAt(computer);
        computer.turnOn();
        pete.stopLooking();
        jack.stopLooking();
        jessica.stopLooking();
        computer.turnOff();
    }

    private static Computer buildComputer() {
        LED led1 = new LED();
        LED led2 = new LED();
        LED led3 = new LED();
        Panel frontPanel = new FrontPanel(led1, led2, led3);
        Panel communicationPanel = new CommunicationPanel();
        return new Computer(frontPanel, communicationPanel);
    }

}
