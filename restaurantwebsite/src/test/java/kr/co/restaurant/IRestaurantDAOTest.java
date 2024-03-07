package kr.co.restaurant;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.restaurant.domain.CategoryDTO;
import kr.co.restaurant.domain.Criteria;
import kr.co.restaurant.domain.RestaurantDTO;
import kr.co.restaurant.domain.RestaurantImgDTO;
import kr.co.restaurant.domain.RestaurantSearchDTO;
import kr.co.restaurant.persistence.IRestaurantDAO;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")
@Log4j
public class IRestaurantDAOTest {

	@Autowired
	public IRestaurantDAO restDao;
	
//	@Test
//	public void testListAll()throws Exception{
//		CategoryDTO categoryDto = new CategoryDTO();
//		categoryDto.setFreParkngAt("1");
//		categoryDto.setValetParkngPosblAt(null);
//		categoryDto.setInfnChairLendPosblAt(null);
//		categoryDto.setWchairHoldAt(null);
//		categoryDto.setPetPosblAt(null);
//		categoryDto.setVgtrMenuHoldAt(null);
//		categoryDto.setSouthAmeri(null);
//		categoryDto.setAisa("1");
//		categoryDto.setNorthAmeri(null);
//		categoryDto.setAfri(null);
//		categoryDto.setOceania(null);
//		categoryDto.setEur(null);
//		categoryDto.setMedEast(null);
//		categoryDto.setCarriSea(null);
//		categoryDto.setMedTerr(null);
//		categoryDto.setFoodAll(null);
//		categoryDto.setServiceAll(null);
//		
//		
//		
//		restDao.listAll(categoryDto);
//		log.info("categoryDto:===================="+ categoryDto.getAfri());
//
//	}
	
//	@Test
//	public void testSelectURL()throws Exception{
//		
//		List<RestaurantImgDTO> list = restDao.selectRestMainImg();
//		String filName = list.get(0).getRestFileName();
//		String uuid = list.get(0).getRestUuid();
//		System.out.println("fileName" + filName);
//		System.out.println("uuid" + uuid);
//		System.out.println("size" + list.size());
		
//		for (int i = 0; i < 5; i++) {
//			String restFileName = fileName.get(i);
//			String restUuid = uuid.get(i);
//			//uuid, 파일이름 합친 식당이미지 파일이름 생성
//			String uploadFileName = restUuid + "_" + restFileName;
//			
//			System.out.println("uploadFileName === " + uploadFileName);
//			
//			//uuid, 파일이름 합친 이미지 파일객체
////			File saveFile = new File(uploadFolder, uploadFileName);
////			saveFile.createNewFile();
//			System.out.println("파일 생성 갯수 === " + i);
//		}
//	}
	
//	@Test
//	public void insertRestaurantImgs()throws Exception{
//		RestaurantImgDTO restImg = new RestaurantImgDTO();
//		restImg.setRestId("1");
//		restImg.setRestUuid("61ca4a07-832c-463c-b77f-8b5ae96d6815");
//		restImg.setRestFileName("https://ukcooyocdlvo8099722.cdn.ntruss.com/public_data/menu_images/985754_1638846214_menu.jpg");
//		
//		restDao.insertImgList(restImg);
//	}
	
//	@Test
//	public void selectFoodListSwife() throws Exception {
//		List<String> ctgryTwoNm = new ArrayList<>();
//
//		
//		ctgryTwoNm.add("동남아시아음식");
//		ctgryTwoNm.add("동아시아음식");
//		ctgryTwoNm.add("서아시아음식");
//		ctgryTwoNm.add("인도아시아음식");
//		
//		
//		System.out.println("foodList == " + ctgryTwoNm.toString());
//		
//		restDao.foodListSwipe(ctgryTwoNm);		
//	}
	
//	@Test
//	public void selectRestaurantPaging() throws Exception {
//		
//		CategoryDTO categoryDto = new CategoryDTO();
//		categoryDto.setFreParkngAt(null);
//		categoryDto.setValetParkngPosblAt(null);
//		categoryDto.setInfnChairLendPosblAt(null);
//		categoryDto.setWchairHoldAt(null);
//		categoryDto.setPetPosblAt(null);
//		categoryDto.setVgtrMenuHoldAt(null);
//		categoryDto.setSouthAmeri(null);
//		categoryDto.setAisa(null);
//		categoryDto.setNorthAmeri(null);
//		categoryDto.setAfri(null);
//		categoryDto.setOceania(null);
//		categoryDto.setEur(null);
//		categoryDto.setMedEast(null);
//		categoryDto.setCarriSea(null);
//		categoryDto.setMedTerr(null);
//		categoryDto.setFoodAll(null);
//		categoryDto.setServiceAll(null);
//		
//		RestaurantSearchDTO restSearchDto = new RestaurantSearchDTO(); 
//		restSearchDto.setChoDiv("choSrch");
//		restSearchDto.setRestSearch(null);
//		restSearchDto.setSearchRange1("가");
//		restSearchDto.setSearchRange2("나");
//		
//		
//		restDao.restTotalCnt(categoryDto, restSearchDto);
//	}
	
	@Test
	public void selectRestaurantPaging() throws Exception {
		
		CategoryDTO categoryDto = new CategoryDTO();
		categoryDto.setFreParkngAt(null);
		categoryDto.setValetParkngPosblAt(null);
		categoryDto.setInfnChairLendPosblAt("1");
		categoryDto.setWchairHoldAt(null);
		categoryDto.setPetPosblAt(null);
		categoryDto.setVgtrMenuHoldAt(null);
		categoryDto.setSouthAmeri(null);
		categoryDto.setAisa(null);
		categoryDto.setNorthAmeri("1");
		categoryDto.setAfri(null);
		categoryDto.setOceania(null);
		categoryDto.setEur(null);
		categoryDto.setMedEast(null);
		categoryDto.setCarriSea(null);
		categoryDto.setMedTerr(null);
		categoryDto.setFoodAll(null);
		categoryDto.setServiceAll(null);
		
		RestaurantSearchDTO restSearchDto = new RestaurantSearchDTO(); 
		restSearchDto.setChoDiv(null);
		restSearchDto.setRestSearch(null);
		restSearchDto.setSearchRange1(null);
		restSearchDto.setSearchRange2(null);
		
		Criteria cri = new Criteria();
		cri.setAmount(10);
		cri.setPageNum(1);
		cri.setRestSearch(null);
		
		
		restDao.listAll(categoryDto, cri, restSearchDto);
	}
	

}
