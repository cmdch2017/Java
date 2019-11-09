package test_109;

import java.util.Scanner;

public abstract class User {
    private String id;
    private String name;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public static User login() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("�������û� id: ");
        String id = scanner.nextLine();
        String role = scanner.nextLine();
        System.out.println("�����ڽ�ɫ: ");
        System.out.println(role);
        System.out.println("�������û�����: ");
        String name = scanner.nextLine();
        System.out.println(name);
      
        User user;
        if (role.equals("��ʦ")) {
            user = new Teacher(id, name);
        } else if (role.equals("ѧ��")){
            user = new Student(id, name);
        } else {
            throw new Exception("����Ľ�ɫ");
        }

        return user;
    }

    public abstract void menu();

    public abstract boolean input();
}