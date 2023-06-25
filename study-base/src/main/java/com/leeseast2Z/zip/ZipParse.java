package com.leeseast2Z.zip;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * @Author: Limf
 * @Date: 2023/6/25 16:48
 * @Description:
 */
public class ZipParse {
    public static void main(String[] args) throws UnsupportedEncodingException, URISyntaxException {
        String path = "templates/pptx/test/物业.pptx";
        File pptFile = new File(ZipParse.class.getClassLoader().getResource(path).toURI().getPath());
        try {
            ZipFile zipFile = new ZipFile(pptFile);
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry zipEntry = entries.nextElement();
                String entryName = zipEntry.getName();
                // 需要替换的幻灯片
                if (!"ppt/slides/".equalsIgnoreCase(entryName) && entryName.indexOf("ppt/slides/slide") != -1) {
                    System.out.println("zipEntry.getName() = " + zipEntry.getName());
                    // System.out.println("zipEntry.toString() = " + zipEntry);
                }else if(!"ppt/media/".equalsIgnoreCase(entryName) && entryName.indexOf("ppt/media/") != -1) {
                    System.out.println("zipEntry.getName() = " + zipEntry.getName());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
