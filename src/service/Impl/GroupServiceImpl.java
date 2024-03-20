package service.Impl;

import database.DataBase;
import group.Group;
import service.GroupService;
import java.util.*;

public class GroupServiceImpl implements GroupService {

    public DataBase dataBase;

    public GroupServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public List<Group> addGroup() {
        List<Group> groups = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Group group = new Group();
        group.setId(MyGeneratorId.generatorGroup());
        while (true) {
            try {
                System.out.print("Жаны группага ат жазыныз: ");
                String groupName = scanner.nextLine();
                if (checkingUniqueness(groupName).equalsIgnoreCase("1") && groupName.length() >= 2) {
                    group.setNameGroup(groupName);
                    break;
                } else {
                    throw new Exception("туура эмес жаздыныз");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.print("Группанын суроттомосуну жазыныз: ");
                group.setDiscription(scanner.nextLine());
                if (group.getDiscription().length() >= 4) {
                    break;
                } else {
                    throw new Exception("туура эмес жаздыныз");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        dataBase.groups.add(group);
        System.out.println("Группа ийгиликтуу кошулду!");
        return dataBase.groups;
    }

    @Override
    public List<Group> getAllGroups() {
        return dataBase.groups;
    }

    @Override
    public Group getGroupByName(String groupName) {
        for (Group group : dataBase.groups) {
            if (group.getNameGroup().equalsIgnoreCase(groupName)) {
                return group;
            }
        }
        return null;
    }

    @Override
    public String upDateGroup(String groupName) {
        Scanner scanner = new Scanner(System.in);
        Scanner scanForStr = new Scanner(System.in);
        for (Group group : dataBase.groups) {
            if (group.getNameGroup().equalsIgnoreCase(groupName)) {
                loop:
                while (true) {
                    menu();
                    try {
                        switch (scanner.nextInt()) {
                            case 1 -> {
                                while (true) {
                                    System.out.print("группага ат жазыныз: ");
                                    String name = scanForStr.nextLine();
                                    if (checkingUniqueness(name).equalsIgnoreCase("1") && name.length() >= 2) {
                                        group.setNameGroup(name);
                                        System.out.println("Группанын аты ийгиликтуу озгорду");
                                        break;
                                    } else {
                                        System.out.println("туура эмес жаздыныз!!!");
                                    }
                                }
                            }
                            case 2 -> {
                                while (true) {
                                    System.out.print("Группанын суроттомосуну жазыныз: ");
                                    group.setDiscription(scanForStr.nextLine());
                                    if (group.getDiscription().length() >= 4) {
                                        break;
                                    } else {
                                        System.out.println("туура эмес жаздыныз");
                                    }
                                }
                            }
                            case 3 -> {
                                break loop;
                            }
                            default -> System.out.println("Жарамсыз тандоо");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println(e.getMessage());
                        scanner.next();
                    }
                }
                return "successfully updated";
            }
        }
        return "туура эмес";
    }

    @Override
    public String deleteGroup(String groupName) {
        for (Group group : dataBase.groups) {
            if (group.getNameGroup().equalsIgnoreCase(groupName)){
                dataBase.groups.remove(group);
                return "successfully deleted";
            }
        }
        return "Туура эмес";
    }


    private String checkingUniqueness(String name) {
        for (Group group : dataBase.groups) {
            if (group.getNameGroup().equalsIgnoreCase(name)) {
                return "0";
            }
        }
        return "1";
    }

    private static void menu() {
        System.out.println("""
                1. group name
                2. group description
                3. exit
                """);
    }
}
