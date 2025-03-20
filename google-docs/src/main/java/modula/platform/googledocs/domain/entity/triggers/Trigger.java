package modula.platform.googledocs.domain.entity.triggers;

import lombok.Data;
import modula.platform.googledocs.domain.entity.field.ActionInterface;
import modula.platform.googledocs.domain.entity.field.ActionParameter;

import java.util.List;


@Data
public class Trigger {
    private String name;
    private String label;
    private String description;
    private List<ActionInterface> outputInterface;
    private List<ActionParameter> inputParameters;
}
