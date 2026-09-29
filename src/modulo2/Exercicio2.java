package modulo2;
import java.util.Locale;
import java.util.Scanner; 

public class Exercicio2{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Digites o seu peso (ex: 70.5): ");
        double peso = scanner.nextDouble();

        System.out.print("Digite aqui a sua altura (ex: 1.75): ");
        double altura = scanner.nextDouble();

        // Fórmula do IMC: peso / (altura * altura)
        double imc = peso / (altura * altura);

        System.out.printf("\nSeu IMC é: %.2f\n", imc);

        // Verificação das faixas de IMC
        if (imc <= 18.5) {
            System.out.println("Classificação: Abaixo do peso");
        } else if (imc <= 24.9) {
            System.out.println("Classificação: Peso ideal");
        } else if (imc <= 29.9) {
            System.out.println("Classificação: Levemente acima do peso");
        } else if (imc <= 34.9) {
            System.out.println("Classificação: Obesidade Grau I");
        } else if (imc <= 39.9){
            System.out.println("Classificação: Obesidade Grau II (Severa)");
        } else {
            System.out.println("Classificação: Obesidade III (Mórbida)");
        }

        scanner.close();
    }
}