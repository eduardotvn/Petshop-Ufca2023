package internetConnectionAPIs;

import org.apache.commons.mail.*;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class javaMail
{
	protected static String emailEmpresarial = "petshopufca2023@hotmail.com";
	protected static String senha;
	
	public static void sendMail(String emailCliente, String pass, String assunto, String mensagem)
	{
		senha = pass; 
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.office365.com");
		properties.put("mail.smtp.ssl.trust", "smtp.office365.com");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.starttls.required", "true");
		properties.put("mail.smtp.ssl.ciphersuites", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384");
		properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
		
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailEmpresarial, senha);
            }
        });
        
		SimpleEmail email = new SimpleEmail(); 
		email.setMailSession(session);


		try 
		{
			
			email.setFrom(emailEmpresarial);
			email.setSubject(assunto);
			email.setMsg(mensagem);
			email.addTo(emailCliente);
			email.send();
			System.out.println("Enviado com sucesso!");
			
		} catch(EmailException e)
		{
			e.printStackTrace();
		}
	}
}
