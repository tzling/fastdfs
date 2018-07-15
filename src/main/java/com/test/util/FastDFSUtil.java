package com.test.util;

import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

public class FastDFSUtil {
    private StorageClient1 storageClient1;
    FastDFSUtil(String conf) throws Exception {
        ClassPathResource url = new ClassPathResource(conf);
        ClientGlobal.init(url.getPath());
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);
        storageClient1 = new StorageClient1(trackerServer, storageServer);

    }
    public String uploadFile(byte[] bytes, String fileSuffix) throws Exception {
        if(storageClient1 == null)return null;
        return storageClient1.upload_file1(bytes, fileSuffix, null);
    }

    public String uploadFile(String fileName, String fileSuffix) throws Exception {
        if(storageClient1 == null)return null;
        return storageClient1.upload_file1(fileName, fileSuffix, null);
    }

    public byte[] downloadFile(String url) throws IOException, MyException {
        return storageClient1.download_file1(url);
    }

    public int downloadFile(String url,String fileName) throws IOException, MyException {
        return storageClient1.download_file1(url,fileName);
    }

    public int deleteFile(String fileName) throws IOException, MyException {
        return storageClient1.delete_file1(fileName);
    }

}
