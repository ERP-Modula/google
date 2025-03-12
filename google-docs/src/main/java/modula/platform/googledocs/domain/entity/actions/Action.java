package modula.platform.googledocs.domain.entity.actions;


import lombok.Builder;
import lombok.Data;
import modula.platform.googledocs.domain.entity.Category;
import modula.platform.googledocs.domain.entity.field.Field;

import java.util.List;

@Data
@Builder
public class Action {
    private String name;
    private String description;
    private Category category;
    private List<Field> requiredFields;
    private List<Field> producedFields;
}
