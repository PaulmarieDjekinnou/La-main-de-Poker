package poker;
/**
 *
 * @author PS5_The_Beginners
 */
import org.junit.Test;

import static org.junit.Assert.*;

public class ArbitreTest {

    @Test
    public void comparerLesDeuxMains() {
        /**Plus haute carte*/
        //Egalité
        MainJoueur mainJoueur1 = new MainJoueur(new Carte("Tr",5),new Carte("Pi",3),new Carte("Ca",2),new Carte("Co",4),new Carte("Pi",6));
        mainJoueur1.determinerLaMain();
        MainJoueur mainJoueur2 = new MainJoueur(new Carte("Tr",5),new Carte("Pi",3),new Carte("Ca",2),new Carte("Co",6),new Carte("Pi",4));
        mainJoueur2.determinerLaMain();
        Arbitre arbitre = new Arbitre(mainJoueur1, mainJoueur2);
        arbitre.ComparerLesDeuxMains();
        assertEquals("Egalité",arbitre.reponseArbitre);

        //mainJoueur1 gagne
        mainJoueur1 = new MainJoueur(new Carte("Tr",10),new Carte("Pi",9),new Carte("Ca",6),new Carte("Co",2),new Carte("Pi",8));
        mainJoueur1.determinerLaMain();
        mainJoueur2 = new MainJoueur(new Carte("Tr",5),new Carte("Pi",3),new Carte("Ca",4),new Carte("Co",7),new Carte("Ca",9));
        mainJoueur2.determinerLaMain();
        arbitre = new Arbitre(mainJoueur1, mainJoueur2);
        arbitre.ComparerLesDeuxMains();
        assertEquals("La main 1 gagne avec la carte la plus élevée : 10",arbitre.reponseArbitre);

        //mainJoueur2 gagne
        mainJoueur1 = new MainJoueur(new Carte("Tr",6),new Carte("Pi",9),new Carte("Ca",4),new Carte("Co",5),new Carte("Pi",2));
        mainJoueur1.determinerLaMain();
        mainJoueur2 = new MainJoueur(new Carte("Tr",5),new Carte("Pi",10),new Carte("Ca",2),new Carte("Co",6),new Carte("Pi",8));
        mainJoueur2.determinerLaMain();
        arbitre = new Arbitre(mainJoueur1, mainJoueur2);
        arbitre.ComparerLesDeuxMains();
        assertEquals("La main 2 gagne avec la carte la plus élevée : 10",arbitre.reponseArbitre);

        /**Brelan*/

        //mainJoueur1 gagne car il a un brelan mais pas mainJoueur2
        mainJoueur1 = new MainJoueur(new Carte("Tr",5),new Carte("Pi",5),new Carte("Ca",5),new Carte("Co",3),new Carte("Pi",2));
        mainJoueur1.determinerLaMain();
        mainJoueur2 = new MainJoueur(new Carte("Tr",8),new Carte("Co",2),new Carte("Ca",3),new Carte("Co",4),new Carte("Pi",5));
        mainJoueur2.determinerLaMain();
        arbitre = new Arbitre(mainJoueur1, mainJoueur2);
        arbitre.ComparerLesDeuxMains();
        assertEquals("La main 1 gagne avec brelan de : 5",arbitre.reponseArbitre);

        //mainJoueur2 gagne car il a un brelan mais pas mainJoueur1
        mainJoueur1 = new MainJoueur(new Carte("Tr",5),new Carte("Pi",2),new Carte("Ca",4),new Carte("Co",3),new Carte("Pi",8));
        mainJoueur1.determinerLaMain();
        mainJoueur2 = new MainJoueur(new Carte("Tr",8),new Carte("Co",8),new Carte("Ca",8),new Carte("Co",2),new Carte("Pi",3));
        mainJoueur2.determinerLaMain();
        arbitre = new Arbitre(mainJoueur1, mainJoueur2);
        arbitre.ComparerLesDeuxMains();
        assertEquals("La main 2 gagne avec brelan de : 8",arbitre.reponseArbitre);

        //mainJoueur1 gagne car il a un full mais mainJoueur2 a une paire
        mainJoueur1 = new MainJoueur(new Carte("Tr",5),new Carte("Pi",5),new Carte("Ca",5),new Carte("Co",2),new Carte("Pi",2));
        mainJoueur1.determinerLaMain();
        mainJoueur2 = new MainJoueur(new Carte("Tr",2),new Carte("Co",8),new Carte("Ca",8),new Carte("Co",4),new Carte("Pi",3));
        mainJoueur2.determinerLaMain();
        arbitre = new Arbitre(mainJoueur1, mainJoueur2);
        arbitre.ComparerLesDeuxMains();
        assertEquals("La main 1 gagne avec Full de valeur brelan : 5",arbitre.reponseArbitre);

        //mainJoueur2 gagne car il a un brelan mais mainJoueur1 a une paire
        mainJoueur1 = new MainJoueur(new Carte("Tr",5),new Carte("Pi",5),new Carte("Ca",4),new Carte("Co",2),new Carte("Pi",2));
        mainJoueur1.determinerLaMain();
        mainJoueur2 = new MainJoueur(new Carte("Tr",8),new Carte("Co",8),new Carte("Ca",8),new Carte("Co",3),new Carte("Pi",4));
        mainJoueur2.determinerLaMain();
        arbitre = new Arbitre(mainJoueur1, mainJoueur2);
        arbitre.ComparerLesDeuxMains();
        assertEquals("La main 2 gagne avec brelan de : 8",arbitre.reponseArbitre);

        /**Siute, paire et double paire*/

        //mainJoueur1 gagne car il a une suite mais mainJoueur2 a un brelan
        mainJoueur1 = new MainJoueur(new Carte("Tr",3),new Carte("Pi",4),new Carte("Ca",5),new Carte("Co",6),new Carte("Pi",7));
        mainJoueur1.determinerLaMain();
        mainJoueur2 = new MainJoueur(new Carte("Tr",2),new Carte("Pi",2),new Carte("Ca",2),new Carte("Co",5),new Carte("Pi",6));
        mainJoueur2.determinerLaMain();
        arbitre = new Arbitre(mainJoueur1, mainJoueur2);
        arbitre.ComparerLesDeuxMains();
        assertEquals("La main 1 gagne avec suite de : 7",arbitre.reponseArbitre);

        //mainJoueur2 gagne car il a une suite mais mainJoueur1 a un brelan
        mainJoueur1 = new MainJoueur(new Carte("Tr",4),new Carte("Pi",3),new Carte("Ca",4),new Carte("Co",4),new Carte("Pi",6));
        mainJoueur1.determinerLaMain();
        mainJoueur2 = new MainJoueur(new Carte("Tr",3),new Carte("Pi",4),new Carte("Ca",5),new Carte("Co",6),new Carte("Pi",7));
        mainJoueur2.determinerLaMain();
        arbitre = new Arbitre(mainJoueur1, mainJoueur2);
        arbitre.ComparerLesDeuxMains();
        assertEquals("La main 2 gagne avec suite de : 7",arbitre.reponseArbitre);

        //mainJoueur1 gagne car il a une suite mais mainJoueur2 a une 2Paire
        mainJoueur1 = new MainJoueur(new Carte("Tr",3),new Carte("Pi",4),new Carte("Ca",5),new Carte("Co",6),new Carte("Pi",7));
        mainJoueur1.determinerLaMain();
        mainJoueur2 = new MainJoueur(new Carte("Tr",2),new Carte("Pi",2),new Carte("Ca",4),new Carte("Co",4),new Carte("Pi",6));
        mainJoueur2.determinerLaMain();
        arbitre = new Arbitre(mainJoueur1, mainJoueur2);
        arbitre.ComparerLesDeuxMains();
        assertEquals("La main 1 gagne avec suite de : 7",arbitre.reponseArbitre);

        //mainJoueur2 gagne car il a une suite mais mainJoueur1 a une 2Paire
        mainJoueur1 = new MainJoueur(new Carte("Tr",4),new Carte("Pi",3),new Carte("Ca",3),new Carte("Co",4),new Carte("Pi",6));
        mainJoueur1.determinerLaMain();
        mainJoueur2 = new MainJoueur(new Carte("Tr",3),new Carte("Pi",4),new Carte("Ca",5),new Carte("Co",6),new Carte("Pi",7));
        mainJoueur2.determinerLaMain();
        arbitre = new Arbitre(mainJoueur1, mainJoueur2);
        arbitre.ComparerLesDeuxMains();
        assertEquals("La main 2 gagne avec suite de : 7",arbitre.reponseArbitre);

        //mainJoueur1 gagne car il a une suite mais mainJoueur2 a une Paire
        mainJoueur1 = new MainJoueur(new Carte("Tr",3),new Carte("Pi",4),new Carte("Ca",5),new Carte("Co",6),new Carte("Pi",7));
        mainJoueur1.determinerLaMain();
        mainJoueur2 = new MainJoueur(new Carte("Tr",2),new Carte("Pi",3),new Carte("Ca",4),new Carte("Co",4),new Carte("Pi",6));
        mainJoueur2.determinerLaMain();
        arbitre = new Arbitre(mainJoueur1, mainJoueur2);
        arbitre.ComparerLesDeuxMains();
        assertEquals("La main 1 gagne avec suite de : 7",arbitre.reponseArbitre);

        //mainJoueur2 gagne car il a une suite mais mainJoueur1 a une Paire
        mainJoueur1 = new MainJoueur(new Carte("Tr",4),new Carte("Pi",3),new Carte("Ca",8),new Carte("Co",4),new Carte("Pi",6));
        mainJoueur1.determinerLaMain();
        mainJoueur2 = new MainJoueur(new Carte("Tr",3),new Carte("Pi",4),new Carte("Ca",5),new Carte("Co",6),new Carte("Pi",7));
        mainJoueur2.determinerLaMain();
        arbitre = new Arbitre(mainJoueur1, mainJoueur2);
        arbitre.ComparerLesDeuxMains();
        assertEquals("La main 2 gagne avec suite de : 7",arbitre.reponseArbitre);
    }

