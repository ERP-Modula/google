package modula.platform.googledocs.domain.entity.actions;


import lombok.Builder;
import lombok.Data;
import modula.platform.googledocs.domain.entity.field.ActionInterface;
import modula.platform.googledocs.domain.entity.field.ActionParameter;

import java.util.List;

@Data
@Builder
public class Action {
    private String name;
    private String label;
    private String description;
    private List<ActionInterface> outputInterface;
    private List<ActionParameter> inputParameters;
}
