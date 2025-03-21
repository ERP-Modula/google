//package modula.platform.googledocs.core;
//
//import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;
//import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
//import com.google.api.client.http.javanet.NetHttpTransport;
//import com.google.api.client.json.gson.GsonFactory;
//import lombok.RequiredArgsConstructor;
//import modula.platform.googledocs.configuration.GoogleProperties;
//import modula.platform.googledocs.domain.entity.token.GoogleToken;
//import modula.platform.googledocs.repository.TokenRepository;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//public class TokenService {
//
//    private final GoogleProperties googleProperties;
//    private final TokenRepository tokenRepository;
//
//    public void handleAuthCode(String code) throws IOException {
//        GoogleTokenResponse tokenResponse = new GoogleAuthorizationCodeTokenRequest(
//                new NetHttpTransport(),
//                GsonFactory.getDefaultInstance(),
//                googleProperties.getClientId(),
//                googleProperties.getClientSecret(),
//                code,
//                googleProperties.getRedirectUri()
//        ).execute();
//
//        saveTokens(tokenResponse);
//
//        System.out.println(tokenResponse.toPrettyString());
//    }
//
//    private void saveTokens(GoogleTokenResponse tokenResponse) throws IOException {
//
//        GoogleToken googleToken;
//        String userEmail = tokenResponse.parseIdToken().getPayload().getEmail();
//
//        Optional<GoogleToken> optionalGoogleToken = tokenRepository.findByUserEmail(userEmail);
//        googleToken = optionalGoogleToken.orElseGet(GoogleToken::new);
//
//        googleToken.setAccessToken(tokenResponse.getAccessToken());
//        googleToken.setRefreshToken(tokenResponse.getRefreshToken());
//        googleToken.setIdToken(tokenResponse.getIdToken());
//        googleToken.setScopes(tokenResponse.getScope());
//        googleToken.setUserEmail(userEmail);
//
//        tokenRepository.saveAndFlush(googleToken);
//    }
//
//    public Optional<GoogleToken> getTokenByUserEmail(String userEmail) {
//        return tokenRepository.findByUserEmail(userEmail);
//    }
//}
