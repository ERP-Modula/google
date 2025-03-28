package modula.platform.google.domain.entity.token;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "google_tokens")
public class GoogleToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userEmail;

    @Column(length = 2048)
    private String accessToken;

    @Column(length = 2048)
    private String idToken;

    @Column(length = 2048)
    private String refreshToken;

    @Column(length = 2048)
    private String scopes;
}
