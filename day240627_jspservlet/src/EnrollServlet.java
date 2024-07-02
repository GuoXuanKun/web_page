import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EnrollServlet", value = "/EnrollServlet")
public class EnrollServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //        request  请求对象（外交官 信使  ）带着 前台穿过的数据一起来的  getParameter 获得请求参数 通过 name的值
        String sname   = request.getParameter("sname");
        String password   = request.getParameter("password");

        //        没有真实的数据（没有数据库），假数据
        if(!"".equals(sname)&&!"".equals(password)){
            System.out.println("注册成功");
            //让他跳转到指定页面
            // 响应（服务器--》 浏览器  让浏览器 去显示 html页面 让浏览器去找成功的页面 ）
            response.sendRedirect("enroll_success.html");  //  sendRedirect 重定向  (修改地址栏)




        }else{
            System.out.println("注册失败");
            response.sendRedirect("enroll_error.html");

        }

    }
}
