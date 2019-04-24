package util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;


public class Gmail extends Authenticator {
	// 이메일 전송시 필요한 아이디, 비밀번호
	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication("ogo10dang@gmail.com", "0918rjs0314vheh");
	}
}
