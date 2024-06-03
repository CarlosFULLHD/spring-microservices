package com.microservice.users.microservice_users.api;

import com.microservice.users.microservice_users.bl.UserBl;
import com.microservice.users.microservice_users.entity.RoleEntity;
import com.microservice.users.microservice_users.entity.UserEntity;
import com.microservice.users.microservice_users.entity.VehicleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserBl userBl;

    @Autowired
    public UserController(UserBl userBl) {
        this.userBl = userBl;
    }

    @GetMapping
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity> users = userBl.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable Long id) {
        Optional<UserEntity> user = userBl.findById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) {
        UserEntity savedUser = userBl.save(user);
        return ResponseEntity.ok(savedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userBl.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{userId}/roles")
    public ResponseEntity<List<RoleEntity>> getUserRoles(@PathVariable Long userId) {
        List<RoleEntity> roles = userBl.findAllRoles();
        return ResponseEntity.ok(roles);
    }

    @GetMapping("/{userId}/vehicles")
    public ResponseEntity<List<VehicleEntity>> getUserVehicles(@PathVariable Long userId) {
        List<VehicleEntity> vehicles = userBl.findAllVehiclesByUserId(userId);
        return ResponseEntity.ok(vehicles);
    }
}
