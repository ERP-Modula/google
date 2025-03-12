package modula.platform.googledocs.domain.entity.triggers;

import lombok.Data;
import modula.platform.googledocs.domain.entity.field.Field;

import java.util.List;

@Data
public class Event {
    private String id;
    private List<Field> requiredFields;
}
