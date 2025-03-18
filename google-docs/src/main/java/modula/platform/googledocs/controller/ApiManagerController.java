package modula.platform.googledocs.controller;


import lombok.RequiredArgsConstructor;
import modula.platform.googledocs.core.ApiManagerService;
import modula.platform.googledocs.domain.entity.ModuleInfo;
import modula.platform.googledocs.domain.entity.ModuleShortInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1")
public class ApiManagerController {

    private final ApiManagerService apiManagerService;

    @GetMapping("/module/shortMetadata")
    public ModuleShortInfo getShortModuleApi() {
        return apiManagerService.getModuleShortInfo();
    }

    @GetMapping("/module/metadata")
    public ModuleInfo getModuleApi() {
        return apiManagerService.getModuleInfo();
    }
}
