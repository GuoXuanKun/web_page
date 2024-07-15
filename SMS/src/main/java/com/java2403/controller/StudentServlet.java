package com.java2403.controller;

import com.java2403.dao.StudentDao;
import com.java2403.entity.PageInfo;
import com.java2403.entity.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "StudentServlet", value = "/student/manage")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 中文处理
        request.setCharacterEncoding("utf-8");
        //获得 参数 op
        String op  =     request.getParameter("op");
        System.out.println("op:"+op);
        HttpSession session = request.getSession();
        Integer sno = (Integer) session.getAttribute("sno");

//        // 权限控制
//        // 排除 login这个操作，因为 session中 的sno 需要 登录后才能 被set 进去
//        if(!"login".equals(op)){
//            // 如果 session中没有 sno 这个属性，说明没登录成功，跳转到 登录界面
//            if(sno==null){
//
//                session.setAttribute("msg","请登录后再访问");
//                response.sendRedirect("login.jsp");
//                // 中途“截胡”，在后面加一个return
//                return;//  后续代码就不要执行了
//
//            }
//        }



        // 根据op值 调用相应的方法（执行相应的操作）
        if("queryAllStudent".equals(op)){ //查询全部

            queryAllStudent(request,response);

        }else if("login".equals(op)){    // 登录
            login(request,response);
        } else if ("queryMyInfo".equals(op)) {
            queryMyInfo(request,response);
        }else if("modifyMyInfo".equals(op)){
            modifyMyInfo(request,response);
        }else if("deleteStudentBySno".equals(op)){
            deleteStudentBySno(request,response);
        }else if("modifyStudent".equals(op)){
            modifyStudent(request,response);
        }else if("addStudent".equals(op)){
            addStudent(request,response);
        }else if("queryStudentBySno".equals(op)){
//            op.equals("queryStudentBySno")
            queryStudentBySno(request,response);
        }else if("logout".equals(op)){
            logout(request,response);
        }else if("admin".equals(op)){
            admin(request,response);
        }else if("queryAllStudentByPage".equals(op)){ //查询全部
            queryAllStudentByPage(request,response);
        }else  if("queryAllStudentByPage2".equals(op)){ //查询全部
            queryAllStudentByPage2(request,response);
        }else  if("isSnoExist".equals(op)){

            isSnoExist(request,response);

        }


        //注册
        // 修改
        // 删除





    }
    // 增加 Map 集合来存哈希地址
//    public static final Map<String,Integer> ADDR_COUNT = new HashMap<>();

    protected void queryAllStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //
        StudentDao studentDao  = new StudentDao();
        List<Student> slist   =  studentDao.queryAllStudent();
        // 把数据放在属性中（行李箱中）属性名  叫 slist 后面的人就可以直接拿了
        request.setAttribute("slist",slist);
        // 跳转到显示页面
        request.getRequestDispatcher("queryAllStudent.jsp").forward(request,response);

    }


    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String sno_str   = request.getParameter("sno");
        int sno  =0;
        HttpSession session  =   request.getSession();

        // 万一 转换异常 ，try catch 包起来，就不报错了。改成 回到 登录界面，并提示
        try {
            sno  = Integer.parseInt(sno_str);// 判断是否为 数字...
        }catch (Exception e){

            session.setAttribute("msg","学号不能为非数字，请重新登录!");// message
            // request.getRequestDispatcher("login.jsp").forward(request,response);
            response.sendRedirect("login.jsp");
            return; // 记得return

        }

        String password  = request.getParameter("password");
        String rememberMe  =   request.getParameter("rememberMe");

