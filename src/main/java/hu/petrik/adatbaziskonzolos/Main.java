package hu.petrik.adatbaziskonzolos;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static MajomDB db;
    public static void main(String[] args) {
        try{
            db = new MajomDB();
            majmokListazasa();
            majomHozzaad();
            majmokListazasa();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    private static void majmokListazasa() throws SQLException {
        List<Majom> majmok = db.majmokListazasa();
        majmok.forEach(System.out::println);
    }

    private static void majomHozzaad() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Adja meg a majom fajtáját");
        String fajta = sc.nextLine();
        System.out.printf("Adja meg a majom iq szintjét");
        int max_iq = Integer.parseInt(sc.nextLine());
        System.out.printf("Szereti a banánt?");
        boolean szereti_banant = sc.nextLine().toLowerCase().contains("i");
        Majom majom = new Majom(fajta,max_iq,szereti_banant);
        db.majomHozzaAdas(majom);
    }
}
