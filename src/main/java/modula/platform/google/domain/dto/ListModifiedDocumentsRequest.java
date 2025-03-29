package modula.platform.google.domain.dto;

import lombok.Data;

@Data
public class ListModifiedDocumentsRequest {
    private String folderId;
    private String userEmail;
    private String modifiedTime;
}
