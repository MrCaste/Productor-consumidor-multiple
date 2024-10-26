public class App {
    public static void main(String[] args) throws Exception {
        App main = new App();
        main.inicializarProductorConsumidor();
    }

    public void inicializarProductorConsumidor(){
        Gotas gota = new Gotas();
        Productor producer = new Productor("Producer",gota);
        producer.start();
        ThreadGroup consumidores = new ThreadGroup("Consumidores");
        Consumidor consumer1 = new Consumidor("Botella 1", gota, consumidores);
        Consumidor consumer2 = new Consumidor("Botella 2", gota, consumidores);
        Consumidor consumer3 = new Consumidor("Botella 3", gota, consumidores);
        Consumidor consumer4 = new Consumidor("Botella 4", gota, consumidores);
        consumer1.start();
        consumer2.start();
        consumer3.start();
        consumer4.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace(); 
        }
        Consumidor[] consumers = new Consumidor[4];
        consumidores.enumerate(consumers);

        producer.interrupt();
        consumidores.interrupt();

        for (int i = 0; i < consumers.length; i++) {
            try {
                consumers[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\n");
        for (int i = 0; i < consumers.length; i++) {
            System.out.println(consumers[i].getName() + " ==>> " + consumers[i].getVolumenContador());
        }
    }
}
