package modula.platform.googledocs.domain.dto;

import lombok.Data;

@Data
public class ListDocumentsRequest {
    private String folderId;
    private String userEmail;
}