    @Test
    public void departagerFull(){
        //mainJoueur1 gagne
        MainJoueur mainJoueur1 = new MainJoueur(new Carte("Tr",10),new Carte("Pi",10),new Carte("Ca",10),new Carte("Co",7),new Carte("Pi",7));
        mainJoueur1.determinerLaMain();
        MainJoueur mainJoueur2 = new MainJoueur(new Carte("Tr",5),new Carte("Pi",5),new Carte("Ca",5),new Carte("Co",4),new Carte("Pi",4));
        mainJoueur2.determinerLaMain();
        Arbitre arbitre = new Arbitre(mainJoueur1, mainJoueur2);
        String result = arbitre.departagerFull();
        assertEquals("La main 1 gagne avec Full de valeur brelan : 10",result);

        //mainJoueur2 gagne
        mainJoueur1 = new MainJoueur(new Carte("Tr",7),new Carte("Pi",7),new Carte("Ca",7),new Carte("Co",5),new Carte("Pi",5));
        mainJoueur1.determinerLaMain();
        mainJoueur2 = new MainJoueur(new Carte("Tr",10),new Carte("Pi",10),new Carte("Ca",10),new Carte("Co",6),new Carte("Pi",6));
        mainJoueur2.determinerLaMain();
        arbitre = new Arbitre(mainJoueur1, mainJoueur2);
        result = arbitre.departagerFull();
        assertEquals("La main 2 gagne avec Full de valeur brelan : 10",result);
    }

