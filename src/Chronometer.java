public class Chronometer {
    public int time = 0;

    public void startCounter() {
        while (true) {
            synchronized (this) {
                time++;
                System.out.print("Left time " + time + " sec. ");
                this.notifyAll();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
