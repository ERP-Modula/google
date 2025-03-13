package modula.platform.googledocs.domain.entity;

import modula.platform.googledocs.domain.entity.actions.ActionShortInfo;
import modula.platform.googledocs.domain.entity.triggers.TriggerShortInfo;

import java.util.List;
import java.util.UUID;

public class ModuleInfo extends ModuleShortInfo {

    ModuleInfo(UUID id, String name, String label, String description, String iconPath, Boolean isPublic, String theme, List<ActionShortInfo> actions, List<TriggerShortInfo> triggers, List<String> categories) {
        super(id, name, label, description, iconPath, isPublic, theme, actions, triggers, categories);
    }
}
