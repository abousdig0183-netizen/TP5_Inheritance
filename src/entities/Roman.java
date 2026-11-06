package entities;

public class Roman extends Livre {

    private String genre;

    public Roman(String titre, String auteur, int nbrPages, String genre) {
        super(titre, auteur, nbrPages);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return super.toString() + ", genre=" + genre;
    }
}