package com.sangkon.app.repository;

import com.sangkon.app.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository  extends JpaRepository<Skill,Long> {
}
