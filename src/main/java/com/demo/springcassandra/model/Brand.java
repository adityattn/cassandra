package com.demo.springcassandra.model;


import org.springframework.data.cassandra.core.mapping.PrimaryKey;

public class Brand {

    @PrimaryKey
    private String id;
    private String contentId;
    private String title;
    private String description;

    public Brand() {

    }

    public String getContentId() {
        return contentId;
    }

    public Brand setContentId(String contentId) {
        this.contentId = contentId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Brand setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Brand setDescription(String description) {
        this.description = description;
        return this;
    }

    public Brand(String id, String contentId, String title, String description) {
        this.id = id;
        this.contentId = contentId;
        this.title = title;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public Brand setId(String id) {
        this.id = id;
        return this;
    }
}

