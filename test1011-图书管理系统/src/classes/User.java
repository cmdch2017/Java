package classes;

import action.Action;
import databases.RecordShelf;
import databases.Where;

import java.util.List;
import java.util.Scanner;

public abstract class User {
    private String id;
    private String name;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    private static User currentUser = null;
    public static User login() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("�������û� id: ");
        String id = scanner.nextLine();
        System.out.println("�������û�����: ");
        String name = scanner.nextLine();
        System.out.println("�����ڽ�ɫ:");
        String role = scanner.nextLine();
        if (role.equals("teacher")) {
            currentUser = new Teacher(id, name);
        } else if (role.equals("student")){
            currentUser = new Student(id, name);
        } else {
            throw new Exception("����Ľ�ɫ");
        }

        return currentUser;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public abstract void menu();

    public abstract boolean input();

    private static class Current implements Where<Book> {
        @Override
        public boolean test(Book book) {
            return book.getCurrentCount() > 0;
        }
    }

    private static class BookTitle implements Where<Book> {
        private String title;
        BookTitle(String title) {
            this.title = title;
        }

        @Override
        public boolean test(Book book) {
            return book.getTitle().equals(title);
        }
    }

    protected void queryBooks() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("��ѡ��ȫ��ѯ����������ѯ:");
        System.out.println("1. ȫ��ѯ");
        System.out.println("2. ��ѯ���� > 0 ��");
        System.out.println("����. ����������ѯ");
        int selected = scanner.nextInt();
        scanner.nextLine();
        List<Book> bookList;
        switch (selected) {
            case 1:
                bookList = Action.queryBooks();
                break;
            case 2:
                bookList = Action.queryBooksByWhere(new Current());
                break;
            default:
                System.out.println("����������:");
                String title = scanner.nextLine();
                bookList = Action.queryBooksByWhere(new BookTitle(title));
                break;
        }
        for (Book book : bookList) {
            System.out.printf("��%s��by %s �۸�: %.2f ����: %d ���Ĵ���: %d%n",
                    book.getTitle(), book.getAuthor(), book.getPrice(),
                    book.getCurrentCount(), book.getBorrowedCount());
        }
        System.out.println("����ѯ�� " + bookList.size() + " ����");
    }

    protected void queryRecords() {
        List<Record> recordList = Action.queryRecords();
        for (Record record : recordList) {
            System.out.printf("%s %s %s%n",
                    record.getUserId(),
                    record.getBookISBN(),
                    record.getBorrowedAt());
        }
        System.out.println("����ѯ�� " + recordList.size() + " �����ļ�¼");
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
