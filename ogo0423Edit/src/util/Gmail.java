package util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;


public class Gmail extends Authenticator {
	// �̸��� ���۽� �ʿ��� ���̵�, ��й�ȣ
	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication("ogo10dang@gmail.com", "0918rjs0314vheh");
	}
}
