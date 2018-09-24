/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ps5_poker;

import com.sun.org.apache.xalan.internal.xsltc.runtime.BasisLibrary;
import java.util.Scanner;

/**
 *
 * @author thevie
 */
public class PS5_Poker {
    
    int cartes[][] = new int[4][13];
    Scanner scanner = new Scanner(System.in);

    public PS5_Poker() {
        for(int i=0; i<4; i++){
            for(int j=0; j<13; j++){
                cartes[i][j]=-1;
            }
        }
    }
    
    public void distribution(int nbJoueurs, int nbCartes){
        //boolean trouve=false;
        int nbDist=0;
        for(int j=0; j<nbCartes; j++){
            System.out.println("---Carte "+(j+1)+"---\n");
            for(int i=0; i<nbJoueurs;i++){
                boolean trouve=false;
                System.out.println("Joueur "+(i+1)+" - Choix du type de carte:\n");
                do{    
                    System.out.println("Tapez:\n");
                    System.out.println("0- Pour Trèfle(Tr)\n");
                    System.out.println("1- Pour Carreau(Ca)\n");
                    System.out.println("2- Pour Coeur(Co)\n");
                    System.out.println("3- Pour Pique(Pi)\n");
                    int typeCarte;
                    typeCarte = scanner.nextInt();scanner.nextLine();
                    System.out.println("Choix de la valeur de la carte:\nTapez:");
                    System.out.println("0- Pour As\n");
                    System.out.println("1- Pour 2\n");
                    System.out.println("2- Pour 3\n");
                    System.out.println("3- Pour 4\n");
                    System.out.println("4- Pour 5\n");
                    System.out.println("5- Pour 6\n");
                    System.out.println("6- Pour 7\n");
                    System.out.println("7- Pour 8\n");
                    System.out.println("8- Pour 9\n");
                    System.out.println("9- Pour 10\n");
                    System.out.println("10- Pour Vallet\n");
                    System.out.println("11- Pour Dame\n");
                    System.out.println("12- Pour Roi\n");
                    int valeurCarte;
                    valeurCarte = scanner.nextInt();scanner.nextLine();

                    if(cartes[typeCarte][valeurCarte]==-1){
                        cartes[typeCarte][valeurCarte] = i;
                        //nbDist++;
                        trouve = true;
                    }
                    else{
                        //trouve = true;
                        System.out.println("Cette carte est déjà prise! veuillez en choisir une autre.");
                    }

            
                }while(trouve==false);
            
            }
        }
            
    }
    
    public String convertStringTypeCarte(String typeCarte){
        String res="";
        switch(typeCarte){
            case "0": 
                res="Tr";
                break;
            case "1": 
                res="Ca";
                break;
            case "2": 
                res="Co";
                break;
            case "3": 
                res="Pi";
                break;
        }
        return res;
    }
    
    public String convertStringValeurCarte(String valeurCarte){
        String res="";
        switch(valeurCarte){
            case "0": 
                res="As";
                break;
            case "1": 
                res="2";
                break;
            case "2": 
                res="3";
                break;
            case "3": 
                res="4";
                break;
            case "4": 
                res="5";
                break;
            case "5": 
                res="6";
                break;
            case "6": 
                res="7";
                break;
            case "7": 
                res="8";
                break;    
            case "8": 
                res="9";
                break;
            case "9": 
                res="10";
                break;
            case "10": 
                res="V";
                break;
            case "11": 
                res="D";
                break;
            case "12": 
                res="R";
                break;
            /*default:
                res=valeurCarte;
                break;*/
        }
        return res;
    }
    
    public void presentationCartes(int numMain,String... mainJoueur){
        System.out.print("Main "+numMain+":  ");
        for(int i=0;i<mainJoueur.length;i++){
            String typeCarte = mainJoueur[i].substring(0,1);
            typeCarte = convertStringTypeCarte(typeCarte);
            String valeurCarte = mainJoueur[i].substring(1);
            valeurCarte = convertStringValeurCarte(valeurCarte);
            System.out.print(valeurCarte+typeCarte+" ");
        }
        System.out.println("");
    }
    
