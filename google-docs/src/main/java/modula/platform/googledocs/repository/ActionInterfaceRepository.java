package modula.platform.googledocs.repository;

import modula.platform.googledocs.domain.entity.field.ActionInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionInterfaceRepository extends JpaRepository<ActionInterface, Long> {

}