//        HttpSession session = request.getSession();

        StudentDao studentDao  = new StudentDao();
        boolean flag  = studentDao.login(sno,password);
        if(flag){
//            request.setAttribute("sno",sno);
            // 用 session 传数据

            session.setAttribute("sno",sno);
            // 成功跳转到 欢迎界面
//            request.getRequestDispatcher("main.jsp").forward(request,response);
            //当登录成功后，将学号 和 密码 记录下啦
            if("true".equals(rememberMe)){

                Cookie snoCookie   = new Cookie("sno",sno+"");
                snoCookie.setMaxAge(7*24*60*60); // 设置coockie 最大寿命 单位 秒

                Cookie passwordCookie   = new Cookie("password",password);
                passwordCookie.setMaxAge(7*24*60*60);

                response.addCookie(snoCookie);
                response.addCookie(passwordCookie);

            }else{
                //取消掉
                // 当 cookie name值 和  浏览器中 旧的cookie 名字 相同 就会 取代  它
                Cookie snoCookie   = new Cookie("sno","");
                snoCookie.setMaxAge(0);

                Cookie passwordCookie   = new Cookie("password","");
                passwordCookie.setMaxAge(0);

                response.addCookie(snoCookie);
                response.addCookie(passwordCookie);


            }
            // 登录成功后，找到 application 对象 ， 然后 visitCount + 1
            ServletContext application = request.getServletContext();
            // 如果启动后,第一次登录,添加一个 visitCount 属性
            Integer visitCount = (Integer) application.getAttribute("visitCount");
            if (visitCount==null){
                visitCount = 0;
            }
            visitCount++;
            application.setAttribute("visitCount",visitCount);




            //
            Map<String,Integer> ADDR_COUNT = (Map<String, Integer>) application.getAttribute("ADDR_COUNT");
            if (ADDR_COUNT == null){
                 ADDR_COUNT = new HashMap<>();
            }
            // 将 ip地址 加入 Map 集合
            if (ADDR_COUNT.get(request.getRemoteAddr())==null){
                ADDR_COUNT.put(request.getRemoteAddr(),1);
            }else{
                ADDR_COUNT.put(request.getRemoteAddr(),ADDR_COUNT.get(request.getRemoteAddr())+1);
            }
            // 将计数 IP地址 集合传给 main.jsp
            application.setAttribute("ADDR_COUNT",ADDR_COUNT);

            // 转发重定向( 跳转 )
            response.sendRedirect("main.jsp");


        }else{
            // 携带相关消息过去
            session.setAttribute("msg","学号或密码错误,请重新登录");
            // 失败，回到登录界面，重新登录
            response.sendRedirect("login.jsp");

        }



    }

    protected void queryMyInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //
        String sno_str = request.getParameter("sno");
        int sno = Integer.parseInt(sno_str);
        StudentDao studentDao = new StudentDao();
        Student my = studentDao.queryMyInfo(sno);
        System.out.println(my.toString());
        request.setAttribute("my",my);
        request.getRequestDispatcher("queryMyInfo.jsp").forward(request,response);

    }

    protected void modifyMyInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        // 获得数据
        String sno_str = request.getParameter("sno");
        int sno = Integer.parseInt(sno_str);
        String sname = request.getParameter("sname");
        String password = request.getParameter("password");
        String sex = request.getParameter("sex");
        String agr_str = request.getParameter("age");
        int age = Integer.parseInt(agr_str);

        Student my = new Student(sno,sname,sex,age,password);
        StudentDao studentDao = new StudentDao();
        boolean flag = studentDao.modify(my);
        if (flag){
            request.setAttribute("msg","修改成功");
        }else {
            request.setAttribute("msg","修改失败");
        }
        request.getRequestDispatcher("manage?op=queryMyInfo&sno="+sno).forward(request,response);

    }
    protected void deleteStudentBySno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String sno_str  =  request.getParameter("sno");
        int sno  = Integer.parseInt(sno_str);

        StudentDao studentDao  = new StudentDao();
        boolean flag =  studentDao.deleteBySno(sno);
        HttpSession session = request.getSession();
        if(flag){
//            request.setAttribute("msg","删除成功");
            session.setAttribute("msg","删除成功");
        }else{
//            request.setAttribute("msg","删除失败");
            session.setAttribute("msg","删除失败");
        }
