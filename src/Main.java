import database.DataBase;
import group.Admin;

import group.Group;
import group.Lessons;
import group.Student;
import service.AdminService;
import service.GroupService;
import service.Impl.AdminImpl;
import service.Impl.GroupServiceImpl;
import service.Impl.LessonServiceImpl;
import service.Impl.StudentServiceImpl;
import service.StudentService;


import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner scanForStr = new Scanner(System.in);

        DataBase dataBase = new DataBase();
        GroupService group = new GroupServiceImpl(dataBase);
        LessonServiceImpl lesson = new LessonServiceImpl(dataBase);
        StudentService student = new StudentServiceImpl(dataBase);
        AdminService adminService = new AdminImpl();
        Admin admin = new Admin();

        boolean isTrue = true;
        while (isTrue) {
            try {
                timeMenu();
                System.out.println("Катталган болсонуз 1 басыныз, пароль унутуп калып, озгортуу учун 2 басыныз, 3 чыгуу!");
                int buttonLog = scanner.nextInt();
                if (buttonLog == 1) {
                    Admin login = adminService.login(admin);
                    if (login == null) {
                        System.out.println("туура эмес жаздыныз!!!");
                    } else {
                        System.out.println("Кош келиниз");
                        innerLoop:
                        while (true) {
                            try {
                                mainMenu();
                                switch (scanner.nextInt()) {
                                    case 0 -> {
                                        break innerLoop;
                                    }
                                    case 1 -> System.out.println(group.addGroup());
                                    case 2 -> {
                                        System.out.print("Группанын атын жазыныз: ");
                                        String groupName = scanForStr.nextLine();
                                        Group groupByName = group.getGroupByName(groupName);
                                        if (groupByName == null) {
                                            System.out.println("туура эмес жаздыныз!!!");
                                        } else System.out.println(groupByName);
                                    }
                                    case 3 -> {
                                        System.out.print("Группанын атын жазыныз: ");
                                        String groupName = scanForStr.nextLine();
                                        System.out.println(group.upDateGroup(groupName));
                                    }
                                    case 4 -> System.out.println(group.getAllGroups());
                                    case 5 -> {
                                        System.out.print("Группанын атын жазыныз: ");
                                        String groupName = scanForStr.nextLine();
                                        List<Student> students = student.addStudent(groupName);
                                        if (students == null) {
                                            System.out.println("туура эмес жаздыныз!");
                                        } else System.out.println(students);
                                    }
                                    case 6 -> {
                                        System.out.print("Студенттин email жазыныз: ");
                                        String email = scanForStr.nextLine();
                                        System.out.println(student.upDateStudentName(email));
                                    }
                                    case 7 -> {
                                        System.out.print("Студенттин атын жазыныз: ");
                                        String nameStudent = scanForStr.nextLine();
                                        Student list = student.findStudent(nameStudent);
                                        if (list == null) {
                                            System.out.println("туура эмес жаздыныз!");
                                        } else {
                                            System.out.println(list);
                                        }
                                    }
                                    case 8 -> {
                                        System.out.print("Группанын атын жазыныз: ");
                                        String groupName = scanForStr.nextLine();
                                        List<Student> studentList = student.getAllStudentsByGroup(groupName);
                                        if (studentList == null) {
                                            System.out.println("туура эмес жаздыныз!");
                                        } else {
                                            System.out.println(studentList);
                                        }
                                    }
                                    case 9 -> {
                                        System.out.print("Студенттин id жазыныз: ");
                                        long id = scanner.nextLong();
                                        List<Lessons> allLessonsStudent = student.getAllLessonsStudent(id);
                                        if (allLessonsStudent == null) {
                                            System.out.println("туура эмес жаздыныз!");
                                        } else {
                                            System.out.println(allLessonsStudent);
                                        }
                                    }
                                    case 10 -> {
                                        System.out.print("Студенттин email жазыныз: ");
                                        String email = scanForStr.nextLine();
                                        System.out.println(student.deleteStudent(email));
                                    }
                                    case 11 -> {
                                        System.out.print("Группанын атын жазыныз: ");
                                        String groupName = scanForStr.nextLine();
                                        List<Lessons> addLesson = lesson.addLesson(groupName);
                                        if (addLesson == null) {
                                            System.out.println("туура эмес жаздыныз!");
                                        } else {
                                            System.out.println(addLesson);
                                        }
                                    }
                                    case 12 -> {
                                        System.out.print("Сабактын атын жазыныз: ");
                                        String lessonName = scanForStr.nextLine();
                                        Lessons lessonLesson = lesson.getLesson(lessonName);
                                        if (lessonLesson == null) {
                                            System.out.println("туура эмес жаздыныз!");
                                        } else {
                                            System.out.println(lessonLesson);
                                        }
                                    }
                                    case 13 -> {
                                        System.out.print("Группанын атын жазыныз: ");
                                        String groupName = scanForStr.nextLine();
                                        List<Lessons> lessonList = lesson.getAllLessonByGroupName(groupName);
                                        if (lessonList == null) {
                                            System.out.println("туура эмес жаздыныз!");
                                        } else {
                                            System.out.println(lessonList);
                                        }
                                    }
                                    case 14 -> {
                                        System.out.print("Сабактын ID жазыныз: ");
                                        long id = scanner.nextLong();
                                        System.out.println(lesson.deleteLessonById(id));
                                    }
                                    case 15 -> {
                                        System.out.print("Группанын атын жазыныз: ");
                                        String groupName = scanForStr.nextLine();
                                        System.out.println(group.deleteGroup(groupName));
                                    }
                                }
                            } catch (InputMismatchException e) {
                                System.err.println("Enter valid Integer");
                                scanner.nextLine();
                            }
                        }
                    }
                } else if (buttonLog == 2) {
                    Admin changed = adminService.changePassword(admin);
                    if (changed == null) {
                        System.out.println("туура эмес жаздыныз!");
                    } else {
                        System.out.println(changed);
                    }
                } else if (buttonLog == 3) {
                    isTrue = false;
                }
            } catch (InputMismatchException e) {
                System.err.println("Enter valid Integer");
                scanner.nextLine();
            }
        }
    }

    private static void timeMenu() {
        ZonedDateTime currentDateTime = ZonedDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        int currentHour = currentDateTime.getHour();

        if (currentHour > 4 && currentHour < 11) {
            System.out.println("Кутман тан! саат -> " + currentDateTime.format(dateTimeFormatter));
        } else if (currentHour >= 11 && currentHour < 17) {
            System.out.println("Кутман кун! саат -> " + currentDateTime.format(dateTimeFormatter));
        } else if (currentHour >= 17 && currentHour < 22) {
            System.out.println("Кутман кеч! саат -> " + currentDateTime.format(dateTimeFormatter));
        } else {
            System.out.println("Кутман тун! саат -> " + currentDateTime.format(dateTimeFormatter));
        }
    }

    private static void mainMenu() {
        System.out.println("""
                    *** Бир команда танданыз! ***
                0  -> Exit.
                1  -> Add new group.
                2  -> Get group by name.
                3  -> Update group name.
                4  -> Get all groups.
                5  -> Add new student to group.
                6  -> Update student.
                7  -> Find student by first name.
                8  -> Get all students by group name.
                9  -> Get all student's lesson.
                10 -> Delete student by email.
                11 -> Add new lesson to group.
                12 -> Get lesson by name.
                13 -> Get all lesson by group name.
                14 -> Delete lesson by ID.
                15 -> Delete group by name.
                """);
        System.out.print("Команда: ");
    }
}