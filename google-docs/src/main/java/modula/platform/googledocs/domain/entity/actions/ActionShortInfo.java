package modula.platform.googledocs.domain.entity.actions;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ActionShortInfo {
    private UUID id;
    private String name;
    private String label;
    private String description;
    private String category;
}
