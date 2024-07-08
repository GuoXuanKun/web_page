package com.java2403.dao;

import com.java2403.util.JDBCUtils;

import java.sql.ResultSet;

public class AdminDao {
    //  将数据 访问次数  从 t_visit_record 表中 取回
    public int getVisitCount(){
        int visitCount =0;
       ResultSet rs = JDBCUtils.doQuery("select visit_count from t_visit_record ORDER BY update_date desc limit 1");
       try {
           while (rs.next()){
               visitCount= rs.getInt("visit_count");
           }
       }catch (Exception e){
           e.printStackTrace();
       }finally {
           JDBCUtils.doClose(rs);
       }


    return  visitCount;

    }



    //  将数据 访问次数  保存到 t_visit_record 表中
    public boolean saveVisitCount(int visitCount){

     int count =   JDBCUtils.doUpdate("insert into t_visit_record(visit_count,update_date)values(?,SYSDATE())",visitCount);
    return  count>0;


    }









    public static void main(String[] args) {

//        System.out.println(new AdminDao().getVisitCount());
        System.out.println(new AdminDao().saveVisitCount(66));

    }


}
