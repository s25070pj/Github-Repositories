package com.atipera.githubRepositories.model;

import java.util.List;

public record Repository(String name, Owner owner, List<Branch> branches) {
}
