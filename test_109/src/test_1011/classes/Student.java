package classes;

import java.util.Scanner;

public class Student extends User {
    public Student(String id, String name) {
        super(id, name);
    }

    @Override
    public void menu() {
        System.out.println("**  同学，请选择 **");
        System.out.println("** 0. 退出 **");
        System.out.println("** 1. 上架 **");
        System.out.println("** 2. 查阅图书 **");
        System.out.println("** 3. 查阅记录 **");
    }

    @Override
    public boolean input() {
        Scanner scanner = new Scanner(System.in);
        int selected = scanner.nextInt();
        switch (selected) {
            case 0: return true;
            case 1:
                System.out.println("请上架"); break;
            case 2:
                System.out.println("请查询图书"); break;
            case 3:
                System.out.println("请查询记录"); break;
        }

        return false;
    }
}