    public void comparaison(int nbJoueurs, int nbCartes){
        int joueur1=-1,joueur2=-1,joueur3=-1,joueur4=-1;
        String joueur1Cartes[]=new String[nbCartes],joueur2Cartes[]=new String[nbCartes],joueur3Cartes[]=new String[nbCartes],joueur4Cartes[]=new String[nbCartes];
        int j1=0,j2=0,j3=0,j4=0;
        if(nbJoueurs==2){
            joueur1=0;
            joueur2=1;
        }
        if(nbJoueurs==3){
            joueur1=0;
            joueur2=1;
            joueur3=2;
        }
        if(nbJoueurs==4){
            joueur1=0;
            joueur2=1;
            joueur3=2;
            joueur4=3;
        }
        //on récupère les valeurs des cartes de chaque joueur dans leurs tableaux respectifs
        for(int i=0; i<4; i++){
            for(int j=0; j<13; j++){
                if(cartes[i][j]!=-1){
                    if(cartes[i][j]==joueur1){
                        joueur1Cartes[j1]=""+i+j;
                        j1++;
                    }
                    if(cartes[i][j]==joueur2){
                        joueur2Cartes[j2]=""+i+j;
                        j2++;
                    }
                    if(cartes[i][j]==joueur3){
                        joueur3Cartes[j3]=""+i+j;
                        j3++;
                    }
                    if(cartes[i][j]==joueur4){
                        joueur4Cartes[j4]=""+i+j;
                        j4++;
                    }
                }
            }
        }
        //on affiche selon l'exemple les cartes de chaque joueur
        presentationCartes(1,joueur1Cartes);
        presentationCartes(2,joueur2Cartes);
        if(nbJoueurs==3) presentationCartes(3,joueur3Cartes);
        if(nbJoueurs==4) presentationCartes(4,joueur4Cartes);
        //on compare les cartes
        if(nbCartes==1){
            if(nbJoueurs==2){
                int valJoueur1 = BasisLibrary.stringToInt(joueur1Cartes[0].substring(1));
                int valJoueur2 = BasisLibrary.stringToInt(joueur2Cartes[0].substring(1));
                
                if(valJoueur1>valJoueur2) System.out.println("La main 1 gagne avec la carte la plus élevée : "+convertStringValeurCarte(joueur1Cartes[0].substring(1)));
                if(valJoueur1<valJoueur2) System.out.println("La main 2 gagne avec la carte la plus élevée : "+convertStringValeurCarte(joueur2Cartes[0].substring(1)));
                if(valJoueur1==valJoueur2) System.out.println("Egalite");
            }
        }
        
    }
    
    public void jeu(int nbJoueurs, int nbCartes){
        
        switch(nbJoueurs){
            case 2:
                switch(nbCartes){
                    case 1:
                        distribution(2,1);
                        comparaison(2,1);
                        break;
                    case 2:
                        distribution(2,2);
                        break;
                    case 3:
                        distribution(2,3);
                        break;
                    case 4:
                        distribution(2,4);
                        break;
                    case 5:
                        distribution(2,5);
                        break;
                }
                break;
            case 3:break;
            case 4:break;
            default: System.out.println("Réponse non valide!");
        }
        
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String rep="";
        
        System.out.println("*****Kata - La main de Poker*****\n");
        System.out.println("Bienvenue!!!\n");
        do{
            PS5_Poker kata = new PS5_Poker();
            Scanner scanner = new Scanner(System.in);
            int /*nbJoueurs,*/ nbCartes;
            
            //System.out.println("Veuillez saisir le nombre de joueurs(min: 2/max: 4): ");
        
            //nbJoueurs = scanner.nextInt();

            //scanner.nextLine();

            //System.out.println("Veuillez saisir le nombre de cartes de chaque joueur:(max 5): ");
            //System.out.println("Saisissez vos cartes:(max 5): ");
            //nbCartes = scanner.nextInt();

            //scanner.nextLine();

            kata.jeu(2,1);
            
            //scanner.nextLine();

            System.out.println("Voulez vous rejouer?(o/n)");
            rep = scanner.nextLine();
            if(rep.equals("n")) System.out.println("ok! Merci, au revoir.");
        }while(rep.equals("o"));
        
        
    }
    
}
