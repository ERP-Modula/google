package modula.platform.googledocs.domain.entity;

import lombok.Builder;
import lombok.Data;
import modula.platform.googledocs.domain.entity.actions.Action;
import modula.platform.googledocs.domain.entity.triggers.Trigger;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class ModuleInfo {
//    private ModuleShortInfo shortInfo;
    private UUID id;
    private String name;
    private String label;
    private String description;
    private String iconPath;
    private Boolean isPublic;
    private String theme;
    private List<Action> actions;
    private List<Trigger> triggers;
}
