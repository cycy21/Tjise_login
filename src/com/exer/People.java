package com.exer;

/**
 * @Auther:hsd
 * @Date:2021/3/5-03-05-15:25
 * @Description:
 * @version: 1.0
 */
public class People {
    public static int NUM = 0;
    private String name;
    private String tel;
    private Member info;

    public People() {
    }

    public People(String name, String tel) {
        NUM = NUM + 1;
        this.name = name;
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Member getInfo() {
        return info;
    }

    public void setInfo(Member info) {
        this.info = info;
    }

}
