public class Messenger implements Runnable {
    private int delaySec;
    public Chronometer chronometer;
    public static boolean finish = false;

    Messenger(int delay, Chronometer chronometer) {
        this.delaySec = delay;
        this.chronometer = chronometer;
    }

    public void startTimer() {
        while (true) {
            synchronized (chronometer) {
                try {
                    if (chronometer.time % this.delaySec == 0 && chronometer.time != 0) {
                        System.out.println("In this stream, the delay is " + this.delaySec);
                    }
                    chronometer.wait();
                    if (finish) return;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public void run() {
        startTimer();
    }
}
