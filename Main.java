import java.util.Scanner;
import java.util.Locale;


public class Main {

    static  int INDEX=20;
    static String[][] books=new String[INDEX][4];
    static String[][] patrons=new String[INDEX][4];
    static String[][] transactions=new String[INDEX][3];
    static int bookQuantity=0;
    static int patronQuantity=0;


    public static void addBook(String title,String author,String bookPage,String ISBN){
        if (bookQuantity<books.length){
            books[bookQuantity][0]=title;
            books[bookQuantity][1]=author;
            books[bookQuantity][2]=bookPage;
            books[bookQuantity][3]=ISBN;

            bookQuantity++;
        }
        else {
            String[][] newBooks=new String[books.length+1][4];
            for (int i=0; i<books.length; i++){
                for (int j=0; j<4; j++){
                    newBooks[i][j]=books[i][j];
                }
            }
            newBooks[bookQuantity][0]=title;
            newBooks[bookQuantity][1]=author;
            newBooks[bookQuantity][2]=bookPage;
            newBooks[bookQuantity][3]=ISBN;

            bookQuantity++;
            books=newBooks;
        }
    }

    public static void checkOutBook(){

    }


    public static void returnBook(String isbn){


    }
    public static void deleteBook(String ISBN){
        int findIndex=-1;
        for (int i=0; i<bookQuantity; i++) {
            if (books[i][3].equals(ISBN)) {
                findIndex = i;
                break;
            }
        }
                if (findIndex!=-1){
                    for (int i=findIndex; i<bookQuantity-1; i++){
                        books[i]=books[i+1];
                    }
                    //books[books.length-1]=null;
                    bookQuantity--;
                    System.out.println("Kitap Silinmiştir.");
            }
            else {
                System.out.println("Kitap bulunmamaktadır.");

            }
        }
   /* public static void deleteBook(String ISBN){
        int findIndex=-1;
        for (int i=0; i<bookQuantity; i++) {
            if (books[i][3].equals(ISBN)) {
                findIndex = i;
                break;
            }
        }
        if (findIndex!=-1){
            String[][] newBooks=new String[bookQuantity-1][4];
            for (int i=0; i<findIndex; i++){
                newBooks[i]=books[i];
            }
            for (int i=findIndex; i<bookQuantity-1; i++){
                newBooks[i]=books[i];
            }
           // books[bookQuantity-1]=null;
            bookQuantity--;
            books=newBooks;
            System.out.println("Kitap Silinmiştir.");
        }
        else {
            System.out.println("Kitap bulunmamaktadır.");

        }
    }*/




    public static void generateReports() {

        System.out.printf("%-20s %-20s %-20s %-20s%n", "Kitap İsmi", "Yazar İsmi","Kitap Sayfası", "ISBN");
        for (int i = 0; i < bookQuantity; i++) {
            System.out.printf("%-20s %-20s %-20s %-20s%n",books[i][0],books[i][1],books[i][2],books[i][3]);
        }
        System.out.println();
        int totalBooks = 0;
        for (int i = 0; i < bookQuantity; i++) {
            totalBooks++;
        }
        System.out.println("Toplam kitap sayısı : " + totalBooks);
    }




    public static void viewAvailableBooks() {
        System.out.printf("%-20s %-20s %-20s %-20s%n", "Kitap İsmi", "Yazar İsmi","Kitap Sayfası", "ISBN");

        for (int i = 0; i < bookQuantity; i++) {
            System.out.printf("%-20s %-20s %-20s %-20s%n",books[i][0],books[i][1],books[i][2],books[i][3]);
            }

        }

    public static void searchBooks(String keyWord){
        boolean bookFind=false;
        for (int i=0; i<bookQuantity; i++){
            if (books[i][0].equals(keyWord) || books[i][1].equals(keyWord) ||books[i][3].equals(keyWord)){
                System.out.println("Başlık: " + books[i][0] +
                        ", Yazar: " + books[i][1] +
                        ", Sayfa Sayısı: " + books[i][2] +
                        ", ISBN: " + books[i][3]);
                        bookFind=true;
            }
            if (!bookFind){
                System.out.println("Kitap bulunmamaktadır.");
            }

        }

    }




    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String islemler="1. Kitap Ekle\n"+
                "2. Kitap Alma\n"+
                "3. Kitap İade Et\n"+
                "4. Mevcut Kitapları Görüntüle\n"+
                "5. Kitap Ara\n"+
                "6. Kitap Sil\n"+
                "7. Rapor Oluştur\n"+
                "0. Çıkış\n";

        while (true){

            System.out.println(islemler);
            System.out.print("Lütfen bir seçenek girin: ");
            int secim=scanner.nextInt();
            scanner.nextLine();


            switch (secim){
                case 1:
<<<<<<< HEAD
                    System.out.println();
                    System.out.println("Kitap başlığını giriniz.");
                    String baslik=scanner.nextLine();
                    System.out.println("Yazar ismini giriniz.");
                    String yazar=scanner.nextLine();
                    System.out.println("Kitap sayfa sayısını giriniz.");
                    String sayfaSayisi=scanner.nextLine();
                    System.out.println("ISBN kodunu giriniz.");
                    String isbn= scanner.nextLine();
                    addBook(baslik,yazar,sayfaSayisi,isbn);
                    System.out.println();
=======
                   
>>>>>>> 9b3d737ea2a999950a9de3de06b42417617d92e9
                    break;
                case 2:
                   
                    break;
                case 3:
<<<<<<< HEAD
                    System.out.println();
                    System.out.println("İade istedipiniz kitabın ISBN kodunu giriniz.");
                    String isbn3=scanner.nextLine();
                    System.out.println("Kullanıcı ismini giriniz.");
                    String patron1=scanner.nextLine();
                    System.out.println("İade kitap sayısı.");
                    int iadeKitap=scanner.nextInt();
                    //returnBook();
                    System.out.println();
=======
                    
>>>>>>> 9b3d737ea2a999950a9de3de06b42417617d92e9
                    break;
                case 4:
                    
                    break;
                case 5:
<<<<<<< HEAD
                    System.out.println();
                    System.out.println("Aramak istediğiniz kitabın ISBN,Yazar veya Başlığını yazaınız.");
                    String key= scanner.nextLine();
                    System.out.println("Kitap aranıyor...");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    searchBooks(key);
                    System.out.println();
                    break;
                case 6:
                    System.out.println("Lütfen silmek istediğiniz kitabın ISBN kodunu giriniz.");
                    String isbn4=scanner.nextLine();
                    deleteBook(isbn4);
                    break;
                case 7:
                    System.out.println();
                    generateReports();
                    System.out.println();
=======
                    
                    break;
                case 6:
                    
>>>>>>> 9b3d737ea2a999950a9de3de06b42417617d92e9
                    break;
                case 0:
                   
                    break;
                default:
                   
                    break;
            }
        }

    }
}

