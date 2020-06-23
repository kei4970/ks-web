package kr.ac.ks.app.repository;

import kr.ac.ks.app.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByName(final String name);
    List<Student> findAllByEmailIsLike(final String email);

    @Transactional
    @Modifying
    long deleteAllByIdIn(List<Long> ids);

    @Transactional
    @Modifying
    @Query("delete from Student s where s.id in :ids")
    void deleteAllByIdInQuery(@Param("ids") List<Long> ids);
}
