package cc.prayol.springtraining.filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author hjx
 * @date 2020/8/21
 */
public class HeartbeatCheckFilter extends OncePerRequestFilter {
    private final String heartbeatUrl = "/heartbeat";
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (request.getRequestURI().indexOf(heartbeatUrl)>=0) {
            PrintWriter out = null;
            try {
                response.setStatus(200);
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/plain; charset=UTF-8");
                response.setHeader("pragma", "no-cache");
                response.setHeader("Cache-Control", "no-cache");
                response.setDateHeader("Expires", 0L);
                out = response.getWriter();
                out.write(String.valueOf(System.currentTimeMillis()));
            } catch (Exception var9) {
            } finally {
                if (out != null) {
                    out.close();
                }

            }
        }
        filterChain.doFilter(request, response);
    }
}
