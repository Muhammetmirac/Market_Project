package marketapp;

import jdk.jshell.execution.Util;

import java.util.Scanner;

public class MusteriPage {
    public static void customerPage(){
        while (true){
            System.out.println("*".repeat(40) + "\n Musteri Anasayfasina Hosgeldiniz \n1-Urunleri Goster\n2-Alisveris Yap\n3-Sepete Git\n4-Odeme Yap\n5-Anasayfa\n0-Cikis");
            Scanner input = new Scanner(System.in);
            String choice = input.next();
            switch (choice){
                case "1":
                    Database.urunGoster();
                    break;
                case "2":
                    Shooping.alisVeris();
                    break;
                case "3":
                    Shooping.sepet();
                    break;
                case "4":
                    //odeme
                    break;
                case "5":
                    Homepage.run();
                    break;
                case "0":
                    Utils.out();
                    break;
                default:
                    System.out.println("Gecersiz Islem");
                    customerPage();
            }
        }
    }

}