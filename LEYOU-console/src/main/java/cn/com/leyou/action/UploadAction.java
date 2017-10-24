package cn.com.leyou.action;

import cn.com.leyou.core.tools.Constants;
import cn.com.leyou.core.tools.FastDFSTool;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

/**
 * @author XuYuandong
 * @create 2017-10-24 10:26 AM
 * @desc
 **/
@Controller
public class UploadAction {

    @ResponseBody
    @RequestMapping(value = "/uploadFile.do")
    public HashMap<String,String> uploadFile(MultipartFile pic) throws Exception {
        System.out.println(pic.getOriginalFilename());
        String uploadFile = FastDFSTool.uploadFile(pic.getBytes(),pic.getOriginalFilename());
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("path",uploadFile);
        System.out.println(uploadFile);
        return hashMap;
    }

}
