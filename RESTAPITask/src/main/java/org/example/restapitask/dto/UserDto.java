package org.example.restapitask.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.example.restapitask.domain.Role;
import org.example.restapitask.domain.User;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

public class UserDto {

    public record CreateRequest(
            @NotBlank String name,
            @NotBlank String loginId,
            @NotBlank String password,
            @NotBlank @Email String email
    ) {
    }

    public record Response(
            Long id,
            String name,
            String loginId,
            String email,
            LocalDateTime joinedDate,
            Set<RoleResponse> roles
    ) {
        public static Response from(User user) {
            return new Response(
                    user.getId(),
                    user.getName(),
                    user.getLoginId(),
                    user.getEmail(),
                    user.getJoinedDate(),
                    user.getRoles()
                            .stream()
                            .map(RoleResponse::from)
                            .collect(Collectors.toSet())
            );
        }
    }

    public record SimpleResponse(
            Long id,
            String name,
            String loginId
    ) {
        public static SimpleResponse from(User user) {
            return new SimpleResponse(
                    user.getId(),
                    user.getName(),
                    user.getLoginId()
            );
        }
    }

    public record RoleResponse(
            Long id,
            String name
    ) {
        public static RoleResponse from(Role role) {
            return new RoleResponse(role.getId(), role.getName());
        }
    }
}