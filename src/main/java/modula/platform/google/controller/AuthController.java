package modula.platform.google.controller;

import lombok.RequiredArgsConstructor;
import modula.platform.google.core.TokenService;
import modula.platform.google.domain.dto.AuthCodeDTO;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class AuthController {

    private final TokenService tokenService;

    @PostMapping("/login")
    public void login(@RequestBody AuthCodeDTO authCodeDTO) throws IOException {
        tokenService.handleAuthCode(authCodeDTO.getCode());
    }
}
