package in.bushansirgur.springboot.crudapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.bushansirgur.springboot.crudapi.model.User;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
}

