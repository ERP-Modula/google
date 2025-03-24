package modula.platform.googledocs.controller;

import com.google.api.services.drive.model.File;
import lombok.RequiredArgsConstructor;
import modula.platform.googledocs.core.GoogleDocsService;
import modula.platform.googledocs.domain.dto.ListDocumentsRequest;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

@RestController
@RequestMapping("api/v1/docs")
@RequiredArgsConstructor
public class GoogleDocsController {

    private final GoogleDocsService googleDocsService;

    @PostMapping
    public List<File> getDocumentsFromFolder(@RequestBody ListDocumentsRequest request) throws GeneralSecurityException, IOException {
        return googleDocsService.getFilesFromFolder(request);
    }

}
