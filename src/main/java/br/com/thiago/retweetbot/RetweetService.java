package br.com.thiago.retweetbot;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RetweetService {

    private final TwitterClientV1 twitterClientV1;
    private final TwitterClientV2 twitterClientV2;
    @Value("${oauth.consumerKey}")
    private String consumerKey;
    @Value("${oauth.consumerSecret}")
    private String consumerSecret;
    @Value("${oauth.accessToken}")
    private String accessToken;
    @Value("${oauth.accessTokenSecret}")
    private String accessTokenSecret;


    public void retweet(TweetSearchDto tweets, String bearerToken) throws JsonProcessingException, GeneralSecurityException, UnsupportedEncodingException {

        var userName = "BrazilMemeBot";

        var userResponse = twitterClientV2.getUserDataByUserName(userName, bearerToken).getBody();
        ObjectMapper mapper = new ObjectMapper();
        var userData = mapper.readValue(userResponse, User.class);
        var userId = userData.getData().getId();

        final var signature = computeSignature(accessToken, accessTokenSecret);

        final var oauthTimeStamp = Timestamp.from(Instant.now());

        var oauthNonce = UUID.randomUUID().toString();
        oauthNonce = oauthNonce.replaceAll("-","");

        final var signatureString = "OAuth oauth_consumer_key=" + consumerKey +
                ", oauth_nonce=" + oauthNonce + ", oauth_signature=" + signature +
                ", oauth_signature_method=\"HMAC-SHA1\", oauth_timestamp=" + oauthTimeStamp + ", " +
                "oauth_token=" + accessToken + ", oauth_version=\"1.0\"";

        tweets.getData().forEach(
                data -> twitterClientV1.retweetById(data.getId().toString(), signatureString)
        );
    }

    private static String computeSignature(String baseString, String keyString) throws GeneralSecurityException, UnsupportedEncodingException {

        SecretKey secretKey;

        byte[] keyBytes = keyString.getBytes();
        secretKey = new SecretKeySpec(keyBytes, "HmacSHA1");

        Mac mac = Mac.getInstance("HmacSHA1");

        mac.init(secretKey);

        byte[] text = baseString.getBytes();

        return new String(Base64.encodeBase64(mac.doFinal(text))).trim();
    }
}