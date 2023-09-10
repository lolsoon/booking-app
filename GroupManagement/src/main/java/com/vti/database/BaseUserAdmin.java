package com.vti.database;

import com.vti.entity.Role;
import com.vti.entity.User;
import com.vti.entity.ERole;
import com.vti.entity.UserStatus;
import com.vti.repository.RoleRepository;
import com.vti.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class BaseUserAdmin {
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private UserRepository repository;
    @Autowired
    private RoleRepository roleRepository;

    @Bean
    CommandLineRunner initDatabase(RoleRepository roleRepository, UserRepository repository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Role role1 = new Role();
                role1.setId(1);
                role1.setName(ERole.ADMIN);

                Role role2 = new Role();
                role2.setId(2);
                role2.setName(ERole.CUSTOMER);
                if (roleRepository.findAll().size() == 0) {
                    roleRepository.save(role1);
                    roleRepository.save(role2);
                }
                if (repository.findAll().size() == 0) {
                    User admin = new User();
                    admin.setId(1);
                    admin.setUserName("dinhson");
                    admin.setEmail("sondinhkhac1998@gmail.com");
                    admin.setFirstName("Đinh Khắc");
                    admin.setLastName("Sơn");
                    admin.setAddress("Nam Định");
                    admin.setStatus(UserStatus.ACTIVE);
                    admin.setAvatarUrl("1613362949329.png");
                    Set<Role> roles = new HashSet<>();
                    admin.setPassword(encoder.encode("123456@"));
                    Role adminRole = roleRepository.findByName(ERole.ADMIN)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(adminRole);
                    admin.setRoles(roles);
                    repository.save(admin);
                }

            }
        };
    }
}
