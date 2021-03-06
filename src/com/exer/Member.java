package com.exer;

/**
 * @Auther:hsd
 * @Date:2021/3/5-03-05-15:32
 * @Description:
 * @version: 1.0
 */
public class Member {
    private String userName;
    private String passWord;
    private People p;
    public static Member[] members;

    public Member() {
    }

    public Member(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public People getP() {
        return p;
    }

    public void setP(People p) {
        this.p = p;
    }

    public Member[] getMembers() {
        return members;
    }

    public void setMembers(Member[] members) {
        this.members = members;
    }
}