    @Test
    public void departagerCarre(){
        //mainJoueur1 gagne
        MainJoueur mainJoueur1 = new MainJoueur(new Carte("Tr",10),new Carte("Pi",10),new Carte("Ca",10),new Carte("Co",10),new Carte("Pi",6));
        mainJoueur1.determinerLaMain();
        MainJoueur mainJoueur2 = new MainJoueur(new Carte("Tr",7),new Carte("Pi",7),new Carte("Ca",7),new Carte("Co",7),new Carte("Pi",8));
        mainJoueur2.determinerLaMain();
        Arbitre arbitre = new Arbitre(mainJoueur1, mainJoueur2);
        String result = arbitre.departagerCarre();
        assertEquals("La main 1 gagne avec carre de : 10",result);

        //mainJoueur2 gagne
        mainJoueur1 = new MainJoueur(new Carte("Tr",5),new Carte("Pi",5),new Carte("Ca",5),new Carte("Co",5),new Carte("Pi",7));
        mainJoueur1.determinerLaMain();
        mainJoueur2 = new MainJoueur(new Carte("Tr",6),new Carte("Pi",10),new Carte("Ca",6),new Carte("Co",6),new Carte("Pi",6));
        mainJoueur2.determinerLaMain();
        arbitre = new Arbitre(mainJoueur1, mainJoueur2);
        result = arbitre.departagerCarre();
        assertEquals("La main 2 gagne avec carre de : 6",result);
    }

