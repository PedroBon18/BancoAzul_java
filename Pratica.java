import java.util.Locale;
import java.util.Scanner;

public class Pratica {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        //System.out.println("Digite o seu nome");
        //String nome = entrada.nextLine();
        //System.out.println("Seja bem vindo" + nome);


        //System.out.println("Vou descobrir sua idade!");
        //System.out.println("Digite sua idade aqui:");
        //int idade = entrada.nextInt();
        //System.out.println("Sua idade é " + idade);

        System.out.print("Digite a sua altura:");
        double altura = entrada.nextDouble();
        System.out.println("A sua altura é " + altura);

        entrada.close();
    }
}
