package com.example.demo.controller;

import com.example.demo.dto.LoginEventDTO;
import com.example.demo.service.LoginEventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/login-events")
public class LoginEventController {

    private final LoginEventService service;

    public LoginEventController(LoginEventService service) {
        this.service = service;
    }

    @PostMapping
    public LoginEventDTO create(@RequestBody LoginEventDTO dto) {
        return service.createLoginEvent(dto);
    }

    @GetMapping("/{id}")
    public LoginEventDTO getById(@PathVariable Long id) {
        return service.getLoginEventById(id);
    }

    @GetMapping
    public List<LoginEventDTO> getAll() {
        return service.getAllLoginEvents();
    }

    @PutMapping("/{id}")
    public LoginEventDTO update(@PathVariable Long id,
                                @RequestBody LoginEventDTO dto) {
        return service.updateLoginEvent(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteLoginEvent(id);
    }
}
