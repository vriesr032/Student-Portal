package com.example.studentportal;

public class Portal {

    private String Title;
    private String Url;

    public Portal(String Title, String Url){
        this.setTitle(Title);
        this.setUrl(Url);
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }
}
