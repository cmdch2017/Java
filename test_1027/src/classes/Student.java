package classes;

import action.Action;
import databases.BookShelf;
import databases.RecordShelf;
import exceptions.BorrowedOutException;
import exceptions.NoSuchBookException;
import exceptions.NotBorrowedException;
import exceptions.YetBorrowedException;

import java.net.ServerSocket;
import java.util.Scanner;

public class Student extends User {
    public Student(String id, String name) {
        super(id, name);
    }

    @Override
    public void menu() {
        System.out.println("**  同学，请选择 **");
        System.out.println("** 0. 退出 **");
        System.out.println("** 1. 查阅图书 **");
        System.out.println("** 2. 借阅图书 **");
        System.out.println("** 3. 归还图书 **");
        System.out.println("** 4. 查询借阅情况 **");
    }

    @Override
    public boolean input() {
        Scanner scanner = new Scanner(System.in);
        int selected = scanner.nextInt();
        scanner.nextLine();
        switch (selected) {
            case 0: return true;
            case 1:
                queryBooks();
                break;
            case 2:
                borrowBook();
                break;
            case 3:
                returnBook();
                break;
        }

        return false;
    }

    private void returnBook() {
        // 用户界面
        // 还书-前提条件
        // 1. 判断有没有这本书
        // 2. 用户借过该书
        // 还书-流程
        // 1. 借阅记录删除
        // 2. 书的存量 + 1
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要归还书籍的 ISBN:");
        String ISBN = scanner.nextLine();
        User user = User.getCurrentUser();
        try {
            Book book = Action.returnBook(user, ISBN);
            System.out.printf("《%s》归还成功！%n", book.getTitle());
        } catch (NoSuchBookException e) {
            System.out.println("错误！没有这本书");
        } catch (NotBorrowedException e) {
            System.out.println("错误！这本书没有被你借过");
        }
    }

    private void borrowBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要借阅书籍的 ISBN:");
        String ISBN = scanner.nextLine();
        User user = User.getCurrentUser();
        try {
            Book book = Action.borrowBook(user, ISBN);
            System.out.printf("《%s》借阅成功！%n", book.getTitle());
        } catch (NoSuchBookException e) {
            System.out.println("错误！没有这本书");
        } catch (BorrowedOutException e) {
            System.out.println("错误！这本书已经全被借完了");
        } catch (YetBorrowedException e) {
            System.out.println("错误！这本书已经你已经借过了");
        }
    }
}
