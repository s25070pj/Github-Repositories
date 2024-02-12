package com.atipera.githubRepositories.domain.advice;

import com.atipera.githubRepositories.infrastructure.controller.GithubController;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice(assignableTypes = GithubController.class)
public class ApiValidationErrorHandler {
    @ExceptionHandler(FeignException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrorResponse handleException(FeignException exception) {
        return new ApiErrorResponse(HttpStatus.NOT_FOUND, "User not found");
    }

}