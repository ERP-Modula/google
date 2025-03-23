package modula.platform.googledocs.domain.entity.actions;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import modula.platform.googledocs.domain.entity.field.ActionInterface;
import modula.platform.googledocs.domain.entity.field.ActionParameter;

import java.util.List;

@Data
@Entity
@Table(name = "actions")
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String label;
    private String description;
    private String category;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ActionInterface> outputInterface;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ActionParameter> inputParameters;
}
