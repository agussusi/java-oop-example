import java.util.ArrayList;

interface Reading {
  void receiveBook(Book book);
  void giveBook(Book book);
}

interface Reading1 {
  Book getBookById(String id);
}

abstract class Member implements Reading, Reading1 {
  String id;
  String name;
  ArrayList<Book> borrowedBooks;

  public Member(String id, String name) {
    this.id = id;
    this.name = name;
    this.borrowedBooks = new ArrayList<Book>();
  }

  public String getId() {
    return id;
  }

  public ArrayList<Book> getborrowedBooks() {
    return borrowedBooks;
  }

  public void receiveBook(Book book) {
    this.borrowedBooks.add(book);
  }

  public void giveBook(Book book) {
    this.borrowedBooks.remove(book);
  }

  public abstract Book getBookById(String id);
}

class createMember extends Member {
  public createMember(String id, String name) {
    super(id, name);
  }

  @Override
  public Book getBookById(String id) {
    for (Book book : this.borrowedBooks) {
      if (book.getId().equals(id)) {
        return book;
      }
    }
    return null;
   }
}
//selesai
