package com.atipera.githubRepositories.infrastructure.controller;

import com.atipera.githubRepositories.domain.model.Repository;
import com.atipera.githubRepositories.domain.service.GithubService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/repositories")
public class GithubController {

    private final GithubService githubService;

    public GithubController(GithubService githubService) {
        this.githubService = githubService;
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Repository>> getCompleteRepositories(@PathVariable String name) {
        List<Repository> completeRepositories = githubService.getRepositories(name);
        return ResponseEntity.ok(completeRepositories);
    }
}