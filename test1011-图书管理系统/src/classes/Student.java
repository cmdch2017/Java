package classes;

import action.Action;
import databases.BookShelf;
import databases.RecordShelf;
import exceptions.BorrowedOutException;
import exceptions.NoSuchBookException;
import exceptions.NotBorrowedException;
import exceptions.YetBorrowedException;

import java.util.Scanner;

public class Student extends User {
    public Student(String id, String name) {
        super(id, name);
    }

    @Override
    public void menu() {
        System.out.println("**  ͬѧ����ѡ�� **");
        System.out.println("** 0. �˳� **");
        System.out.println("** 1. ����ͼ�� **");
        System.out.println("** 2. ����ͼ�� **");
        System.out.println("** 3. �黹ͼ�� **");
        System.out.println("** 4. ��ѯ������� **");
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
                System.out.println("���ѯ��¼"); break;
        }

        return false;
    }

    private void returnBook() {
		// TODO �Զ����ɵķ������
		Scanner scanner=new Scanner(System.in);
		System.out.println("������Ҫ�黹�鼮��ISBN");
		String ISBN=scanner.nextLine();
		User user=User.getCurrentUser();
		//Book bookShelf;
		try {
		Book book=Action.returnBook(user,ISBN);
		}
	catch(NoSuchBookException e) {
	
	}catch(NotBorrowedException e) {
		
	}
    }
	private void borrowBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("������Ҫ�����鼮�� ISBN:");
        String ISBN = scanner.nextLine();
        User user = User.getCurrentUser();
        try {
            Book book = Action.borrowBook(user, ISBN);
            System.out.printf("��%s�����ĳɹ���%n", book.getTitle());
        } catch (NoSuchBookException e) {
            System.out.println("����û���Ȿ��");
        } catch (BorrowedOutException e) {
            System.out.println("�����Ȿ���Ѿ�ȫ��������");
        } catch (YetBorrowedException e) {
            System.out.println("�����Ȿ���Ѿ����Ѿ������");
        }
    }
}