    @Test
    public void departagerSuite(){
        //Egalité
        MainJoueur mainJoueur1 = new MainJoueur(new Carte("Tr",2),new Carte("Pi",3),new Carte("Ca",4),new Carte("Co",5),new Carte("Pi",6));
        mainJoueur1.determinerLaMain();
        MainJoueur mainJoueur2 = new MainJoueur(new Carte("Tr",6),new Carte("Pi",5),new Carte("Ca",4),new Carte("Co",3),new Carte("Pi",2));
        mainJoueur2.determinerLaMain();
        Arbitre arbitre = new Arbitre(mainJoueur1, mainJoueur2);
        String result = arbitre.departagerSuite();
        assertEquals("Egalité",result);

        //mainJoueur1 gagne car il a une suite plus grande que celle de mainJoueur2
        mainJoueur1 = new MainJoueur(new Carte("Tr",3),new Carte("Pi",4),new Carte("Ca",5),new Carte("Co",6),new Carte("Pi",7));
        mainJoueur1.determinerLaMain();
        mainJoueur2 = new MainJoueur(new Carte("Tr",2),new Carte("Pi",3),new Carte("Ca",4),new Carte("Co",5),new Carte("Pi",6));
        mainJoueur2.determinerLaMain();
        arbitre = new Arbitre(mainJoueur1, mainJoueur2);
        result = arbitre.departagerSuite();
        assertEquals("La main 1 gagne avec suite de : 7",result);

        //mainJoueur2 gagne car il a une suite plus grande que celle de mainJoueur1
        mainJoueur1 = new MainJoueur(new Carte("Tr",2),new Carte("Pi",3),new Carte("Ca",4),new Carte("Co",5),new Carte("Pi",6));
        mainJoueur1.determinerLaMain();
        mainJoueur2 = new MainJoueur(new Carte("Tr",3),new Carte("Pi",4),new Carte("Ca",5),new Carte("Co",6),new Carte("Pi",7));
        mainJoueur2.determinerLaMain();
        arbitre = new Arbitre(mainJoueur1, mainJoueur2);
        result = arbitre.departagerSuite();
        assertEquals("La main 2 gagne avec suite de : 7",result);

    }

    @Test
    public void departagerQuinte(){
        /**Couleur noire*/

        //Egalité
        MainJoueur mainJoueur1 = new MainJoueur(new Carte("Tr",2),new Carte("Tr",3),new Carte("Tr",4),new Carte("Tr",5),new Carte("Tr",6));
        mainJoueur1.determinerLaMain();
        MainJoueur mainJoueur2 = new MainJoueur(new Carte("Pi",6),new Carte("Pi",5),new Carte("Pi",4),new Carte("Pi",3),new Carte("Pi",2));
        mainJoueur2.determinerLaMain();
        Arbitre arbitre = new Arbitre(mainJoueur1, mainJoueur2);
        String result = arbitre.departagerQuinte();
        assertEquals("Egalité",result);

        //mainJoueur1 gagne car il a une quinte flush plus grande que celle de mainJoueur2
        mainJoueur1 = new MainJoueur(new Carte("Tr",3),new Carte("Tr",4),new Carte("Tr",5),new Carte("Tr",6),new Carte("Tr",7));
        mainJoueur1.determinerLaMain();
        mainJoueur2 = new MainJoueur(new Carte("Pi",2),new Carte("Pi",3),new Carte("Pi",4),new Carte("Pi",5),new Carte("Pi",6));
        mainJoueur2.determinerLaMain();
        arbitre = new Arbitre(mainJoueur1, mainJoueur2);
        result = arbitre.departagerQuinte();
        assertEquals("La main 1 gagne avec Quinte flush de suite : 7",result);

        //mainJoueur2 gagne car il a une quinte flush plus grande que celle de mainJoueur1
        mainJoueur1 = new MainJoueur(new Carte("Tr",2),new Carte("Pi",3),new Carte("Ca",4),new Carte("Co",5),new Carte("Pi",6));
        mainJoueur1.determinerLaMain();
        mainJoueur2 = new MainJoueur(new Carte("Tr",3),new Carte("Pi",4),new Carte("Ca",5),new Carte("Co",6),new Carte("Pi",7));
        mainJoueur2.determinerLaMain();
        arbitre = new Arbitre(mainJoueur1, mainJoueur2);
        result = arbitre.departagerQuinte();
        assertEquals("La main 2 gagne avec Quinte flush de suite : 7",result);

        /**Couleur rouge*/

        //Egalité
        mainJoueur1 = new MainJoueur(new Carte("Co",2),new Carte("Co",3),new Carte("Co",4),new Carte("Co",5),new Carte("Co",6));
        mainJoueur1.determinerLaMain();
        mainJoueur2 = new MainJoueur(new Carte("Ca",6),new Carte("Ca",5),new Carte("Ca",4),new Carte("Ca",3),new Carte("Ca",2));
        mainJoueur2.determinerLaMain();
        arbitre = new Arbitre(mainJoueur1, mainJoueur2);
        result = arbitre.departagerQuinte();
        assertEquals("Egalité",result);

        //mainJoueur1 gagne car il a une quinte flush plus grande que celle de mainJoueur2
        mainJoueur1 = new MainJoueur(new Carte("Ca",3),new Carte("Ca",4),new Carte("Ca",5),new Carte("Ca",6),new Carte("Ca",7));
        mainJoueur1.determinerLaMain();
        mainJoueur2 = new MainJoueur(new Carte("Co",2),new Carte("Co",3),new Carte("Co",4),new Carte("Co",5),new Carte("Co",6));
        mainJoueur2.determinerLaMain();
        arbitre = new Arbitre(mainJoueur1, mainJoueur2);
        result = arbitre.departagerQuinte();
        assertEquals("La main 1 gagne avec Quinte flush de suite : 7",result);

        //mainJoueur2 gagne car il a une quinte flush plus grande que celle de mainJoueur1
        mainJoueur1 = new MainJoueur(new Carte("Co",2),new Carte("Ca",3),new Carte("Co",4),new Carte("Ca",5),new Carte("Co",6));
        mainJoueur1.determinerLaMain();
        mainJoueur2 = new MainJoueur(new Carte("Ca",3),new Carte("Co",4),new Carte("Ca",5),new Carte("Co",6),new Carte("Ca",7));
        mainJoueur2.determinerLaMain();
        arbitre = new Arbitre(mainJoueur1, mainJoueur2);
        result = arbitre.departagerQuinte();
        assertEquals("La main 2 gagne avec Quinte flush de suite : 7",result);

    }

