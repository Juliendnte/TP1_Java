package TP1;

/**
 * Classe Tp1.3
 * @author julien
 */
public class TP_13 {

    public static void main(String[] args) {
        int a = tools.AskInt("Rentrer A (en m) : ");
        int b = tools.AskInt("\nRentrer B (en m) : ");
        int c = tools.AskInt("\nRentrer C (en m) : ");
        System.out.println("La surface du trapèze est de "+(int)((a+b)*c*0.5)+" m");
        Swing.createTrapeze(a,b,c);
    }
}
