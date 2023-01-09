package marketapp;


import java.sql.*;
import java.util.Scanner;
import java.util.stream.Stream;

public class Database {
    public static Connection con;
    public static Statement statement;
    public static Scanner input = new Scanner(System.in);


    public static void getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/MarketApp", "postgres", "435186");
        } catch (Exception e) {
            System.out.println("Bağlantı Hatası");
        }

    }

    public static void getStatement() {
        try {
            statement = con.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeAll() {
        try {
            con.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean checkUsernamePassword(String username, String password) {
        getConnection();
        getStatement();

        boolean result = false;
        String query = "select * from admins";
        try {
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String user = resultSet.getString(1);
                String pass = resultSet.getString(2);

                if (user.equals(username) && pass.equals(password)) {
                    result = true;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        closeAll();
        return result;
    }


    public static void urunGoster() {
        getConnection();
        getStatement();
        String query = "select * from products";
        try {
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println("ID \t\t Name \t\t Category \t\t Price \t\t Stock");
            while ((resultSet.next())) {

                System.out.println(resultSet.getInt(1) + "\t\t" + resultSet.getString(2) + "\t\t"
                        + resultSet.getString(3) + "\t\t" + resultSet.getString(4) + "\t\t" + resultSet.getString(5));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        closeAll();
    }

    public static void urunEkle() {
        getConnection();
        getStatement();
        System.out.print("Urun Ismi: ");
        String urunIsmi = input.next();
        System.out.print("Kategori: ");
        String kategori = input.next();
        System.out.print("Fiyat: ");
        double fiyat = input.nextDouble();
        System.out.print("Stok: ");
        int stok = input.nextInt();

        String query = "Insert into products Values (default, '" + urunIsmi + "', '" + kategori + "', " + fiyat + ", " + stok + ")";
        try {
            statement.execute(query);
        } catch (SQLException e) {
            System.out.println("Ekelenemedi");
            AdminPanel.adminPanel();
        }
        Utils.eklemeSecenleri();
        closeAll();
    }


    public static void urunSil() {
        getConnection();
        getStatement();
        System.out.println("Silmek istediğiniz ürün ismini giriniz");
        String silinecekUrun = input.next();
        String query = " Delete from products where product_name = '" + silinecekUrun + "'";
        try {
            statement.execute(query);
        } catch (SQLException e) {
            System.out.println(" hata alındı");
            AdminPanel.adminPanel();

        }
        Utils.silmeSecenekleri();


        closeAll();
    }


    public static void fiyatGuncelle() {
        getConnection();
        getStatement();
        System.out.println("Fiyatı Güncellenecek Ürünün İsmini Giriniz");
        String guncellenecekUrun = input.next();

        System.out.println("Yeni fiyatı girin");
        double yeniFiyat = input.nextDouble();
        String query = "update products set price =" + yeniFiyat + "where product_name = '" + guncellenecekUrun + "' ";
        try {
            statement.execute(query);
        } catch (SQLException e) {
            System.out.println("Hata");
            AdminPanel.adminPanel();
        }
        Utils.guncelle();

        closeAll();
    }


    public static void stokGuncelle() {
        getConnection();
        getStatement();
        System.out.println("Stok Bilgisi Güncellenecek Ürünün İsmini Giriniz");
        String guncellenecekStok = input.next();
        System.out.println("Yeni stok miktarını girin");
        int yeniStok = input.nextInt();

        String query = "update products set stock =" + yeniStok + "where product_name = '" + guncellenecekStok + "' ";
        try {
            statement.execute(query);
        } catch (SQLException e) {
            System.out.println("Hata");
            AdminPanel.adminPanel();
        }
        Utils.guncelle();


        closeAll();
    }


    public static boolean customerLogin(String username, String password) {
        getConnection();
        getStatement();
        boolean result = false;
        String query = "Select * From customers";
        try {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String user = resultSet.getString("username");
                String pass = resultSet.getString("password");
                if (user.equals(username) && pass.equals(password)) {
                    result = true;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        closeAll();
        return result;
    }


    public static void addCustomer() {
        System.out.print(" Ad : ");
        String isim = input.next();
        System.out.print(" Soyad : ");
        String soyIsim = input.next();
        System.out.print("Mail Adresi : ");
        String mail = input.next();
        System.out.print(" Kullanıcı Adı : ");
        String username = input.next();
        System.out.print(" Şifre : ");
        String password = input.next();

        getConnection();
        getStatement();
        String query = "insert into customers values (default, '" + isim + "','" + soyIsim + "','" + mail + "','+" + username + "','" + password + "' )";
        try {
            statement.execute(query);
        } catch (SQLException e) {
            System.out.println("Geçersiz işlem");
            addCustomer();
        }
        System.out.println("Bilgileriniz başarılı bir şekilde kaydedildi\n Giriş yapabilirsiniz");
        Utils.musteriGirisi();

        closeAll();
    }


    public static double fiyat(String urunIsmi) {
        getConnection();
        getStatement();
        double price = 0;
        String query="select price from products where product_name ='"+urunIsmi+"'";
        try {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                price = resultSet.getDouble(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        closeAll();
        return price;
    }


}
