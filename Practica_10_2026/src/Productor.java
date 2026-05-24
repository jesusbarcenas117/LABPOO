public class Productor implements Runnable {
    private BufferTransacciones buffer;
    private String nombre;

    public Productor(String nombre, BufferTransacciones buffer) {
        this.nombre = nombre;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            try {
                buffer.producir(nombre + "-TX" + i);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}