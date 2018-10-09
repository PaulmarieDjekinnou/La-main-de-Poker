/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

import java.util.ArrayList;

/**
 * @author PS5
 */

public class Arbitre {
    
    MainJoueur MainOne;
    MainJoueur MainTwo;
    String     reponseArbitre;
    
    public Arbitre(MainJoueur one,MainJoueur two)
    {
        MainOne = one;
        MainTwo = two;
    }
    
    public void ComparerLesDeuxMains()
    {
        int MainO = CombinaisonJoueur.convertirMain(MainOne.getCombinaison());
        int MainT = CombinaisonJoueur.convertirMain(MainTwo.getCombinaison());
        
        if (MainO > MainT) donnerReponseMainDifferente(1);
        else if (MainO < MainT) donnerReponseMainDifferente(2);
        else
        {
            switch(MainO){
                case 0 : reponseArbitre = this.departagerPlusHauteCarte(); break;
                case 1 : reponseArbitre = this.departagerPaire(); break;
                case 2 : reponseArbitre = this.departagerDeuxPaire(); break;
                case 3 : reponseArbitre = this.departagerBrelan(); break; 
                case 4 : reponseArbitre = this.departagerSuite(); break;
                case 5 : reponseArbitre = this.departagerCouleur(); break;
                case 6 : reponseArbitre = this.departagerFull(); break;
                case 7 : reponseArbitre = this.departagerCarre(); break;
                case 8 : reponseArbitre = this.departagerQuinte(); break;
            }
        }
    }
    
    void donnerReponseMainDifferente(int mainNum)
    {
        switch(mainNum)
        {
            case 1 : {
                        int MainO = CombinaisonJoueur.convertirMain(MainOne.getCombinaison());
                        switch(MainO)
                        {
                            case 0 : {
                               MainPlusHauteCarte test = new MainPlusHauteCarte(MainOne,"Plus haute carte");
                               reponseArbitre = "La main 1 gagne avec carte la plus élevée : "+renvoitNomCarte(test.determinerLaCartePlusHaute(4));
                                     }break;
                            case 1 : {
                               MainPaire test = new MainPaire(MainOne,"Paire");
                               reponseArbitre = "La main 1 gagne avec paire de "+renvoitNomCarte(test.renvoitValeurPairre());
                                     }break;
                            case 2 : {
                               MainDeuxPaire test = new MainDeuxPaire(MainOne,"2Paire");
                               int[] tab1 = test.renvoitValeur2Pairre();
                               reponseArbitre = "La main 1 gagne avec deux paire de : "+renvoitNomCarte(tab1[0])+" et de : "+renvoitNomCarte(tab1[1]);
                                     }break;
                            case 3 : {
                                MainBrelan test = new MainBrelan(MainOne,"Brelan");
                                reponseArbitre = "La main 1 gagne avec brelan de : "+renvoitNomCarte(test.renvoiValeurBrelan());
                                     }break;
                            case 4 : {
                                MainSuite test = new MainSuite(MainOne,"Suite");
                                reponseArbitre = "La main 1 gagne avec suite de : "+renvoitNomCarte(test.RenvoitValeurSuite());
                                     }break;
                            case 5 : {
                                MainCouleur test = new MainCouleur(MainOne,"Couleur");
                                reponseArbitre = "La main 1 gagne avec couleur de carte haute : "+renvoitNomCarte(test.determinerLaCartePlusHaute(4));
                                     }break;
                            case 6 : {
                                MainFull test = new MainFull(MainOne,"Full");
                                reponseArbitre = "La main 1 gagne avec Full de valeur brelan : "+renvoitNomCarte(test.renvoiValeurBrelan());
                                     }break;
                            case 7 : {
                                MainCarre test = new MainCarre(MainOne,"Carre");
                                reponseArbitre = "La main 1 gagne avec Carre de : "+renvoitNomCarte(test.retourneValeurCarre());
                                     }break;
                            case 8 : {
                                MainQuinteFlush test = new MainQuinteFlush(MainOne,"Quinte");
                                reponseArbitre = "La main 1 gagne avec Quinte de : "+renvoitNomCarte(test.renvoitValeurQuinte());
                                     }break;
                        } 
                     }break;
            
            case 2 : {
                        int MainO = CombinaisonJoueur.convertirMain(MainTwo.getCombinaison());
                        switch(MainO)
                        {
                            case 0 : {
                               MainPlusHauteCarte test = new MainPlusHauteCarte(MainTwo,"Plus haute carte");
                               reponseArbitre = "La main 2 gagne avec carte la plus élevée : "+renvoitNomCarte(test.determinerLaCartePlusHaute(4));
                                     }break;
                            case 1 : {
                               MainPaire test = new MainPaire(MainTwo,"Paire");
                               reponseArbitre = "La main 2 gagne avec paire de "+renvoitNomCarte(test.renvoitValeurPairre());
                                     }break;
                            case 2 : {
                               MainDeuxPaire test = new MainDeuxPaire(MainTwo,"2Paire");
                               int[] tab1 = test.renvoitValeur2Pairre();
                               reponseArbitre = "La main 2 gagne avec deux paire de : "+renvoitNomCarte(tab1[0])+" et de : "+renvoitNomCarte(tab1[1]);
                                     }break;
                            case 3 : {
                                MainBrelan test = new MainBrelan(MainTwo,"Brelan");
                                reponseArbitre = "La main 2 gagne avec brelan de : "+renvoitNomCarte(test.renvoiValeurBrelan());
                                     }break;
                            case 4 : {
                                MainSuite test = new MainSuite(MainTwo,"Suite");
                                reponseArbitre = "La main 2 gagne avec suite de : "+renvoitNomCarte(test.RenvoitValeurSuite());
                                     }break;
                            case 5 : {
                                MainCouleur test = new MainCouleur(MainTwo,"Couleur");
                                reponseArbitre = "La main 2 gagne avec couleur de carte haute : "+renvoitNomCarte(test.determinerLaCartePlusHaute(4));
                                     }break;
                            case 6 : {
                                MainFull test = new MainFull(MainTwo,"Full");
                                reponseArbitre = "La main 2 gagne avec Full de valeur brelan : "+renvoitNomCarte(test.renvoiValeurBrelan());
                                     }break;
                            case 7 : {
                                MainCarre test = new MainCarre(MainTwo,"Carre");
                                reponseArbitre = "La main 2 gagne avec Carre de : "+renvoitNomCarte(test.retourneValeurCarre());
                                     }break;
                            case 8 : {
                                MainQuinteFlush test = new MainQuinteFlush(MainTwo,"Quinte");
                                reponseArbitre = "La main 2 gagne avec Quinte de : "+renvoitNomCarte(test.renvoitValeurQuinte());
                                     }break;
                        } 
                     }break;
        }
    }
    
