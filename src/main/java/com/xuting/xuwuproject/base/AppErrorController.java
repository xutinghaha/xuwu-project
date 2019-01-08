package com.xuting.xuwuproject.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Description 全局异常拦截配置
 * @Author xuting
 * @Date 2019/1/8
 **/
@Controller
@Slf4j
public class AppErrorController extends AbstractErrorController {

    private static final String ERROR_PATH = "error";

    private final ErrorProperties errorProperties;
    @Autowired
    public AppErrorController(ErrorAttributes errorAttributes,ServerProperties serverProperties) {
        super(errorAttributes);
        this.errorProperties=serverProperties.getError();
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    @RequestMapping(value = ERROR_PATH,produces = "text/html")
    public String  errorHtml(HttpServletRequest request,
                                  HttpServletResponse response) {
        ModelAndView modelAndView=new ModelAndView(ERROR_PATH);
        int status = response.getStatus();
        switch (status) {
            case 403:
                return "403";
            case 404:
                return "404";
            case 500:
                return "500";
        }

        return "index";
    }

    @RequestMapping(value = ERROR_PATH)
    @ResponseBody
    public ApiResponse error(HttpServletRequest request) {
        Map<String, Object> errorMap=getErrorAttributes(request, isIncludeStackTrace(request, MediaType.APPLICATION_JSON));
        logHandler(errorMap);
        Integer status = (Integer) errorMap.get("status");
        if(status == null) {
            status = 500;
        }
        return ApiResponse.ofMessage(status,String.valueOf(errorMap.getOrDefault("message","error")));
    }

    private void logHandler(Map<String, Object> errorMap) {
        log.error("url:{},status{},time:{},errorMsg:{}",errorMap.get("path"),errorMap.get("status"),errorMap.get("timestamp"),errorMap.get("message"));
    }

    protected boolean isIncludeStackTrace(HttpServletRequest request,
                                          MediaType produces) {
        ErrorProperties.IncludeStacktrace include = getErrorProperties().getIncludeStacktrace();
        if (include == ErrorProperties.IncludeStacktrace.ALWAYS) {
            return true;
        }
        if (include == ErrorProperties.IncludeStacktrace.ON_TRACE_PARAM) {
            return getTraceParameter(request);
        }
        return false;
    }
    private ErrorProperties getErrorProperties() {
        return this.errorProperties;
    }

}
