package modula.platform.googledocs.core;

import lombok.RequiredArgsConstructor;
import modula.platform.googledocs.configuration.ModuleConfiguration;
import modula.platform.googledocs.domain.entity.Module;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApiManagerService {

    private final ModuleConfiguration moduleConfiguration;

    public Module getModuleApi() {
        Module module = moduleConfiguration.getModuleModel();

        // возможно будут не всегда доступные действия и добавлять их можно здесь

        return module;
    }
}
