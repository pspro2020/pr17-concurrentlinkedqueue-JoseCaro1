package ejercicio17;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

public class Tolva implements Runnable {

    private ConcurrentLinkedQueue<Integer> concurrentLinkedQueue =
            new ConcurrentLinkedQueue<>(List.of(0, 1, 2, 3, 4, 5));
    private final MaquinaSeparadora maquinaSeparadora;
    private final Random random= new Random();

    public Tolva(MaquinaSeparadora maquinaSeparadora) {
        this.maquinaSeparadora = maquinaSeparadora;
    }

    @Override
    public void run() {
        try {
            while(!concurrentLinkedQueue.isEmpty()){
                caerElemento();
            }
        } catch (InterruptedException e) {
            System.out.printf("No hay mas elementos en la %s\n",Thread.currentThread().getName());

            return;
        }
        System.out.printf("No hay mas elementos en %s\n",Thread.currentThread().getName());


    }

    private void caerElemento() throws InterruptedException {
            int num=concurrentLinkedQueue.remove();
            TimeUnit.SECONDS.sleep(random.nextInt(2)+1);
            maquinaSeparadora.add(num,Thread.currentThread().getName());
            System.out.printf("La %s ha dejado caer en la cinta al elemento %d\n",Thread.currentThread().getName(),num);

    }
}