    String departagerFull()
    {
        MainFull MainO = new MainFull(MainOne,"Full");
        MainFull MainT = new MainFull(MainTwo,"Full");
        int val1 = MainO.renvoiValeurBrelan();
        int val2 = MainT.renvoiValeurBrelan(); 
        if(val1 > val2) 
            return "La main 1 gagne avec Full de valeur brelan : "+renvoitNomCarte(val1);
        else if (val1 < val2) 
            return "La main 2 gagne avec Full de valeur brelan : "+renvoitNomCarte(val2);
        return "Egalité";
    } 
    
    String getreponseArbitre()
    {
     return reponseArbitre;    
    }
    
    String departagerCarre()
    {
        MainCarre MainO = new MainCarre(MainOne,"Carre");
        MainCarre MainT = new MainCarre(MainTwo,"Carre");
        int val1 = MainO.retourneValeurCarre();
        int val2 = MainT.retourneValeurCarre();
        if (val1 > val2)
            return "La main 1 gagne avec carre de : "+renvoitNomCarte(val1);
        else if (val1 < val2) 
            return "La main 2 gagne avec carre de : "+renvoitNomCarte(val2);
        else return "Egalité";
    }
    
    
    String departagerSuite()
    {
        MainSuite MainO = new MainSuite(MainOne,"Suite");
        MainSuite MainT = new MainSuite(MainTwo,"Suite");
        int val1 = MainO.RenvoitValeurSuite();
        int val2 = MainT.RenvoitValeurSuite(); 
        if (val1 > val2) 
            return "La main 1 gagne avec suite de : "+renvoitNomCarte(val1);
        else if (val1 < val2) 
            return "La main 2 gagne avec suite de : "+renvoitNomCarte(val2);
        else return "Egalité";
    }
    
    String departagerQuinte()
    {
        MainQuinteFlush MainO = new MainQuinteFlush(MainOne,"Quinte");
        MainQuinteFlush MainT = new MainQuinteFlush(MainTwo,"Quinte");
        int val1 = MainO.renvoitValeurQuinte();
        int val2 = MainT.renvoitValeurQuinte(); 
        if (val1 > val2) 
            return "La main 1 gagne avec Quinte flush de suite : "+renvoitNomCarte(val1);
        else if (val1 < val2) 
            return "La main 2 gagne avec Quinte flush de suite : "+renvoitNomCarte(val2);
        else return "Egalité";
    }
    
    String departagerPlusHauteCarte()
    {
        MainPlusHauteCarte MainO = new MainPlusHauteCarte(MainOne,"Plus Haute Carte");
        MainPlusHauteCarte MainT = new MainPlusHauteCarte(MainTwo,"Plus Haute Carte");
        int a = 4;
        int reponse = 0;
        while (MainO.determinerLaCartePlusHaute(a) == MainT.determinerLaCartePlusHaute(a))
        {
            a = a - 1;
            if (a<0) break;
        }
        if (a<0) return "Egalité";
        else
        {
            if (MainOne.mainJ[a].getValeur() > MainTwo.mainJ[a].getValeur()) 
                return "La main 1 gagne avec la carte la plus élevée : "+renvoitNomCarte(MainOne.mainJ[a].getValeur());           
            else 
                return "La main 2 gagne avec la carte la plus élevée : "+renvoitNomCarte(MainTwo.mainJ[a].getValeur());
        }
    }
    
