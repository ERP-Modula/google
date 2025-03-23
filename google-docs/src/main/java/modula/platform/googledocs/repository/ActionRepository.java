package modula.platform.googledocs.repository;

import modula.platform.googledocs.domain.entity.actions.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionRepository extends JpaRepository<Action, Long> {
}
