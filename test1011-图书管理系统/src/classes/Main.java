package classes;
import classes.User;
public class Main {
    public static void main(String[] args) throws Exception {
        // �����ʾ
        // �� scanner ���û�����
        // id/name/��ɫ
        // �����û�����
        User currentUser = User.login();
        boolean isQuit;
        do {
            currentUser.menu();
            isQuit = currentUser.input();
        } while (!isQuit);
        System.out.println("��ӭ�´ι���");
    }
}