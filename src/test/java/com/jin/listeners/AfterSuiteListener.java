package com.jin.listeners;

/**
 * @author 大力pig
 * {@code @date} 2023/11/17
 **/
import com.jin.Invoker.ScriptInvoker;
import com.jin.utils.EmailHelper;
import lombok.extern.slf4j.Slf4j;
import org.testng.ISuiteListener;
import org.testng.ISuite;
@Slf4j
public class AfterSuiteListener implements ISuiteListener {
    @Override
    public void onStart(ISuite iSuite) {
        log.info("auto project start run");
//        ScriptInvoker.runBatFile(System.getProperty("user.dir") + "/src/main/resources/BeforeSuite.bat");
    }

    //suite套件都测试结束时候发送邮件
    @Override
    public void onFinish(ISuite iSuite) {
        if (iSuite.getName().equals("Auto Report Suite")){
            EmailHelper.generateAllureReport();
            EmailHelper.sendEmailWithAllureReport();
        }
        log.info("auto project stop run");
    }
}
