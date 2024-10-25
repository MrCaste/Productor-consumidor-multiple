public class Gotas {

    private boolean volumen;

    public synchronized boolean getVolumen() {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        if(volumen){
            volumen = false;
            notifyAll();
            return true;
        }else return false;
    }

    public synchronized void setVolumen() {
        if(volumen){
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }else{
            volumen = true;
            notify();
        }   
    }  
}
