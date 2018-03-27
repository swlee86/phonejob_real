package kr.or.phonejob.pc.Util;

import javax.servlet.http.HttpServletRequest;

public class CheckUtil {

    //접속 자 모바일 체크(모바일인 경우 true 리턴)
    public static boolean isMobile(HttpServletRequest request){
        String userAgent = request.getHeader("user-agent");
        boolean mobile1 = userAgent.matches(".*(iPhone|iPod|Android|Windows CE|BlackBerry|Symbian|Windows Phone|sebOS|Opera Mini|Opera Mobi|POLARIS|IEMobile|lgtelecom|nokia|SonyEricsson).*");
        boolean mobile2 = userAgent.matches(".*(LG|SAMSUNG|samsung).*");

        if(mobile1 || mobile2){
            return true;
        }
        return false;
    }

}
