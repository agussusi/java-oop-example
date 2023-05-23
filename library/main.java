import java.util.Scanner;

class Main {

  static Scanner scan = new Scanner(System.in);
  static Library library = new Library();

  public static void main(String[] args) {
    initLibraryData();

    String isContinue = "y";

    while (isContinue.equals("y")) {
      showMenu();
      int selectedMenu = chooseMenu();

      if (selectedMenu == 1) {
        showBooks();
      } else if (selectedMenu == 2) {
        showMembers();
      } else if (selectedMenu == 3) {
        addMember();
      } else if (selectedMenu == 4) {
        addBook();
      } else if (selectedMenu == 5) {
        borrowBook();
      } else if (selectedMenu == 6) {
        returnBook();
      } else {
        System.out.println("wrong input");
      }

      System.out.print("continue ? ");
      isContinue = scan.next();
    }
  }

  public static void showMenu() {
    System.out.println("================================");
    System.out.println("1. show books list");
    System.out.println("2. show members list");
    System.out.println("3. add member");
    System.out.println("4. add book");
    System.out.println("5. borrow book");
    System.out.println("6. return book");
    System.out.println("================================");
  }

  public static void initLibraryData() {
    Book book1 = new Book();
    book1.setId("1");
    book1.setTitle("pemrograman java");

    Book book2 = new Book();
    book2.setId("2");
    book2.setTitle("pemrograman oop");

    Book book3 = new Book();
    book3.setId("3");
    book3.setTitle("pemrograman android");

    Member member1 = new createMember("1", "aka");

    Member member2 = new createMember("2", "budi");

    Member member3 = new createMember("3", "tono");

    library.books.add(book1);
    library.books.add(book2);
    library.books.add(book3);

    library.members.add(member1);
    library.members.add(member2);
    library.members.add(member3);
  }

  public static int chooseMenu() {
    System.out.print("choose menu : ");
    int pilihan = scan.nextInt();
    return pilihan;
}

public static void showBooks() {
    for (Book book : library.books) {
        System.out.println(book.getId() + " " + book.getTitle());
    }
}

public static void showMembers() {
    for (Member member : library.members) {
        System.out.println(member.id + " " + member.name);
    }
}

public static void addMember() {
        System.out.print("id: ");
        String memberId = scan.next();

        System.out.print("name: ");
        String memberName = scan.next();

        Member member = new createMember(memberId, memberName);
        library.addMember(member);

}
public static void returnBook() {
  System.out.print("id member : ");
  String memberId = scan.next();

  System.out.print("id book : ");
  String bookId = scan.next();

  library.receiveBook( memberId,bookId);
}

public static void addBook() {
    Book book = new Book();

    System.out.print("id : ");
    book.setId(scan.next());

    System.out.print("title : ");
    scan.nextLine();
    book.setTitle(scan.next());
    library.addBook(book);
  }

public static void borrowBook() {
    System.out.print("id member : ");
    String memberId = scan.next();

    System.out.print("id book : ");
    String bookId = scan.next();

    library.giveBook( memberId,bookId);
}

}