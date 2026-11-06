package test;

import java.util.Scanner;
import entities.*;

public class TestBibliotheque {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Donner la capacite de la bibliotheque : ");
        int n = sc.nextInt();
        sc.nextLine();

        Bibliotheque b = new Bibliotheque(n);

        // Initialisation avec deux documents
        b.ajouter(new Roman("Le Petit Prince", "Antoine de Saint-Exupery", 96, "Aventure"));
        b.ajouter(new Revue("Science et Vie", 5, 2026));

        int choix;

        do {
            System.out.println("\n===== MENU BIBLIOTHEQUE =====");
            System.out.println("1. Ajouter un document");
            System.out.println("2. Afficher les documents");
            System.out.println("3. Supprimer un document");
            System.out.println("4. Rechercher un document");
            System.out.println("5. Afficher les auteurs");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");

            choix = sc.nextInt();
            sc.nextLine();

            switch (choix) {

                case 1:
                    System.out.print("Titre : ");
                    String titre = sc.nextLine();

                    System.out.print("Auteur : ");
                    String auteur = sc.nextLine();

                    System.out.print("Nombre de pages : ");
                    int pages = sc.nextInt();
                    sc.nextLine();

                    Roman r = new Roman(titre, auteur, pages, "General");

                    if (b.ajouter(r))
                        System.out.println("Document ajoute !");
                    else
                        System.out.println("Bibliotheque pleine !");
                    break;

                case 2:
                    b.afficherDocuments();
                    break;

                case 3:
                    System.out.print("Numero d'enregistrement : ");
                    int numSup = sc.nextInt();

                    Document d = b.document(numSup);

                    if (d != null && b.supprimer(d))
                        System.out.println("Document supprime !");
                    else
                        System.out.println("Document introuvable !");
                    break;

                case 4:
                    System.out.print("Numero d'enregistrement : ");
                    int num = sc.nextInt();

                    Document doc = b.document(num);

                    if (doc != null)
                        System.out.println(doc);
                    else
                        System.out.println("Document introuvable !");
                    break;

                case 5:
                    b.afficherAuteurs();
                    break;

                case 0:
                    System.out.println("Au revoir !");
                    break;

                default:
                    System.out.println("Choix invalide !");
            }

        } while (choix != 0);

        sc.close();
    }
}