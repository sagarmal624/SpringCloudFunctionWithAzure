package com.example.hellofunction.azurehandler;

import com.example.hellofunction.domains.User;
import com.example.hellofunction.util.ResponseDTO;
import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.BindingName;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import org.springframework.cloud.function.adapter.azure.AzureSpringBootRequestHandler;

import java.util.Optional;

public class UserHandler extends AzureSpringBootRequestHandler<Object, ResponseDTO> {

    @FunctionName("userSave")
    public ResponseDTO save(
            @HttpTrigger(name = "userSaveRequest", methods = {HttpMethod.POST}, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<User>> request,
            ExecutionContext context) {
        return handleRequest(request.getBody().get(), context);
    }

    @FunctionName("userGet")
    public ResponseDTO get(
            @HttpTrigger(name = "userGetRequest", methods = {HttpMethod.GET}, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage request,
            @BindingName("id") Integer id, ExecutionContext context) {
        return handleRequest(id, context);
    }

    @FunctionName("userDelete")
    public ResponseDTO delete(
            @HttpTrigger(name = "userDeleteRequest", methods = {HttpMethod.DELETE}, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage request,
            @BindingName("id") Integer id, ExecutionContext context) {
        return handleRequest(id, context);
    }

    @FunctionName("userUpdate")
    public ResponseDTO update(
            @HttpTrigger(name = "userUpdateRequest", methods = {HttpMethod.PUT}, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<User>> request,
            ExecutionContext context) {
        return handleRequest(request.getBody().get(), context);
    }

    @FunctionName("userProfile")
    public ResponseDTO profile(
            @HttpTrigger(name = "userProfileRequest", methods = {HttpMethod.GET}, route = "profile/{id}", authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage request,
            @BindingName("id") String id, ExecutionContext context) {
        return handleRequest(id, context);
    }
}