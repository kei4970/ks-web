package kr.ac.ks.app.repository;

import kr.ac.ks.app.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    @Transactional
    @Modifying
    @Query("delete from Course c where c.lesson.id in :ids")
    void deleteAllByIdInQuery(@Param("ids") List<Long> ids);

//    @Transactional
//    @Modifying
//    @Query("delete from Course c where c.student.id in :ids")
//    void deleteAllByIdInQuery(@Param("ids") List<Long> ids);
}
