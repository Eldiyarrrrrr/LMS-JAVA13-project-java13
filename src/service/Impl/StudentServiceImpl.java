package service.Impl;

import database.DataBase;
import enums.Gender;
import group.Group;
import group.Lessons;
import group.Student;


import service.StudentService;

import java.util.*;

public class StudentServiceImpl implements StudentService {

    public DataBase dataBase;

    public StudentServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public List<Student> addStudent(String groupName) {
        Scanner scanForSTR = new Scanner(System.in);
        for (Group group : dataBase.groups) {
            if (group.getNameGroup().equalsIgnoreCase(groupName)) {
                Student student = new Student();
                student.setId(MyGeneratorId.generatorStudent());
                while (true) {
                    try {
                        System.out.print("Студенттин атыны жазыныз: ");
                        student.setFirstName(scanForSTR.nextLine());
                        if (student.getFirstName().length() > 1) {
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
                        System.out.print("Студенттин фамилиясыны жазыныз: ");
                        student.setLastName(scanForSTR.nextLine());
                        if (student.getLastName().length() > 1) {
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
                        System.out.print("Студенттин телефон номерини жазыныз: ");
                        student.setPhoneNumber(scanForSTR.nextLine());
                        if (student.getPhoneNumber().startsWith("+996") && student.getPhoneNumber().length() == 13) {
                            break;
                        } else {
                            throw new Exception("туура эмес, +996 дан башталышы керек жана 13 цифрадан туруусу зарыл");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                while (true) {
                    try {
                        System.out.print("Логин жазыныз: ");
                        String log = scanForSTR.nextLine();
                        if (checkingUniqueness(log).equalsIgnoreCase("1") && log.endsWith("@gmail.com") && log.length() > 10) {
                            student.setEmail(log);
                            break;
                        } else {
                            throw new Exception("Логин ди туура эмес жаздыныз. @gmail.com камтыш керек");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                while (true) {
                    try {
                        System.out.print("Пароль жазыныз: ");
                        student.setPassword(scanForSTR.nextLine());
                        if (student.getPassword().length() >= 7) {
                            break;
                        } else {
                            throw new Exception("Пароль ду туура эмес жаздыныз. 7 символдон кем болбосун");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                while (true) {
                    System.out.print("Жынысын жазыныз: (m/f): ");
                    String gender = (new Scanner(System.in).next());
                    try {
                        if (gender.equalsIgnoreCase("m")) {
                            student.setGender(Gender.MALE);
                            break;
                        } else if (gender.equalsIgnoreCase("f")) {
                            student.setGender(Gender.FEMALE);
                            break;
                        } else {
                            throw new Exception("жыныс только (m/f) камтыш керек");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                group.students.add(student);
                System.out.println("Студент ийгиликтуу кошулду!");
                return group.students;
            }
        }
        return null;
    }

    @Override
    public String upDateStudentName(String email) {
        Scanner scanner = new Scanner(System.in);
        Scanner scanForStr = new Scanner(System.in);
        for (Group group : dataBase.groups) {
            for (Student student : group.students) {
                if (student.getEmail().equalsIgnoreCase(email)) {
                    loop:
                    while (true) {
                        menu();
                        try {
                            switch (scanner.nextInt()) {
                                case 1 -> {
                                    System.out.print("Студенттин атыны жазыныз: ");
                                    String firstName = scanForStr.nextLine();
                                    if (firstName.length() > 1) {
                                        student.setFirstName(firstName);
                                        System.out.println("Ийгиликтуу озгорду");
                                    } else {
                                        System.out.println("туура эмес жаздыныз");
                                    }
                                }
                                case 2 -> {
                                    System.out.print("Студенттин фамилиясыны жазыныз: ");
                                    String lastName = scanForStr.nextLine();
                                    if (student.getLastName().length() > 1) {
                                        student.setLastName(lastName);
                                        System.out.println("Ийгиликтуу озгорду");
                                    } else {
                                        System.out.println("туура эмес жаздыныз");
                                    }
                                }
                                case 3 -> {
                                    System.out.print("Студенттин телефон номерини жазыныз: ");
                                    String numberPhone = scanForStr.nextLine();
                                    if (numberPhone.startsWith("+996") && numberPhone.length() == 13) {
                                        student.setPhoneNumber(numberPhone);
                                        System.out.println("Ийгиликтуу озгорду");
                                    } else {
                                        System.out.println("туура эмес, +996 дан башталышы керек жана 13 цифрадан туруусу зарыл");
                                    }
                                }
                                case 4 -> {
                                    System.out.print("Логин жазыныз: ");
                                    String login = scanForStr.nextLine();
                                    if (checkingUniqueness(login).equalsIgnoreCase("1") && login.endsWith("@gmail.com") && login.length() > 10) {
                                        student.setEmail(login);
                                        System.out.println("Ийгиликтуу озгорду");
                                    } else {
                                        System.out.println("Логин ди туура эмес жаздыныз. @gmail.com камтыш керек");
                                    }
                                }
                                case 5 -> {
                                    System.out.print("Пароль жазыныз: ");
                                    String password = scanForStr.nextLine();
                                    if (password.length() >= 7) {
                                        student.setPassword(password);
                                        System.out.println("Ийгиликтуу озгорду");
                                    } else {
                                        System.out.println("Пароль ду туура эмес жаздыныз. 7 символдон кем болбосун");
                                    }
                                }
                                case 6 -> {
                                    System.out.print("Жынысын жазыныз: (m/f): ");
                                    String gender = scanForStr.nextLine();
                                    if (gender.equalsIgnoreCase("m")) {
                                        student.setGender(Gender.MALE);
                                        System.out.println("Ийгиликтуу озгорду");
                                    } else if (gender.equalsIgnoreCase("f")) {
                                        student.setGender(Gender.FEMALE);
                                        System.out.println("Ийгиликтуу озгорду");
                                    } else {
                                        System.out.println("жыныс только (m/f) камтыш керек");
                                    }
                                }
                                case 7 -> {
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
        }
        return "Туура эмес";
    }

    @Override
    public Student findStudent(String studentName) {
        for (Group group : dataBase.groups) {
            for (Student student : group.students) {
                if (student.getFirstName().equalsIgnoreCase(studentName)){
                    return student;
                }
            }
        }
        return null;
    }

    @Override
    public List<Student> getAllStudentsByGroup(String groupName) {
        for (Group group : dataBase.groups) {
            if (group.getNameGroup().equalsIgnoreCase(groupName)){
                return group.students;
            }
        }
        return null;
    }

    @Override
    public String deleteStudent(String email) {
        for (Group group : dataBase.groups) {
            group.students.removeIf(student -> student.getEmail().equalsIgnoreCase(email));
            return "successfully deleted";
        }
        return "Туура эмес";
    }

    @Override
    public List<Lessons> getAllLessonsStudent(long id) {
        for (Group group : dataBase.groups) {
            for (Student student : group.students) {
                if (student.getId() == id){
                    return group.lessons;
                }
            }
        }
        return null;
    }


    private String checkingUniqueness(String name) {
        for (Group group : dataBase.groups) {
            for (Student student : group.students) {
                if (student.getEmail().equalsIgnoreCase(name)) {
                    return "0";
                }
            }
        }
        return "1";
    }

    private static void menu() {
        System.out.println("""
                1. first name
                2. last name
                3. phone number
                4. email
                5. password
                6. gender
                7. exit
                """);
    }
}
