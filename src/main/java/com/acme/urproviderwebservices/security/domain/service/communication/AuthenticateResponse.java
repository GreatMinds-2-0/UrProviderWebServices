package com.acme.urproviderwebservices.security.domain.service.communication;

import com.acme.urproviderwebservices.security.resource.AuthenticateResource;
import com.acme.urproviderwebservices.shared.domain.service.comunnication.BaseResponse;

public class AuthenticateResponse extends BaseResponse<AuthenticateResource> {

    public AuthenticateResponse(String message){ super(message);}
    public AuthenticateResponse(AuthenticateResource resource){super(resource);}
}
