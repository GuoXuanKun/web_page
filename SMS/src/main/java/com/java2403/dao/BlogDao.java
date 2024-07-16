package com.java2403.dao;

import com.java2403.entity.Blog;
import com.java2403.util.JDBCUtils;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BlogDao {


    public boolean addBlog(String blogTitle ,String blogContent){

     int count =   JDBCUtils.doUpdate("insert into t_blog(blog_title,blog_content)values(?,?)",blogTitle,blogContent);
        return  count>0;
    }


    public List<Blog> queryAllBlog(){

        List<Blog> blogList = new ArrayList<>();
       ResultSet rs  =  JDBCUtils.doQuery("select blog_id blogId ,blog_title blogTile from t_blog");
       try {
           while (rs.next()){
               Blog blog =     new Blog();
                blog.setBlogId(rs.getInt("blogId"));
                blog.setBlogTitle(rs.getString("blogTile"));
                blogList.add(blog);
           }
       }catch (Exception e){
           e.printStackTrace();
       }finally {
           JDBCUtils.doClose(rs);
       }

       return  blogList;
    }

    public Blog queryBlogById(int blogId){

        Blog blog =null;
        ResultSet rs  =  JDBCUtils.doQuery("select blog_id blogId ,blog_title blogTile,blog_content blogContent from t_blog where blog_id =?",blogId);
        try {
            while (rs.next()){
                 blog =     new Blog();
                blog.setBlogId(rs.getInt("blogId"));
                blog.setBlogTitle(rs.getString("blogTile"));
                blog.setBlogContent(rs.getString("blogContent"));

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.doClose(rs);
        }

        return  blog;
    }


    public static void main(String[] args) {

        BlogDao bLogDao = new BlogDao();
//        System.out.println(bLogDao.addBlog("123333", "124443"));
//        System.out.println(bLogDao.queryAllBlog());
        System.out.println(bLogDao.queryBlogById(1));

    }


}
