package kr.co.restaurant;

import java.io.File;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.co.restaurant.domain.MemberAttachDTO;
import kr.co.restaurant.service.IMemberService;
import lombok.extern.log4j.Log4j;
import net.coobird.thumbnailator.Thumbnails;

@Controller
@Log4j
public class ProfileUploadController {
	@Autowired
	public IMemberService service;
	
	String uploadFolder = "D:\\workspace\\spring4-4.10.0.RELEASE\\restaurantwebsite\\src\\main\\webapp\\resources\\fileUpload\\profile";
	
	
	/*profile 파일 업로드 */
	
	@RequestMapping(value = "/profileUploadAjaxAction", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE) //UTF-8로 인코딩
	@ResponseBody
	public ResponseEntity<MemberAttachDTO> profileUploadAjaxActionPOST(MultipartFile uploadFile, Model model) {
		System.out.print("profileUploadAjaxActionPOST..........");
		
		/* 이미지 파일 체크 */
		File checkfile = new File(uploadFile.getOriginalFilename());
		String type = null; //MIME TYPE을 저장할 String 타입
		
		try {
			type = Files.probeContentType(checkfile.toPath());
			System.out.println("파일 type = " + type);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(!type.startsWith("image")) { //파일일 이미지가 아니라면 null값 부여
			MemberAttachDTO list = null;
			return new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
		}
		
		MemberAttachDTO MemberAttachDTO = new MemberAttachDTO(); // DTO생성해서 set으로 담아주기
			
		/* 파일 이름 */
		String uploadFileName = uploadFile.getOriginalFilename();
		MemberAttachDTO.setFileName(uploadFileName); //파일 이름 
		/*똑같은 이름이 생성되지 않도록 이름 앞에 숫자 붙이기*/
		String uuid = UUID.randomUUID().toString();
		uploadFileName = uuid + "_" + uploadFileName;
		MemberAttachDTO.setUuid(uuid); // 램덤함수
		
		/* 파일 위치, 파일 이름을 합친 File 객체 */
		File saveFile = new File(uploadFolder, uploadFileName);//파일 경로에 업로드한 파일 이름으로 생성하겠다.
			
		/* 파일 저장 */
		try {
			uploadFile.transferTo(saveFile);
			File thumbnailFile = new File(uploadFolder, "s_" + uploadFileName);// 파일 경로에 썸네일 파일 이름을 생성하겠다.
			Thumbnails.of(saveFile).size(160, 160).toFile(thumbnailFile);//Thumbnails 라이브러리 사용하여 썸네일 사이즈 조정
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		
		ResponseEntity<MemberAttachDTO> result = new ResponseEntity<MemberAttachDTO>(MemberAttachDTO, HttpStatus.OK);
		return result;
	}
	
	/*이미지 파일 보여주기*/
	@GetMapping("/display")
	public ResponseEntity<byte[]> getImage(String fileName){
		File file = new File("D:\\workspace\\spring4-4.10.0.RELEASE\\restaurantwebsite\\src\\main\\webapp\\resources\\fileUpload\\profile\\" + fileName);
		System.out.print("display..........");
		ResponseEntity<byte[]> result = null;
		
		try {
			
			HttpHeaders header = new HttpHeaders(); //뷰로 전달할 header객체 생성
			header.add("Content-type", Files.probeContentType(file.toPath())); // content-type에 파일 확장자 추가
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK); // 뷰로 header, body, status 상태 전송
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/*이미지 파일 삭제*/
	@PostMapping("/deleteFile")
	public ResponseEntity<String> deleteFile(String fileName){
		System.out.print("deleteFile........" + fileName);
		File file = null;
		
		try {
			/* 썸네일 파일 삭제  파일 생성을 위해 UTF-8 디코딩*/
			file = new File("D:\\workspace\\spring4-4.10.0.RELEASE\\restaurantwebsite\\src\\main\\webapp\\resources\\fileUpload\\profile\\", URLDecoder.decode(fileName, "UTF-8")); 
			file.delete();
			
			/* 원본 파일 삭제 */
			String originFileName = file.getAbsolutePath().replace("s_", ""); //이미 썸네일 파일 지정하면서 file경로가 있기 때문에..
			file = new File(originFileName);
			file.delete();
			
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("fail", HttpStatus.NOT_IMPLEMENTED);
		}
		
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
}
