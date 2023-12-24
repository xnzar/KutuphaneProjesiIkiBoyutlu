import java.util.Scanner;
import java.util.Locale;


public class Main {

    static final int IMDEX=20;
    static String[][] books=new String[IMDEX][4];
    static String[][] patrons=new String[IMDEX][4];
    static String[][] transactions=new String[IMDEX][3];
    public static int bookQuantity=0;



    /*public static void addBook(String title,String author,String ISBN){
        if (bookQuantity<IMDEX){
            books[bookQuantity][0]=title;
            books[bookQuantity][1]=author;
            books[bookQuantity][2]=ISBN;
            bookQuantity++;
        }
        else {
            System.out.println("The library capacity is full, new books cannot be added.");
        }


    }*/
    public static void addBook(String[] bookInfo){
        if (bookInfo.length == 4 && bookQuantity<IMDEX){
            books[bookQuantity]=new String[]{bookInfo[0],bookInfo[1],bookInfo[2],bookInfo[3]};
            bookQuantity++;
        }
        else {
            System.out.println("The library capacity is full, new books cannot be added.");
        }


    }






    public static void checkOutBook(){

    }





    public static void returnBook(){

    }



    public static void generateReports(){

    }





    public static void viewAvailableBooks(){

    }






    public static void searchBooks(String aranacakKitap){

    }




    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String islemler="1. Kitap Ekle\n"+
                "2. Kitap Alma\n"+
                "3. Kitap İade Et\n"+
                "4. Mevcut Kitapları Görüntüle\n"+
                "5. Kitap Ara\n"+
                "6. Rapor Oluştur\n"+
                "0. Çıkış\n";

        while (true){

            System.out.println(islemler);
            System.out.print("Lütfen bir seçenek girin: ");
            int secim=scanner.nextInt();
            scanner.nextLine();


            switch (secim){
                case 1:
                    System.out.println();
                    System.out.println("Kitap başlığını giriniz.");
                    String baslik=scanner.nextLine();
                    System.out.println("Yazar ismini giriniz.");
                    String yazar=scanner.nextLine();
                    System.out.println("ISBN kodunu giriniz.");
                    String isbn= scanner.nextLine();
                    System.out.println("Kitap miktarını giriniz.");
                    int miktar=scanner.nextInt();
                    scanner.nextLine();
                    //addBook(baslik,yazar,isbn,miktar);
                    System.out.println();
                    break;
                case 2:
                    System.out.println();
                    System.out.println("Almak istedipiniz kitabın ISBN kodunu giriniz.");
                    String isbn2=scanner.nextLine();
                    System.out.println("Kullanıcı ismini giriniz.");
                    String patron=scanner.nextLine();
                    System.out.println("Alınıcak kitap sayısı.");
                    int alinanKitap=scanner.nextInt();
                    checkOutBook();
                    System.out.println();
                    break;
                case 3:
                    System.out.println();
                    System.out.println("İade istedipiniz kitabın ISBN kodunu giriniz.");
                    String isbn3=scanner.nextLine();
                    System.out.println("Kullanıcı ismini giriniz.");
                    String patron1=scanner.nextLine();
                    System.out.println("İade kitap sayısı.");
                    int iadeKitap=scanner.nextInt();
                    returnBook();
                    System.out.println();
                    break;
                case 4:
                    System.out.println();
                    viewAvailableBooks();
                    System.out.println();
                    break;
                case 5:
                    System.out.println();
                    System.out.println("Aramak istediğiniz kitabın ISBN,Yazar veya Başlığını yazaınız.");
                    String isbn1= scanner.nextLine();
                    System.out.println("Kitap aranıyor...");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    searchBooks(isbn1);
                    System.out.println();
                    break;
                case 6:
                    System.out.println();
                    generateReports();
                    System.out.println();
                    break;
                case 0:
                    System.out.println();
                    System.out.println("Çıkış yapılıyor...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Geçersiz işlem...");
                    break;
            }
        }

    }
}

