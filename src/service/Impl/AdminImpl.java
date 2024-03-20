package service.Impl;

import group.Admin;
import service.AdminService;

import java.util.Scanner;

public class AdminImpl implements AdminService {

    @Override
    public Admin login(Admin admin) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Логин жазыныз: ");
        String email = scanner.nextLine();
        System.out.print("Пароль жазыныз: ");
        String password = scanner.nextLine();
        if (email.equalsIgnoreCase(admin.getEmail()) && password.equals(admin.getPassword())) {
            return admin;
        }
        return null;
    }

    @Override
    public Admin changePassword(Admin admin) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Логин жазыныз: ");
        String log = scanner.nextLine();
        if (log.equalsIgnoreCase(admin.getEmail())) {
            System.out.print("Жаны пароль жазыныз: ");
            String pass = scanner.nextLine();
            if (pass.length() >= 7) {
                admin.setPassword(pass);
                System.out.println("Парол ийгиликтуу озгортулду!");
                return admin;
            }
        }
        return null;
    }


}

