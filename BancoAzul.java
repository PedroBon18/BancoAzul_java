import java.util.Scanner;
import java.util.Locale;

public class BancoAzul {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        double saldo = 0;
        String extrato = "";
        int numeroSaques = 0;
        int limiteSaques = 3;
        double limiteValor = 500;

        while (true) {
            System.out.println("============================");
            System.out.println("Selecione uma opção:");
            System.out.println("[d] - Depósito");
            System.out.println("[s] - Saque");
            System.out.println("[e] - Extrato");
            System.out.println("[q] - Sair");
            System.out.println("============================");

            String entrada = scanner.nextLine().trim().toLowerCase();
            if (entrada.length() == 0) continue; // ignora entradas vazias

            char opcao = entrada.charAt(0); // pega apenas o primeiro caractere

            if (opcao == 'd') {
                System.out.print("Informe o valor do depósito: R$ ");
                double valor = scanner.nextDouble();
                scanner.nextLine(); // limpa buffer

                if (valor > 0) {
                    saldo += valor;
                    extrato += String.format("Depósito: R$ %.2f%n", valor);
                    System.out.printf("Depósito de R$ %.2f realizado com sucesso.%n", valor);
                } else {
                    System.out.println("Valor inválido para depósito.");
                }

            } else if (opcao == 's') {
                if (numeroSaques >= limiteSaques) {
                    System.out.println("Limite diário de saques atingido.");
                } else {
                    System.out.print("Informe o valor do saque: R$ ");
                    double valor = scanner.nextDouble();
                    scanner.nextLine(); // limpa buffer

                    if (valor > saldo) {
                        System.out.println("Saldo insuficiente para saque.");
                    } else if (valor > limiteValor) {
                        System.out.println("Valor excede o limite por saque (R$ 500,00).");
                    } else if (valor <= 0) {
                        System.out.println("Valor inválido para saque.");
                    } else {
                        saldo -= valor;
                        numeroSaques++;
                        extrato += String.format("Saque:    R$ %.2f%n", valor);
                        System.out.printf("Saque de R$ %.2f realizado com sucesso.%n", valor);
                    }
                }

            } else if (opcao == 'e') {
                System.out.println("\n====== EXTRATO ======");
                if (extrato.isEmpty()) {
                    System.out.println("Não foram realizadas movimentações.");
                } else {
                    System.out.print(extrato);
                }
                System.out.printf("Saldo atual: R$ %.2f%n", saldo);
                System.out.println("=====================\n");

            } else if (opcao == 'q') {
                System.out.println("Obrigado por usar o Banco Azul. Até logo!");
                break;

            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}
