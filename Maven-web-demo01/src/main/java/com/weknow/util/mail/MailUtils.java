package com.weknow.util.mail;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;
import java.util.*;
import javax.activation.*;

public class MailUtils {

    private String host = ""; // smtp������
    private String from = ""; // �����˵�ַ
    private String to = ""; // �ռ��˵�ַ
    private String affix = ""; // ������ַ
    private String affixName = ""; // �������� 
    private String user = ""; // �û���
    private String pwd = ""; // ����
    private String subject = ""; // �ʼ�����
    private String content = ""; // �ʼ�����
    

    public void setAddress(String from, String to, String subject) {
        this.from = from;
        this.to = to;
        this.subject = subject;
    }
    public void setAddress(String from, String to, String subject, String content) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.content = content;
    }

    public void setAffix(String affix, String affixName) {
        this.affix = affix;
        this.affixName = affixName;
    }

    public void send(String host, String user, String pwd) {
        this.host = host;
        this.user = user;
        this.pwd = pwd;

        Properties props = new Properties();

        // ���÷����ʼ����ʼ������������ԣ�����ʹ�����׵�smtp��������
        props.put("mail.smtp.host", host);
        // ��Ҫ������Ȩ��Ҳ�����л����������У�飬��������ͨ����֤��һ��Ҫ����һ����
        props.put("mail.smtp.auth", "true");

        // �øո����úõ�props���󹹽�һ��session
        Session session = Session.getDefaultInstance(props);

        // ������������ڷ����ʼ��Ĺ�������console����ʾ������Ϣ��������ʹ
        // �ã�������ڿ���̨��console)�Ͽ��������ʼ��Ĺ��̣�
        session.setDebug(true);

        // ��sessionΪ����������Ϣ����
        MimeMessage message = new MimeMessage(session);
        try {
            // ���ط����˵�ַ
            message.setFrom(new InternetAddress(from));
            // �����ռ��˵�ַ
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            // ���ر���
            message.setSubject(subject);

            // ��multipart����������ʼ��ĸ����������ݣ������ı����ݺ͸���
            Multipart multipart = new MimeMultipart();

            // �����ʼ����ı�����
            BodyPart contentPart = new MimeBodyPart();
            contentPart.setText(content);
            multipart.addBodyPart(contentPart);
            // ��Ӹ���
            BodyPart messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(affix);
            // ��Ӹ���������
            messageBodyPart.setDataHandler(new DataHandler(source));
            // ��Ӹ����ı���
            // �������Ҫ��ͨ�������Base64�����ת�����Ա�֤������ĸ����������ڷ���ʱ����������
            sun.misc.BASE64Encoder enc = new sun.misc.BASE64Encoder();
            messageBodyPart.setFileName("=?GBK?B?"
                    + enc.encode(affixName.getBytes()) + "?=");
            multipart.addBodyPart(messageBodyPart);

            // ��multipart����ŵ�message��
            message.setContent(multipart);
            // �����ʼ�
            message.saveChanges();
            // �����ʼ�
            Transport transport = session.getTransport("smtp");
            // ���ӷ�����������
            transport.connect(host, user, pwd);
            // ���ʼ����ͳ�ȥ
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    

    public static void main(String[] args) {
        MailUtils cn = new MailUtils();
        // ���÷����˵�ַ���ռ��˵�ַ���ʼ�����
        cn.setAddress("xxd1279@163.com", "2041088160@qq.com", "ɵɵɵɵɵɵɵɵɵɵɵɵɵɵɵɵɵɵɵɵɵɵɵɵɵɵɵɵɵɵɵ");
        // ����Ҫ���͸�����λ�úͱ���
        cn.setAffix("d:/xd.txt", "xd.txt");
        
        /**
         * ����smtp�������Լ�������ʺź�����
         * ��QQ ������Ϊ�����߲���ʹ ��ԭ������
         * 163 ������ԣ����Ǳ��뿪��  POP3/SMTP���� �� IMAP/SMTP����
         * ��Ϊ�������ڵ�������¼�����Ե�¼�������ʹ��163����Ȩ��  
         */

        // ע�⣺ [��Ȩ�����ƽʱ��¼�������ǲ�һ����]
        //for(int i = 0 ; i< 30; i++){
        cn.send("smtp.163.com", "xxd1279@163.com", "xxd1279");
        //}

    }
}