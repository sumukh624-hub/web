package com.example;

import static org.mockito.Mockito.*;

import java.io.PrintWriter;
import java.io.StringWriter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.Test;

public class HelloServletTest {

    @Test
    void testDoGet() throws Exception {
        HelloServlet servlet = new HelloServlet();

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);

        when(response.getWriter()).thenReturn(writer);

        servlet.doGet(request, response);

        writer.flush();
        String result = stringWriter.toString();

        assert(result.contains("Deployment Successful!"));
        assert(result.contains("GitHub"));
        assert(result.contains("Jenkins"));
        assert(result.contains("Docker"));
        assert(result.contains("Tomcat 11"));

        verify(response).setContentType("text/html");
    }
}