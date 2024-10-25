public class Consumidor extends Thread {

    private Gotas gota;
    private int volumenContador = 0;

    public Consumidor(String name, Gotas gota, ThreadGroup consumidores) {
        super(consumidores, name);
        this.gota = gota;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            if(gota.getVolumen()){
                volumenContador++;
                System.out.println(Thread.currentThread().getName() + ":" + volumenContador);
            }
        }
    }

    public int getVolumenContador() {
        return volumenContador;
    } 
}
