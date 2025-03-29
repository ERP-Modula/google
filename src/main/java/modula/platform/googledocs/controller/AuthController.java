package modula.platform.googledocs.controller;

import lombok.RequiredArgsConstructor;
import modula.platform.googledocs.core.TokenService;
import modula.platform.googledocs.domain.dto.AuthCodeDTO;
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
