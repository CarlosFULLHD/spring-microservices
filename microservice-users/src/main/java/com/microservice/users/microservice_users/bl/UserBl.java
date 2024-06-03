package com.microservice.users.microservice_users.bl;

import com.microservice.users.microservice_users.dao.RoleRepository;
import com.microservice.users.microservice_users.dao.RoleUserRepository;
import com.microservice.users.microservice_users.dao.UserRepository;
import com.microservice.users.microservice_users.dao.VehicleRepository;
import com.microservice.users.microservice_users.entity.RoleEntity;
import com.microservice.users.microservice_users.entity.UserEntity;
import com.microservice.users.microservice_users.entity.VehicleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserBl {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final RoleUserRepository roleUserRepository;
    private final VehicleRepository vehicleRepository;

    @Autowired
    public UserBl(UserRepository userRepository, RoleRepository roleRepository, RoleUserRepository roleUserRepository, VehicleRepository vehicleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.roleUserRepository = roleUserRepository;
        this.vehicleRepository = vehicleRepository;
    }

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    public Optional<UserEntity> findById(Long id) {
        return userRepository.findById(id);
    }

    public UserEntity save(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public List<RoleEntity> findAllRoles() {
        return roleRepository.findAll();
    }

    public List<VehicleEntity> findAllVehiclesByUserId(Long userId) {
        return vehicleRepository.findAllByUserId(userId);
    }

    // Más métodos según sea necesario
}
