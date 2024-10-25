package com.javamail.utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class MailUtils {

    // Thiết lập thuộc tính cho kết nối SMTP
    private Properties props = new Properties();

    public MailUtils() {
        props.put("mail.smtp.host", "smtp.gmail.com"); // Máy chủ SMTP
        props.put("mail.smtp.port", "587");            // Cổng SMTP (587 là cổng TLS)
        props.put("mail.smtp.auth", "true");           // Xác thực yêu cầu
        props.put("mail.smtp.starttls.enable", "true"); // Kích hoạt TLS (bảo mật)
    }

    public boolean sendEmail(String senderEmail, String receiverEmail, String subjectText, String bodyText) {

        // Xác thực với tên người dùng và mật khẩu của bạn
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("phama9162@gmail.com", "owkq lhmi duce lcds"); // Thay bằng email và mật khẩu của bạn
            }
        });

        try {
            // Tạo tin nhắn email
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail)); // Địa chỉ gửi
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiverEmail)); // Người nhận
            message.setSubject(MimeUtility.encodeText(subjectText, "UTF-8", "B"));
            message.setContent(bodyText, "text/plain; charset=UTF-8");

            // Gửi email
            Transport.send(message);

            return true; // Trả về true nếu gửi thành công
        } catch (Exception e) {
            e.printStackTrace(); // In lỗi ra console để dễ dàng debug
            return false; // Trả về false nếu gửi thất bại
        }
    }
}
