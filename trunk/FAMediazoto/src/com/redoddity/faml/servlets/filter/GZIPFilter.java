package com.redoddity.faml.servlets.filter;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.io.*;

public class GZIPFilter extends HttpServlet implements Filter {
	
	private FilterConfig filterConfig;
	private static final long serialVersionUID = 4566164157109553670L;
	private static Log logger = LogFactory.getLog(GZIPFilter.class);

	// Handle the passed-in FilterConfig
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	// Process the request/response pair
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws ServletException, IOException {

		if (req instanceof HttpServletRequest) {
			logger.debug("Entering GZIP filter servlet..");
			HttpServletRequest request = (HttpServletRequest) req;
			HttpServletResponse response = (HttpServletResponse) resp;
			String ae = request.getHeader("accept-encoding");
			if (ae != null && ae.indexOf("gzip") != -1) {
				logger.debug("GZIP supported: compressing..");
				GZIPResponseWrapper wrappedResponse = new GZIPResponseWrapper(response);
				logger.debug("doFilter is being called for "+ request.getRequestURL() + "..");
				chain.doFilter(request, wrappedResponse);
				wrappedResponse.finishResponse();
				logger.debug("doFilter returned...");
			} else {
				chain.doFilter(req, resp);
			}
			logger.debug("GZIP filter servlet exit..");
		}
	}

	// Clean up resources
	public void destroy() {
	}
}
