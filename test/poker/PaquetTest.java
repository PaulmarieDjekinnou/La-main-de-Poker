package poker;
/**
 *
 * @author PS5_The_Beginners
 */
import org.junit.Test;

import static org.junit.Assert.*;

public class PaquetTest {

    @Test
    public void carteSelection() {
        Paquet paquet= new Paquet();
        paquet.carteSelection(new Carte("Tr",2));
        boolean result = false;
        for (int i=0; i<=51; i++){
            if("Tr".equals(paquet.cartes[i].getType()) && 2 == paquet.cartes[i].getValeur() && paquet.cartes[i].isSelected()){
                result = true;
                break;
            }
        }
        assertTrue("La carte n'a pas été sélectionnée",result == true);
    }

    @Test
    public void carteIsSelected() {
        Paquet paquet= new Paquet();
        paquet.carteSelection(new Carte("Tr",2));
        boolean result = paquet.carteIsSelected(new Carte("Tr",2));
        assertTrue("La fonction qui vérifie si la carte a été sélectionnée ne marche pas",result == true);
    }

    @Test
    public void nbOccurences() {
        Paquet paquet= new Paquet();
        int result = paquet.nbOccurences("to","toto est toto");
        assertEquals(4,result);
    }

    @Test
    public void isANumber() {
        Paquet paquet= new Paquet();
        boolean result1 = Paquet.isANumber("2");
        boolean result2 = Paquet.isANumber("A");
        assertTrue("c'est normalement un nombre", result1 == true);
        assertFalse("ce n'est pas un nombre", result2 == true);
    }

    @Test
    public void controleDeSaisieDe1Carte() {
        Paquet paquet= new Paquet();
        Carte result;

        //Test de saisie nulle
        result = paquet.controleDeSaisieDe1Carte(" ");
        assertEquals("",result.getType());
        assertEquals(0,result.getValeur());

        //Test de saisie d'une carte valide
        result = paquet.controleDeSaisieDe1Carte("2Tr");
        assertEquals("Tr",result.getType());
        assertEquals(2,result.getValeur());

        //Test de saisie d'une carte non valide
        result = paquet.controleDeSaisieDe1Carte("2tr");
        assertEquals("",result.getType());
        assertEquals(0,result.getValeur());
    }

}