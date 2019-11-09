package classes;

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
        System.out.println("请输入用户 id: ");
        String id = scanner.nextLine();
        System.out.println("请输入用户姓名: ");
        String name = scanner.nextLine();
        System.out.println("请属于角色: ");
        String role = scanner.nextLine();
        User user;
        if (role.equals("老师")) {
            user = new Teacher(id, name);
        } else if (role.equals("学生")){
            user = new Student(id, name);
        } else {
            throw new Exception("错误的角色");
        }

        return user;
    }

    public abstract void menu();

    public abstract boolean input();
}
