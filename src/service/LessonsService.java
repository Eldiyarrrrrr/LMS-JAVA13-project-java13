package service;

import group.Lessons;


import java.util.List;

public interface LessonsService {

    List<Lessons> addLesson(String groupName);

    Lessons getLesson(String groupName);

    List<Lessons> getAllLessonByGroupName(String groupName);

    String deleteLessonById(long id);
}
