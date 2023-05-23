import java.util.ArrayList;

class Library {
  public ArrayList<Book> books = new ArrayList<Book>();
  public ArrayList<Member> members = new ArrayList<Member>();

  public Library() {
    this.books = new ArrayList<>();
    this.members = new ArrayList<>();
  }
  protected int getMemberIndex(Member member) {
    return this.members.indexOf(member);
  }

  protected Member getMemberById(String id) throws Exception {
    for (Member member : this.members) {
      if (member.id.equals(id)) {
        return member;
      }
    }
    throw new Exception("Member " + id + " tidak ada");
  }

  protected Book getBookById(String id) throws Exception {
    for (Book book : this.books) {
      if (book.getId().equals(id)) {
        return book;
      }
    }
    throw new Exception("Buku  " + id + " sedang dipinjam");
  }

  public void addMember(Member member) {
    if (!isMemberIdExist(member.id)) {
      this.members.add(member);
      System.out.println("Member berhasil ditambahkan");
    } else {
      System.out.println("Member ID " + member.id + " sudah tersedia");
    }
  }

  public Boolean isMemberIdExist(String id) {
    for (Member member : this.members) {
      if (member.id.equals(id)) {
        return true;
      }
    }
    return false;
  }

  // add book
  public void addBook(Book book) {
    if (isBookIdExist(book.getId())) {
      System.out.println("Buku dengan ID " + book.getId() + " sudah tersedia");
    } else if ( isBookBorrowed(book.getId() )) {
      System.out.println("Buku dengan ID " + book.getId()  + " sudah tersedia dan sedang dipinjam");
    } else {
      this.books.add(book);
      System.out.println("Buku berhasil ditambahkan");
    }
  }

  private boolean isBookBorrowed(String bookId) {
    for (Member member : this.members) {
      if (member.getBookById(bookId) != null) {
        return true;
      }
    }
    return false;
  }


  public Boolean isBookIdExist(String id) {
    for (Book book : this.books) {
      if (book.getId().equals(id)) {
        return true;
      }
    }
    return false;
  }


  public void giveBook(String memberId, String bookId) {
    try {
      Book book = this.getBookById(bookId);
      Member member = this.getMemberById(memberId);
      int memberIndex = this.getMemberIndex(member);

      this.books.remove(book);
      this.members.get(memberIndex).getborrowedBooks().add(book);

      System.out.println("Buku dengan ID " + book.getId()  + " telah berhasil dipinjam oleh member " + member.id);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void receiveBook(String memberId, String bookId) {
    try {
        Member member = this.getMemberById(memberId);
        int memberIndex = this.getMemberIndex(member);

        Book book = this.members.get(memberIndex). getBookById(bookId);

        if (book != null && this.members.get(memberIndex).getborrowedBooks().contains(book)) {
            this.books.add(book);
            this.members.get(memberIndex).getborrowedBooks().remove(book);
            System.out.println("Buku " + book.getId() + " berhasil dikembalikan oleh member " + member.id);
        } else {
            System.out.println("Buku " + bookId + " tidak sedang dipinjam oleh member " + member.id);
        }
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}
}