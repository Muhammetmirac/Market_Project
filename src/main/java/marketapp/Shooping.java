package marketapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shooping {
public static List<String > urunler = new ArrayList<>();

public static double toplam;
public static Scanner input = new Scanner(System.in);

public static void alisVeris() {
    System.out.println(" Satın almak istediğiniz ürün ismini giriniz \n Çıkış için 0 seçin");
    while (true) {
        System.out.print("Ürün ismi :");
        String urunIsmi = input.next();
        if (urunIsmi.equals("0")){
            System.out.println("Satın Aldığınız Ürünler : " + urunler);
            System.out.println("Toplam Borcunuz :"+ toplam+ "$");
        }
        urunler.add(urunIsmi);
        toplam += Database.fiyat(urunIsmi);
        System.out.println("Toplam Borç : "+ toplam);

    }
}

public static void sepet(){
    System.out.println("Sepetinizdeki Ürünler : "+ urunler);
    System.out.println("Toplam Borcunuz :"+ toplam+ " $");

}

public static void odemeYap(){
    System.out.println("Ödeme Sayfasına Hoşgeldiniz");
    System.out.println("Borcunuz : "+toplam+ "$");
    double odeme = input.nextDouble();
     toplam-=odeme;
    System.out.println("Kalan Borc : "+toplam );
}






}
