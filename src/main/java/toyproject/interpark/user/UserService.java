package toyproject.interpark.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import toyproject.interpark.user.dto.SignUpRequest;
import toyproject.interpark.user.dto.SignInRequest;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // 회원 가입
    public User signUp(SignUpRequest request) {

        if (userRepository.existsByUserId(request.getUserId())) {
            throw new RuntimeException("이미 존재하는 아이디입니다.");
        }

        User newUser = new User();
        newUser.setUserId(request.getUserId());
        newUser.setUserPw(request.getUserPw());
        newUser.setUserName(request.getUserName());
        newUser.setUserAddr(request.getUserAddr());
        newUser.setUserPhone(request.getUserPhone());

        return userRepository.save(newUser);
    }

    // 로그인
    public String signIn(SignInRequest request) {
        String signInId = request.getUserId();
        String signInPW = request.getUserPw();

        User user = userRepository.findByUserId(signInId);
        if (user != null && signInPW.equals(user.getUserPw())) {
            return user.getUserName();
        }
        else if (user == null ) {
            throw new RuntimeException("로그인 실패 : 해당 아이디 없음");
        }
        else if (!signInId.equals(user.getUserPw())) {
            throw new RuntimeException("로그인 실패 : 비밀번호 불일치");
        }
        else {
             throw new RuntimeException("로그인 실패");
        }

    }

}
