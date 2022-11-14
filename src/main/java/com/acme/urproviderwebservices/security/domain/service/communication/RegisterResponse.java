package com.acme.urproviderwebservices.security.domain.service.communication;

import com.acme.urproviderwebservices.security.resource.UserResource;
import com.acme.urproviderwebservices.shared.domain.service.comunnication.BaseResponse;

public class RegisterResponse extends BaseResponse<UserResource> {
    public RegisterResponse(String message){super(message);}
    public RegisterResponse(UserResource resource){super(resource);}
}
