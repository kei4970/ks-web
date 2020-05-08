package com.sangkon.app.repository;

import com.sangkon.app.entity.SocialMedia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterestsRepository extends JpaRepository<SocialMedia,Long> {
}
