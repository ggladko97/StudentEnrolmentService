package com.wsiiz.studentservice.model;

import java.io.Serializable;
import java.util.Set;


/**
 * Created by ggladko97 on 12.11.17.
 */
public class Univercity implements Serializable{
    private int id;
    private String title;
    private String localization;

    private Set<Opinion> opinionss;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocalization() {
        return localization;
    }

    public void setLocalization(String localization) {
        this.localization = localization;
    }

    public Set<Opinion> getOpinionss() {
        return opinionss;
    }

    public void setOpinionss(Set<Opinion> opinionss) {
        this.opinionss = opinionss;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Univercity that = (Univercity) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (localization != null ? !localization.equals(that.localization)
                : that.localization != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (localization != null ? localization.hashCode() : 0);
        return result;
    }
}
