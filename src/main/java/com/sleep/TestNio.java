package com.sleep;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author
 */
public class TestNio {
    public static void main(String[] args) throws IOException {
        nioCopyFile("D:/demo/NIO/source.txt","D:/demo/NIO/destination.txt");
    }

    private static void nioCopyFile(String resource, String destination) throws IOException {
        FileInputStream fis = new FileInputStream(resource);
        FileOutputStream fos = new FileOutputStream(destination);
        FileChannel readChannel  = fis.getChannel();
        FileChannel writeChannel = fos.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while(true){
            buffer.clear();
            int len = readChannel.read(buffer);
            if(len == -1){
                break;
            }

        }
        readChannel.close();
        writeChannel.close();
    }
}
