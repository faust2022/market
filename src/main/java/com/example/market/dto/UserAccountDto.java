package com.example.market.dto;

/**
 * A DTO for the {@link com.example.projectspring.domain.UserAccount} entity
 */
public record UserAccountDto(Long id,
                             String userId,
                             String userPassword,
                             String email,
                             String nickname)
{
    public static UserAccountDto of(Long id, String userId, String userPassword, String email, String nickname){
        return new UserAccountDto(id, userId, userPassword, email, nickname);
    }
}