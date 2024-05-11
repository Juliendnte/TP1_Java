package TP1;

import java.util.Scanner;

/**
 * Classe tools (boite à outils)
 * @author julien
 */
public final class tools {

    /**
     * Constructeur bloqué
     */
    private tools() {}
    //Nbr max d'un int
    public static final Scanner sc = new Scanner(System.in);

    /*
    Message d'erreurs
    TOO_MANY_DUCKS_ERROR = Nombre trop grand pour un float
    NOT_ENOUGH_DUCKS_ERROR = Nombre trop petit pour un float
    DIVISION_BY_ZERO_ERROR = Division par 0
    MODULO_BY_ZERO_ERROR = Modulo par 0
     */
    private static final String TOO_MANY_DUCKS_ERROR = "Trop de canard pour moi!";
    private static final String NOT_ENOUGH_DUCKS_ERROR = "Pas assez de canard pour moi!";
    public static final String DIVISION_BY_ZERO_ERROR = "Division par zéro !";
    public static final String MODULO_BY_ZERO_ERROR = "Modulo par zéro !";

    /**
     * Fonction pour savoir ce que l'utilisateur renvoie après un message
     * @param message Messaqe pour l'utilisateur
     * @return ce que l'utilisateur a répondue
     */
    public static String AskString(String message) {
        System.out.print(message);
        return sc.nextLine();
    }

    /**
     * Fonction pour qui attend que l'utilisateur renvoie un float
     * @param message Message pour l'utilisateur
     * @return float renvoyé par l'utilisateur
     */
    public static float AskFloat(String message) {
        System.out.print(message);
        while (!sc.hasNextFloat()) {//Tant que l'utilisateur envoie un float
            System.out.println("Erreur : Entrée invalide. Veuillez entrer un float.");
            sc.next();
            System.out.print(message);
        }
        return sc.nextFloat();
    }

    /**
     * Fonction pour qui attend que l'utilisateur renvoie un int
     * @param message Message pour l'utilisateur
     * @return int renvoyé par l'utilisateur
     */
    public static int AskInt(String message) {
        System.out.print(message);
        while (!sc.hasNextInt()) {//Tant que l'utilisateur envoie un int
            System.out.println("Erreur : Entrée invalide. Veuillez entrer un entier.");
            sc.next();
            System.out.print(message);
        }
        return sc.nextInt();
    }

    /**
     * Fonction pour savoir si un nombre est pair ou non
     * @param ent L'entier que l'on veut tester
     */
    public static void EvenOrOdd(int ent) {
        if (ent % 2 == 0)
            System.out.println(ent + " est un nombre pair");
        else
            System.out.println(ent + " est un nombre impair");
    }

    /**
     * Fonction Puissance
     * @param base Le nombre a la base
     * @param exponent L'exposant
     * @return Le résultat
     */
    public static float powerFunction(float base, float exponent) {
        float result = 1;
        for (float i = 0; i < exponent; ++i) {
            result *= base;
            ducksError(result);
        }
        return result;
    }

    /**
     * Fonction pour savoir si le résultat d'une opération est correct
     * @param result Le résultat testé
     * @return Le résultat
     * @throws ArithmeticException Si l'erreur dépasse les limites d'un float
     */
    public static float ducksError(float result) {
        if (result > tools.getMax())
            throw new ArithmeticException(TOO_MANY_DUCKS_ERROR);
        else if (result < tools.getMin())
            throw new ArithmeticException(NOT_ENOUGH_DUCKS_ERROR);
        return result;
    }

    /**
     * Getteur du max d'un float
     * @return Le nombre maximum que peut être un float
     */
    public static float getMax(){
        return  Float.MAX_VALUE;
    }
    /**
     * Getteur du min d'un float
     * @return Le nombre minimum que peut être un float
     */
    public static float getMin(){
        return Float.MIN_VALUE;
    }
}