    @Test
    public void departagerPlusHauteCarte() {
        //Egalité
        MainJoueur mainJoueur1 = new MainJoueur(new Carte("Tr",5),new Carte("Pi",3),new Carte("Ca",2),new Carte("Co",4),new Carte("Pi",8));
        mainJoueur1.determinerLaMain();
        MainJoueur mainJoueur2 = new MainJoueur(new Carte("Tr",2),new Carte("Pi",5),new Carte("Ca",3),new Carte("Co",8),new Carte("Pi",4));
        mainJoueur2.determinerLaMain();
        Arbitre arbitre = new Arbitre(mainJoueur1, mainJoueur2);
        String result = arbitre.departagerPlusHauteCarte();
        assertEquals("Egalité",result);

        //mainJoueur1 gagne
        mainJoueur1 = new MainJoueur(new Carte("Tr",10),new Carte("Pi",3),new Carte("Ca",2),new Carte("Co",8),new Carte("Pi",7));
        mainJoueur1.determinerLaMain();
        mainJoueur2 = new MainJoueur(new Carte("Tr",5),new Carte("Pi",2),new Carte("Ca",3),new Carte("Co",6),new Carte("Pi",4));
        mainJoueur2.determinerLaMain();
        arbitre = new Arbitre(mainJoueur1, mainJoueur2);
        result = arbitre.departagerPlusHauteCarte();
        assertEquals("La main 1 gagne avec la carte la plus élevée : 10",result);

        //mainJoueur2 gagne
        mainJoueur1 = new MainJoueur(new Carte("Tr",2),new Carte("Pi",3),new Carte("Ca",2),new Carte("Co",6),new Carte("Pi",4));
        mainJoueur1.determinerLaMain();
        mainJoueur2 = new MainJoueur(new Carte("Tr",8),new Carte("Pi",10),new Carte("Ca",3),new Carte("Co",8),new Carte("Pi",9));
        mainJoueur2.determinerLaMain();
        arbitre = new Arbitre(mainJoueur1, mainJoueur2);
        result = arbitre.departagerPlusHauteCarte();
        assertEquals("La main 2 gagne avec la carte la plus élevée : 10",result);
    }

