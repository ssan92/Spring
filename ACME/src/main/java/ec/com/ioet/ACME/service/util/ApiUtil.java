package ec.com.ioet.ACME.service.util;

import org.springframework.web.context.request.NativeWebRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Santiago
 * */

public class ApiUtil {
    public static void setExampleResponse(NativeWebRequest req, String contentType, String example) {
        try {
            HttpServletResponse res = req.getNativeResponse(HttpServletResponse.class);
            res.setCharacterEncoding("UTF-8");
            res.addHeader("Content-Type", contentType);
            res.getWriter().print(example);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static String format(Date fecha,String pattern) {
    	SimpleDateFormat dateFormat=new SimpleDateFormat(pattern);
    	return dateFormat.format(fecha);
    }
    
    public static Date format(String fecha,String pattern) throws ParseException {
    	SimpleDateFormat dateFormat=new SimpleDateFormat(pattern);
    	return dateFormat.parse(fecha);
    }
}

