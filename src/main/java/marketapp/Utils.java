package marketapp;

import java.util.Scanner;

public class Utils {
    public static Scanner input = new Scanner(System.in);

    public static void out(){
        System.exit(1);
    }
    public static void adminLogin(){
        int counter = 3;
        do {


        System.out.println("********* Admin Paneline Erişmek İçin Giriş Yapmanız Gerekiyor *********");
        System.out.print("Kullanıcı Adınızı Giriniz : ");
        String username = input.nextLine();
        System.out.print("Şifrenizi Giriniz : ");
        String password = input.nextLine();
        boolean result =Database.checkUsernamePassword(username,password);
        if (result){
            System.out.println("Bilgiler Doğru");
            AdminPanel.adminPanel();
        }else{
           counter--;
            System.out.println("Hatalı giriş yaptınız "+counter+ " hakkınız kaldı");
        }
        if (counter==0){
            System.out.println("Anasayfaya yönlendiriliyorsunuz");
            Homepage.run();
        }
    }while (true);
    }

    public static void eklemeSecenleri(){
        System.out.println("Urun Basarili Bir Sekilde Eklendi");
        System.out.println("Yeni Urun Eklemek Icin 1, Admin Paneli Icin 2, Anasayfa 3, Cikis 0");
        String secim = input.next();
        while (true){
            switch (secim){
                case "1":
                    Database.urunEkle();
                    break;
                case "2":
                    AdminPanel.adminPanel();
                    break;
                case "3":
                    Homepage.run();
                    break;
                case "4":
                    out();
                    break;
                default:
                    System.out.println("Gecersiz Islem Yaptiniz ");
                    eklemeSecenleri();
            }
        }}



    public static void silmeSecenekleri(){
        System.out.println("Urun Basarili Bir Sekilde Silindi");
        System.out.println("Yeni Urun Silmek Icin 1, Admin Paneli Icin 2, Anasayfa 3, Cikis 0");
        String secim = input.next();
        while (true){
            switch (secim){
                case "1":
                    Database.urunSil();
                    break;
                case "2":
                    AdminPanel.adminPanel();
                    break;
                case "3":
                    Homepage.run();
                    break;
                case "4":
                    out();
                    break;
                default:
                    System.out.println("Gecersiz Islem Yaptiniz ");
                    silmeSecenekleri();
            }
        }}

    public static void guncelle(){
        System.out.println("Urun Basarili Bir Sekilde Güncellendi");
        System.out.println(" Fiyat  Güncellemek Icin 1, Stok Guncellemek için 2, Admin Paneli Icin 3, Anasayfa 4, Cikis 0");
        String secim = input.next();
        while (true){
            switch (secim){
                case "1":
                    Database.fiyatGuncelle();
                    break;
                    case "2":
                    Database.stokGuncelle();
                    break;
                case "3":
                    AdminPanel.adminPanel();
                    break;
                case "4":
                    Homepage.run();
                    break;
                case "0":
                    out();
                    break;
                default:
                    System.out.println("Gecersiz Islem Yaptiniz ");
                    guncelle();
            }
        }}


    public static void musteriGirisi(){
        System.out.print("Kullanici Adi: ");
        String username = input.next();
        System.out.println("Sifre: ");
        String password = input.next();
        boolean result = Database.customerLogin(username, password);
        if (result){
            System.out.println("Basarili Giris");
            MusteriPage.customerPage();
        }else{
            System.out.println("Sifre veya Kullanici Adi Hatali");
            MusteriPanel.musteriPaneli();
        }
    }







}
