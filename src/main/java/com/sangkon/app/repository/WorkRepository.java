package com.sangkon.app.repository;

import com.sangkon.app.entity.SocialMedia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkRepository extends JpaRepository<SocialMedia,Long> {
}
