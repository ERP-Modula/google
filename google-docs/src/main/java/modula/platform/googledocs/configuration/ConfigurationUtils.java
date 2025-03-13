package modula.platform.googledocs.configuration;


import modula.platform.googledocs.domain.entity.Category;
import modula.platform.googledocs.domain.entity.actions.Action;
import modula.platform.googledocs.domain.entity.actions.ActionShortInfo;
import modula.platform.googledocs.domain.entity.field.Field;
import modula.platform.googledocs.domain.entity.field.FieldType;
import modula.platform.googledocs.domain.entity.triggers.TriggerShortInfo;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

public class ConfigurationUtils {

    private static Action getListFilesAction() {
        Field field = new Field("folderId", FieldType.STRING);
        List<Field> requiredFields = new ArrayList<>();
        requiredFields.add(field);

        return Action.builder()
                .name("list files")
                .requiredFields(requiredFields)
                .producedFields(new ArrayList<>())
                .build();
    }

    private static ActionShortInfo getListFilesActionShortInfo() {
        return ActionShortInfo.builder()
                // id не должен быть рандомным
                .id(UUID.randomUUID())
                .name("listFiles")
                .label("List Documents")
                .description("Retrieve a list of documents")
                .category(Category.DOCUMENT.getName())
                .build();
    }

    public static void putAvailableActionsShortInfo(List<ActionShortInfo> actions) {
        actions.add(
                getListFilesActionShortInfo()
        );
    }



    public static void putAvailableTriggersShortInfo(List<TriggerShortInfo> triggers) {

    }
}
