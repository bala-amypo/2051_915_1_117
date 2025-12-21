package com.example.demo.controller;

import com.example.demo.dto.UserAccountDTO;
import com.example.demo.service.UserAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserAccountController {

    private final UserAccountService service;

    public UserAccountController(UserAccountService service) {
        this.service = service;
    }

    @PostMapping
    public UserAccountDTO create(@RequestBody UserAccountDTO dto) {
        return service.createUser(dto);
    }

    @GetMapping("/{id}")
    public UserAccountDTO getById(@PathVariable Long id) {
        return service.getUserById(id);
    }

    @GetMapping
    public List<UserAccountDTO> getAll() {
        return service.getAllUsers();
    }

    @PutMapping("/{id}")
    public UserAccountDTO update(@PathVariable Long id,
                                 @RequestBody UserAccountDTO dto) {
        return service.updateUser(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteUser(id);
    }
}
