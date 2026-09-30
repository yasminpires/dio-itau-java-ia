package modulo4;

public class TestaIngresso {
    public static void main(String [] args) {
        Ingresso comum = new Ingresso(40.0, "Batman", true);
        MeiaEntrada meia = new MeiaEntrada(40.0, "Batman", true);
        IngressoFamilia familiaPequena = new IngressoFamilia(40.0, "Batman", true, 2);
        IngressoFamilia familiaGrande = new IngressoFamilia(40.0, "Batman", true, 5);

        System.out.println("=== TESTE DE INGRESSOS===");
        System.out.println("Ingresso Comum: R$ " + comum.getValorReal());
        System.out.println("Meia Entrada: R$ " + meia.getValorReal());
        System.out.println("Ingresso Família (2 pessoas): R$ " + familiaPequena.getValorReal());
        System.out.println("Ingresso Família (5 pessoas com 5% desc): R$ " + familiaGrande.getValorReal());
    }
}
