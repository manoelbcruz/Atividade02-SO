<h1 align="center"\>💻 Simulador de Hypervisor 🚀<h1\>
<p align="center"\><strong\>Uma demonstração prática de programação concorrente, condições de corrida e sincronização de threads em Java.</strong\></p\>

-----
  
## 🧠 O Conceito

> Este projeto simula um cenário clássico de Sistemas Operacionais: múltiplas **Máquinas Virtuais (VMs)** competindo por um **recurso de hardware compartilhado** — a placa de rede do hospedeiro. O objetivo é visualizar o caos da concorrência não gerenciada e a ordem imposta pela sincronização.

### 💥 O Problema: Condição de Corrida

Quando várias VMs (threads) tentam usar a placa de rede ao mesmo tempo, suas operações são executadas de forma intercalada. O resultado é uma saída de logs caótica e imprevisível, onde o processamento de um pacote de uma VM é interrompido pelo de outra.

### ✅ A Solução: Sincronização

Ao declarar a função de acesso à rede como uma **região crítica** (usando `synchronized`), nós forçamos as VMs a formarem uma "fila". Apenas uma VM pode executar a operação por vez, garantindo que o processamento de cada pacote seja uma operação **atômica** e indivisível.

-----

## ✨ Funcionalidades

  * ✅ **Simulação Concorrente**: Cada VM opera em sua própria `Thread`, simulando paralelismo real.
  * ✅ **Menu Interativo**: Escolha no início da execução se deseja rodar a simulação **com** ou **sem** o mecanismo de sincronização.
  * ✅ **Visualização Clara**: A saída do console foi projetada para mostrar de forma explícita o problema e a solução.
  * ✅ **Código Didático**: A estrutura do projeto é simples e focada nos conceitos de concorrência.

-----

## 📂 Estrutura do Projeto

| Classe              | Responsabilidade                                                                 |
| ------------------- | -------------------------------------------------------------------------------- |
| `Main.java`         | 🏛️ **Ponto de entrada**. Apresenta o menu de seleção e inicia a simulação.          |
| `Hypervisor.java`   | 👨‍💼 **Orquestrador**. Cria os componentes (VMs, NetworkCard) e gerencia as threads. |
| `VirtualMachine.java`| 🖥️ **Máquina Virtual**. Implementa `Runnable` para ser a tarefa de cada thread.    |
| `NetworkCard.java`  | 🌐 **Recurso Crítico**. A placa de rede compartilhada que necessita de sincronização. |

-----

## ▶️ Como Executar

### 🛠️ Pré-requisitos

  * **Java Development Kit (JDK)** - Versão 11 ou superior.
  * **Git** para clonar o projeto.

### 🚀 Passos

1.  **Clone o repositório:**

    ```bash
    git clone https://github.com/manoelbcruz/Atividade02-SO.git
    ```

2.  **Navegue até o diretório:**

    ```bash
    cd nome-do-seu-projeto
    ```

3.  **Compile os arquivos `.java`:**
    *(Ajuste o caminho se sua estrutura de pacotes for diferente)*

    ```bash
    javac src/org/example/*.java
    ```

4.  **Execute a classe `Main`:**

    ```bash
    java src/org/example/Main.java
    ```

5.  **Escolha o modo no menu interativo** e observe a mágica (ou o caos) acontecer\!

-----

## 🎬 Demonstração Visual

### ❌ Modo SEM Sincronização

Abaixo, um exemplo da saída caótica, onde as operações das VMs se misturam, caracterizando a condição de corrida.

*(Dica: Grave um GIF da sua tela executando este modo e substitua este texto pela imagem\!)*

```console
### INICIANDO SIMULAÇÃO SEM SINCRONIZAÇÃO ###
...
[VM Usuário - VM1-Desktop] Requisitando acesso à rede...
[NetworkCard - Física] Recebendo pacote: Pacote de dados para VM1-Desktop #944
[VM Usuário - VM2-Database] Requisitando acesso à rede...
[NetworkCard - Física] Recebendo pacote: Pacote de dados para VM2-Database #91b
[OS Núcleo - VM1-Desktop_OS] Atendendo chamada: RECEIVE_DATA
[OS Núcleo - VM1-Desktop_OS] Processando dados: Pacote de dados para VM1-Desktop #944
[OS Núcleo - VM2-Database_OS] Atendendo chamada: RECEIVE_DATA
...
```

### ✔️ Modo COM Sincronização

Com a sincronização ativada, a saída é perfeitamente ordenada. Cada VM executa seu bloco de operações de forma atômica, sem interrupções.

*(Dica: Grave um GIF da sua tela executando este modo também\!)*

```console
### INICIANDO SIMULAÇÃO COM SINCRONIZAÇÃO ###
...
[VM Usuário - VM3-WebServer] Requisitando acesso à rede...
[NetworkCard - Física] Recebendo pacote: Pacote de dados para VM3-WebServer #541
[OS Núcleo - VM3-WebServer_OS] Atendendo chamada: RECEIVE_DATA
[OS Núcleo - VM3-WebServer_OS] Processando dados: Pacote de dados para VM3-WebServer #541
----------------------------------------------------------

[VM Usuário - VM1-Desktop] Requisitando acesso à rede...
[NetworkCard - Física] Recebendo pacote: Pacote de dados para VM1-Desktop #81
[OS Núcleo - VM1-Desktop_OS] Atendendo chamada: RECEIVE_DATA
[OS Núcleo - VM1-Desktop_OS] Processando dados: Pacote de dados para VM1-Desktop #81
----------------------------------------------------------
```
