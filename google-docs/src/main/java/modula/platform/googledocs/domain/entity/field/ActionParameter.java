package modula.platform.googledocs.domain.entity.field;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
//@Builder
@Entity
@Table(name = "action_parameters")
public class ActionParameter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String label;
    // ParameterType
    private String type;
    private Boolean required;
    private String help;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "action_parameter_id", insertable = false, updatable = false)
    private List<NestedFieldOption> options;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "parent_action_parameter_id")
    private List<ActionParameter> spec;
}
