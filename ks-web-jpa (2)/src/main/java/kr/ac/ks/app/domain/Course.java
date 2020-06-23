package kr.ac.ks.app.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Getter
@Setter
public class Course {
    //item
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Lesson lesson;

    public void setStudent(Student student) {
        this.student = student;
        this.student.getCourses().add(this);
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
        this.lesson.getCourses().add(this);
    }

    public static Course createCourse(Student student, Lesson... lessons) {
        Course course = new Course();
        course.setStudent(student);
        Arrays.stream(lessons).forEach(course::setLesson);
        return course;
    }
}
