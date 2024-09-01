package com.example.mapper;

import com.example.dto.RegisterRequestDTO;

import com.example.model.RegisterRequest;

public class RegisterRequestMapper {

    public static RegisterRequestDTO toDTO(RegisterRequest registerRequest) {
        if (registerRequest == null) {
            return null;
        }

        RegisterRequestDTO dto = new RegisterRequestDTO();
        dto.setEmail(registerRequest.getEmail());
        dto.setPassword(registerRequest.getPassword());
        return dto;
    }

    public static RegisterRequest toEntity(RegisterRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setEmail(dto.getEmail());
        registerRequest.setPassword(dto.getPassword());
        return registerRequest;
    }
}
