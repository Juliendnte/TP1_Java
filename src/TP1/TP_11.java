package TP1;

/**
 * Classe TP1.1
 * @author julien
 */
public class TP_11 {

    public static void main(String[] args) {
        String nom = tools.AskString("Rentrer votre nom : ");
        System.out.println("Bonjour " + nom);

        float nb1 = tools.AskFloat("Rentrer un nombre réel A : ");
        float nb2 = tools.AskFloat("Rentrer un nombre réel B : ");

        System.out.println("Le maximum entre A et B est " + Math.max(nb1, nb2));

        int ent = tools.AskInt("Rentrez un entier : ");
        tools.EvenOrOdd(ent);

        System.out.println("A bientôt");
    }
}
