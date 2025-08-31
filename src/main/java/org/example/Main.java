package org.example;

import Classes.Hypervisor;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        System.out.println("### CONFIGURAÇÃO DA SIMULAÇÃO DE HYPERVISOR ###");
        System.out.println("Escolha o modo de execução:");
        System.out.println("1. Sem Sincronização (para ver a condição de corrida)");
        System.out.println("2. Com Sincronização (para ver a solução)");
        System.out.print("Digite sua opção (1 ou 2): ");

        try {
            choice = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Entrada inválida. Encerrando.");
            scanner.close();
            return;
        }

        boolean useSync;

        if (choice == 1) {
            useSync = false;
            System.out.println("\n### INICIANDO SIMULAÇÃO SEM SINCRONIZAÇÃO ###");
        } else if (choice == 2) {
            useSync = true;
            System.out.println("\n### INICIANDO SIMULAÇÃO COM SINCRONIZAÇÃO ###");
        } else {
            System.out.println("Opção inválida. Encerrando.");
            scanner.close();
            return;
        }

        scanner.close();

        System.out.println("Criando e delegando a execução para o Hypervisor...");
        Hypervisor hypervisor = new Hypervisor();

        hypervisor.startSimulation(useSync);

        System.out.println("\nMAIN: O Hypervisor iniciou a simulação.");
    }
}