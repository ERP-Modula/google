package modula.platform.google.controller;

import com.google.api.services.drive.model.File;
import lombok.RequiredArgsConstructor;
import modula.platform.google.core.GoogleDocsService;
import modula.platform.google.domain.dto.ListDocumentsRequest;
import modula.platform.google.domain.dto.ListModifiedDocumentsRequest;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

@RestController
@RequestMapping("api/v1/docs")
@RequiredArgsConstructor
public class GoogleDocsController {

    private final GoogleDocsService googleDocsService;

    @PostMapping("/documents")
    public List<File> getDocumentsFromFolder(@RequestBody ListDocumentsRequest request) throws GeneralSecurityException, IOException {
        return googleDocsService.getDocumentsFromFolder(request);
    }

    @PostMapping("/folders")
    public List<File> getFoldersFromFolder(@RequestBody ListDocumentsRequest request) throws GeneralSecurityException, IOException {
        return googleDocsService.getFoldersFromFolder(request);
    }

    @PostMapping("/documents/changes")
    public List<File> getChangedDocumentsFromFolder(@RequestBody ListModifiedDocumentsRequest request) throws GeneralSecurityException, IOException {
        return googleDocsService.getModifiedDocumentsFromFolder(request);
    }

}
