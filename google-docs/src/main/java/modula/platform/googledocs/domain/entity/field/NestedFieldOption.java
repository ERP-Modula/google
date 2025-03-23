package modula.platform.googledocs.domain.entity.field;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
//@Builder
@Entity
@Table(name = "nested_field_options")
public class NestedFieldOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String label;
    private String value;
    // InterfaceFieldType
    private String type;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ActionParameter> nested;
    private Boolean isDefaultValue;
}
