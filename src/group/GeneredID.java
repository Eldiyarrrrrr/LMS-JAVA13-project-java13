package group;

public class GeneredID {
    public static int id = 0;
    public static int studentsId = 0;
    public static int generetorid() {
        return (++id);
    }
    public static int generateStudend(){
        return (++studentsId);
    }
}
