package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MemberController extends HttpServlet{

	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContentType();
		
		String command = requestURI.substring(contextPath.length());
			
		Action action = null;
		ActionForward forward = null;
		
		if(command.equals("/MemberJoin.me")){
			//view페이지 이동
			
			forward = new ActionForward();
			forward.setPath("./member/joinForm.jsp");
			forward.setRedirect(false);
		}else if (command.equals("/MemberJoinAction.me")) {
			//model페이지 이동
			
			action = new MemberJoinAction();
			
			try {
				action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/MemberLogin.me")) {
			forward = new ActionForward();
			forward.setPath("./member/loginForm.jsp");
			forward.setRedirect(false);
			
		}else if (command.equals("/MemberLoginAction.me")) {
			
			action = new MemberLoginAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/Main.me")) {
			forward = new ActionForward();
			forward.setPath("./member/main.jsp");
			forward.setRedirect(false);
			
		}else if (command.equals("MemberLogout.me")){
			
			action = new MemberLogoutAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/MemberInfo.me")) {
			
			action = new MemberInfoAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/MemberUpdate.me")) {
			
			action = new MemberUpdate();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if (command.equals("/MemberUpdateAction.me")) {
			
			action = new MemberUpdateAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/MemberDelete.me")) {
			
			forward = new ActionForward();
			forward.setPath("./member/deleteForm.jsp");
			forward.setRedirect(false);
			
		}else if (command.equals("/MemberDeleteAction.me")) {
			
			action = new MemberDeleteAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if (command.equals("/MemberList.me")) {
			
			action = new MemberListAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	//페이지 이동
	if(forward != null){
		if(forward.isRedirect()){
			response.sendRedirect(forward.getPath());
		}else {
			RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
			
			dis.forward(request, response);
		}
	}	
		
		
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
}
