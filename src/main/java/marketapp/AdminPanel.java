package marketapp;

import java.util.Scanner;

public class AdminPanel {
   public static Scanner input = new Scanner(System.in);
    public static void adminPanel() {

        System.out.println("******** Giriş Başarılı Admin Paneline Hoşgeldiniz *******");
        while (true) {
            System.out.println("Lütfen Yapmak İstediğiniz İşlemi Seçiniz \n 1- Ürün Tablosu\n" +
                    " 2- Ürün Ekle\n 3- Ürün Sil\n 4-Fiyat Guncelle\n 5- Stock Guncelle\n 6- Anasayfaya Don\n 0- Cikis Yap ");
            String secim = input.next();
            switch (secim) {
                case "1":
                    Database.urunGoster();
                    break;
                case "2":
                    Database.urunEkle();
                    break;
                case "3":
                    Database.urunSil();
                    break;
                case "4":
                    Database.fiyatGuncelle();
                    break;
                case "5":
                    Database.stokGuncelle();
                    break;
                case "6":
                    Homepage.run();
                    break;
                case "0":
                    System.out.println("Cikis Yapiliyor");
                    Utils.out();
                default:
                    adminPanel();
            }


        }

    }
}