//        request.getRequestDispatcher("student?op=queryAllStudent").forward(request,response);
        response.sendRedirect("manage?op=queryAllStudent");
    }
    protected void modifyStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //  获得 数据
        String sno_str  = request.getParameter("sno");
        int sno  = Integer.parseInt(sno_str);
        String sname  =request.getParameter("sname");
        String password  =request.getParameter("password");
        String sex  =request.getParameter("sex");
        String age_str  = request.getParameter("age");
        int age  = Integer.parseInt(age_str);

        Student stu  = new Student(sno,sname,sex,age,password);
        StudentDao studentDao  = new StudentDao();
        boolean flag  =  studentDao.modify(stu);

        HttpSession session = request.getSession();

        if(flag){
//            request.setAttribute( "msg","修改成功");
//            request.getRequestDispatcher("student?op=queryAllStudent").forward(request,response);
            session.setAttribute( "msg","修改成功");
            response.sendRedirect("manage?op=queryAllStudent");
        }else{

//            request.setAttribute( "msg","修改失败");
//            request.getRequestDispatcher("student?op=queryStudentBySno&sno="+sno).forward(request,response);
            session.setAttribute( "msg","修改失败");
            response.sendRedirect("manage?op=queryStudentBySno&sno="+sno);
        }
        // queryMyInfo(request,response); 可以实现，但是不推荐，后续可能会出现通过serlvet的 跳转
        // 思考一下为什么这么写，这个传递的时候，是怎么传值的（request中的值）

    }
    protected void addStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{


        String sname  =request.getParameter("sname");
        String password  =request.getParameter("password");
        String sex  =request.getParameter("sex");
        String age_str  = request.getParameter("age");
        int age  = Integer.parseInt(age_str);

        Student stu = new Student(sname,password,sex,age);
        HttpSession session = request.getSession();
        StudentDao studentDao  = new StudentDao();
        boolean flag =   studentDao.addStudent(stu);
        if(flag){
//            request.setAttribute("msg","添加成功");
//            request.getRequestDispatcher("student?op=queryAllStudent").forward(request,response);
            session.setAttribute("msg","添加成功");
            response.sendRedirect("manage?op=queryAllStudent");

        }else{

//            request.setAttribute("msg","添加失败");
//            request.getRequestDispatcher("addStudent.jsp").forward(request,response);

            session.setAttribute("msg","添加失败");
            response.sendRedirect("addStudent.jsp");

        }


    }
    protected void queryStudentBySno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //
        String sno_str   =  request.getParameter("sno");
        int sno  = Integer.parseInt(sno_str);
        StudentDao studentDao  = new StudentDao();
        Student stu = studentDao.queryMyInfo(sno);
        request.setAttribute("stu",stu);
        // 跳转到显示页面
        request.getRequestDispatcher("modifyStudent.jsp").forward(request,response);
    }
    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        HttpSession session = request.getSession();
        session.removeAttribute("sno");
        session.setAttribute("msg","退出成功,请重新登录");
        response.sendRedirect("login.jsp");
    }
    public void admin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        // 将 统计登录人数的 集合发送给 admin.jsp
        ServletContext application = request.getServletContext();
