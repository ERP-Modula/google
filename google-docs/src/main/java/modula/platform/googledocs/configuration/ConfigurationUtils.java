package modula.platform.googledocs.configuration;


import com.google.api.services.drive.model.File;
import modula.platform.googledocs.domain.entity.Category;
import modula.platform.googledocs.domain.entity.actions.Action;
import modula.platform.googledocs.domain.entity.actions.ActionShortInfo;
import modula.platform.googledocs.domain.entity.field.*;
import modula.platform.googledocs.domain.entity.triggers.Trigger;
import modula.platform.googledocs.domain.entity.triggers.TriggerShortInfo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.UUID;
import java.util.List;

public class ConfigurationUtils {

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

    private static TriggerShortInfo getWatchDocumentsShortTriggerInfo() {
        return TriggerShortInfo.builder()
                .id(UUID.randomUUID())
                .name("watchDocuments")
                .label("Watch Documents")
                .description("Triggers when a new document is created or modified in a specific folder")
                .category(Category.DOCUMENT.getName())
                .build();
    }

//    private static Action getListFilesActionInfo() {
//        return Action.builder()
//                .name("listFiles")
//                .label("List Documents")
//                .description("Retrieve a list of documents")
//                .inputParameters(getListFilesActionParameters())
//                .outputInterface(getListFilesOutputInterface())
//                .build();
//    }

    private static List<ActionParameter> getListFilesActionParameters() {
        List<ActionParameter> out = new ArrayList<>();

//        List<NestedFieldOption> destinationNestedOptions = new ArrayList<>();
//        destinationNestedOptions.add(
//                NestedFieldOption.builder()
//                        .value("drive")
//                        .label("My Drive")
//                        .type(InterfaceFieldType.STRING)
//                        .isDefaultValue(true)
//                        .build()
//        );

//        List<ActionParameter> destinationSpec = new ArrayList<>();
//        destinationSpec.add(
//                ActionParameter.builder()
//                        .name("folder")
//                        .label("File ID")
//                        .type(ParameterType.STRING)
//                        .build()
//        );

//        List<ActionParameter> connectionSpec = new ArrayList<>();
//        connectionSpec.add(
//                ActionParameter.builder()
//                        .name("destination")
//                        .label("Destination")
//                        .required(true)
//                        .type(ParameterType.SELECT)
//                        .options(destinationNestedOptions)
//                        .spec(destinationSpec)
//                        .build()
//        );

//        ActionParameter actionParameter = ActionParameter.builder()
//                .name("connection")
//                .label("Connection")
//                .type(ParameterType.CONNECTION)
//                .required(true)
//                .spec(connectionSpec)
//                .build();
//        out.addLast(actionParameter);
        return out;
    }

    private static List<ActionInterface> getListFilesOutputInterface() {

        return convertClassToEntities(File.class);
    }

    public static void putAvailableActionsShortInfo(List<ActionShortInfo> actions) {
        actions.add(
                getListFilesActionShortInfo()
        );
    }

    public static void putAvailableTriggersShortInfo(List<TriggerShortInfo> triggers) {
        triggers.add(
                getWatchDocumentsShortTriggerInfo()
        );
    }

    public static List<Action> getAvailableActionsInfo() {
        List<Action> actions = new ArrayList<>();
//        actions.add(
//                getListFilesActionInfo()
//        );
        return actions;
    }

    public static List<Trigger> getAvailableTriggerInfo() {
        List<Trigger> triggers = new ArrayList<>();

        return triggers;
    }

    public static List<ActionInterface> convertClassToEntities(Class<?> clazz) {
        List<ActionInterface> entities = new ArrayList<>();

        // Получаем все поля класса, включая приватные
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            ActionInterface entity = new ActionInterface();
            entity.setName(field.getName());
            entity.setType(InterfaceFieldType.STRING.getName()); // Пример, можно адаптировать
            entity.setLabel(field.getName()); // Пример, можно адаптировать
            entity.setTime(false); // Пример, можно адаптировать

            // Если поле является сложным типом (например, вложенный класс), рекурсивно обрабатываем его
            if (!field.getType().isPrimitive() && !field.getType().getName().startsWith("java.")) {
                List<ActionInterface> nestedEntities = convertClassToEntities(field.getType());
                entity.setSpec(nestedEntities);
            }

            entities.add(entity);
        }

        return entities;
    }


}
