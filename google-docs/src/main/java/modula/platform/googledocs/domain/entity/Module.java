package modula.platform.googledocs.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import modula.platform.googledocs.domain.entity.actions.Action;
import modula.platform.googledocs.domain.entity.triggers.Trigger;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class Module {
    private UUID id;
    private String uniqueName;
    private List<Action> actions;
    private List<Trigger> triggers;
}
