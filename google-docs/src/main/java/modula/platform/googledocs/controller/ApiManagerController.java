package modula.platform.googledocs.controller;


import lombok.RequiredArgsConstructor;
import modula.platform.googledocs.core.ApiManagerService;
import modula.platform.googledocs.domain.entity.Module;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1")
public class ApiManagerController {

    private final ApiManagerService apiManagerService;

    @GetMapping("/module")
    public Module getModuleApi() {
        return apiManagerService.getModuleApi();
    }
}
