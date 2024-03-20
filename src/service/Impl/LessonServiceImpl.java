package service.Impl;

import database.DataBase;

import group.Group;
import group.Lessons;


import service.Impl.MyGeneratorId;

import service.LessonsService;

import java.util.*;

public class LessonServiceImpl implements LessonsService {
    public DataBase dataBase;

    public LessonServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public List<Lessons> addLesson(String groupName) {
        Scanner scanForSTR = new Scanner(System.in);
        for (Group group : dataBase.groups) {
            if (group.getNameGroup().equalsIgnoreCase(groupName)) {
                Lessons lesson = new Lessons();
                lesson.setId(MyGeneratorId.generatorLesson());
                while (true) {
                    System.out.print("Сабактын атын жазыныз: ");
                    String nameLesson = scanForSTR.nextLine();
                    try {
                        if (nameLesson.length() >= 2) {
                            lesson.setNameLesson(nameLesson);
                            break;
                        } else {
                            throw new Exception("Сабактын атын туура эмес жаздыныз");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                while (true) {
                    System.out.print("Тапшырманын суроттомосуну жазыныз: ");
                    String lessonDes = scanForSTR.nextLine();
                    try {
                        if (lessonDes.length() >= 7) {
                            lesson.setDescriptionLesson(lessonDes);
                            break;
                        } else {
                            throw new Exception("Тапшырманын суроттомосуну туура эмес жаздыныз");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                group.lessons.add(lesson);
                System.out.println("Сабак ийгиликтуу кошулду!");
                return group.lessons;
            }
        }
        return null;
    }

    @Override
    public Lessons getLesson(String groupName) {
        for (Group group : dataBase.groups) {
            for (Lessons lesson : group.lessons) {
                if (lesson.getNameLesson().equalsIgnoreCase(groupName)) {
                    return lesson;
                }
            }
        }
        return null;
    }

    @Override
    public List<Lessons> getAllLessonByGroupName(String groupName) {
        for (Group group : dataBase.groups) {
            if (group.getNameGroup().equalsIgnoreCase(groupName)) {
                return group.lessons;
            }
        }
        return null;
    }

    @Override
    public String deleteLessonById(long id) {
        for (Group group : dataBase.groups) {
            group.lessons.removeIf(lesson -> lesson.getId() == id);
            return "Successfully deleted";
        }
        return "Туура эмес";
    }
}
