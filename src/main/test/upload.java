import com.test.util.FastDFSUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class upload {

    @Autowired FastDFSUtil fastDFSUtil;

    @Test
    public void uploadFile() throws Exception {
        String fileName = "fastdfs/pom.xml";
        String saveFile = "fastdfs/pom1.xml";
        String result = fastDFSUtil.uploadFile(fileName, "xml");
        int downloadResult = fastDFSUtil.downloadFile(result, saveFile);
        int deleteResult   = fastDFSUtil.deleteFile(result);
        System.out.println(result);
        System.out.println(downloadResult);
        System.out.println(deleteResult);
    }
}