    String renvoitNomCarte(int a)
    {
        String val="";
        switch (a)
        {
            case 2 : val = "2";break;
            case 3 : val = "3";break;
            case 4 : val = "4";break;
            case 5 : val = "5";break;
            case 6 : val = "6";break;
            case 7 : val = "7";break;
            case 8 : val = "8";break;
            case 9 : val = "9";break;
            case 10 : val = "10";break;
            case 11 : val = "Valet";break;
            case 12 : val = "Dame";break;
            case 13 : val = "Roi";break;
            case 14 : val = "As";break;
        }
        return val;
    }
    
    String departagerDeuxPaire()
    {
        MainOne.rangerCarteOrdreCroissant();
        MainTwo.rangerCarteOrdreCroissant();   
        MainDeuxPaire MainO = new MainDeuxPaire(MainOne,"2Paire");
        MainDeuxPaire MainT = new MainDeuxPaire(MainTwo,"2Paire");
        
        int[] tab1 = MainO.renvoitValeur2Pairre();
        int[] tab2 = MainT.renvoitValeur2Pairre();  
        int a = 1;
        while (tab1[a] == tab2[a])
            {
                a = a - 1;
                if (a<0) break;
            }
        if (a<0)
        {   
            int val1 = MainO.retourneValeurDerniereCarte(tab1);
            int val2 = MainT.retourneValeurDerniereCarte(tab2);
            
            if (val1 > val2) 
                return "La main 1 gagne avec deux paire de carte plus élevée : "+renvoitNomCarte(val1);
            else if (val1 < val2) 
                return "La main 2 gagne avec deux paire de carte plus élevée : "+renvoitNomCarte(val2);
            else return "Egalité";
        }
        else if (tab1[a] > tab2[a])
            return "La main 1 gagne avec deux paire de : "+renvoitNomCarte(tab1[0])+" et de : "+renvoitNomCarte(tab1[1]);
        else 
            return "La main 2 gagne avec deux paire de : "+renvoitNomCarte(tab2[0])+" et de : "+renvoitNomCarte(tab2[1]);
    }
      
    String departagerPaire()
    {
        MainOne.rangerCarteOrdreCroissant();
        MainTwo.rangerCarteOrdreCroissant();
        MainPaire PaireOne = new MainPaire(MainOne,"Paire");
        MainPaire PaireTwo = new MainPaire(MainTwo,"Paire");
        int Paire1 = PaireOne.renvoitValeurPairre();
        int Paire2 = PaireTwo.renvoitValeurPairre();
        
        if (Paire1 > Paire2) 
            return "La main 1 gagne avec paire de : "+renvoitNomCarte(Paire1);
        else if (Paire1 < Paire2) 
            return "La main 2 gagne avec paire de : "+renvoitNomCarte(Paire2);
        else 
        {
            int[] tab1 = PaireOne.retourneListeDes3CartesRestantTriee();
            int[] tab2 = PaireTwo.retourneListeDes3CartesRestantTriee();
            int a = 2;
            int reponse = 0;
            while (tab1[a] == tab2[a])
            {
                a = a - 1;
                if (a<0) break;
            }
            if (a<0) return "Egalité";
            else
            {
                if (tab1[a] > tab2[a]) 
                    return "La main 1 gagne avec paire de carte plus élevée : "+renvoitNomCarte(tab1[a]);
                else 
                    return "La main 2 gagne avec paire de carte plus élevée : "+renvoitNomCarte(tab2[a]);
            }
        }
    }
    
    
    String departagerBrelan()
    {
        MainOne.rangerCarteOrdreCroissant();
        MainTwo.rangerCarteOrdreCroissant(); 
        MainBrelan BrelanOne = new MainBrelan(MainOne,"Brelan");
        MainBrelan BrelanTwo = new MainBrelan(MainTwo,"Brelan");
        int val1 = BrelanOne.renvoiValeurBrelan();
        int val2 = BrelanTwo.renvoiValeurBrelan();
        
        if(val1 > val2) 
            return "La main 1 gagne avec brelan de : "+renvoitNomCarte(val1);
        else if (val1 < val2) 
            return "La main 2 gagne avec brelan de : "+renvoitNomCarte(val2);
        else return "Egalité";
    }
    
    String departagerCouleur()
    {
        MainCouleur MainO = new MainCouleur(MainOne,"Couleur");
        MainCouleur MainT = new MainCouleur(MainTwo,"Couleur");
        int a = 4;
        int reponse = 0;
        while (MainO.determinerLaCartePlusHaute(a) == MainT.determinerLaCartePlusHaute(a))
        {
            a = a - 1;
            if (a<0) break;
        }
        if (a<0) return "Egalité";
        else
        {
            if (MainOne.mainJ[a].getValeur() > MainTwo.mainJ[a].getValeur()) 
                return "La main 1 gagne avec la couleur de carte la plus élevée : "+renvoitNomCarte(MainOne.mainJ[a].getValeur());
            else 
                return "La main 2 gagne avec la couleur de carte la plus élevée : "+renvoitNomCarte(MainTwo.mainJ[a].getValeur());
        }
    }
}
