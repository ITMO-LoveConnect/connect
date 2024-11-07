package ru.itmo.loveconnect.mail;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender emailSender;
    private final SpringTemplateEngine springTemplateEngine;

    @Value("${app.mail.smtp-username}")
    private String smtpUsername;

    public void sendLoginConfirmationCode(@NotNull String to, @NotNull String confirmationCode) throws MessagingException {
        sendMessageUsingThymeleafTemplate(to, "Код подтверждения для ITMO LoveConnect",
                "confirmation.html", Map.of(
                        "confirmation_code", confirmationCode
                ));
    }

    @SuppressWarnings("SameParameterValue")
    private void sendMessageUsingThymeleafTemplate(
            String to, String subject, String templateName,
            Map<String, Object> templateModel) throws MessagingException {

        Context thymeleafContext = new Context();
        thymeleafContext.setVariables(templateModel);
        String htmlBody = springTemplateEngine.process(templateName, thymeleafContext);

        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        helper.setTo(to);
        helper.setFrom(smtpUsername);
        helper.setSubject(subject);
        helper.setText(htmlBody, true);
        emailSender.send(message);
    }

}
