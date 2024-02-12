package com.atipera.githubRepositories.domain.proxy;
import com.atipera.githubRepositories.domain.dto.RepositoryDto;
import com.atipera.githubRepositories.domain.model.Branch;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
@FeignClient(value = "github-client")
@Headers("Content-Type: application/json")
public interface GithubProxy {

    @GetMapping(value = "/users/{name}/repos")
    List<RepositoryDto> searchRepositories(@PathVariable String name);

    @GetMapping(value = "/repos/{name}/{repo}/branches")

    List<Branch> searchBranches(@PathVariable String name, @PathVariable String repo);
}
