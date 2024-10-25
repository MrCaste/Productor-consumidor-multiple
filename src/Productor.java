import java.util.Random;

public class Productor extends Thread {

    private Gotas gota;
    private Random random;
    private int milis = 0;
    public int totalMilis = 0;

    public Productor(String name, Gotas gota) {
        super(name);
        this.gota = gota;
        this.random = new Random();
    }

    @Override
    public void run() {
       while (!isInterrupted()){
        milis = random.nextInt(1,10);
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        gota.setVolumen();
       }
    }
}
