package modula.platform.google.repository;

import modula.platform.google.domain.entity.token.GoogleToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<GoogleToken, Long> {

    Optional<GoogleToken> findByUserEmail(String userEmail);
}
