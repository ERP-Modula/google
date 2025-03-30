package modula.platform.google.core;

import com.modula.common.domain.moduleconfiguration.ModuleConfiguration;
import com.modula.common.dto.moduleconfiguration.ModuleConfigurationShortInfoDTO;
import lombok.RequiredArgsConstructor;
//import modula.platform.googledocs.repository.ActionInterfaceRepository;
import modula.platform.google.core.mapper.ModuleShortInfoMapper;
import modula.platform.google.repository.ModuleConfigurationRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApiManagerService {

    private final ModuleShortInfoMapper moduleShortInfoMapper;
    private final ModuleConfigurationRepository moduleConfigurationRepository;

    public ModuleConfiguration getModuleInfo() {
        return moduleConfigurationRepository.findByName("googledocs").orElseThrow();
    }

    public ModuleConfigurationShortInfoDTO getModuleShortInfo() {
        ModuleConfiguration configuration = getModuleInfo();
        return moduleShortInfoMapper.mapToShortInfoDTO(configuration);
    }
}
