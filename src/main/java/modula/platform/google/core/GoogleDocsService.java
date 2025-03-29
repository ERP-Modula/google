package modula.platform.google.core;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.GoogleCredentials;
import lombok.RequiredArgsConstructor;
import modula.platform.google.domain.dto.ListDocumentsRequest;
import modula.platform.google.domain.dto.ListModifiedDocumentsRequest;
import modula.platform.google.domain.entity.token.GoogleToken;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GoogleDocsService {

    private final TokenService tokenService;
    private final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();

    private String getListFilesQuery(String folderId, String mimeType) {
        String folder = folderId == null ? "root" : folderId;
        return String.format("'%s' in parents and mimeType='%s'", folder, mimeType);
    }

    private String getModifiedDocumentsQuery(String folderId, String modifiedDate) {
        String folder = folderId == null ? "root" : folderId;
        return String.format("'%s' in parents and mimeType='application/vnd.google-apps.document' and " +
                "modifiedTime > '%s'", folder, modifiedDate);
    }

    private List<File> getFilesFromFolderWithQuery(ListDocumentsRequest request, String query) throws GeneralSecurityException, IOException {
        GoogleToken googleToken = tokenService
                .getTokenByUserEmail(request.getUserEmail())
                .orElseThrow(() -> new RuntimeException("User not registered"));

        GoogleCredentials credentials = GoogleCredentials.newBuilder().setAccessToken(
                        AccessToken.newBuilder()
                                .setTokenValue(googleToken.getAccessToken())
                                .build()
                )
                .build()
                .createScoped(DriveScopes.DRIVE_METADATA);
        HttpRequestInitializer requestInitializer = new HttpCredentialsAdapter(
                credentials);

        NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();

        Drive service = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, requestInitializer)
                .setApplicationName("modula-google-docs")
                .build();

//        String query = getListFilesQuery(request.getFolderId(), mimeType);
        FileList result = service.files().list()
                .setQ(query)
                .execute();

        return result.getFiles();
    }

    public List<File> getDocumentsFromFolder(ListDocumentsRequest request) throws GeneralSecurityException, IOException {
        String query = getListFilesQuery(request.getFolderId(), "application/vnd.google-apps.document");
        return getFilesFromFolderWithQuery(request, query);
    }

    public List<File> getFoldersFromFolder(ListDocumentsRequest request) throws GeneralSecurityException, IOException {
        String query = getListFilesQuery(request.getFolderId(), "application/vnd.google-apps.folder");
        return getFilesFromFolderWithQuery(request, query);
    }

    public List<File> getModifiedDocumentsFromFolder(ListModifiedDocumentsRequest request) throws GeneralSecurityException, IOException {
        String query = getModifiedDocumentsQuery(request.getFolderId(), request.getModifiedTime());

        ListDocumentsRequest request1 = new ListDocumentsRequest();
        request1.setFolderId(request.getFolderId());
        request1.setUserEmail(request.getUserEmail());

        return getFilesFromFolderWithQuery(request1, query);
    }
}
