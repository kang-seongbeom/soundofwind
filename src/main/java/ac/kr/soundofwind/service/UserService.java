package ac.kr.soundofwind.service;


import ac.kr.soundofwind.domain.RoleType;
import ac.kr.soundofwind.domain.User;
import ac.kr.soundofwind.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Transactional
    public void signUp(User user) {
        String rawPassword = user.getPassword(); //입력한 password
        String encPassword = encoder.encode(rawPassword); //해싱한 password
        user.setPassword(encPassword);
        user.setRole(RoleType.USER); //db의 정보 중 role만 자동적으로 입력이 되지 않기 때문에 넣어줘야 함.
        userRepository.save(user);
    }

    @Transactional
    public void updateApi(User user) {
        String rawPassword = user.getPassword();
        String encPassword = encoder.encode(rawPassword);
        userRepository.updateUser(user.getEmail(), encPassword, user.getId());

    }
}
