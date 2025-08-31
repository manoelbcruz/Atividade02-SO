package Classes;

public class Hypervisor {
    public void startSimulation(boolean useSynchronization) {
        System.out.println("HYPERVISOR: Inicializando ambiente...");

        // A escolha é usada para instanciar a placa de rede no modo correto
        NetworkCard sharedCard = new NetworkCard(useSynchronization);

        // O restante do código permanece o mesmo
        VirtualMachine vm1 = new VirtualMachine("VM1-Desktop", sharedCard);
        VirtualMachine vm2 = new VirtualMachine("VM2-Database", sharedCard);
        VirtualMachine vm3 = new VirtualMachine("VM3-WebServer", sharedCard);
        System.out.println("HYPERVISOR: Máquinas Virtuais prontas para execução.");

        Thread threadVm1 = new Thread(vm1);
        Thread threadVm2 = new Thread(vm2);
        Thread threadVm3 = new Thread(vm3);

        System.out.println("HYPERVISOR: Ligando todas as VMs...\n");
        threadVm1.start();
        threadVm2.start();
        threadVm3.start();
    }
}