//        application.setAttribute("ADDR_COUNT",ADDR_COUNT);
        response.sendRedirect("admin.jsp");
    }
    protected void queryAllStudentByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int pageIndex  = 1;// 默认值为第一页
        int pageSize  = 5;// 默认值为 一页5条
        String pageIndex_str  =  request.getParameter("pageIndex");
        String pageSize_str  =    request.getParameter("pageSize");

        try{
            pageIndex  =   Integer.parseInt(pageIndex_str);
        }catch (Exception e){
            System.out.println("传入的是非数字，pageindex默认为 1");
        }


        try{
            pageSize  =   Integer.parseInt(pageSize_str);
        }catch (Exception e){
            System.out.println("传入的是非数字，pageSize  5");
        }





        StudentDao studentDao  = new StudentDao();
        List<Student> slist   =  studentDao.queryAllStudentByPage(pageIndex,pageSize);
        // 总条数
        int totalData  = studentDao.queryAllStudentByPage_count();
        // 总页数
        int totalPage  = totalData/pageSize  + ((totalData%pageSize==0)?0:1);// 当 总条数 不能被  一页几条 整除 ，需要 +1

        PageInfo<Student> pageInfo  = new PageInfo<>();
        pageInfo.setPageIndex(pageIndex);
        pageInfo.setPageSize(pageSize);
        pageInfo.setTotalPage(totalPage);
        pageInfo.setTotalData(totalData);
        pageInfo.setData(slist);


        // 把数据放在属性中（行李箱中）属性名  叫 slist 后面的人就可以直接拿了
        //PageInfo<Student> pageInfo  = new PageInfo<>();
        //pageInfo.setData(slist);
        // 剩下的数据怎么得到？ 一共几页 怎么得到  去数据库 查看一个 一共几条数据，然后 除 5 （什么情况+1 什么情况不+1 ）


//        request.setAttribute("slist",slist);
        request.setAttribute("pageInfo",pageInfo);
        // 跳转到显示页面
        request.getRequestDispatcher("queryAllStudentByPage.jsp").forward(request,response);

    }


    protected void queryAllStudentByPage2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{


        int pageIndex  = 1;// 默认值为第一页
        int pageSize  = 5;// 默认值为 一页5条
        String pageIndex_str  =  request.getParameter("pageIndex");
        String pageSize_str  =    request.getParameter("pageSize");

        try{
            pageIndex  =   Integer.parseInt(pageIndex_str);
        }catch (Exception e){
            System.out.println("传入的是非数字，pageindex默认为 1");
        }


        try{
            pageSize  =   Integer.parseInt(pageSize_str);
        }catch (Exception e){
            System.out.println("传入的是非数字，pageSize  5");
        }





        String sno =  request.getParameter("sno");
        String sname =  request.getParameter("sname");
        String sex =  request.getParameter("sex");
        String age =  request.getParameter("age");
        //判断
        if(sno==null || "".equals(sno)){
            sno="%%";
        }

        if(sname==null || "".equals(sname)){
            sname="%%";
        }else{
            sname="%"+sname+"%"; // %浩%
        }

        if(sex==null || "".equals(sex)){
            sex="%%";
        }

        if(age==null || "".equals(age)){
            age="%%";
        }

        StudentDao studentDao  = new StudentDao();
        // 当前页的学生信息
        List<Student> slist   = studentDao.queryAllStudentByPage2(sno, sname, sex, age, pageIndex, pageSize);
        // 总条数
        int totalData  = studentDao.queryAllStudentByPage2_count(sno, sname, sex, age);
        // 总页数
        int totalPage  = totalData/pageSize  + ((totalData%pageSize==0)?0:1);// 当 总条数 不能被  一页几条 整除 ，需要 +1

        PageInfo<Student> pageInfo  = new PageInfo<>();
        pageInfo.setPageIndex(pageIndex);
        pageInfo.setPageSize(pageSize);
        pageInfo.setTotalPage(totalPage);
        pageInfo.setTotalData(totalData);
        pageInfo.setData(slist);

        request.setAttribute("pageInfo",pageInfo);

        // 跳转到显示页面
        request.getRequestDispatcher("queryAllStudentByPage2.jsp").forward(request,response);

    }

    /**
     * 校验 学号是否存在
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void isSnoExist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String sno_str  =   request.getParameter("sno");
        int sno  = Integer.parseInt(sno_str);
        StudentDao studentDao  = new StudentDao();
        boolean flag  =  studentDao.isSnoExist(sno);

        PrintWriter out  =  response.getWriter();
        out.println(flag);
        out.flush();
        out.close();



    }

}
