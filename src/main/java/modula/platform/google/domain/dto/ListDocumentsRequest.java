package modula.platform.google.domain.dto;

import lombok.Data;

@Data
public class ListDocumentsRequest {
    private String folderId;
    private String userEmail;
}
