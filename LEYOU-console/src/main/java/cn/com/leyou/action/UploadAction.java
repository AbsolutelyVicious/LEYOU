package cn.com.leyou.action;

import cn.com.leyou.core.tools.FastDFSTool;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

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

    @ResponseBody
    @RequestMapping(value = "/uploadPics.do")
    public List<String> uploadPics(@RequestParam MultipartFile[] pics) throws Exception {
        List<String> list = new ArrayList<>();
        for(MultipartFile mpf : pics){
            String s = FastDFSTool.uploadFile(mpf.getBytes(), mpf.getOriginalFilename());
            list.add(s);
        }
        return list;
    }

    @ResponseBody
    @RequestMapping("/upload/uploadFck.do")
    public HashMap<String,Object> uploadFck(HttpServletRequest  request, HttpServletResponse response) throws Exception {
        MultipartRequest mr = (MultipartRequest)request;
        Set<Map.Entry<String, MultipartFile>> entrySet = mr.getFileMap().entrySet();
        for(Map.Entry<String, MultipartFile> entry : entrySet){
            MultipartFile mpf = entry.getValue();
            String file = FastDFSTool.uploadFile(mpf.getBytes(), mpf.getOriginalFilename());
            HashMap<String, Object> map = new HashMap<>();
            map.put("error",0);
            map.put("url",file);
            return map;
        }
        return null;
    }
}
