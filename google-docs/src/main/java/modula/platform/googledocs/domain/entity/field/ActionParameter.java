package modula.platform.googledocs.domain.entity.field;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ActionParameter {
    private String name;
    private String label;
    private ParameterType type;
    private Boolean required;
    private String help;
    private List<NestedFieldOption> options;
    private List<ActionParameter> spec;
}
