package week2.library;

public class LibraryCatalogApp {
    public static void main(String[] args) {

        LibraryCatalog libraryCatalog = new LibraryCatalog();

        Book book = new Book();
        book.setBookName("Padurea spanzuratilor");
        book.numberOfPages = 2;

        //metodele incep doar cu litere mici, si au camelCase
        libraryCatalog.addBook(book);
        libraryCatalog.deleteBook(book);
        libraryCatalog.listBook();

        Novel novel = new Novel();
        //folosim incapsulare, accesand fields doar cu getteri/setteri, nu direct
        //novel.bookName = "Enigma Otiliei";
        novel.setBookName("Enigma Otiliei");
        novel.numberOfPages = 2;
        novel.type = "Mystery";

        libraryCatalog.addBook(novel);

        Album album = new Album();
        novel.setBookName("Hamlet");
        album.numberOfPages = 2;
        album.paperQuality = "Good";

        libraryCatalog.addBook(album);

        libraryCatalog.listBook();
    }
}
