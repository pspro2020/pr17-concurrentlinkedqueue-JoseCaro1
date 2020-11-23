package ejercicio17;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MaquinaSeparadora maquinaSeparadora = new MaquinaSeparadora();
        Thread tolvas[] = new Thread[5];
        Thread hiloMaquinaSeparadora = new Thread(maquinaSeparadora);

        for (int i = 0; i < tolvas.length; i++) {
            tolvas[i]= new Thread(new Tolva(maquinaSeparadora),"tolva "+i);
            tolvas[i].start();
        }
        Thread.sleep(3000);
        hiloMaquinaSeparadora.start();
    }
}
