package com.dingwang.File;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MapFileToMemory {

    private String              path;
    //    @Resource
    //    private IFileManager        fileManager;

    private static final Logger log = LoggerFactory.getLogger(MapFileToMemory.class);

    //    public static void main(String[] args) throws IOException {
    //        File file = new File("E:\\生产问题查询\\policy_biz_id_2015.dat");
    //        MapFileToMemory mf = new MapFileToMemory();
    //        try {
    //            mf.parseFile();
    //        } catch (FileNotFoundException e) {
    //            e.printStackTrace();
    //        }
    //    }

    /**
     * 对一个文件画块后开启不同的线程，线程中划分的块中要记录下一个块的位置。
     * 
     * @throws IOException
     */
    public void parseFile() throws IOException {

        if (log.isWarnEnabled()) {
            log.warn("---------------update jhs policy task start--------------filepath=" + path);
        }

        long start = System.currentTimeMillis();

        File file = new File("E:\\生产问题查询\\policy_biz_id_2015.dat");//"E:\\生产问题查询\\policy_biz_id_2015.dat"
        if (!file.exists()) {
            log.error("文件不存在parseFile()=======filePath-->" + path);
            return;
        }
        try {
            long length = file.length();
            @SuppressWarnings("resource")
            MappedByteBuffer buffer = new RandomAccessFile(file, "r").getChannel().map(FileChannel.MapMode.READ_ONLY, 0,
                    file.length());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < (int) length; i++) {
                if (buffer.get(i) == 10) {//判断遇到换行符，处理此行数据
                    System.out.println(sb.toString());
                    //                    fileManager.excuteContent(sb.toString());
                    sb.delete(0, sb.length());
                } else if (i == length - 1) {//判断到了最后一行，处理此行数据
                    sb.append((char) buffer.get(i));
                    System.out.println(sb.toString());
                    //                    fileManager.excuteContent(sb.toString());
                } else {//拼接成一行数据
                    sb.append((char) buffer.get(i));
                }
            }
            sb = null;
        } catch (FileNotFoundException e) {
            log.error("cannot find the file" + file);
        } catch (IOException e) {
            log.error("IOException");
        } finally {
            if (log.isWarnEnabled()) {
                log.warn("处理文件时间(parseFile):" + (System.currentTimeMillis() - start) / 1000);
                log.warn("---------------update jhs policy task end--------------");
            }
        }
    }

    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path the path to set
     */
    public void setPath(String path) {
        this.path = path;
    }

}
