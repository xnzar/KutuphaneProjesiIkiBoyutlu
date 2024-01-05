import java.util.Date;
import java.util.InputMismatchException;
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

    public static boolean bookAvaible(String ISBN){
        for (int i=0; i<bookQuantity; i++){
            if (books[i][3].equals(ISBN)){
                return true;
            }
        }
        return false;
    }
    public static void generateBookRecommendations(String patronName) {
        String patronISBN = null;
        for (int i = 0; i < patronQuantity; i++) {
            if (patrons[i][0].equals(patronName) && patrons[i][2]!=null) {
                patronISBN = patrons[i][2];
                break;
            }
        }
        String bookAuthor=null;
        for (int i=0; i<bookQuantity; i++){
            if (books[i][3].equals(patronISBN)){
                bookAuthor=books[i][1];
            }
        }
        if (patronISBN == null) {
            System.out.println("Daha önce hiç kitab alınmamiştır.");
            return;
        }
            System.out.println("Daha önce aldığınız kitaplara göre önerilen kitaplar : ");
            for (int j = 0; j < bookQuantity; j++) {
                if (books[j][1].equals(bookAuthor)) {
                    System.out.println("Başlık: " + books[j][0] +
                            ", Yazar: " + books[j][1] +
                            ", Sayfa Sayısı: " + books[j][2] +
                            ", ISBN: " + books[j][3]);
                }
            }
        }

    public static void checkOutBook(String ISBN,String patronName,String patronId){
        int findIndex=-1;
        for (int i=0; i<bookQuantity; i++) {
            if (books[i][3].equals(ISBN)) {
                findIndex=i;
                break;
            }
        }
        if (findIndex!=-1) {
                patrons[patronQuantity][0] = patronName;
                patrons[patronQuantity][1] = patronId;
                patrons[patronQuantity][2] = ISBN;//books[findIndex][0];
                Date date = new Date();
                patrons[patronQuantity][3] = date.toString();
                patronQuantity++;
                System.out.println("Kitap başarıyla alındı.");
            }

        else {
            System.out.println("Kitap bulunamadı.");
        }

    }


    public static void returnBook(String isbn){

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
        }*/
   public static void deleteBook(String ISBN){
       int findIndex=-1;

       if (bookQuantity==0){
           System.out.println("Kütühanede kitap sayısı 0'dır.");
       }
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
           bookQuantity--;
           String[][] newBooks=new String[books.length][4];
           for (int i=0; i<books.length; i++){
               for (int j=0; j<books[i].length; j++){
                   newBooks[i][j]=books[i][j];
               }
           }
           books=newBooks;
           System.out.println("Kitap Silinmiştir.");
       }
       else {
           System.out.println("Silmek isteğiniz kitap bulunmamaktadır.");

       }
   }

    public static void updateBook(String ISBN) {
       Scanner scanner=new Scanner(System.in);

       for (int i=0; i<bookQuantity; i++) {
           if (books[i][3].equals(ISBN)) {
               System.out.println("Kitap başlığını giriniz: ");
               String newTitle = scanner.nextLine();
               System.out.println("Kitap yazarını giriniz: ");
               String newAuthor = scanner.nextLine();
               System.out.println("Kitap sayfasını giriniz :");
               String newPageCount = scanner.nextLine();
               books[i][0] = newTitle;
               books[i][1] = newAuthor;
               books[i][2] = newPageCount;
               System.out.println("Kitap güncellenmiştir.");
               return;
           }
       }
        System.out.println("Kitap bulunmamaktadır.");
    }




    public static void generateReports() {
        int totalBooks = 0;
        if (bookQuantity==0){
            System.out.println("Kütühanede kitap sayısı 0'dır.");
        }
        else {
        System.out.printf("%-20s %-20s %-20s %-20s%n", "Kitap İsmi", "Yazar İsmi","Kitap Sayfası", "ISBN");
        for (int i = 0; i < bookQuantity; i++) {
            System.out.printf("%-20s %-20s %-20s %-20s%n",books[i][0],books[i][1],books[i][2],books[i][3]);
            totalBooks++;
        }
        System.out.println();
        System.out.println("Toplam kitap sayısı : " + totalBooks);
    }
    }




    public static void viewAvailableBooks() {
        System.out.printf("%-20s %-20s %-20s %-20s%n", "Kitap İsmi", "Yazar İsmi","Kitap Sayfası", "ISBN");

        for (int i = 0; i < bookQuantity; i++) {
            System.out.printf("%-20s %-20s %-20s %-20s%n",books[i][0],books[i][1],books[i][2],books[i][3]);
            }

        }
    public static void viewAvailablePatrons() {
        System.out.printf("%-20s %-20s %-20s %-20s%n", "Kullanıcı İsmi", "Kullanıcı ID","Kitap ISBN", "Tarih");

        for (int i = 0; i < patronQuantity; i++) {
            System.out.printf("%-20s %-20s %-20s %-20s%n",patrons[i][0],patrons[i][1],patrons[i][2],patrons[i][3]);
        }

    }

    public static void searchBooks(String keyWord){
        boolean bookFind=false;
        if (bookQuantity==0){
            System.out.println("Kütühanede kitap sayısı 0'dır.");
        }
        else {
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
    }




    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String islemler="1. Kitap Ekle\n"+
                "2.  Kitap Alma\n"+
                "3.  Kitap İade Et\n"+
                "4.  Mevcut Kitapları Görüntüle\n"+
                "5.  Kitap Ara\n"+
                "6.  Kitap Sil\n"+
                "7.  Rapor Oluştur\n"+
                "8.  Kullanıcı Bilgilri\n"+
                "9.  Kitap Öner\n"+
                "10. Kitap Güncelle\n"+
                "0.  Çıkış\n";

        while (true) {

            System.out.println(islemler);
            System.out.print("Lütfen bir seçenek girin: ");
            try {
                int secim = scanner.nextInt();
                scanner.nextLine();


                switch (secim) {
                    case 1:
                        System.out.println();
                        System.out.println("Kitap başlığını giriniz.");
                        String baslik = scanner.nextLine();
                        System.out.println("Yazar ismini giriniz.");
                        String yazar = scanner.nextLine();
                        System.out.println("Kitap sayfa sayısını giriniz.");
                        String sayfaSayisi = scanner.nextLine();
                        System.out.println("ISBN kodunu giriniz.");
                        String isbn = scanner.nextLine();
                        addBook(baslik, yazar, sayfaSayisi, isbn);
                        System.out.println();

                        break;
                    case 2:
                        System.out.println("Almak istediğiniz kitabın ISBN kodunu giriniz.");
                        String isbn1 = scanner.nextLine();
                        System.out.println("Kullanıcı Ad Soyad giriniz(orn:Mustafa Çetin)");
                        String names = scanner.nextLine();
                        System.out.println("Kullanıcı ID giriniz.");
                        String patronId = scanner.nextLine();
                        checkOutBook(isbn1, names, patronId);
                        break;
                    case 3:
                        System.out.println();
                        System.out.println("İade istedipiniz kitabın ISBN kodunu giriniz.");
                        String isbn3 = scanner.nextLine();
                        System.out.println("Kullanıcı ismini giriniz.");
                        String patron1 = scanner.nextLine();
                        System.out.println("İade kitap sayısı.");
                        int iadeKitap = scanner.nextInt();
                        //returnBook();
                        System.out.println();

                        break;
                    case 4:
                        viewAvailableBooks();
                        break;

                    case 5:
                        System.out.println();
                        System.out.println("Aramak istediğiniz kitabın ISBN,Yazar veya Başlığını yazaınız.");
                        String key = scanner.nextLine();
                        searchBooks(key);
                        System.out.println();
                        break;

                    case 6:
                        System.out.println("Lütfen silmek istediğiniz kitabın ISBN kodunu giriniz.");
                        String isbn4 = scanner.nextLine();
                        deleteBook(isbn4);
                        break;

                    case 7:
                        System.out.println();
                        generateReports();
                        System.out.println();
                        break;
                    case 8:
                        viewAvailablePatrons();
                        break;
                    case 9:
                        System.out.println("Lütfen Kullanıcı ismini giriniz.");
                        String name=scanner.nextLine();
                        generateBookRecommendations(name);
                        break;
                    case 0:
                        System.exit(0);
                        break;
                    case 10:
                        System.out.println("Güncellemek istediğiniz kitabın ISBN kodunu giriniz.");
                        String isbn5=scanner.nextLine();
                        updateBook(isbn5);
                        break;
                    default:
                        System.out.println("Geçersiz işlem...");
                        break;
                }
            }
            catch (InputMismatchException e){
                System.out.println("Lütfen rakam ile cevap giriniz.");
                scanner.nextLine();
            }
        }
    }
}

