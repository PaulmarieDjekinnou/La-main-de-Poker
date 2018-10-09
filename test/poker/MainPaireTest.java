package poker;
/**
 *
 * @author PS5_The_Beginners
 */
import org.junit.Test;

import static org.junit.Assert.*;

public class MainPaireTest {

    @Test
    public void renvoitValeurPairre() {
        MainJoueur mainJoueur = new MainJoueur(new Carte("Tr",3),new Carte("Pi",5),new Carte("Ca",3),new Carte("Co",2),new Carte("Pi",2));
        mainJoueur.rangerCarteOrdreCroissant();
        MainPaire mainPaire = new MainPaire(mainJoueur, "Paire");
        int result = mainPaire.renvoitValeurPairre();
        assertEquals(3,result);
    }

    /*@Test
    public void retourneListeDes3CartesRestantTriee() {
        MainJoueur mainJoueur = new MainJoueur(new Carte("Tr",2),new Carte("Pi",3),new Carte("Ca",4),new Carte("Co",5),new Carte("Pi",5));
        mainJoueur.rangerCarteOrdreCroissant();
        MainPaire mainPaire = new MainPaire(mainJoueur, "Paire");
        int[] result = mainPaire.retourneListeDes3CartesRestantTriee();
        assertEquals(2,result[0]);
        assertEquals(4,result[1]);
        assertEquals(5,result[2]);
    }*/
}