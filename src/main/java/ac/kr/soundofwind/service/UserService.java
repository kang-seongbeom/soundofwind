package ac.kr.soundofwind.service;


import ac.kr.soundofwind.model.RoleType;
import ac.kr.soundofwind.model.User;
import ac.kr.soundofwind.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Transactional
    public User signUp(User user) {
        System.out.println("----------"+user+"----------");
        String rawPassword=user.getPassword(); //입력한 password
        String encPassword=encoder.encode(rawPassword); //해싱한 password
        user.setPassword(encPassword);
        user.setRole(RoleType.USER); //db의 정보 중 role만 자동적으로 입력이 되지 않기 때문에 넣어줘야 함.
        return userRepository.save(user);
    }
}
