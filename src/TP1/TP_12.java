package TP1;

/**
 * Classe TP1.2
 * @author julien
 */
public class TP_12 {

    /**
     * Interface pour les opérations +,-,*,/,%,^
     */
    interface Operation {
        float calc(float x, float y);
    }

    /**
     * Fonction pour calculer deux float selon un operateur
     * @param x Premier float
     * @param y Deuxième float
     * @param op Opérateur choisie
     * @return Le résulat
     */
    private static float calculer(float x, float y, Operation op) {
        return op.calc(x, y);
    }

    public static void main(String[] args) {
        //Réponse de l'utilisateur
        String cin;
        //Liste de tous les nombres
        float[] lst;
        //Nombre de calcul
        int max;
        System.out.println("Bienvenue dans la calculatrice");
        while (true) {
            cin = tools.AskString("Voulez-vous faire une addition(+)\nVoulez-vous faire une soustraction(-)\nVoulez-vous faire une multiplication(*)\nVoulez-vous faire une division(/)\nVoulez-vous faire un modulo(%)\nVoulez-vous faire une puissance de votre nombre?(^)\nSi vous voulez quitter, appuyez sur (q)\n");
            switch (cin) {
                //Cas 1 a le choix d'avoir plusieur nombre calculé
                case "+", "-", "/", "%", "*","^" -> {
                    max = tools.AskInt("Combien de nombres voulez-vous calculer ? ");
                    //Gestion d'erreur
                    if (max > 0){
                        //Création d'une liste de nombre a calculer
                        lst = new float[max];
                        for (int cal = 0; cal < max; ++cal) {
                            lst[cal] = tools.AskFloat("Entrez votre nombre : ");
                        }

                        Operation operation = getOperation(cin);
                        //Gestion d'erreur
                        if (operation != null) {
                            try {
                                System.out.printf("Le résultat est : %.2f canard%n" ,(Calculatrice(lst, operation)));
                            } catch (ArithmeticException e) {
                                System.out.printf("Erreur: %s%n" , e.getMessage());
                            }
                        }
                    }
                    break;
                }
                case "q" -> {
                    return;
                }
                default -> System.out.println("Opérateur non reconnu");
            }
            tools.sc.nextLine();
        }
    }

    /**
     * Fonction qui calcule tous les nombres d'une liste avec l'opération voulue
     * @param arr Liste avec tous les nombres a calculer
     * @param op Operateur choisie
     * @return Résultat de toutes la liste selon l'opérateur
     */
    private static float Calculatrice(float[] arr, Operation op) {
        float res = arr[0];
        for (int i = 1; i < arr.length; ++i) {
            res = calculer(res, arr[i], op);
        }
        return res;
    }

    /**
     * Fonction pour récupérer l'opérateur séléctionner selon ce que l'utilisateur a rentré
     * @param operator Opérateur choisie en string
     * @return Caste en type Operation
     */
    private static Operation getOperation(String operator) {
        return switch (operator) {
            case "+" -> addition;
            case "-" -> soustraction;
            case "*" -> multiplication;
            case "/" -> division;
            case "%" -> modulo;
            case "^" -> puissance;
            default -> null;
        };
    }

    //lambdas de toutes les opérations possible
    private static final Operation addition = (x, y) -> tools.ducksError(x+y);
    private static final Operation soustraction = (x, y) -> tools.ducksError(x-y);
    private static final Operation multiplication = (x, y) -> tools.ducksError(x*y);
    private static final Operation puissance = tools::powerFunction;
    private static final Operation division = (x, y) -> {
        if (y == 0) {
            throw new ArithmeticException(tools.DIVISION_BY_ZERO_ERROR);
        }
        return tools.ducksError(x/y);
    };
    private static final Operation modulo = (x, y) -> {
        if (y == 0) {
            throw new ArithmeticException(tools.MODULO_BY_ZERO_ERROR);
        }
        return tools.ducksError(x%y);
    };
}