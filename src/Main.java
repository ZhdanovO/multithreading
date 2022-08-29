
public class Main {
    public static void main(String[] args) {

        Chronometer chronometer = new Chronometer();
        Runnable messenger1 = new Messenger(1, chronometer);
        Runnable messenger2 = new Messenger(5, chronometer);
        Runnable messenger3 = new Messenger(7, chronometer);
        new Thread(messenger1).start();
        new Thread(messenger2).start();
        new Thread(messenger3).start();
        chronometer.startCounter();
    }
}
