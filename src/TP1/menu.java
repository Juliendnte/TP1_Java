package TP1;
/**
 * Classe menu
 * @author julien
 */
public class menu{
    /**
     * Fonction main pour parcourir tous les TPs
     */
    public static void main(String[] args)  {
        while (true){
            switch (tools.AskString("Quels TP voulez-vous essayer?\n1-TP.11\n2-TP.12\n3-TP.13\n4-TP.14\nq.quitter\n")){
                case "1"->TP_11.main(new String[]{});
                case "2"->TP_12.main(new String[]{});
                case "3"->TP_13.main(new String[]{});
                case "4" ->TP_14.main(new String[]{});
                case "q"-> {
                    return;
                }
                default -> System.out.println("Résultat inconnue");
            }
            tools.sc.nextLine();//Pour prendre le \n après avoir répondu
        }
    }
}
