package com.lzxuni.config;

import net.sf.jmimemagic.Magic;
import net.sf.jmimemagic.MagicMatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 
 * @Description: 处理项目的静态资源
 * @author 孙志强
 * @date 2017年3月6日 上午10:27:26
 * @version v1.0
 * @since v1.0
 */
public class StaticResourceFilter implements Filter {
	protected Logger log = LoggerFactory.getLogger(StaticResourceFilter.class);

	@Autowired
	private AttachmentConfig attachmentConfig;

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String uri = httpRequest.getServletPath();
		// 读取流文件渲染页面
		showPage(uri, httpRequest, httpResponse, chain);
	}

	@Override
	public void init(FilterConfig filterconfig)  {
	}

	private void showPage(String uri, HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		response.setCharacterEncoding("UTF-8");
		//过滤规则，如果有图片则渲染，提高访问速度
		if(uri.contains("resource")){
				String mimeType = "";
				try {
					MagicMatch match = Magic.getMagicMatch(new File(attachmentConfig.getPath() + uri),true);
					mimeType = match.getMimeType() ;
				} catch (Exception e1) {
					log.error(e1.getClass().getName()+":"+e1.getMessage());
					e1.printStackTrace();
				}
				response.setContentType(mimeType);

		}else {
			chain.doFilter(request, response);
			return ;
		}
		ServletOutputStream out;
		// 通过文件路径获得File对象
		File html_file = new File(attachmentConfig.getPath() + uri);
		try {
			FileInputStream inputStream = new FileInputStream(html_file);
			out = response.getOutputStream();
			int b = 0;
			byte[] buffer = new byte[1024];
			while ((b = inputStream.read(buffer)) != -1) {
				out.write(buffer, 0, b);
			}
			inputStream.close();
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			log.error(e.getClass().getName()+":"+e.getMessage());
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			e.printStackTrace(); 
		} catch (IOException e) {
			log.error(e.getClass().getName()+":"+e.getMessage());
			e.printStackTrace();
		}
	}
}