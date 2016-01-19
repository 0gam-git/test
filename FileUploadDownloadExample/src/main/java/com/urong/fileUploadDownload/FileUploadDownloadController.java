package com.urong.fileUploadDownload;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileUploadDownloadController implements ApplicationContextAware {

	private WebApplicationContext context = null;

	@RequestMapping(value = "uploadForm.do")
	private String uploadForm() {

		return "upload";
	}

	private ModelAndView upload() {
		ModelAndView mav = new ModelAndView();

		return mav;
	}

	@RequestMapping(value = "fileUpload.do")
	private @ResponseBody String writeFile(MultipartFileModel model) {

		MultipartFile multipartfile = model.getFile();
		OutputStream out = null;
		try {
			System.out.println("save path : " + context.getServletContext().getRealPath(""));
			System.out.println("file upload : " + multipartfile.getName());
			System.out.println("file upload : " + multipartfile.getOriginalFilename());
			System.out.println("size : " + multipartfile.getSize());
			
			out = new FileOutputStream(context.getServletContext().getRealPath("/UpLoad/" + multipartfile.getOriginalFilename()));
			BufferedInputStream bis = new BufferedInputStream(multipartfile.getInputStream());
			byte[] buffer = new byte[4096];
			int read = 0;
			while ((read = bis.read(buffer)) > 0) {
				out.write(buffer, 0, read);
			}

		} catch (IOException ioe) {

		} finally {
			IOUtils.closeQuietly(out);
		}

		return "uploadSuccess";
	}

	@RequestMapping("downolad.do")
	public ModelAndView download(@RequestParam("fileName") String fileName) {
		
		String fullPath = context.getServletContext().getRealPath("/UpLoad/" + fileName);
		System.out.println("downloadPath== " +fullPath);
		File file = new File(fullPath);
		
		return new ModelAndView("download", "downloadFile", file);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = (WebApplicationContext) applicationContext;
	}
}
