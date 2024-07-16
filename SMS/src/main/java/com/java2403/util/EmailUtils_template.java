package com.java2403.util;

import org.apache.commons.mail.HtmlEmail;

public class EmailUtils_template {

    /**
     * 发送邮箱功能
     * @param subject  邮箱主题
     * @param msg       邮箱内容
     * @param emails    收件人（可多个）
     * @return      是否成功
     */
    public static boolean sendEmail(String subject,String msg,String ...emails){
        try{
            // 创建邮箱对象
            HtmlEmail email = new HtmlEmail();
            // 设置 中文集
            email.setCharset("utf-8");
            // 设置 邮箱服务器 域名
            email.setHostName("smtp.qq.com");
            // 设置 发送邮箱的账号 信息（邮箱名和授权码）
            email.setAuthentication("","");
            // 发送者 (举一反三 自己百度  添加抄送 - 添加密送 | 分别发送 发送图片 和文件等等 功能)
            email.setFrom("@qq.com");
            //  接受者
           if(emails!=null && emails.length>0 ){
              email.addTo(emails);
           }else{
               return  false;
           }

            //  设置发送的内容
            // 设置主题
            email.setSubject(subject);
//
//            String msg ="<h1>作业1：</h1>";
//            msg +="<b>完成ajax练习</b>";
//            msg +="<h1>作业2：</h1>";
//            msg +="<b>完成邮箱发送功能</b>";
            // 使用html格式设置内容
            email.setHtmlMsg(msg);
            //发送
            email.send();
            return  true;

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }






    public static void main(String[] args)  {
       /*try{
           // 创建邮箱对象
           HtmlEmail email = new HtmlEmail();
            // 设置 中文集
           email.setCharset("utf-8");
           // 设置 邮箱服务器 域名
           email.setHostName("smtp.qq.com");
           // 设置 发送邮箱的账号 信息（邮箱名和授权码）
           email.setAuthentication("569669383@qq.com","");
           // 发送者 (举一反三 自己百度  添加抄送 - 添加密送 | 分别发送 发送图片 和文件等等 功能)
           email.setFrom("569669383@qq.com");
            //  接受者
           email.addTo("@qq.com");
           email.addTo("5T693@qq.com");
           email.addTo("");

           //  设置发送的内容
           // 设置主题
           email.setSubject("2024年7月16日的作业");

           String msg ="<h1>作业1：</h1>";
           msg +="<b>完成ajax练习</b>";
           msg +="<h1>作业2：</h1>";
           msg +="<b>完成邮箱发送功能</b>";
           // 使用html格式设置内容
           email.setHtmlMsg(msg);

        //发送
           email.send();

       }catch (Exception e){
           e.printStackTrace();
       }
*/


        System.out.println( EmailUtils_template.sendEmail("111","邮箱地址","","邮箱地址"));



    }



}
