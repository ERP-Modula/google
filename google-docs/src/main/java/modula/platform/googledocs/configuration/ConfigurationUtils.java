package modula.platform.googledocs.configuration;


import modula.platform.googledocs.domain.entity.actions.Action;
import modula.platform.googledocs.domain.entity.field.Field;
import modula.platform.googledocs.domain.entity.field.FieldType;
import modula.platform.googledocs.domain.entity.triggers.Trigger;

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

    public static void putAvailableActions(List<Action> actions) {

        actions.add(
            getListFilesAction()
        );
    }



    public static void putAvailableTriggers(List<Trigger> triggers) {

    }
}
