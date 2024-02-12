# github-Repositories

Acceptance criteria:

FIRST As an api consumer, given username (s25070) for thus example and header “Accept: application/json”, List all his github repositories, which are not forks.

Information, which I require in the response, is: Repository Name, Owner Login and for each branch it’s name and last commit sha

![image](https://github.com/s25070pj/githubRepositories/assets/92248838/de0b0f18-e19c-4902-a5aa-438cc94c78fb)

As an api consumer, given not existing github user, I would like to receive 404 response in such a format:

{

    “status”: ${responseCode}

    “message”: ${whyHasItHappened}

}


 ![image](https://github.com/s25070pj/githubRepositories/assets/92248838/cd2b4c7c-9891-4332-8489-a70bf45a5e67)
