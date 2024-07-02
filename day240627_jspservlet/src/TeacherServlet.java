import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TeacherServlet", value = "/TeacherServlet")
public class TeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        request  请求   浏览器 向 服务器 请求 （我 请求 访问 你）
//       response  响应   服务器 向 浏览器 回应（我回复，别来 ge wu en ）
//        http://localhost:8080/untitled/StudentServlet? sname=zhw&password=123
        // 通过请求对象，获得 请求参数
       String value值 =  request.getParameter("name值");// 通过 name值 获得 value值

        // 根据请求数据进行 可以实现  业务逻辑处理 （包括逻辑判断 或者 访问数据库等等） 得到一个结果

        // 根据结果，我们会做一些响应（成功 显示啥  失败 显示啥）  下面这种方式 比较繁琐（手敲出来一个界面，特麻烦）
//       PrintWriter out  =  response.getWriter();
//       out.println("<html>");
//       out.println("<。。。。>");
//       out.println("</html>");

        // 在工程中，web目录下，创建一个 专门用来显示 文件( html 或者  jsp 加入 css js等等让页面更丰富 好写  )
        // 注意，虽然 前端文件  我们放在 web目录下的，当时对于工程来说，访问的路径 是 根路径


        // 让 浏览器 去 找 成功或失败 等 界面  （相当于 响应了一句话（命令）给浏览器：你去找隔壁的老 boby xxx.html）
        response.sendRedirect("新路径");// 浏览器会根据这个新路径 去找 新的 文件
        // 因为 html等文件 浏览器会直接读取，不需要 再做加工 ，直接获取直接显示


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
