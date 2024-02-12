package com.atipera.githubRepositories.domain.service;
import com.atipera.githubRepositories.domain.dto.RepositoryDto;
import com.atipera.githubRepositories.domain.model.Branch;
import com.atipera.githubRepositories.domain.model.Owner;
import com.atipera.githubRepositories.domain.model.Repository;
import com.atipera.githubRepositories.domain.proxy.GithubProxy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GithubService {

    public final GithubProxy githubProxy;

    public GithubService(GithubProxy githubProxy) {
        this.githubProxy = githubProxy;
    }

    public List<Repository> getRepositories(String name) {
        List<RepositoryDto> allRepositories = githubProxy.searchRepositories(name);
        List<Repository> repositories = new ArrayList<>();

        for (RepositoryDto dto : allRepositories) {
            if (!dto.fork()) {
                Repository repository = mapFromDto(dto);

                List<Branch> branches = githubProxy.searchBranches(name, repository.name());

                if (!branches.isEmpty()) {
                    Repository completeRepository = new Repository(repository.name(), new Owner(repository.owner().login()), branches);
                    repositories.add(completeRepository);
                }
            }
        }
        return repositories;
    }


    public Repository mapFromDto(RepositoryDto repositoryDto){
        return new Repository(repositoryDto.name(), repositoryDto.owner(), repositoryDto.branches());
    }
}