    @Test
    public void departagerDeuxPaire(){
        //Egalité
        MainJoueur mainJoueur1 = new MainJoueur(new Carte("Tr",5),new Carte("Pi",5),new Carte("Ca",2),new Carte("Co",2),new Carte("Pi",4));
        mainJoueur1.determinerLaMain();
        MainJoueur mainJoueur2 = new MainJoueur(new Carte("Tr",2),new Carte("Co",5),new Carte("Ca",5),new Carte("Co",4),new Carte("Pi",2));
        mainJoueur2.determinerLaMain();
        Arbitre arbitre = new Arbitre(mainJoueur1, mainJoueur2);
        String result = arbitre.departagerDeuxPaire();
        assertEquals("Egalité",result);

        //Egalité de double paire, mainJoueur1 gagne par ses autres cartes
        mainJoueur1 = new MainJoueur(new Carte("Tr",5),new Carte("Pi",5),new Carte("Ca",8),new Carte("Co",8),new Carte("Pi",7));
        mainJoueur1.determinerLaMain();
        mainJoueur2 = new MainJoueur(new Carte("Tr",8),new Carte("Co",5),new Carte("Ca",5),new Carte("Co",4),new Carte("Pi",8));
        mainJoueur2.determinerLaMain();
        arbitre = new Arbitre(mainJoueur1, mainJoueur2);
        result = arbitre.departagerDeuxPaire();
        assertEquals("La main 1 gagne avec deux paire de carte plus élevée : 7",result);

        //Egalité de double paire, mainJoueur2 gagne par ses autres cartes
        mainJoueur1 = new MainJoueur(new Carte("Tr",5),new Carte("Pi",5),new Carte("Ca",2),new Carte("Co",2),new Carte("Pi",4));
        mainJoueur1.determinerLaMain();
        mainJoueur2 = new MainJoueur(new Carte("Tr",2),new Carte("Co",5),new Carte("Ca",5),new Carte("Co",7),new Carte("Pi",2));
        mainJoueur2.determinerLaMain();
        arbitre = new Arbitre(mainJoueur1, mainJoueur2);
        result = arbitre.departagerDeuxPaire();
        assertEquals("La main 2 gagne avec deux paire de carte plus élevée : 7",result);

        //mainJoueur1 gagne par la double paire la plus grande
        mainJoueur1 = new MainJoueur(new Carte("Tr",10),new Carte("Pi",10),new Carte("Ca",8),new Carte("Co",8),new Carte("Pi",4));
        mainJoueur1.determinerLaMain();
        mainJoueur2 = new MainJoueur(new Carte("Tr",5),new Carte("Pi",5),new Carte("Ca",3),new Carte("Co",3),new Carte("Tr",4));
        mainJoueur2.determinerLaMain();
        arbitre = new Arbitre(mainJoueur1, mainJoueur2);
        result = arbitre.departagerDeuxPaire();
        assertEquals("La main 1 gagne avec deux paire de : 8 et de : 10",result);

        //mainJoueur2 gagne par la double paire la plus grande
        mainJoueur1 = new MainJoueur(new Carte("Tr",10),new Carte("Pi",2),new Carte("Ca",2),new Carte("Co",3),new Carte("Pi",3));
        mainJoueur1.determinerLaMain();
        mainJoueur2 = new MainJoueur(new Carte("Tr",8),new Carte("Pi",10),new Carte("Ca",10),new Carte("Co",8),new Carte("Pi",6));
        mainJoueur2.determinerLaMain();
        arbitre = new Arbitre(mainJoueur1, mainJoueur2);
        result = arbitre.departagerDeuxPaire();
        assertEquals("La main 2 gagne avec deux paire de : 8 et de : 10",result);
    }

