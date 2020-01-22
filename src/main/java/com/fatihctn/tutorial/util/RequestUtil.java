package com.fatihctn.tutorial.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class RequestUtil {
    @Autowired
    private HttpServletRequest request;

    public String getClientIp() {
        String clientIp = "";
        if (request != null) {
            clientIp = request.getHeader("X-FORWARDED_FOR");
            if (ObjectCheckUtil.isEmptyObject(clientIp)) {
                clientIp = request.getRemoteAddr();
                if (ObjectCheckUtil.isEmptyObject(clientIp)) {
                    clientIp = "";
                }
            }
        }
        return clientIp;
    }
}
