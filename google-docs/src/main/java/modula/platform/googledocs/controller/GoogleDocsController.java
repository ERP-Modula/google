package modula.platform.googledocs.controller;

import com.google.api.services.drive.model.File;
import lombok.RequiredArgsConstructor;
import modula.platform.googledocs.core.GoogleDocsService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class GoogleDocsController {

    private final GoogleDocsService googleDocsService;

    @GetMapping("/docs/list")
    public List<File> listDocuments(@AuthenticationPrincipal OAuth2AuthenticationToken authentication) throws Exception {
        return googleDocsService.getAllDocuments(authentication.getName());
    }
}
