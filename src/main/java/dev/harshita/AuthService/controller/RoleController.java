package dev.harshita.AuthService.controller;

import dev.harshita.AuthService.model.Role;
import dev.harshita.AuthService.repository.RoleRepository;
import dev.harshita.AuthService.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private RoleRepository roleRepository;

    @PostMapping
    public ResponseEntity createRole(@RequestBody Role role){

        return ResponseEntity.ok(roleRepository.save(role));
    }

    @GetMapping("/")
    public ResponseEntity getRoles(){
        return ResponseEntity.ok(roleRepository.findAll());
    }

}
