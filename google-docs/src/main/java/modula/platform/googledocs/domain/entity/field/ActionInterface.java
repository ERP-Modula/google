package modula.platform.googledocs.domain.entity.field;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ActionInterface {
    private String name;
    private InterfaceFieldType type;
    private String label;
    private Boolean time;
    private List<ActionInterface> spec;
}
