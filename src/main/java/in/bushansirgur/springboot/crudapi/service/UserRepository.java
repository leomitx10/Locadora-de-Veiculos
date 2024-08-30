package in.bushansirgur.springboot.crudapi.service;

import org.springframework.data.jpa.repository.JpaRepository;

import in.bushansirgur.springboot.crudapi.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
