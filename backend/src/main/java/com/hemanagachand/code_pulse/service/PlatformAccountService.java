package com.hemanagachand.code_pulse.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hemanagachand.code_pulse.dto.PlatformAccountRequest;
import com.hemanagachand.code_pulse.dto.PlatformAccountResponse;
import com.hemanagachand.code_pulse.dto.PlatformAccountUpdateRequest;
import com.hemanagachand.code_pulse.entity.PlatformAccount;
import com.hemanagachand.code_pulse.entity.User;
import com.hemanagachand.code_pulse.repository.PlatformAccountRepository;
import com.hemanagachand.code_pulse.repository.UserRepository;

@Service
public class PlatformAccountService {

    private final PlatformAccountRepository platformAccountRepository;
    private final UserRepository userRepository;

    public PlatformAccountService(
            PlatformAccountRepository platformAccountRepository,
            UserRepository userRepository) {

        this.platformAccountRepository = platformAccountRepository;
        this.userRepository = userRepository;
    }

    public PlatformAccountResponse createPlatformAccount(
            PlatformAccountRequest request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        PlatformAccount existingAccount =
                platformAccountRepository.findByUserAndPlatform(
                        user,
                        request.getPlatform()
                );

        if (existingAccount != null) {

            existingAccount.setUsername(
                    request.getUsername());

            PlatformAccount updatedAccount =
                    platformAccountRepository.save(
                            existingAccount);

            return mapToResponse(updatedAccount);
        }

        PlatformAccount account = new PlatformAccount();

        account.setUser(user);
        account.setPlatform(request.getPlatform());
        account.setUsername(request.getUsername());

        PlatformAccount savedAccount =
                platformAccountRepository.save(account);

        return mapToResponse(savedAccount);
    }

    public List<PlatformAccountResponse> getAccountsByUserId(
            Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        return platformAccountRepository.findByUser(user)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public PlatformAccountResponse updatePlatformAccount(
            Long accountId,
            PlatformAccountUpdateRequest request) {

        PlatformAccount account =
                platformAccountRepository.findById(accountId)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Platform account not found"));

        account.setUsername(
                request.getUsername());

        PlatformAccount updatedAccount =
                platformAccountRepository.save(account);

        return mapToResponse(updatedAccount);
    }

    private PlatformAccountResponse mapToResponse(
            PlatformAccount account) {

        return PlatformAccountResponse.builder()
                .id(account.getId())
                .userId(account.getUser().getId())
                .platform(account.getPlatform())
                .username(account.getUsername())
                .build();
    }
}