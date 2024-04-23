package br.victoremerick.khipoteste.infrastructure.auth.api;

import br.victoremerick.khipoteste.infrastructure.auth.model.dto.LoginResponseDTO;
import br.victoremerick.khipoteste.infrastructure.auth.service.AuthenticationService;
import br.victoremerick.khipoteste.infrastructure.auth.service.JwtService;
import br.victoremerick.khipoteste.infrastructure.auth.model.dto.LoginUserDTO;
import br.victoremerick.khipoteste.infrastructure.auth.model.dto.RegisterUserDTO;
import br.victoremerick.khipoteste.user.model.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterUserDTO registerUserDto) {
        User registeredUser = authenticationService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> authenticate(@RequestBody LoginUserDTO loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponseDTO loginResponseDTO = LoginResponseDTO.builder()
                .token(jwtToken)
                .expiresIn(jwtService.getExpirationTime())
                .build();

        return ResponseEntity.ok(loginResponseDTO);
    }
}
