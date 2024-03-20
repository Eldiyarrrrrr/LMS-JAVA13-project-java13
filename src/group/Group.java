package group;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private int Id;
    private String nameGroup;
    private String discription;
    public List<Lessons> lessons = new ArrayList<>();
    public List<Student> students = new ArrayList<>();

    public Group() {

    }

    public Group(int id, String nameGroup, String discription, List<Lessons> lessons, List<Student> students) {
        Id = id;
        this.nameGroup = nameGroup;
        this.discription = discription;
        this.lessons = lessons;
        this.students = students;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public List<Lessons> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lessons> lessons) {
        this.lessons = lessons;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Group{" +
                "Id=" + Id +
                ", nameGroup='" + nameGroup + '\'' +
                ", discription='" + discription + '\'' +
                ", lessons=" + lessons +
                ", students=" + students +
                '}';
    }
}
