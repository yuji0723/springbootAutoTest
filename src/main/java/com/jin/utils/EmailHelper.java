package com.jin.utils;

import lombok.extern.slf4j.Slf4j;

import javax.mail.MessagingException;
import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * @author 大力pig
 * {@code @date} 2023/11/17
 **/
@Slf4j
public class EmailHelper {
    public final static String ALLURE_RESULTS_PATH = "target/allure-results";
    public final static String ALLURE_REPORT_PATH = "target/allure-report";



    //执行allure命令，产生报告
    public static void generateAllureReport() {
        try {
            // 执行Allure报告生成命令
            ProcessBuilder processBuilder = new ProcessBuilder("D:\\software\\allure-2.20.0\\bin\\allure.bat", "generate", ALLURE_RESULTS_PATH, "-o", ALLURE_REPORT_PATH);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            log.error("error:" +e.getMessage());
        }
    }



    //发邮箱
    public static void sendEmailWithAllureReport()  {
        // 发送邮件逻辑，调用你的邮件发送类的方法
        try {
//            EmailSender.sendEmail("your_email@example.com", "subject", "body", new File("path/to/allure-report/index.html"));
            EmailSender.sentEmail(ALLURE_REPORT_PATH + "/index.html");
        } catch (GeneralSecurityException e) {
            log.error("error:\n" +e.getMessage());
        }
    }
}
