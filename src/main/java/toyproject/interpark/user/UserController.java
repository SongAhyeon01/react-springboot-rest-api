package toyproject.interpark.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import toyproject.interpark.user.dto.SignInRequest;
import toyproject.interpark.user.dto.SignUpRequest;

@Tag(name = "users", description = "회원가입 및 로그인 api")
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "회원 가입")
    @PostMapping("/sign_up")
    public ResponseEntity<String> signUp(@RequestBody SignUpRequest request) {
        userService.signUp(request);
        return ResponseEntity.ok("가입이 완료되었습니다.");
    }

    @Operation(summary = "로그인")
    @PostMapping("/sign_in")
    public ResponseEntity<String> signIn(@RequestBody SignInRequest request) {
        String signInName = userService.signIn(request);
        return ResponseEntity.ok(signInName + " 님 반갑습니다!");
    }


}
