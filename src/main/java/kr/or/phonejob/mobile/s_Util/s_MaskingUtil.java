package kr.or.phonejob.mobile.s_Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class s_MaskingUtil {
	private static final Logger logger = LoggerFactory.getLogger(s_MaskingUtil.class);
	private static final String PHONE_NUM_PATTERN = "(01[016789])(\\d{3,4})(\\d{4})";
	private static final String ID_PATTERN = "^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$";
	private static final String KOR_NAME_PATTERN = "^[가-힣]{2,4}$";
	private static final String ENG_NAME_PATTERN = "^[a-zA-Z]*$";
	private static final String ENG_SPACE_NAME_PATTERN = "(^[a-zA-Z]{2,20}(\\s[a-zA-Z]{2,20})(\\s[a-zA-Z]{2,20})?$)";

	   /**
	    * 이메일이든, 휴대폰번호든 각 포맷에 맞게 마스킹된 결과값 리턴해주는 함수
	    * 포맷이 맞지 않을 경우 인풋으로 들어온 값 그대로 리턴
	    *
	    * public은 이거 하나! valid check류의 메서드들도 추후 필요하면 public으로 바꿀 예정
	    *
	    * @param id
	    * @return maskedId
	    */
	   
	   //이름 마스킹 유틸
	   public static String getMaskingName(String userid){
    	  return getMaskedName(userid);
   	   }
	   
	   //번호 마스킹 유틸
	   public static String getMaskingPhoneNum(String userid){
	      return getMaskedPhoneNum(userid);
	   }
	   
	   //아이디 마스킹 유틸
	   public static String getMaskingId(String userid) {
		  return getMaskedid(userid);
	   }
	   
	   /**
	    * 아이디 포맷 Validator
	    * @param str
	    * @return isValidEmailFormat
	    */
	   private static boolean isEmail(final String str) {
	      return isValid(ID_PATTERN, str);
	   }

	   /**
	    * 휴대폰 번호 포맷 Validator
	    * @param str
	    * @return isValidCellPhoneNumFormat
	    */
	   private static boolean isPhoneNum(final String str) {
	      return isValid(PHONE_NUM_PATTERN, str);
	   }
	   

	   

	   /**
	    * 문자열이 정규식에 맞는 포맷인지 체크
	    * @param regex
	    * @param target
	    * @return isValid
	    */
	   private static boolean isValid(final String regex, final String target) {
	      Matcher matcher = Pattern.compile(regex).matcher(target);
	      return matcher.matches();
	   }

	   /**
	    * 아이디 마스킹 처리
	    * @param userid
	    * @return maskedUserId
	    */
	   private static String getMaskedid(String userid) {
	      /*
	      * 요구되는 아이디 포맷
	      * {userId}
	      */
		   String replaceTarget = userid.substring(1, userid.length()-1);
	       char[] c = new char[replaceTarget.length()];
	       Arrays.fill(c, '*');
	       return userid.replace(replaceTarget, String.valueOf(c));
	      }
	   

	   /**
	    * 휴대폰 번호 마스킹 처리
	    * @param phoneNum
	    * @return maskedCellPhoneNumber
	    */
	   private static String getMaskedPhoneNum(String phoneNum) {
	      /*
	      * 요구되는 휴대폰 번호 포맷
	      * 01055557777 또는 0113339999 로 010+네자리+네자리 또는 011~019+세자리+네자리 이!지!만!
	      * 사실 0107770000 과 01188884444 같이 가운데 번호는 3자리 또는 4자리면 돈케어
	      * */
	      String regex = "(01[016789])(\\d{3,4})\\d{4}$";
	      Matcher matcher = Pattern.compile(regex).matcher(phoneNum);
	      if (matcher.find()) {
	         String replaceTarget = matcher.group(2);
	         char[] c = new char[replaceTarget.length()];
	         Arrays.fill(c, '*');
	         return phoneNum.replace(replaceTarget, String.valueOf(c));
	      }
	      return phoneNum;
	   }
	   
	   //이름 마스킹 함수
	   private static String getMaskedName(String username) {
		   //logger.info("이름 짤린 내용 : " + username.substring(1, username.length()-1));
		   String replaceTarget = username.substring(1, username.length()-1);
	       char[] c = new char[replaceTarget.length()];
	       Arrays.fill(c, '*');
	       return username.replace(replaceTarget, String.valueOf(c));
	   }

}
