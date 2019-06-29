package b_01_06.LibraryCatalog;

public class LibraryCatalogApp {
    public static void main (String [] args){

        LibraryCatalog libraryCatalog = new LibraryCatalog();

        Book book = new Book();
        book.bookName = "Padurea spanzuratilor";
        book.numberOfPages = 2;

        libraryCatalog.AddBook(book);
        libraryCatalog.DeleteBook(book);
        libraryCatalog.ListBook();

        Novel novel = new Novel();
        novel.bookName = "Enigma Otiliei";
        novel.numberOfPages = 2;
        novel.Type = "Mystery";

        libraryCatalog.AddBook(novel);

        Album album = new Album();
        album.bookName = "Hamlet";
        album.numberOfPages = 2;
        album.PaperQuality = "Good";

        libraryCatalog.AddBook(album);

        libraryCatalog.ListBook();
    }
}
