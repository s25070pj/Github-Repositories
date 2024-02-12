package com.atipera.githubRepositories.domain.advice;

import org.springframework.http.HttpStatus;

public record ApiErrorResponse(HttpStatus status, String message) {
}
