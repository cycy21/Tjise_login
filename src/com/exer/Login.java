package com.exer;

import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Auther:hsd
 * @Date:2021/3/5-03-05-16:24
 * @Description:
 * @version: 1.0
 */
public class Login {
    Scanner sc = new Scanner(System.in);
    //初始成员

    static{
        Member.members = new Member[]{
                new Member("zs","111111"),
                new Member("ls","222222")
        };
        Member.members[0].setP(new People("张三","14577889988"));
        Member.members[0].getP().setInfo(Member.members[0]);
        Member.members[1].setP(new People("李四","18866666666"));
        Member.members[1].getP().setInfo(Member.members[1]);
    }

    //程序入口
    public static void star(){
        System.out.println("------------欢迎您使用人员管理系统------------");
        new Login().input();
    }


    //用户输入
    public void input(){
        while (true){
            System.out.println("请选择您的操作：");
            System.out.println("1、登录");
            System.out.println("2、注册");
            int num = sc.nextInt();
            String temp = sc.nextLine(); //这个是接收空的\n字符的
            if (num == 1)
            {
                //输入信息操作
                String[] ininfo = getiinfo(); //得到输入信息
                //验证信息操作
                Object[] info = regist(ininfo[0],ininfo[1]);
                isTrue(info);
            }
            else if(num == 2){
                String[] ininfo = new String[2]; //得到输入信息
                boolean  flag = true;
                while (flag){
                    ininfo = getiinfo();
                    if (isTrueUserName(ininfo[0],ininfo[1])){
                        flag = false;
                    }
                }
                login(ininfo[0],ininfo[1]);
            }
        }
    }

    public String[] getiinfo(){
        System.out.print("请输入您的用户名：");
        String username= sc.nextLine();
        System.out.print("请输入您的登录密码：");
        String password = sc.nextLine();
        return new String[]{username,password};
    }
 //   注册操作
    public void login(String username,String password){
        //Sring temp = sc.nextLine(); //这个是接收空的\n字符的
        System.out.print("请输入您的真实姓名：");
        String realName = sc.nextLine();
        String tel = getTrueTel();      //得到电话
        People p = new People(realName,tel);         //创建对象
        Member m = new Member(username,password);
        p.setInfo(m);
        m.setP(p);                                    //对象间进行关联
        Member[] increse = new Member[Member.members.length+1];     //准备给静态初始数组扩容
        for (int i = 0; i < Member.members.length; i++) {
            increse[i] = Member.members[i];
        }
        Member.members = Arrays.copyOf(increse,increse.length);
        Member.members[Member.members.length-1] = m;        //扩容赋值对象
        System.out.println("------注册成功！------");
    }


    //判断用户名是否相同
    public boolean isTrueUserName(String username, String password){
        for (int i = 0; i < Member.members.length; i++) {
            if (Member.members[i].getUserName().equals(username)){
                System.out.println("您输入的用户名已经存在了，请重新输入！！！");
                System.out.println(Member.members[i].getUserName());
                System.out.println(username);
                return false;
            }
        }
        return true;
    }
    //信息校验
    public Object[] regist(String username,String password){
        String realName = null;
        boolean flag = false;
        if (Member.members != null) {
            for (int i = 0; i < Member.members.length; i++) {
                if (Member.members[i].getUserName().equals(username)  && Member.members[i].getPassWord().equals(password)){
                    realName = Member.members[i].getP().getName();
                    flag = true;
                    break;
                }
            }
        }
        return new Object[]{flag,realName};

    }
    //信息判断
    public void isTrue(Object[] obj){
        String realName = (String)obj[1];
        if ((boolean)obj[0]){
            System.out.println("欢迎您，"+realName+",当前系统已经有"+People.NUM+"人了");
            System.out.println("------------欢迎您下次使用本软件------------");
        }else{
            System.out.println("对不起，用户名或者密码错误，或者用户不存在，请重新输入信息登录！");
            System.out.println("------------欢迎您下次使用本软件------------");
        }

    }
    public String getTrueTel(){
        System.out.print("请输入您的手机号：");
        String tel = null;
        //判断tel是不是11位
        while (true){
            tel = sc.nextLine();
            if (tel.length() != 11 || tel.charAt(0) != '1'){
                System.out.print("请重新输入您的手机号！");
            }
            else{
                return tel;
            }
        }
    }


}
