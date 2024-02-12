package com.atipera.githubRepositories.domain.dto;

import com.atipera.githubRepositories.domain.model.Branch;
import com.atipera.githubRepositories.domain.model.Owner;

import java.util.List;

public record RepositoryDto(String name, boolean fork, Owner owner, List<Branch> branches) {
}
