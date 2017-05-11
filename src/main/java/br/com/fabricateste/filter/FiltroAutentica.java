package br.com.fabricateste.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(dispatcherTypes={DispatcherType.REQUEST}, urlPatterns="/*")
public class FiltroAutentica implements Filter {

	public void destroy() {
		
		
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest)req;
		HttpServletResponse httpResp = (HttpServletResponse)resp;
		
		String uri = httpReq.getRequestURI();
		HttpSession sessao =  httpReq.getSession(false);
		
		if(sessao != null || uri.lastIndexOf("login.html")!=-1 || uri.lastIndexOf("autenticador.do")!=-1){
			chain.doFilter(req, resp);
		}else{
			httpResp.sendRedirect("login.html");
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		
		
	}

}
