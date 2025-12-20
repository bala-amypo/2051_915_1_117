package com.example.demo.service.impl;

import com.example.demo.dto.LoginEventDto;
import com.example.demo.entity.LoginEvent;
import com.example.demo.repository.LoginEventRepository;
import com.example.demo.service.LoginEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoginEventServiceImpl implements LoginEventService {

    @Autowired
    private LoginEventRepository loginEventRepository;

    private LoginEventDto mapToDto(LoginEvent entity) {
        return new LoginEventDto(
                entity.getId(),
                entity.getUserId(),
                entity.getTimestamp(),
                entity.isSuccess(),
                entity.getIpAddress()
        );
    }

    private LoginEvent mapToEntity(LoginEventDto dto) {
        return new LoginEvent(
                dto.getId(),
                dto.getUserId(),
                dto.getTimestamp(),
                dto.isSuccess(),
                dto.getIpAddress()
        );
    }

    @Override
    public List<LoginEventDto> getAllEvents() {
        return loginEventRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<LoginEventDto> getEventsByUserId(Long userId) {
        return loginEventRepository.findByUserId(userId)
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<LoginEventDto> getFailedEventsByUserId(Long userId) {
        return loginEventRepository.findByUserIdAndSuccess(userId, false)
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public LoginEventDto createEvent(LoginEventDto eventDto) {
        LoginEvent entity = mapToEntity(eventDto);
        LoginEvent saved = loginEventRepository.save(entity);
        return mapToDto(saved);
    }
}
