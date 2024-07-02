import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")  // 这个路径可以根据自己的习惯 进行调整
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        request  请求对象（外交官 信使  ）带着 前台穿过的数据一起来的  getParameter 获得请求参数 通过 name的值
       String sname   = request.getParameter("sname");
        String password   = request.getParameter("password");

//        没有真实的数据（没有数据库），假数据
        if("gxk".equals(sname)&&"123".equals(password)){
            System.out.println("登录成功");
            //让他跳转到指定页面
            // 响应（服务器--》 浏览器  让浏览器 去显示 html页面 让浏览器去找成功的页面 ）
            response.sendRedirect("success.html");  //  sendRedirect 重定向  (修改地址栏)




        }else{
            System.out.println("登录失败");
            response.sendRedirect("error.html");

        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
