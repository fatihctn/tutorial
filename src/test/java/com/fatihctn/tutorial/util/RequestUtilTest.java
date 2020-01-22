package com.fatihctn.tutorial.util;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;

@RunWith(MockitoJUnitRunner.class)
public class RequestUtilTest {

    @Mock
    private HttpServletRequest request;

    @InjectMocks
    private RequestUtil requestUtil;

    private final String X_FORWARDED_FOR = "X-FORWARDED_FOR";

    @Test
    public void whenGetClientIp_thenHeaderIsNull() {
        String expectedIp = "";
        Mockito.lenient().doReturn(null).when(request);
        String actualIp = requestUtil.getClientIp();
        Assertions.assertThat(actualIp).isEqualTo(expectedIp);
    }

    @Test
    public void whenGetClientIp_thenGetHeaderIsEmpty() {
        String expectedIp = "";
        Mockito.lenient().doReturn(null).when(request).getHeader(X_FORWARDED_FOR);
        String actualIp = requestUtil.getClientIp();
        Assertions.assertThat(actualIp).isEqualTo(expectedIp);
    }

    @Test
    public void whenGetClientIp_thenGetRemoteAddrIsNull() {
        String expectedIp = "";
        Mockito.lenient().doReturn(null).when(request).getHeader(X_FORWARDED_FOR);
        Mockito.doReturn(null).when(request).getRemoteAddr();
        String actualIp = requestUtil.getClientIp();
        Assertions.assertThat(actualIp).isEqualTo(expectedIp);
    }

    @Test
    public void whenGetClientIp_ThenXIsNotEmpty() {
        String expectedIp = "127.0.0.1";
        Mockito.lenient().doReturn(expectedIp).when(request).getHeader(X_FORWARDED_FOR);
        String actualIp = requestUtil.getClientIp();
        Assertions.assertThat(actualIp).isEqualTo(expectedIp);
    }

    @Test
    public void whenGetClientIp_ThenIsNotEmpty() {
        String expectedIp = "127.0.0.1";
        Mockito.lenient().doReturn(null).when(request).getHeader(X_FORWARDED_FOR);
        Mockito.doReturn(expectedIp).when(request).getRemoteAddr();
        String actualIp = requestUtil.getClientIp();
        Assertions.assertThat(actualIp).isEqualTo(expectedIp);
    }

}
