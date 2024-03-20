package service.Impl;

public class MyGeneratorId {
    public static long idGroup = 0;
    public static long idLesson = 0;
    public static long idStudent = 0;

    public static long generatorGroup(){
        return (++idGroup);
    }

    public static long generatorLesson(){
        return (++idLesson);
    }

    public static long generatorStudent(){
        return (++idStudent);
    }
}
