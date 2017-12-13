package com.wsiiz.studentservice.model;


/**
 * Created by ggladko97 on 12.11.17.
 */
public class Opinion {
  private int id;
  private String content;
  private String date;

  private User userId;
  private Univercity univercityId;



  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public User getUserId() {
    return userId;
  }

  public void setUserId(User userId) {
    this.userId = userId;
  }

  public Univercity getUnivercityId() {
    return univercityId;
  }

  public void setUnivercityId(Univercity univercityId) {
    this.univercityId = univercityId;
  }

  @Override public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Opinion opinion = (Opinion) o;

    if (id != opinion.id) return false;
    if (content != null ? !content.equals(opinion.content) : opinion.content != null) return false;
    if (date != null ? !date.equals(opinion.date) : opinion.date != null) return false;

    return true;
  }

  @Override public int hashCode() {
    int result = id;
    result = 31 * result + (content != null ? content.hashCode() : 0);
    result = 31 * result + (date != null ? date.hashCode() : 0);
    return result;
  }
}
