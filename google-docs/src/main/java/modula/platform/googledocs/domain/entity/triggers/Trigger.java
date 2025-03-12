package modula.platform.googledocs.domain.entity.triggers;

import lombok.Data;
import modula.platform.googledocs.domain.entity.Category;
import modula.platform.googledocs.domain.entity.field.Field;

import java.util.List;


@Data
public class Trigger {
    private String name;
    private String description;
    private Category category;
    private Event event;
    private List<Field> producedFields;
}
