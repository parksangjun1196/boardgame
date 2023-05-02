package SV;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/boardservlet.do")
public class BoardServlet extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {
		System.out.println("test");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("xidx")); /*필요는 없음 서버랑 통신중이라는걸 표현하고싶음*/
		System.out.println(request.getParameter("yidx")); /*필요는 없음 서버랑 통신중이라는걸 표현하고싶음*/
		System.out.println(request.getParameter("turnsend")); /*필요는 없음 서버랑 통신중이라는걸 표현하고싶음*/
		
		
		System.out.println(request.getParameter("whowinsend")); /*누군가 승리했을떄 ajax로 통신한 request (parameter = whowinsend) */
		BoardDAO bd = new BoardDAO();
			
		
		
		
		if (!request.getParameter("whowinsend").equals("none")) { /*누군가 이겼을때 db에 저장 (whowin 값과*/
			BoardVO vo = new BoardVO();
			System.out.println(request.getParameter("whowinsend") + "is win");
			vo.setWhowin(request.getParameter("whowinsend"));
			Date date = new Date();
	        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        String str = format.format(date);

			vo.setGamedate(str);
			bd.addresult(vo);
			
		}
		
		
		
//		request.getRequestDispatcher("/boardgame/omok.jsp").forward(request, response);
		response.sendRedirect("/boardgame/omok.jsp");
		
		
		
		
		
	}

}
