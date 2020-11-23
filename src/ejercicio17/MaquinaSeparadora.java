package ejercicio17;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

public class MaquinaSeparadora implements Runnable {
    private ConcurrentLinkedQueue<Integer> concurrentLinkedQueueNum =
            new ConcurrentLinkedQueue<>();
    private ConcurrentLinkedQueue<String> concurrentLinkedQueueName =
            new ConcurrentLinkedQueue<>();
    private final Random random= new Random();

    @Override
    public void run() {
        try {
            while (!concurrentLinkedQueueNum.isEmpty()) {
                procesarElemento();
            }
        } catch (InterruptedException e) {
            System.out.println("Se ha interrumpido mientras se procesaba");
            return;
        }
        System.out.println("No hay mas elementos en la maquina procesadora");
    }


    protected void add(int element, String name){
        concurrentLinkedQueueNum.add(element);
        concurrentLinkedQueueName.add(name);

    }
    private void procesarElemento() throws InterruptedException {

            int num=concurrentLinkedQueueNum.remove();
            TimeUnit.SECONDS.sleep(random.nextInt(2)+1);
            System.out.printf("El elemento %d de la %s ha sido procesado\n",num,concurrentLinkedQueueName.remove());

    }
}
