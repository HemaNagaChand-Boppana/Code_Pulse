package com.hemanagachand.code_pulse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hemanagachand.code_pulse.entity.PlatformAccount;
import com.hemanagachand.code_pulse.entity.User;
import com.hemanagachand.code_pulse.enums.Platform;

public interface PlatformAccountRepository
        extends JpaRepository<PlatformAccount, Long> {

    List<PlatformAccount> findByUser(User user);

    PlatformAccount findByUserAndPlatform(User user, Platform platform);

}