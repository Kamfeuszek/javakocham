import java.io.Serializable;

public class Osoba implements Serializable {
    private String imie;
    private String nazwisko;
    private int dzienUrodzenia;
    private int miesiacUrodzenia;
    private int rokUrodzenia;

    public Osoba(String imie, String nazwisko, int dzienUrodzenia, int miesiacUrodzenia, int rokUrodzenia) throws OsobyException {
        int dniWLutym = 28;
        if((rokUrodzenia % 4 == 0 && rokUrodzenia % 100 == 1) || rokUrodzenia % 400 == 0) {
             dniWLutym = 29;
        }
        if(dzienUrodzenia <= 0  || (miesiacUrodzenia == 2 && dzienUrodzenia > dniWLutym) || (miesiacUrodzenia == 4 || miesiacUrodzenia == 6 || miesiacUrodzenia == 9 || miesiacUrodzenia == 11 && dzienUrodzenia > 30) || dzienUrodzenia > 31) {
            throw new OsobyException("Niepoprawna liczba dni");
        }
        if(miesiacUrodzenia <= 0 || miesiacUrodzenia > 12) {
            throw new OsobyException("Niepoprawna miesiąc");
        }
        if(rokUrodzenia < 1900 || rokUrodzenia > 2100 ) {
            throw new OsobyException("Niepoprawny rok");
        }
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dzienUrodzenia = dzienUrodzenia;
        this.miesiacUrodzenia = miesiacUrodzenia;
        this.rokUrodzenia = rokUrodzenia;
    }

    @Override
    public String toString() {
        return "Osoba(" + "Imie='" + imie + "\n" + "Nazwisko='" + nazwisko + "\n" + "DzienUrodzenia=" + dzienUrodzenia + "\n" + "MiesiacUrodzenia=" + miesiacUrodzenia + "\n" + "RokUrodzenia=" + rokUrodzenia + ')';
    }

    public String getNazwisko() {
        return nazwisko;
    }
}
