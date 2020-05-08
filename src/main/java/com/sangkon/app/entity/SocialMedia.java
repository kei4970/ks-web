package com.sangkon.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SocialMedia {
    @Id
    @GeneratedValue
    private String instagram;
    private String facebook;
    private String twitter;
    private String github;

    public SocialMedia(String instagram, String facebook, String twitter, String github){
        this.facebook = facebook;
        this.instagram = instagram;
        this.github = github;
        this.twitter = twitter;
    }

    public String getfacebook() {
        return facebook;
    }

    public void setfacebook(String facebook) {
        this.facebook = facebook;
    }
    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }
    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }
    public String getTwitter() {
        return twitter;
    }

    public void set(String twitter) {
        this.twitter = twitter;
    }
}

