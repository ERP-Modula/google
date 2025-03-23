package modula.platform.googledocs.domain.entity.field;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
//@Builder
@Entity
@Table(name = "action_interfaces")
public class ActionInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    // InterfaceFieldType
    private String type;
    private String label;
    private Boolean time;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ActionInterface> spec;
}
