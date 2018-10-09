package poker;
/**
 *
 * @author PS5_The_Beginners
 */
import org.junit.Test;

import static org.junit.Assert.*;

public class MainJoueurTest {

    @Test
    public void rangerCarteOrdreCroissant() {
        MainJoueur mainJoueur = new MainJoueur(new Carte("Tr",5),new Carte("Pi",3),new Carte("Ca",2),new Carte("Co",6),new Carte("Pi",9));
        mainJoueur.rangerCarteOrdreCroissant();
        assertEquals("Ca",mainJoueur.mainJ[0].getType());
        assertEquals(2,mainJoueur.mainJ[0].getValeur());
        assertEquals("Pi",mainJoueur.mainJ[1].getType());
        assertEquals(3,mainJoueur.mainJ[1].getValeur());
        assertEquals("Tr",mainJoueur.mainJ[2].getType());
        assertEquals(5,mainJoueur.mainJ[2].getValeur());
        assertEquals("Co",mainJoueur.mainJ[3].getType());
        assertEquals(6,mainJoueur.mainJ[3].getValeur());
        assertEquals("Pi",mainJoueur.mainJ[4].getType());
        assertEquals(9,mainJoueur.mainJ[4].getValeur());
    }

    @Test
    public void determinerLaMain() {
        //Test Plus haute carte
        MainJoueur mainJoueur = new MainJoueur(new Carte("Tr",5),new Carte("Pi",3),new Carte("Ca",2),new Carte("Co",6),new Carte("Pi",9));
        String result = mainJoueur.determinerLaMain();
        assertEquals("Plus haute carte",result);
        //Test Paire
        mainJoueur = new MainJoueur(new Carte("Tr",5),new Carte("Pi",5),new Carte("Ca",2),new Carte("Co",6),new Carte("Pi",9));
        result = mainJoueur.determinerLaMain();
        assertEquals("Paire",result);
        //Test Brelan
        mainJoueur = new MainJoueur(new Carte("Tr",5),new Carte("Pi",5),new Carte("Ca",5),new Carte("Co",2),new Carte("Pi",9));
        result = mainJoueur.determinerLaMain();
        assertEquals("Brelan",result);
        //Test 2Paires
        mainJoueur = new MainJoueur(new Carte("Tr",5),new Carte("Pi",5),new Carte("Ca",2),new Carte("Co",2),new Carte("Pi",9));
        result = mainJoueur.determinerLaMain();
        assertEquals("2Paire",result);
        //Test Suite
        mainJoueur = new MainJoueur(new Carte("Tr",5),new Carte("Pi",4),new Carte("Ca",2),new Carte("Co",3),new Carte("Pi",6));
        result = mainJoueur.determinerLaMain();
        assertEquals("Suite",result);
        //Test Couleur
        mainJoueur = new MainJoueur(new Carte("Tr",5),new Carte("Tr",5),new Carte("Tr",5),new Carte("Tr",2),new Carte("Tr",9));
        result = mainJoueur.determinerLaMain();
        assertEquals("Couleur",result);
        //Test Full
        mainJoueur = new MainJoueur(new Carte("Tr",5),new Carte("Pi",5),new Carte("Ca",5),new Carte("Co",2),new Carte("Pi",2));
        result = mainJoueur.determinerLaMain();
        assertEquals("Full",result);
        //Test Carre
        mainJoueur = new MainJoueur(new Carte("Tr",5),new Carte("Pi",5),new Carte("Ca",5),new Carte("Co",5),new Carte("Pi",9));
        result = mainJoueur.determinerLaMain();
        assertEquals("Carre",result);
        //Test Quinte
        mainJoueur = new MainJoueur(new Carte("Tr",5),new Carte("Tr",4),new Carte("Tr",6),new Carte("Tr",8),new Carte("Tr",7));
        result = mainJoueur.determinerLaMain();
        assertEquals("Quinte flush",result);
    }

