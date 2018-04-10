package com.zm.employee.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zm.employee.bean.EmpData;
import com.zm.employee.bean.Employee;
import com.zm.employee.bean.Msg;
import com.zm.employee.service.EmpDataService;

@Controller
public class EmpDataController {

	@Autowired
	private EmpDataService service;

	@ResponseBody
	@RequestMapping("/empData")
	public Msg cxMsg(@RequestParam String empid,HttpServletRequest rq) {

		List<EmpData> cxMsg = service.cxMsg(empid);
		rq.setAttribute("list", cxMsg);
		return Msg.success().add("msg", cxMsg);
	}

	//下载简历
	@RequestMapping("/download")    
	public ResponseEntity<byte[]> download(@RequestParam String id,HttpServletRequest req) throws IOException {    
		String path="";  
		File file=new File(path);  
		HttpHeaders headers = new HttpHeaders();    
		String fileName=new String("你好.xlsx".getBytes("UTF-8"),"iso-8859-1");//为了解决中文名称乱码问题  
		headers.setContentDispositionFormData("attachment", fileName);   
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);   
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),    
				headers, HttpStatus.CREATED);    
	}  
	// 单文件上传+资料更新
	@ResponseBody
	@RequestMapping(value = "user/empData",method = RequestMethod.POST)
	public Msg addEmpdata(@RequestParam(required = false) MultipartFile imageFile,HttpServletRequest req,
			EmpData data) throws IllegalStateException, IOException{
		req.setCharacterEncoding("utf-8");
		String filename =imageFile.getOriginalFilename();		//  获取上传文件名

		//判断上传的文件和文件名是否为空  
		if(imageFile!=null&&filename!="") {
			String uploadUrl = req.getSession().getServletContext().getRealPath("/") + "static/img/";
			System.out.println("filename:" + filename);
			File dir= new File(uploadUrl);
			if(!dir.exists()) {
				dir.mkdirs();
			}
			System.out.println("文件上传到：" + uploadUrl);
			//如果上传的图片名称不为空   就截出他的后缀
			File targetFile = new File(uploadUrl + data.getEmpid()  + filename.substring(filename.length()-4, filename.length()));


			if(!targetFile.exists()) {
				targetFile.createNewFile();				// 如果没有这个文件就创建新文件
			}

			imageFile.transferTo(targetFile);		// 把上传的文件的移动到这个文件夹内 完成上传   如果文件存在 直接覆盖
			//设置文件名  id+后缀
			data.setImg(data.getEmpid() + filename.substring(filename.length()-4, filename.length()));
			//			System.out.println(filename.substring(filename.length()-4, filename.length()));
		}

		service.addEmpdata(data);

		return Msg.success();

	}


	//简历上传
	@ResponseBody
	@RequestMapping(value = "user/scJl",method = RequestMethod.POST)
	public Msg scJl(@RequestParam(required = false) MultipartFile jlFile,HttpServletRequest req) throws IllegalStateException, IOException{
		req.setCharacterEncoding("utf-8");
		String filename =jlFile.getOriginalFilename();		//  获取上传文件名
		Employee e = (Employee) req.getSession().getAttribute("user");
		//判断上传的文件和文件名是否为空  
		if(jlFile!=null&&filename!="") {
			String uploadUrl = req.getSession().getServletContext().getRealPath("/") + "static/doc/";
			System.out.println("filename:" + filename);
			File dir= new File(uploadUrl);
			if(!dir.exists()) {
				dir.mkdirs();
			}
			System.out.println("文件上传到：" + uploadUrl);
			//如果上传的图片名称不为空   就截出他的后缀
			File targetFile = new File(uploadUrl + e.getEmpId()  + ".doc" );


			if(!targetFile.exists()) {
				targetFile.createNewFile();				// 如果没有这个文件就创建新文件
			}

			jlFile.transferTo(targetFile);		// 把上传的文件的移动到这个文件夹内 完成上传   如果文件存在 直接覆盖
			//设置文件名  id+后缀
		}
		return Msg.success();
	}
}
