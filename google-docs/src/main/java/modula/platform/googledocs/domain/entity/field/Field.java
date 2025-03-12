package modula.platform.googledocs.domain.entity.field;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Field {
    private String key;
    private FieldType type;
//    private String value;
}
