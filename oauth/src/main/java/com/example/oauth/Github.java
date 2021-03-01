package com.example.oauth;

import com.spotify.github.v3.repos.Repository;

public class Github extends ApiBinging{
    public static final String GITHUB_API = "https://api.github.com/";

    public Github(String accessToken){
        super(accessToken);
    }

    public Repository[] getRepos(String name){
        return restTemplate.getForObject(
                GITHUB_API + "/users/" + name + "/repos",Repository[].class
        );
    }

}
