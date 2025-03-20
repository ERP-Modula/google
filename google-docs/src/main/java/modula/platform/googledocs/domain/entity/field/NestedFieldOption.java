package modula.platform.googledocs.domain.entity.field;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class NestedFieldOption {
    private String label;
    private String value;
    private InterfaceFieldType type;
    private List<ActionParameter> nested;
    private Boolean isDefaultValue;
}
