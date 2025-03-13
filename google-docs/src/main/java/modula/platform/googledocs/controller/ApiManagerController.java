package modula.platform.googledocs.controller;


import lombok.RequiredArgsConstructor;
import modula.platform.googledocs.core.ApiManagerService;
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

    @GetMapping("/module/metadata")
    public ModuleShortInfo getModuleApi(@RequestParam(required = false) Optional<Boolean> shortInfo) {
        return shortInfo.orElse(false)
                ? apiManagerService.getModuleShortInfo()
                : apiManagerService.getModuleInfo();
    }
}
