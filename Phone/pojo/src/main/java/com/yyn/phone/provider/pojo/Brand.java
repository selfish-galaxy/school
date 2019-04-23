package com.yyn.phone.provider.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler","fieldHandler"})
public class Brand implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Integer id;

//    private Integer bId;

    private String bName;

    private String bImg;

    private String introduction;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public Integer getbId() {
//        return bId;
//    }
//
//    public void setbId(Integer bId) {
//        this.bId = bId;
//    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public String getbImg() {
        return bImg;
    }

    public void setbImg(String bImg) {
        this.bImg = bImg;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
