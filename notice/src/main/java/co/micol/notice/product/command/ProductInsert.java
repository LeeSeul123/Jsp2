package co.micol.notice.product.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.micol.notice.common.Command;
import co.micol.notice.product.service.ProductService;
import co.micol.notice.product.service.ProductVO;
import co.micol.notice.product.service.Impl.ProductServiceImpl;

public class ProductInsert implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		ProductService ps = new ProductServiceImpl();
		ProductVO vo = new ProductVO();
		
		
		// 제품등록 처리 및 파일업로드
		//String saveDir = "C:\\Users\\admin\\git\\Jsp2\\notice\\src\\main\\webapp\\upload";
		
		String saveDir="c:/temp/";
		int maxSize = 100 * 1024 * 1024; //최대 100MB까지 파일을 전송하겠다(HTTP프로토콜(서버의) 디폴트값은 200MB)
		
		try {
			MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, "utf-8", new DefaultFileRenamePolicy());
			String pfile = multi.getFilesystemName("pfile");
			pfile = saveDir + pfile;
			//오리지널 파일네임
			String ofile = multi.getOriginalFileName("pfile");
			
			vo.setProductId(multi.getParameter("productId"));
			vo.setProductName(multi.getParameter("productName"));
			
			if(ofile != null) {//제출한 제품등록서에 이미지가 존재한다는 뜻
				vo.setProductImage(ofile);
				vo.setProductDir(pfile);
			}
			
			ps.productInsert(vo);
			
		} catch(IOException e) { //파일이 없을때
			e.printStackTrace();
		}
	
		return "productList.do";
		
		
	}

}
