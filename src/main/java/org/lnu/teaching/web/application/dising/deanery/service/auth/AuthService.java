package org.lnu.teaching.web.application.dising.deanery.service.auth;

import org.lnu.teaching.web.application.dising.deanery.annotation.Auth;
import org.lnu.teaching.web.application.dising.deanery.dto.user.UserCredentials;

public interface AuthService {
    void signIn(UserCredentials userCredentials);
    void verifyAuthority(Auth auth);
}
