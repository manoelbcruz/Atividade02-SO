package Classes;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class VirtualMachine implements Runnable {

    private final String name;
    private final NetworkCard sharedNetworkCard;
    private final Random random = new Random();

    public VirtualMachine(String name, NetworkCard sharedNetworkCard) {
        this.name = name;
        this.sharedNetworkCard = sharedNetworkCard;
    }

    @Override
    public void run() {
        try {
            // A VM "pensa" por um tempo antes de precisar da rede
            TimeUnit.SECONDS.sleep(random.nextInt(3) + 1);

            // Solicita acesso ao recurso compartilhado
            System.out.println("\n[VM Usuário - " + name + "] Requisitando acesso à rede...");
            sharedNetworkCard.processPacket(name);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("VM " + name + " foi interrompida.");
        }
    }
}
