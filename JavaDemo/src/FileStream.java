import javax.sound.sampled.AudioFormat;
import java.io.*;
import java.util.Base64;

public class FileStream {
    FileStream() {

    }

    // 文件输入流 FileInputStream
    void inputStreamDemo() {

        try {
            String filePath = "/Users/xiaoyuan/Desktop/安装参数.txt";
            // 可以使用字符串类型的文件名来创建一个输入流对象来读取文件：
            InputStream f = new FileInputStream(filePath);

            // 也可以使用一个文件对象来创建一个输入流对象来读取文件。我们首先得使用 File() 方法来创建一个文件对象：
            File file = new File(filePath);
            // 建立连接
            InputStream out = new FileInputStream(file);
            int n = 0;
            StringBuffer sBuffer = new StringBuffer();
            while (n != -1) { // 当n 不等于-1，则代表未到末尾
                //读取文件的一个字节(8个二进制位),并将其由二进制转成十进制的整数返回
                n = out.read();
                // 转换成字符
                char by = (char) n;
                sBuffer.append(by);
            }
            System.out.println(sBuffer.toString());
        } catch (FileNotFoundException e) {
            System.out.println("文件不存在或者文件不可读取或者文件是目录");
        } catch (IOException o) {
            System.out.println("读取过程存在异常");
        }
    }

    // 演示 InputStream 和 OutputStream 用法的例子：
    void inputOutputStreamDemo() {
        // 下面的例子，首先创建文件test.txt，并把给定的数字以二进制形式写进该文件，同时输出到控制台上
        try {
            // 写入文件
            File file = new File("/Users/xiaoyuan/Desktop/test.txt");
            byte bWrite[] = {11, 21, 3, 40, 5};
            OutputStream outputStream = new FileOutputStream(file);
            for (int x = 0; x < bWrite.length; x++) {
                outputStream.write(bWrite[x]);
            }
            // 写入完成后关闭
            outputStream.close();

            // 读取文件
            InputStream inputStream = new FileInputStream(file);
            int size = inputStream.available();
            StringBuffer sBuffer = new StringBuffer();
            for (int i = 0; i < size; i++) {
                char c = (char) inputStream.read();
                sBuffer.append(c + "");
                System.out.println((char) inputStream.read() + "  ");
            }
            inputStream.close();

        } catch (FileNotFoundException e) {
            System.out.println("文件不存在或者文件不可读取或者文件是目录");
        } catch (IOException e) {
            System.out.println(e.toString());
        }

        // 以上代码由于是二进制写入，可能存在乱码，你可以使用以下代码实例来解决乱码问题：
    }

    void inputOutputStreamDemo1() {
        File file = new File("/Users/xiaoyuan/Desktop/test.txt");
        if (file.exists() == false) {
            return;
        }

        try {

            /********* 写入文件 **********/

            // 构建FileOutputStream 输出流对象，文件不存在会自动创建
            FileOutputStream outputStream = new FileOutputStream(file);
            // 构建OutputStreamWriter 对象，参数可以指定编码，默认为操作系统编码，windows上是gbk
            OutputStreamWriter write = new OutputStreamWriter(outputStream, "UTF-8");
            // 写入到缓冲区
            write.append("中文输入");
            // 换行
            write.append("\n");
            // 刷新缓存区，写入到文件，如果下面已经没有写入到内容了，直接close 也会写入
            write.append("English");
            // 关闭输出流，释放系统资源
            write.close();
            outputStream.close();

            /********* 读取文件 **********/
            // 构建FileInputStream 输入流对象，
            FileInputStream inputStream = new FileInputStream(file);
            // 构建InputStreamReader 对象，编码与写入相同
            InputStreamReader reader = new InputStreamReader(inputStream, "UTF-8");

            StringBuffer sBuffer = new StringBuffer();
            while (reader.ready()) {
                // 转成char 加到StringBuffer 对象中
                sBuffer.append((char) reader.read());
            }
            System.out.println(sBuffer.toString());
            // 关闭读取流
            reader.close();
            // 关闭输入流，释放系统资源
            outputStream.close();

        } catch (FileNotFoundException e) {
            System.out.println("文件不存在或者文件不可读取或者文件是目录");
        } catch (UnsupportedEncodingException e) {
            System.out.println("不支持的编码");
        } catch (IOException e) {
            System.out.println("文件写入失败");
        }

    }

    // 从控制台读取字符，当输入q时停止
    void bufferedReaderDemo() {
        File file = new File("/Users/xiaoyuan/Desktop/test.txt");
        StringBuffer sBuffer = new StringBuffer();
        char c;
        // 使用System.in 创建BufferReader
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入字符，按下'q'键退出");
        try {
            // 读取字符
            do {
                 c = (char) bufferedReader.read();
                 sBuffer.append(c);
            } while (c != 'q');
        } catch (IOException e) {
            System.out.println("读取控制台失败");
        }

        // 将控制台输入的所有字符写入到文件
        System.out.println("开始写入文件:\n " + sBuffer.toString());
        try {
            OutputStream outputStream = new FileOutputStream(file);
            OutputStreamWriter write = new OutputStreamWriter(outputStream, "UTF-8");
            write.append(sBuffer.toString());
            write.close();
            outputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("文件不存在或者文件不可读取或者文件是目录");
        } catch (UnsupportedEncodingException e) {
            System.out.println("不支持的编码");
        } catch (IOException e) {
            System.out.println("文件写入或关闭失败");
        }

    }

    // 创建目录
    void mkdirsDemo() {
        // mkdir( )方法创建一个文件夹，成功则返回true，失败则返回false。失败表明File对象指定的路径已经存在，或者由于整个路径还不存在，该文件夹不能被创建。
        String dirName = "/Users/xiaoyuan/Desktop/test";
        File dir = new File(dirName);
        // 创建目录
        dir.mkdirs();
    }

    // 读取目录
    void readDirsDemo() {
        String dirName = "/Users/xiaoyuan/Desktop/test";
        File folder = new File(dirName);
        if (folder.isDirectory()) {
            System.out.println("正在读取目录 " + dirName);
            String s[] = folder.list();
            for (int i = 0; i < s.length; i++) {
                File subFile = new File(dirName + "/" + s[i]);
                if (subFile.isDirectory()) {
                    System.out.println(s[i] + " 是一个目录");
                }
                else {
                    System.out.println(s[i] + " 是一个文件");
                }
            }
        }
        else {
            System.out.println(dirName + " 不是一个目录");
        }
    }

    // 删除目录
    void deleteDirsDemo() {
        String dirName = "/Users/xiaoyuan/Desktop/test1";
        File folder = new File(dirName);
        System.out.println("开始测试删除文件：\n");
        deleteFolder(folder);
    }

    private void deleteFolder(File folder) {
        File[] files = folder.listFiles();
        if (files != null) {
            for (File f: files) {
                if (f.isDirectory()) {
                    deleteFolder(f);
                    System.out.println("准备删除这个目录中的内容：" + f.getName());
                }
                else {
                    System.out.println("删除了文件：" + f.getName());
                    f.delete();
                }
            }
        }
        System.out.println("删除了文件：" + folder.getName());
        folder.delete();
    }
}

