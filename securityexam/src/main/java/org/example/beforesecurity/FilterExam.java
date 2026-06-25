package org.example.beforesecurity;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@WebFilter(urlPatterns = "/api/members/*")
public class FilterExam  implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FilterExam.init() 실행이다 마!");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("FilterExam.doFilter() 실행전이다 마!");
        chain.doFilter(request, response);
        System.out.println("FilterExam.doFilter() 실행후다  마!");
    }

    @Override
    public void destroy() {
        System.out.println("FilterExam.destroy() 실행이다 마!");
    }
}
