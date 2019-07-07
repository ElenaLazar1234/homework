package week2.library;

public class LibraryCatalog {
    Book[] books = new Book[10];

    public void addBook(Book bookToAdd) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = bookToAdd;
                break;
            }
        }
    }

    public void deleteBook(Book bookToDelete) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                if (books[i].getBookName().equals(bookToDelete.getBookName())) {
                    books[i] = null;
                }
            }
        }
    }

    public void listBook() {
        for (Book book : books) {
            if (book != null) {
                System.out.println(book.getBookName());
            }
        }
    }
}

