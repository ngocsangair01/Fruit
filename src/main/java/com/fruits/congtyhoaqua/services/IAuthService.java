package com.fruits.congtyhoaqua.services;

import com.fruits.congtyhoaqua.dtos.UserDTO;
import com.fruits.congtyhoaqua.filters.AuthenticationResponse;
import com.fruits.congtyhoaqua.payload.AuthenticationRequest;

import java.io.InvalidObjectException;

public interface IAuthService {
    AuthenticationResponse login(AuthenticationRequest authenticationRequest);
    AuthenticationResponse signup(UserDTO userDTO);
    AuthenticationResponse validateToken(AuthenticationResponse authenticationResponse) throws InvalidObjectException;
}
