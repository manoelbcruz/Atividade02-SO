package Classes;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class NetworkCard {
    private final boolean useSynchronization;

    // Construtor para escolha com ou sem sincronização
    public NetworkCard(boolean useSynchronization) {
        this.useSynchronization = useSynchronization;
        String mode = useSynchronization ? "COM SINCRONIZAÇÃO" : "SEM SINCRONIZAÇÃO";
        System.out.println("NetworkCard operando em modo: " + mode);
    }

    public void processPacket(String vmName) {
        if (useSynchronization) {
            // sincronizado
            synchronized (this) {
                doProcessing(vmName);
            }
        } else {
            // sem synchronized
            doProcessing(vmName);
        }
    }

    private void doProcessing(String vmName) {
        try {
            String packet = "Pacote de dados para " + vmName + " #" + new Random().nextInt(1000);
            System.out.println("[NetworkCard - Física] Recebendo pacote: " + packet);
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("[OS Núcleo - " + vmName + "_OS] Atendendo chamada: RECEIVE_DATA");
            System.out.println("[OS Núcleo - " + vmName + "_OS] Processando dados: " + packet);
            System.out.println("----------------------------------------------------------");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Thread interrompida: " + e.getMessage());
        }
    }
}
