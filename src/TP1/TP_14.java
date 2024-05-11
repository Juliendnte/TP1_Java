package TP1;

/**
 * Classe du Tp_14
 * @author julien
 */
public class TP_14 {

    public static void main(String[] args) {
        //Try Catch si erreur Arithmetic dans calcul de surface
        try{
            switch (tools.AskInt("Quel forme voulez-vous calculer la surface\n1-Rectangle\n2-Carré\n3-Triangle Rectangle\n4-Cercle\n5-Losange\n6-1/4 de cercle\n")){
                /*
                    Print d'une figure avec en paramètre le résultat de ce que l'utilisateur a choisie comme dimmension
                    La classe mère figure fait hériter a ses fils une méthode surchargé toString
                    Dedans j'y affiche la surface de la figure
                 */
                case 1 -> System.out.println(new Rectangle(tools.AskFloat("Saisissez la largeur du rectangle : "), tools.AskFloat("Saisissez la longeur du rectangle : ")));

                case 2 -> System.out.println(new Carre(tools.AskFloat("Saisissez un côté du carré : ")));

                case 3 -> System.out.println(new Triangle(tools.AskFloat("Saisissez la largeur du triangle : "),tools.AskFloat("Saisissez la longeur du triangle : ")));

                case 4 -> System.out.println(new Cercle(tools.AskFloat("Saisissez le rayon du cercle : ")));

                case 5 -> System.out.println(new Losange(tools.AskFloat("Saisissez la largeur du losange : "),tools.AskFloat("Saisissez la hauteur du losange : ")));

                case 6 -> System.out.println(new unQuartCercle(tools.AskFloat("Saisissez le rayon du cercle : ")));

                default -> System.out.println("Forme non identifié");
            }
        }catch (ArithmeticException e){
            System.out.printf("Erreur: %s%n" , e.getMessage());
        }
    }

    /**
     * Classe abstraite représentant toutes les figures géométriques.
     */
    abstract static class Figure {

        protected float width; // Largeur de la figure
        protected float height; // Hauteur de la figure
        protected String name; // Nom de la figure

        /**
         * Constructeur pour créer une figure avec une taille, une hauteur et un nom.
         * @param width Taille de la figure.
         * @param height Hauteur de la figure.
         * @param name Nom de la figure.
         */
        public Figure(float width, float height, String name) {
            this.width = width;
            this.height = height;
            this.name = name;
        }

        /**
         * Méthode abstraite pour calculer la surface de la figure.
         * @return La surface de la figure.
         */
        public abstract float calculerSurface();

        /**
         * Méthode surchargé pour obtenir une représentation textuelle de la figure avec sa surface.
         * Avec une fonction si cas d'erreur
         * @see tools#ducksError(float)
         * @return La représentation textuelle de la figure avec sa surface.
         */
        @Override
        public String toString(){
            return "La surface de " + this.name + " est de : " + tools.ducksError(this.calculerSurface()) + "m2";
        }
    }

    // Classe Rectangle héritant de Figure
    static class Rectangle extends Figure {

        /**
         * Constructeur pour créer un objet Rectangle avec une largeur et une longueur.
         * @param width La largeur du rectangle.
         * @param height La longueur du rectangle.
         */
        public Rectangle(float width, float height) {
            super(width, height,"Rectangle");
        }

        /**
         * Méthode pour calculer la surface du rectangle.
         * @return La surface du rectangle.
         */
        @Override
        public float calculerSurface() {
            return width * height;
        }
    }

    // Classe Triangle héritant de Figure
    static class Triangle extends Figure {

        /**
         * Constructeur pour créer un objet Triangle avec une largeur et une longueur.
         * @param width La base du triangle.
         * @param height La hauteur du triangle.
         */
        public Triangle(float width, float height) {
            super(width, height,"Triangle Rectangle");
        }

        /**
         * Méthode pour calculer la surface du triangle.
         * @return La surface du triangle.
         */
        @Override
        public float calculerSurface() {
            return (width * height) / 2;
        }
    }

    // Classe Carré héritant de Figure
    static class Carre extends Figure {

        /**
         * Constructeur pour créer un objet Carré avec un côté.
         * @param side La longueur du côté du carré.
         */
        public Carre(float side) {
            super(side, side, "Carré");
        }

        /**
         * Méthode pour calculer la surface du carré.
         * @return La surface du carré.
         */
        @Override
        public float calculerSurface() {
            return width * height;
        }
    }

    // Classe Cercle héritant de Figure
    static class Cercle extends Figure {

        /**
         * Constructeur pour créer un objet Cercle avec un rayon.
         * @param rayon Le rayon du cercle.
         */
        public Cercle(float rayon) {
            super(rayon, rayon, "Cercle");
        }

        /**
         * Méthode pour calculer la surface du cercle.
         * @return La surface du cercle.
         */
        @Override
        public float calculerSurface() {
            return (float) (Math.PI * width * height);
        }
    }

    // Classe 1/4Cercle héritant de Figure
    static class unQuartCercle extends Figure {

        /**
         * Constructeur pour créer un objet 1/4 de cercle avec un rayon.
         * @param rayon Le rayon du cercle.
         */
        public unQuartCercle(float rayon) {
            super(rayon, rayon, "1/4 de cercle");
        }

        /**
         * Méthode pour calculer la surface du 1/4 de cercle.
         * @return La surface du 1/4 de cercle.
         */
        @Override
        public float calculerSurface() {
            return (float) ((Math.PI * width * height)/4);
        }
    }

    // Classe Losange héritant de Figure
    static class Losange extends Figure {

        /**
         * Constructeur pour créer un objet Losange avec deux diagonales.
         * @param diagonale1 La première diagonale du losange.
         * @param diagonale2 La deuxième diagonale du losange.
         */
        public Losange(float diagonale1, float diagonale2) {
            super(diagonale1, diagonale2, "Losange");
        }

        /**
         * Méthode pour calculer la surface du losange.
         * @return La surface du losange.
         */
        @Override
        public float calculerSurface() {
            return (width * height) / 2;
        }
    }
}