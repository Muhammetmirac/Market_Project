package marketapp;

import java.util.Scanner;

public class Homepage {

    public static void run(){
        System.out.println("*****Market Uygulamasına Hoşgeldiniz\n Lütfen Seçim Yapınız*********" +
                "\n1- Admin Panel" +
                "\n2- Musteri Paneli" +
                "\n 3- Exit ");

        Scanner scan = new Scanner(System.in);
        String secim;

        do{
            secim = scan.next();
            switch (secim){
                case "1":
                  Utils.adminLogin();
                  break;
                case "2" :
                    MusteriPanel.musteriPaneli();
                   break;
                case "3" :
                    Utils.out();
                    break;
                default:
                    System.out.println("Geçersiz İşlem Yaptınız");
            }
        }while (true);

    }


}
