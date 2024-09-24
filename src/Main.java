import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, OsobyException {
        Osoba o1 = new Osoba("Danio", "Peabin", 22, 12, 2008);
        FileOutputStream fos = new FileOutputStream("C:\\Users\\9601323u\\Desktop\\osoby.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(o1);
        FileInputStream fis = new FileInputStream("C:\\Users\\9601323u\\Desktop\\osoby.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        try {
            System.out.println(ois.readObject());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}