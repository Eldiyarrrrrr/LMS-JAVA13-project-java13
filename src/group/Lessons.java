package group;

import java.util.Objects;

public class Lessons {
    private long id;
    private String nameLesson;
    private String descriptionLesson;

    public Lessons() {
    }

    public Lessons(long id, String nameLesson, String descriptionLesson) {
        this.id = id;
        this.nameLesson = nameLesson;
        this.descriptionLesson = descriptionLesson;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameLesson() {
        return nameLesson;
    }

    public void setNameLesson(String nameLesson) {
        this.nameLesson = nameLesson;
    }

    public String getDescriptionLesson() {
        return descriptionLesson;
    }

    public void setDescriptionLesson(String descriptionLesson) {
        this.descriptionLesson = descriptionLesson;
    }

    @Override
    public String toString() {
        return ": " +
                "id=" + id +
                " nameLesson='" + nameLesson + '\'' +
                " descriptionLesson='" + descriptionLesson + '\'' + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lessons lesson = (Lessons) o;
        return id == lesson.id && Objects.equals(nameLesson, lesson.nameLesson) && Objects.equals(descriptionLesson, lesson.descriptionLesson);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameLesson, descriptionLesson);
    }
}
