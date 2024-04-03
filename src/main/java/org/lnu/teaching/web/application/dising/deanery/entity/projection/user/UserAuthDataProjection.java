package org.lnu.teaching.web.application.dising.deanery.entity.projection.user;

public interface UserAuthDataProjection {
    String getUsername();
    String getPasswordHash();
    boolean getIsAdmin();
}
