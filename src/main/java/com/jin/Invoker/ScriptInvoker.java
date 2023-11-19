package com.jin.Invoker;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.lang.InterruptedException;

/**
 * @author 大力pig
 * {@code @date} 2023/11/17
 **/
@Slf4j
public class ScriptInvoker {

    //识别不同系统然后跑bat文件
    public static void runBatFile(String batFilePath) {
        try {
            String os = System.getProperty("os.name").toLowerCase();

            ProcessBuilder processBuilder;

            //inheritIO 继承当前进程的输入、输出和错误流。这样可以简化代码，也有助于识别问题。
            if (os.contains("win")) {
                // Windows系统
                processBuilder = new ProcessBuilder("cmd.exe", "/c", batFilePath);
            } else if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
                // Unix/Linux/Mac系统
                processBuilder = new ProcessBuilder("bash", "-c", batFilePath);
            } else {
                System.out.println("Unsupported operating system");
                return;
            }

            // 设置工作目录，如果你的脚本依赖于特定的工作目录
            // processBuilder.directory(new File("C:\\path\\to\\your\\working\\directory"));

            // 启动进程
            Process process = processBuilder.start();

            // 等待进程执行完成
            int exitCode = process.waitFor();

            // 打印脚本的执行结果
            log.info("Exit Code: " + exitCode);

        } catch (IOException | InterruptedException e) {
            log.error("error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // 传入.bat文件的路径
        runBatFile(System.getProperty("user.dir") + "/src/main/resources/BeforeSuite.bat");
    }
}
