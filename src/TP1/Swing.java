package TP1;

import javax.swing.*;
import java.awt.*;

/**
 * Classe Swing pour de l'affichage
 * @author julien
 */
public class Swing extends JPanel {
     private final int base,top,height;//Valeur du trapèze

    private static final int maxWidth = Toolkit.getDefaultToolkit().getScreenSize().width-100;//Taille max de l'écran
    private static final int maxHeight = Toolkit.getDefaultToolkit().getScreenSize().height-100;//Hauteur max de l'écran

    /**
     * Constructeur de la classe Swing
     * @param a Longueur de la base du trapèze
     * @param b Longueur du haut du trapèze
     * @param c Longueur du segment rejoignant de a à b du trapèze
     */
     /*
     *         b
     *       ____
     *      /    \  c
     *     /______\
     *         a
     */
    private Swing(int a,int b,int c){
        this.base = a;
        this.top = b;
        this.height = c;
    }

    /**
     * Méthode surchargé pour affiché une forme géométrique ici utilisé pour un trapèze
     * @see JPanel#paintComponent(Graphics)
     * @param graphic the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics graphic) {
        super.paintComponent(graphic);
        int[] xPoints = {100, 100+((base-top)/2), 100+((base-top)/2)+top, 100+base}; // Coordonnées x des sommets
        int[] yPoints = {height+100, 100, 100, height+100};   // Coordonnées y des sommets

        graphic.setColor(Color.BLUE); //Couleur du trapèze
        graphic.drawPolygon(xPoints, yPoints, 4);//Affichage du trapèze
    }

    /**
     * Méthode pour initialiser les ressources pour afficher le trapèze
     * @param a Longueur de la base donné par l'utilisateur
     * @param b Longueur du haut donné par l'utilisateur
     * @param c Longueur du segment rejoignant de a à b donné par l'utilisateur
     */
    public static void createTrapeze(int a, int b,int c) {
        if (a < maxWidth && b <maxWidth && c < maxHeight){
            SwingUtilities.invokeLater(() -> {
                JFrame frame = new JFrame("Trapeze");//Création d'une class frame au nom Trapeze
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );//Lors de la fermeture de la fenêtre la fenêtre se ferme juste
                frame.getContentPane().add(new Swing(a,b,c));//Création du trapèze avec les tailles demandé
                frame.setSize(200+a, 200+c);//Taille de l'écran
                frame.setVisible(true);
            });
        }else {
            System.out.println("Les valeurs mise sont trop grandes pour afficher un graphique");
        }
    }
}
