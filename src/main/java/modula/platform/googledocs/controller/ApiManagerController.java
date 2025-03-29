package modula.platform.googledocs.controller;


import com.modula.common.domain.moduleconfiguration.ModuleConfiguration;
import lombok.RequiredArgsConstructor;
import modula.platform.googledocs.core.ApiManagerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1")
public class ApiManagerController {

    private final ApiManagerService apiManagerService;

//    @GetMapping("/module/short-metadata")
//    public ModuleShortInfo getShortModuleApi() {
//        return apiManagerService.getModuleShortInfo();
//    }

    @GetMapping("/module/metadata")
    public ModuleConfiguration getModuleApi() {
        return apiManagerService.getModuleInfo();
    }
}
