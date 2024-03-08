package com.idp.server.auth;

import com.idp.server.dto.AuthResponseDto;
import com.idp.server.dto.LoginDto;
import com.idp.server.dto.RegisterDto;
import com.idp.server.security.CustomUserDetailService;
import com.idp.server.security.JWTGenerator;
import com.idp.server.session.Session;
import com.idp.server.session.SessionRepository;
import com.idp.server.user.UserEntity;
import com.idp.server.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {
    private AuthenticationManager authenticationManager;
    private SessionRepository sessionRepository;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private JWTGenerator jwtGenerator;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager,
                          UserRepository userRepository,
                          PasswordEncoder passwordEncoder,
                          JWTGenerator jwtGenerator,
                          SessionRepository sessionRepository) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;
        this.sessionRepository = sessionRepository;
    }

    @PostMapping("login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginDto loginDto) {
        Optional<UserEntity> userOptional = userRepository.findByUsername(loginDto.getUsername());
        if (userOptional.isPresent()) {
            UserEntity user = userOptional.get();
            Session session = sessionRepository.findByUserId(user.getId());
            if (passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
                String token = jwtGenerator.generateToken(loginDto.getUsername());
                return new ResponseEntity<>(new AuthResponseDto(token, user, session), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new AuthResponseDto("Password does not match username!"),
                        HttpStatus.UNAUTHORIZED);
            }
        } else {
            return new ResponseEntity<>(new AuthResponseDto("Username not found!"), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        UserEntity user = new UserEntity();
        user.setUsername(registerDto.getUsername());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        user.setFirstName(registerDto.getFirstName());
        user.setLastName(registerDto.getLastName());
        user.setPhoneNo(registerDto.getPhoneNo());
        userRepository.save(user);

        Session session = new Session(user.getId(), 0);
        sessionRepository.save(session);

        System.out.println(registerDto.getPassword());
        System.out.println(user.getPassword());
        System.out.println(passwordEncoder.matches(registerDto.getPassword(), user.getPassword()));

        return new ResponseEntity<>("User successfully registered!", HttpStatus.OK);
    }
}
