import java.io.*;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Main2 {
    public static boolean dopisOsoby(Osoba o1) {
        try {
            FileOutputStream fos = new FileOutputStream("C:\\Users\\9601323u\\Desktop\\osoby.dat", true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(o1);
            oos.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }
    public static void wypiszOsoby() throws IOException, ClassNotFoundException {
            FileInputStream fis = new FileInputStream("C:\\Users\\9601323u\\Desktop\\osoby.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (fis.available() > 0) {
                Osoba o2 = (Osoba)ois.readObject();
                System.out.println(o2);
                fis.skip(4);
            }
    }
    public static void wypiszPoNazwisku(String nazwisko) throws IOException, ClassNotFoundException {
            String msg = "Nie znaleziono osoby";
            FileInputStream fis = new FileInputStream("C:\\Users\\9601323u\\Desktop\\osoby.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (fis.available() > 0) {
                Osoba o2 = (Osoba) ois.readObject();
                if (Objects.equals(o2.getNazwisko(), nazwisko)) {
                    System.out.println(o2);
                    msg = "";
                }
                fis.skip(4);
            }
        System.out.println(msg);
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int wybor = -1;
        Scanner scan = new Scanner(System.in);
        while (wybor != 4) {
            System.out.println("\n\nMenu");
            System.out.println("1. Dopisanie osoby");
            System.out.println("2.Przeglądanie");
            System.out.println("3.Wyszukanie według nazwiska");
            System.out.println("4.Koniec");
            System.out.println("Wybierz opcje (1-4)");
            wybor = scan.nextInt();
            String thrash = scan.nextLine();
            switch (wybor) {
                case 1:
                    try {
                        System.out.println("Podaj imię");
                        String imie = scan.nextLine();
                        System.out.println("Podaj nazwisko");
                        String nazwisko = scan.nextLine();
                        System.out.println("Podaj dzien urodzenia");
                        int dzienUrodzenia = scan.nextInt();
                        System.out.println("Podaj miesiac urodzenia");
                        int miesiacUrodzenia = scan.nextInt();
                        System.out.println("Podaj rok urodzenia");
                        int rokUrodzenia = scan.nextInt();

                        dopisOsoby(new Osoba(imie, nazwisko, dzienUrodzenia, miesiacUrodzenia, rokUrodzenia));
                        } catch (InputMismatchException e) {
                            System.out.println("Zły format danych");
                            scan.nextLine();
                        } catch (OsobyException e) {
                            System.out.println("Dane są niepoprawne");
                        }
                            break;
                case 2: wypiszOsoby();
                            break;
                case 3:
                    System.out.println("Podaj nazwisko");
                    String nazwisko2 = scan.nextLine();
                    wypiszPoNazwisku(nazwisko2);
                            break;
                case 4:  return;
            }
        }
    }
}
