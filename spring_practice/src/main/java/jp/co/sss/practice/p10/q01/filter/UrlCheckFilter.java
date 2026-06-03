package jp.co.sss.practice.p10.q01.filter;

import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class UrlCheckFilter extends HttpFilter {
	@Override
	public void doFilter(
			HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String requestURL = request.getRequestURL().toString();
		if (requestURL.contains("filter")) {
			request.setAttribute("url", requestURL);
			System.out.println(requestURL);
			if (requestURL.endsWith("abc")) {
				response.sendRedirect("/practice/filter/xyz");
			} else {
				chain.doFilter(request, response);
			}
		}
		chain.doFilter(request, response);

	}

}
