package com.dailycodework.buynowdotcom.repository;

import aj.org.objectweb.asm.commons.Remapper;
import com.dailycodework.buynowdotcom.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>
{

    boolean existsByEmail(String email);
}
