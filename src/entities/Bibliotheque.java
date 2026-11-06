package entities;

public class Bibliotheque {

    private Document[] documents;
    private int nombreDocuments;

    public Bibliotheque(int capacite) {
        documents = new Document[capacite];
        nombreDocuments = 0;
    }

    public boolean ajouter(Document doc) {
        if (nombreDocuments == documents.length || doc == null) {
            return false;
        }

        documents[nombreDocuments++] = doc;
        return true;
    }

    public boolean supprimer(Document doc) {
        for (int i = 0; i < nombreDocuments; i++) {
            if (documents[i].getNumEnreg() == doc.getNumEnreg()) {
                for (int j = i; j < nombreDocuments - 1; j++) {
                    documents[j] = documents[j + 1];
                }

                documents[--nombreDocuments] = null;
                return true;
            }
        }
        return false;
    }

    public Document document(int numEnrg) {
        for (int i = 0; i < nombreDocuments; i++) {
            if (documents[i].getNumEnreg() == numEnrg) {
                return documents[i];
            }
        }
        return null;
    }

    public void afficherDocuments() {
        for (int i = 0; i < nombreDocuments; i++) {
            System.out.println(documents[i]);
        }
    }

    public void afficherAuteurs() {
        for (int i = 0; i < nombreDocuments; i++) {
            if (documents[i] instanceof Livre) {
                System.out.println(((Livre) documents[i]).getAuteur());
            }
        }
    }
}