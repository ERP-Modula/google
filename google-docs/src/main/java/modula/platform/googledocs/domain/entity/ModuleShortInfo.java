package modula.platform.googledocs.domain.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import modula.platform.googledocs.domain.entity.actions.Action;
import modula.platform.googledocs.domain.entity.actions.ActionShortInfo;
import modula.platform.googledocs.domain.entity.triggers.Trigger;
import modula.platform.googledocs.domain.entity.triggers.TriggerShortInfo;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class ModuleShortInfo {
    private UUID id;
    private String name;
    private String label;
    private String description;
    private String iconPath;
    private Boolean isPublic;
    private String theme;
    private List<ActionShortInfo> actions;
    private List<TriggerShortInfo> triggers;
    private List<String> categories;
}
