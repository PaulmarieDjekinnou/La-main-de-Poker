package poker;
/**
 *
 * @author PS5_The_Beginners
 */
import org.junit.Test;

import static org.junit.Assert.*;

public class MainSuiteTest {

    @Test
    public void renvoitValeurSuite() {
        MainJoueur mainJoueur = new MainJoueur(new Carte("Tr",3),new Carte("Pi",5),new Carte("Ca",4),new Carte("Co",2),new Carte("Pi",6));
        mainJoueur.rangerCarteOrdreCroissant();
        MainSuite mainSuite = new MainSuite(mainJoueur, "Suite");
        int result = mainSuite.RenvoitValeurSuite();
        assertEquals(6,result);
    }
}