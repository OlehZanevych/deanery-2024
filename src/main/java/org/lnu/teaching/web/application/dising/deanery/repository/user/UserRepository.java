package org.lnu.teaching.web.application.dising.deanery.repository.user;

import org.lnu.teaching.web.application.dising.deanery.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
