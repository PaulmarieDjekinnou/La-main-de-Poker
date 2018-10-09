package poker;
/**
 *
 * @author PS5_The_Beginners
 */
import org.junit.Test;

import static org.junit.Assert.*;

public class CarteTest {

    @Test
    public void compareTwoCard() {
        //Egalité
        Carte carte = new Carte("Tr",8);
        int result = carte.compareTwoCard(new Carte("Ca",8));
        assertEquals(0,result);

        //main1 gagne
        carte = new Carte("Tr",11);
        result = carte.compareTwoCard(new Carte("Tr",2));
        assertEquals(1,result);

        //main2 gagne
        carte = new Carte("Tr",11);
        result = carte.compareTwoCard(new Carte("Tr",12));
        assertEquals(-1,result);
    }
}