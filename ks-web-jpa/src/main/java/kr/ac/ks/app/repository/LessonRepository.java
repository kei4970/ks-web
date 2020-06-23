package kr.ac.ks.app.repository;


import kr.ac.ks.app.domain.Course;
import kr.ac.ks.app.domain.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
    @Transactional
    @Modifying
    long deleteAllByIdIn(List<Long> ids);

    @Transactional
    @Modifying
    @Query("delete from Lesson l where l.id in :ids")
    void deleteAllByIdInQuery(@Param("ids") List<Long> ids);

    @Transactional
    @Modifying
    List<Lesson> findByCoursesEquals(Course course);
}
