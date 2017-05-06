package tour.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.VerifyCode;

/**
 * 生成验证码的servlet
 * @author KL
 *
 */
@WebServlet("/PicCheckCode")
public class PicCheckCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public PicCheckCode() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置不缓存图片
		response.setContentType("image/jpeg");
        //禁止图像缓存
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
          
        HttpSession session = request.getSession();  
          
        VerifyCode vCode = new VerifyCode(120,40,5,100);  
        session.setAttribute("randCheckCode", vCode.getCode());  
        vCode.write(response.getOutputStream());  
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
