package demo.controller;

import demo.Entity.User;
import demo.Jwt.JwtUtil;
import demo.jwtResReq.UserRequest;
import demo.jwtResReq.UserResponse;
import demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController
{
    @Autowired
  private UserService userService;
    private JwtUtil jwtUtil;
    @PostMapping("/register")
    public ResponseEntity<Long> save(@RequestBody User employ) {
        Long employ1 = userService.save(employ);
        return ResponseEntity.status(HttpStatus.MULTI_STATUS).body(employ1);
    }
    public ResponseEntity<UserResponse>loginemploy(@RequestBody UserRequest employRequest)
    {
        String token=jwtUtil.generateToken(employRequest.getUsername());
        return ResponseEntity.ok(new UserResponse(token,"sucessfully generated")

        );
    }


}
