

public class LibraryManagementSystem {

    public static class Book {
        private String bookId;
        private String title;
        private String author;

        public Book(String bookId, String title, String author) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
        }

        public String getBookId() {
            return bookId;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

    }

    public static Book linearSearch(Book[] books, String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    public static Book binarySearch(Book[] books, String title) {
        int left = 0;
        int right = books.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = books[mid].getTitle().compareTo(title);

            if (cmp== 0) {
                return books[mid];
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book("B1", "Book A", "Harry"),
            new Book("B2", "Book B", "Sally"),
            new Book("B3", "Book C", "Jolly"),
        };

        System.out.println("Linear Search:");
        Book foundBook = linearSearch(books, "Book A");
        if (foundBook != null) {
            System.out.println("Found "+ foundBook.getTitle()+" written by "+ foundBook.getAuthor());
        } else {
            System.out.println("Book not found.");
        }

        System.out.println("\nBinary Search:");
        foundBook = binarySearch(books, "Book B");
        if (foundBook != null) {
            System.out.println("Found "+ foundBook.getTitle()+" written by "+ foundBook.getAuthor());
        } else {
            System.out.println("Book not found.");
        }
    }
}
