package modula.platform.googledocs.domain.dto;

import lombok.Data;

@Data
public class ListModifiedDocumentsRequest {
    private String folderId;
    private String userEmail;
    private String modifiedTime;
}
