package modula.platform.googledocs.core;

import com.google.api.client.auth.oauth2.BearerToken;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.JdbcOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.stereotype.Service;

import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GoogleDocsService {

    private final JdbcOAuth2AuthorizedClientService clientService;

    public List<File> getAllDocuments(String username) throws Exception {
        OAuth2AuthorizedClient client = clientService.loadAuthorizedClient("google", username);

        if (client == null) throw new RuntimeException("User not authenticated");

        Credential credential = new Credential(BearerToken.authorizationHeaderAccessMethod())
                .setAccessToken(client.getAccessToken().getTokenValue());

        Drive driveService = new Drive.Builder(
                new NetHttpTransport(),
                GsonFactory.getDefaultInstance(),
                credential
        ).setApplicationName("Google Drive App").build();

        FileList result = driveService.files().list()
                .setFields("nextPageToken, files(id, name, mimeType)")
                .execute();

        List<File> files = new ArrayList<>(result.getFiles());
        String nextPageToken = result.getNextPageToken();

        while (nextPageToken != null) {
            result = driveService.files().list()
                    .setPageToken(nextPageToken)
                    .setFields("nextPageToken, files(id, name, mimeType)")
                    .execute();
            files.addAll(result.getFiles());
            nextPageToken = result.getNextPageToken();
        }

        // Фильтруем только документы Google Docs
        files.removeIf(file -> !file.getMimeType().equals("application/vnd.google-apps.document"));

        return files;
    }
}
