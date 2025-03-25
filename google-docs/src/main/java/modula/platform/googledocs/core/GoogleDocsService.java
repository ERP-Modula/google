package modula.platform.googledocs.core;

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
import modula.platform.googledocs.domain.dto.ListDocumentsRequest;
import modula.platform.googledocs.domain.entity.token.GoogleToken;
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

    private List<File> getFilesFromFolderWithMimeType(ListDocumentsRequest request, String mimeType) throws GeneralSecurityException, IOException {
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

        String query = getListFilesQuery(request.getFolderId(), mimeType);
        FileList result = service.files().list()
                .setQ(query)
                .execute();

        return result.getFiles();
    }

    public List<File> getDocumentsFromFolder(ListDocumentsRequest request) throws GeneralSecurityException, IOException {
        return getFilesFromFolderWithMimeType(request, "application/vnd.google-apps.document");
    }

    public List<File> getFoldersFromFolder(ListDocumentsRequest request) throws GeneralSecurityException, IOException {
        return getFilesFromFolderWithMimeType(request, "application/vnd.google-apps.folder");
    }
}
