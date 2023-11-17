package com.jin.listeners;

/**
 * @author 大力pig
 * {@code @date} 2023/11/17
 **/
import com.jin.utils.EmailHelper;
import org.testng.ISuiteListener;
import org.testng.ISuite;
public class AfterSuiteListener implements ISuiteListener {
    @Override
    public void onStart(ISuite iSuite) {
        //do nothing
    }

    //suite套件都测试结束时候发送邮件
    @Override
    public void onFinish(ISuite iSuite) {
        if (iSuite.getName().equals("Auto Report Suite")){
            EmailHelper.sendEmailWithAllureReport();
        }
    }
}
