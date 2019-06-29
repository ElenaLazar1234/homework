package b_01_06.LibraryCatalog;

public class LibraryCatalog {
    Book[] books = new Book[10];

    public void DeleteBook(Book bookToDelete) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                if (books[i].bookName.equals(bookToDelete.bookName)) {
                    books[i] = null;
                }
            }
        }
    }

    public void AddBook(Book bookToAdd) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = bookToAdd;
                break;
            }
        }
    }

    public void ListBook() {
        for (Book book : books) {
            if (book != null) {
                System.out.println(book.bookName);
            }
        }
    }
}

