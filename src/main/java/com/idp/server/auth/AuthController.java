package com.idp.server.auth;

import com.idp.server.dto.AuthResponseDto;
import com.idp.server.dto.LoginDto;
import com.idp.server.dto.RegisterDto;
import com.idp.server.security.CustomUserDetailService;
import com.idp.server.security.JWTGenerator;
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
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private JWTGenerator jwtGenerator;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager,
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JWTGenerator jwtGenerator) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping("login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginDto loginDto) {
        Optional<UserEntity> userOptional = userRepository.findByUsername(loginDto.getUsername());
        if (userOptional.isPresent()) {
            UserEntity user = userOptional.get();
            if (passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
                String token = jwtGenerator.generateToken(loginDto.getUsername());
                return new ResponseEntity<>(new AuthResponseDto(token), HttpStatus.OK);
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
        userRepository.save(user);

        System.out.println(registerDto.getPassword());
        System.out.println(user.getPassword());
        System.out.println(passwordEncoder.matches(registerDto.getPassword(), user.getPassword()));

        return new ResponseEntity<>("User successfully registered!", HttpStatus.OK);
    }
}
