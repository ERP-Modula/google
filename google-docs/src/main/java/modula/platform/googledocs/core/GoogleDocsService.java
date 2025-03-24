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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GoogleDocsService {

    private final TokenService tokenService;
    private final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();

    public List<File> getFilesFromFolder(ListDocumentsRequest request) throws GeneralSecurityException, IOException {
        GoogleToken googleToken = tokenService
                .getTokenByUserEmail(request.getUserEmail())
                .orElseThrow(() -> new RuntimeException("User not registered"));

        String folderId = request.getFolderId();
        String accessToken = googleToken.getAccessToken();


        GoogleCredentials credentials = GoogleCredentials.newBuilder().setAccessToken(
                AccessToken.newBuilder()
//                        .setScopes(googleToken.getScopes())
                        .setTokenValue(googleToken.getAccessToken())
                        .build()
                )
                .build()
                .createScoped(DriveScopes.DRIVE_METADATA)
                ;
//                .createScoped(Arrays.asList(DriveScopes.DRIVE_FILE));
        HttpRequestInitializer requestInitializer = new HttpCredentialsAdapter(
                credentials);

//        GoogleCredentials.create(AccessToken.newBuilder()
//                        .setTokenValue(accessToken)
//                        .setScopes(googleToken.getScopes())
//
//                .build());

        NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();

//        Drive service = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, req -> {
//            req.getHeaders().setAuthorization("Bearer " + accessToken);
//        })
//                .setApplicationName("modula-google-docs")
//                .build();

        Drive service = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, requestInitializer)
                .setApplicationName("modula-google-docs")
                .build();



        // Фильтр для получения только папок
        String query = folderId == null ?
                "'root' in parents and mimeType='application/vnd.google-apps.folder'" : // Корневая папка
                "'" + folderId + "' in parents and mimeType='application/vnd.google-apps.folder'"; // Указанная папка

        String query1 = "'1iKiPFlJv-1pX0Pspy9G7BNZsfUNoZN1g' in parents";



        String pageToken = null;
        FileList result = service.files().list()
                .setQ("mimeType='application/vnd.google-apps.document'")
//                .setQ("mimeType='image/jpeg'")
//                .setSpaces("drive")
//                .setFields("nextPageToken, files(id, name)")
//                .setPageToken(pageToken)
                .execute();

        return result.getFiles();
    }
}
