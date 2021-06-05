package ac.kr.soundofwind.service;


import ac.kr.soundofwind.model.User;
import ac.kr.soundofwind.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User signUp(User user) {
        System.out.println("----------"+user+"----------");
        return userRepository.save(user);
    }
}
