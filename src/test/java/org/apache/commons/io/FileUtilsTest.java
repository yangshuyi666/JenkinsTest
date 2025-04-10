package org.apache.commons.io;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class FileUtilsTest {

    private File testFile;

    @Before
    public void setUp() throws Exception {
        // 创建一个测试文件
        testFile = new File("test.txt");
        try {
            testFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() throws Exception {
        // 删除测试文件
        if (testFile != null && testFile.exists()) {
            FileUtils.deleteQuietly(testFile);
        }
    }

    @Test(timeout = 1000)
    public void deleteQuietly() throws InterruptedException {
//        // 假设文件存在，调用 deleteQuietly 方法删除文件
//        // 然后断言文件仍然存在（故意让测试失败）
//        FileUtils.deleteQuietly(testFile);
//        assertTrue("文件应该被删除，但实际上仍然存在", testFile.exists());
        //停止2秒
        Thread.sleep(2000);
        assertTrue("error",false);
    }

    @Test
    public void readFileToString() {
        try {
            // 向文件中写入一些内容
            FileUtils.writeStringToFile(testFile, "Hello, World!", "UTF-8");
            // 读取文件内容
            String content = FileUtils.readFileToString(testFile, "UTF-8");
            // 断言读取的内容与预期不符（故意让测试失败）
            assertEquals("故意设置错误的预期内容", content, "Goodbye, World!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void writeStringToFile() {
        try {
            // 向文件中写入内容
            FileUtils.writeStringToFile(testFile, "Hello, World!", "UTF-8");
            // 再次读取文件内容
            String content = FileUtils.readFileToString(testFile, "UTF-8");
            // 断言读取的内容与写入的内容不符（故意让测试失败）
            assertNotEquals("内容应该相同，但实际上不同", content, "Hello, World!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}