    @Test
    public void compareMain() {
        /**Test de comparaison plus haute carte*/

        //Egalité
        MainJoueur mainJoueur1 = new MainJoueur(new Carte("Tr",5),new Carte("Pi",3),new Carte("Ca",2),new Carte("Co",8),new Carte("Pi",9));
        mainJoueur1.determinerLaMain();
        MainJoueur mainJoueur2 = new MainJoueur(new Carte("Pi",9),new Carte("Ca",3),new Carte("Tr",2),new Carte("Co",5),new Carte("Pi",8));
        mainJoueur2.determinerLaMain();
        String result = mainJoueur1.compareMain(mainJoueur2);
        assertEquals("Egalité",result);

        //mainJoueur1 a gagné
        mainJoueur1 = new MainJoueur(new Carte("Tr",14),new Carte("Pi",3),new Carte("Ca",2),new Carte("Co",8),new Carte("Pi",9));
        mainJoueur1.determinerLaMain();
        mainJoueur2 = new MainJoueur(new Carte("Pi",5),new Carte("Ca",3),new Carte("Tr",4),new Carte("Co",13),new Carte("Pi",2));
        mainJoueur2.determinerLaMain();
        result = mainJoueur1.compareMain(mainJoueur2);
        assertEquals("La main 1 gagne avec la carte la plus élevée : As",result);

        //mainJoueur2 a gagné
        mainJoueur1 = new MainJoueur(new Carte("Tr",4),new Carte("Pi",3),new Carte("Ca",2),new Carte("Co",7),new Carte("Pi",8));
        mainJoueur1.determinerLaMain();
        mainJoueur2 = new MainJoueur(new Carte("Pi",5),new Carte("Ca",3),new Carte("Tr",2),new Carte("Co",12),new Carte("Pi",13));
        mainJoueur2.determinerLaMain();
        result = mainJoueur1.compareMain(mainJoueur2);
        assertEquals("La main 2 gagne avec la carte la plus élevée : Roi",result);


        /**Test de comparaison Paire*/

        //Egalité
        mainJoueur1 = new MainJoueur(new Carte("Tr",10),new Carte("Pi",4),new Carte("Ca",3),new Carte("Co",2),new Carte("Pi",2));
        mainJoueur1.determinerLaMain();
        mainJoueur2 = new MainJoueur(new Carte("Pi",10),new Carte("Ca",4),new Carte("Tr",3),new Carte("Co",2),new Carte("Pi",2));
        mainJoueur2.determinerLaMain();
        result = mainJoueur1.compareMain(mainJoueur2);
        assertEquals("Egalité",result);

        //mainJoueur1 a gagné car il a une paire mais pas mainJoueur2
        mainJoueur1 = new MainJoueur(new Carte("Tr",4),new Carte("Pi",5),new Carte("Ca",3),new Carte("Co",2),new Carte("Pi",2));
        mainJoueur1.determinerLaMain();
        mainJoueur2 = new MainJoueur(new Carte("Pi",10),new Carte("Ca",4),new Carte("Tr",2),new Carte("Co",13),new Carte("Pi",12));
        mainJoueur2.determinerLaMain();
        result = mainJoueur1.compareMain(mainJoueur2);
        assertEquals("La main 1 gagne avec paire de 2",result);

        //mainJoueur1 a gagné car il a la paire la plus grande
        mainJoueur1 = new MainJoueur(new Carte("Tr",10),new Carte("Pi",13),new Carte("Ca",3),new Carte("Co",12),new Carte("Pi",12));
        mainJoueur1.determinerLaMain();
        mainJoueur2 = new MainJoueur(new Carte("Pi",5),new Carte("Ca",14),new Carte("Tr",3),new Carte("Co",3),new Carte("Pi",2));
        mainJoueur2.determinerLaMain();
        result = mainJoueur1.compareMain(mainJoueur2);
        assertEquals("La main 1 gagne avec paire de : Dame",result);

        //mainJoueur2 a gagné car il a une paire mais pas mainJoueur1
        mainJoueur1 = new MainJoueur(new Carte("Tr",4),new Carte("Pi",3),new Carte("Ca",2),new Carte("Co",12),new Carte("Pi",11));
        mainJoueur1.determinerLaMain();
        mainJoueur2 = new MainJoueur(new Carte("Pi",5),new Carte("Ca",4),new Carte("Tr",5),new Carte("Co",10),new Carte("Pi",11));
        mainJoueur2.determinerLaMain();
        result = mainJoueur1.compareMain(mainJoueur2);
        assertEquals("La main 2 gagne avec paire de 5",result);

        //mainJoueur2 a gagné car il a la paire la plus grande
        mainJoueur1 = new MainJoueur(new Carte("Tr",4),new Carte("Pi",8),new Carte("Ca",5),new Carte("Co",2),new Carte("Pi",2));
        mainJoueur1.determinerLaMain();
        mainJoueur2 = new MainJoueur(new Carte("Pi",5),new Carte("Ca",4),new Carte("Tr",5),new Carte("Co",12),new Carte("Pi",13));
        mainJoueur2.determinerLaMain();
        result = mainJoueur1.compareMain(mainJoueur2);
        assertEquals("La main 2 gagne avec paire de : 5",result);

        /**Test de comparaison Brelan*/

        //Egalité de brelan impossible car on ne peut avoir 2 brelans

        //mainJoueur1 a gagné car il a un brelan mais pas mainJoueur2
        mainJoueur1 = new MainJoueur(new Carte("Tr",3),new Carte("Pi",3),new Carte("Ca",3),new Carte("Co",2),new Carte("Pi",8));
        mainJoueur1.determinerLaMain();
        mainJoueur2 = new MainJoueur(new Carte("Pi",10),new Carte("Ca",5),new Carte("Tr",4),new Carte("Co",8),new Carte("Pi",2));
        mainJoueur2.determinerLaMain();
        result = mainJoueur1.compareMain(mainJoueur2);
        assertEquals("La main 1 gagne avec brelan de : 3",result);

        //mainJoueur1 a gagné car il a un brelan mais mainJoueur2 a une paire
        mainJoueur1 = new MainJoueur(new Carte("Tr",3),new Carte("Pi",3),new Carte("Ca",3),new Carte("Co",9),new Carte("Pi",4));
        mainJoueur1.determinerLaMain();
        mainJoueur2 = new MainJoueur(new Carte("Pi",10),new Carte("Ca",5),new Carte("Tr",5),new Carte("Co",8),new Carte("Pi",2));
        mainJoueur2.determinerLaMain();
        result = mainJoueur1.compareMain(mainJoueur2);
        assertEquals("La main 1 gagne avec brelan de : 3",result);

        //mainJoueur1 a gagné car il a le brelan le plus grand
        mainJoueur1 = new MainJoueur(new Carte("Tr",3),new Carte("Pi",3),new Carte("Ca",3),new Carte("Co",10),new Carte("Pi",8));
        mainJoueur1.determinerLaMain();
        mainJoueur2 = new MainJoueur(new Carte("Pi",2),new Carte("Ca",2),new Carte("Tr",2),new Carte("Co",7),new Carte("Pi",6));
        mainJoueur2.determinerLaMain();
        result = mainJoueur1.compareMain(mainJoueur2);
        assertEquals("La main 1 gagne avec brelan de : 3",result);

        //mainJoueur2 a gagné car il a un brelan mais pas mainJoueur1
        mainJoueur1 = new MainJoueur(new Carte("Tr",2),new Carte("Pi",3),new Carte("Ca",5),new Carte("Co",10),new Carte("Pi",4));
        mainJoueur1.determinerLaMain();
        mainJoueur2 = new MainJoueur(new Carte("Pi",10),new Carte("Ca",10),new Carte("Tr",10),new Carte("Co",9),new Carte("Pi",2));
        mainJoueur2.determinerLaMain();
        result = mainJoueur1.compareMain(mainJoueur2);
        assertEquals("La main 2 gagne avec brelan de : 10",result);

        //mainJoueur2 a gagné car il a un brelan mais mainJoueur1 a une paire
        mainJoueur1 = new MainJoueur(new Carte("Tr",10),new Carte("Pi",3),new Carte("Ca",3),new Carte("Co",8),new Carte("Pi",9));
        mainJoueur1.determinerLaMain();
        mainJoueur2 = new MainJoueur(new Carte("Pi",5),new Carte("Ca",5),new Carte("Tr",5),new Carte("Co",12),new Carte("Pi",11));
        mainJoueur2.determinerLaMain();
        result = mainJoueur1.compareMain(mainJoueur2);
        assertEquals("La main 2 gagne avec brelan de : 5",result);

        //mainJoueur2 a gagné car il a le brelan le plus grand
        mainJoueur1 = new MainJoueur(new Carte("Tr",3),new Carte("Pi",3),new Carte("Ca",3),new Carte("Co",9),new Carte("Pi",8));
        mainJoueur1.determinerLaMain();
        mainJoueur2 = new MainJoueur(new Carte("Pi",5),new Carte("Ca",5),new Carte("Tr",5),new Carte("Co",2),new Carte("Pi",7));
        mainJoueur2.determinerLaMain();
        result = mainJoueur1.compareMain(mainJoueur2);
        assertEquals("La main 2 gagne avec brelan de : 5",result);

    }

}