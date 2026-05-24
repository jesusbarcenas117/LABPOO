public class Consumidor implements Runnable {
    private BufferTransacciones buffer;
    private String nombre;

    public Consumidor(String nombre, BufferTransacciones buffer) {
        this.nombre = nombre;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            try {
                buffer.consumir();
                Thread.sleep(150);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}