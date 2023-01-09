package marketapp;

import java.util.Scanner;

public class MusteriPanel {
public  static Scanner input = new Scanner(System.in);
    public static void musteriPaneli(){
        System.out.println("Müşteri Paneline Hoşgeldiniz");
        while (true){
            System.out.println("1- Giriş Yap\n" +
                    "2- Kayıt Ol\n" +
                    "3- Anasaydaya Dön\n" +
                    "4- Çıkış ");
            String secim = input.next();
            switch (secim){
                case "1":
                    Utils.musteriGirisi();
                    break;
                case "2":
                    Database.addCustomer();
                    break;
                case "3":
                    //giris
                    break;
                case "4":
                    //giris
                    break;
                default:
                    System.out.println("Hatalı giriş");
                    musteriPaneli();
            }
        }



    }
}
