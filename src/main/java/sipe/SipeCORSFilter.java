package sipe;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Component("corsFilter")
public class SipeCORSFilter extends CorsFilter {

	public SipeCORSFilter(CorsConfigurationSource configSource) {
		super(configSource);
	}

	@Override
	public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		System.out.println("CORSFilter HTTP Request: " + request.getMethod());

		((HttpServletResponse) response).addHeader("Access-Control-Allow-Origin", "*");
		((HttpServletResponse) response).addHeader("Access-Control-Allow-Methods", "GET, OPTIONS, HEAD, PUT, POST");
		((HttpServletResponse) response).addHeader("Access-Control-Allow-Headers", "content-type, access-control-allow-origin, authorization");

		HttpServletResponse resp = (HttpServletResponse) response;

		if (request.getMethod().equals("OPTIONS")) {
			resp.setStatus(HttpServletResponse.SC_ACCEPTED);
			return;
		}
		filterChain.doFilter(request, response);
	}

}