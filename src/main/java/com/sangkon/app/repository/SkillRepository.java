package com.sangkon.app.repository;

import com.sangkon.app.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository  extends JpaRepository<Person,Long> {
}