    @Test
    public void departagerPaire() {
        //Egalité
        MainJoueur mainJoueur1 = new MainJoueur(new Carte("Tr",5),new Carte("Pi",5),new Carte("Ca",2),new Carte("Co",3),new Carte("Pi",4));
        mainJoueur1.determinerLaMain();
        MainJoueur mainJoueur2 = new MainJoueur(new Carte("Tr",2),new Carte("Co",5),new Carte("Ca",5),new Carte("Co",4),new Carte("Pi",3));
        mainJoueur2.determinerLaMain();
        Arbitre arbitre = new Arbitre(mainJoueur1, mainJoueur2);
        String result = arbitre.departagerPaire();
        assertEquals("Egalité",result);

        //Egalité de paire, mainJoueur1 gagne par ses autres cartes
        mainJoueur1 = new MainJoueur(new Carte("Tr",5),new Carte("Pi",5),new Carte("Ca",8),new Carte("Co",6),new Carte("Pi",7));
        mainJoueur1.determinerLaMain();
        mainJoueur2 = new MainJoueur(new Carte("Tr",2),new Carte("Co",5),new Carte("Ca",5),new Carte("Co",4),new Carte("Pi",3));
        mainJoueur2.determinerLaMain();
        arbitre = new Arbitre(mainJoueur1, mainJoueur2);
        result = arbitre.departagerPaire();
        assertEquals("La main 1 gagne avec paire de carte plus élevée : 8",result);

        //Egalité de paire, mainJoueur2 gagne par ses autres cartes
        mainJoueur1 = new MainJoueur(new Carte("Tr",5),new Carte("Pi",5),new Carte("Ca",2),new Carte("Co",3),new Carte("Pi",4));
        mainJoueur1.determinerLaMain();
        mainJoueur2 = new MainJoueur(new Carte("Tr",9),new Carte("Co",5),new Carte("Ca",5),new Carte("Co",7),new Carte("Pi",6));
        mainJoueur2.determinerLaMain();
        arbitre = new Arbitre(mainJoueur1, mainJoueur2);
        result = arbitre.departagerPaire();
        assertEquals("La main 2 gagne avec paire de carte plus élevée : 9",result);

        //mainJoueur1 gagne par paire la plus grande
        mainJoueur1 = new MainJoueur(new Carte("Tr",10),new Carte("Pi",10),new Carte("Ca",2),new Carte("Co",3),new Carte("Pi",4));
        mainJoueur1.determinerLaMain();
        mainJoueur2 = new MainJoueur(new Carte("Tr",5),new Carte("Pi",5),new Carte("Ca",3),new Carte("Co",2),new Carte("Tr",4));
        mainJoueur2.determinerLaMain();
        arbitre = new Arbitre(mainJoueur1, mainJoueur2);
        result = arbitre.departagerPaire();
        assertEquals("La main 1 gagne avec paire de : 10",result);

        //mainJoueur2 gagne par paire la plus grande
        mainJoueur1 = new MainJoueur(new Carte("Tr",10),new Carte("Pi",2),new Carte("Ca",2),new Carte("Co",3),new Carte("Pi",4));
        mainJoueur1.determinerLaMain();
        mainJoueur2 = new MainJoueur(new Carte("Tr",8),new Carte("Pi",10),new Carte("Ca",10),new Carte("Co",2),new Carte("Pi",6));
        mainJoueur2.determinerLaMain();
        arbitre = new Arbitre(mainJoueur1, mainJoueur2);
        result = arbitre.departagerPaire();
        assertEquals("La main 2 gagne avec paire de : 10",result);
    }

    @Test
    public void departagerBrelan() {
        //mainJoueur1 gagne par brelan le plus élevé
        MainJoueur mainJoueur1 = new MainJoueur(new Carte("Tr",5),new Carte("Pi",5),new Carte("Ca",5),new Carte("Co",2),new Carte("Pi",2));
        mainJoueur1.determinerLaMain();
        MainJoueur mainJoueur2 = new MainJoueur(new Carte("Tr",3),new Carte("Co",3),new Carte("Ca",3),new Carte("Co",4),new Carte("Pi",4));
        mainJoueur2.determinerLaMain();
        Arbitre arbitre = new Arbitre(mainJoueur1, mainJoueur2);
        String result = arbitre.departagerBrelan();
        assertEquals("La main 1 gagne avec brelan de : 5",result);

        //mainJoueur2 gagne par brelan le plus élevé
        mainJoueur1 = new MainJoueur(new Carte("Tr",5),new Carte("Pi",5),new Carte("Ca",5),new Carte("Co",4),new Carte("Pi",4));
        mainJoueur1.determinerLaMain();
        mainJoueur2 = new MainJoueur(new Carte("Tr",8),new Carte("Co",8),new Carte("Ca",8),new Carte("Co",2),new Carte("Pi",2));
        mainJoueur2.determinerLaMain();
        arbitre = new Arbitre(mainJoueur1, mainJoueur2);
        result = arbitre.departagerBrelan();
        assertEquals("La main 2 gagne avec brelan de : 8",result);

    }

    @Test
    public void departagerCouleur(){
        /**Couleur noire*/

        //Egalité
        MainJoueur mainJoueur1 = new MainJoueur(new Carte("Tr",2),new Carte("Tr",8),new Carte("Tr",4),new Carte("Tr",3),new Carte("Tr",6));
        mainJoueur1.determinerLaMain();
        MainJoueur mainJoueur2 = new MainJoueur(new Carte("Pi",6),new Carte("Pi",3),new Carte("Pi",4),new Carte("Pi",8),new Carte("Pi",2));
        mainJoueur2.determinerLaMain();
        Arbitre arbitre = new Arbitre(mainJoueur1, mainJoueur2);
        String result = arbitre.departagerCouleur();
        assertEquals("Egalité",result);

        //mainJoueur1 gagne car il a une Couleur plus grande que celle de mainJoueur2
        mainJoueur1 = new MainJoueur(new Carte("Tr",9),new Carte("Tr",4),new Carte("Tr",5),new Carte("Tr",6),new Carte("Tr",7));
        mainJoueur1.determinerLaMain();
        mainJoueur2 = new MainJoueur(new Carte("Pi",2),new Carte("Pi",3),new Carte("Pi",8),new Carte("Pi",5),new Carte("Pi",6));
        mainJoueur2.determinerLaMain();
        arbitre = new Arbitre(mainJoueur1, mainJoueur2);
        result = arbitre.departagerCouleur();
        assertEquals("La main 1 gagne avec la couleur de carte la plus élevée : 9",result);

        //mainJoueur2 gagne car il a une Couleur plus grande que celle de mainJoueur1
        mainJoueur1 = new MainJoueur(new Carte("Tr",2),new Carte("Pi",3),new Carte("Ca",7),new Carte("Co",5),new Carte("Pi",6));
        mainJoueur1.determinerLaMain();
        mainJoueur2 = new MainJoueur(new Carte("Tr",3),new Carte("Pi",4),new Carte("Ca",5),new Carte("Co",6),new Carte("Pi",10));
        mainJoueur2.determinerLaMain();
        arbitre = new Arbitre(mainJoueur1, mainJoueur2);
        result = arbitre.departagerCouleur();
        assertEquals("La main 2 gagne avec la couleur de carte la plus élevée : 10",result);

        /**Couleur rouge*/

        //Egalité
        mainJoueur1 = new MainJoueur(new Carte("Co",2),new Carte("Co",3),new Carte("Co",4),new Carte("Co",8),new Carte("Co",6));
        mainJoueur1.determinerLaMain();
        mainJoueur2 = new MainJoueur(new Carte("Ca",6),new Carte("Ca",8),new Carte("Ca",4),new Carte("Ca",3),new Carte("Ca",2));
        mainJoueur2.determinerLaMain();
        arbitre = new Arbitre(mainJoueur1, mainJoueur2);
        result = arbitre.departagerCouleur();
        assertEquals("Egalité",result);

        //mainJoueur1 gagne car il a une Couleur plus grande que celle de mainJoueur2
        mainJoueur1 = new MainJoueur(new Carte("Ca",9),new Carte("Ca",4),new Carte("Ca",5),new Carte("Ca",6),new Carte("Ca",7));
        mainJoueur1.determinerLaMain();
        mainJoueur2 = new MainJoueur(new Carte("Co",2),new Carte("Co",3),new Carte("Co",8),new Carte("Co",5),new Carte("Co",6));
        mainJoueur2.determinerLaMain();
        arbitre = new Arbitre(mainJoueur1, mainJoueur2);
        result = arbitre.departagerCouleur();
        assertEquals("La main 1 gagne avec la couleur de carte la plus élevée : 9",result);

        //mainJoueur2 gagne car il a une Couleur plus grande que celle de mainJoueur1
        mainJoueur1 = new MainJoueur(new Carte("Co",2),new Carte("Ca",3),new Carte("Co",7),new Carte("Ca",5),new Carte("Co",6));
        mainJoueur1.determinerLaMain();
        mainJoueur2 = new MainJoueur(new Carte("Ca",3),new Carte("Co",4),new Carte("Ca",5),new Carte("Co",6),new Carte("Ca",10));
        mainJoueur2.determinerLaMain();
        arbitre = new Arbitre(mainJoueur1, mainJoueur2);
        result = arbitre.departagerCouleur();
        assertEquals("La main 2 gagne avec la couleur de carte la plus élevée : 10",result);
    }
}