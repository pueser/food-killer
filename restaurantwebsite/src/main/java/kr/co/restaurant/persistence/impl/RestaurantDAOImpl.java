package kr.co.restaurant.persistence.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.restaurant.domain.CategoryDTO;
import kr.co.restaurant.domain.Criteria;
import kr.co.restaurant.domain.RestaurantDTO;
import kr.co.restaurant.domain.RestaurantImgDTO;
import kr.co.restaurant.domain.RestaurantSearchDTO;
import kr.co.restaurant.domain.API.RestaurantData;
import kr.co.restaurant.persistence.IRestaurantDAO;
import lombok.extern.log4j.Log4j;

@Log4j
@Repository
public class RestaurantDAOImpl implements IRestaurantDAO {
	
	@Autowired
	public SqlSession session;
	
	
	//식당 카테고리 list출력
	@Override
	public List<RestaurantDTO> listAll(CategoryDTO categoryDto, Criteria cri, RestaurantSearchDTO restSearchDto) throws Exception {
		//카테고리
		Map<Object, Object> map= new HashMap<>();
		map.put("getFoodAll", categoryDto.getFoodAll());
		map.put("southAmeri", categoryDto.getSouthAmeri());
		map.put("aisa", categoryDto.getAisa());
		map.put("northAmeri", categoryDto.getNorthAmeri());
		map.put("afri", categoryDto.getAfri());
		map.put("oceania", categoryDto.getOceania());
		map.put("eur", categoryDto.getEur());
		map.put("medEast", categoryDto.getMedEast());
		map.put("carriSea", categoryDto.getCarriSea());
		map.put("medTerr", categoryDto.getMedTerr());
		map.put("serviceAll", categoryDto.getServiceAll());
		map.put("freParkngAt", categoryDto.getFreParkngAt());
		map.put("valetParkngPosblAt", categoryDto.getValetParkngPosblAt());
		map.put("infnChairLendPosblAt", categoryDto.getInfnChairLendPosblAt());
		map.put("wchairHoldAt", categoryDto.getWchairHoldAt());
		map.put("petPosblAt", categoryDto.getPetPosblAt());
		map.put("vgtrMenuHoldAt", categoryDto.getVgtrMenuHoldAt());
		//페이징
		map.put("amount", cri.getAmount());
		map.put("pageNum", cri.getPageNum());
		//식당검색
		map.put("choDiv", restSearchDto.getChoDiv());
		map.put("restSearch", restSearchDto.getRestSearch());
		map.put("searchRange1", restSearchDto.getSearchRange1());
		map.put("searchRange2", restSearchDto.getSearchRange2());
		
		System.out.println("restSearchDto == " + restSearchDto.toString());
		return session.selectList("restaurantMapper.listAll", map);
	}
	
	//식당 카테고리 총 갯수
	@Override
	public int restTotalCnt(CategoryDTO categoryDto, RestaurantSearchDTO restSearchDto) throws Exception {
		//카테고리
		Map<Object, Object> map= new HashMap<>();
		map.put("getFoodAll", categoryDto.getFoodAll());
		map.put("southAmeri", categoryDto.getSouthAmeri());
		map.put("aisa", categoryDto.getAisa());
		map.put("northAmeri", categoryDto.getNorthAmeri());
		map.put("afri", categoryDto.getAfri());
		map.put("oceania", categoryDto.getOceania());
		map.put("eur", categoryDto.getEur());
		map.put("medEast", categoryDto.getMedEast());
		map.put("carriSea", categoryDto.getCarriSea());
		map.put("medTerr", categoryDto.getMedTerr());
		map.put("serviceAll", categoryDto.getServiceAll());
		map.put("freParkngAt", categoryDto.getFreParkngAt());
		map.put("valetParkngPosblAt", categoryDto.getValetParkngPosblAt());
		map.put("infnChairLendPosblAt", categoryDto.getInfnChairLendPosblAt());
		map.put("wchairHoldAt", categoryDto.getWchairHoldAt());
		map.put("petPosblAt", categoryDto.getPetPosblAt());
		map.put("vgtrMenuHoldAt", categoryDto.getVgtrMenuHoldAt());
		//식당검색
		map.put("choDiv", restSearchDto.getChoDiv());
		map.put("restSearch", restSearchDto.getRestSearch());
		map.put("searchRange1", restSearchDto.getSearchRange1());
		map.put("searchRange2", restSearchDto.getSearchRange2());
		
		return session.selectOne("restaurantMapper.restTotalCnt", map);
	}
	
	//detailPage
	@Override
	public RestaurantDTO detailPage(String restId) throws Exception {
		return session.selectOne("restaurantMapper.detailPage", restId);
	}
	//이미지 url
	@Override
	public String detailPageImgUrl(String restId) throws Exception {
		return session.selectOne("restaurantMapper.detailPageImgUrl", restId);
	}
	//메인 페이지 식당 Swipe출력
	@Override
	public List<RestaurantDTO> foodListSwipe(List<String> ctgryTwoNm)throws Exception{
		return session.selectList("restaurantMapper.foodListSwife", ctgryTwoNm);
	}	
	
	//식당이미지 DB 저장
	@Override
	public void insertImgList(RestaurantImgDTO restImg) throws Exception {
		
		String restFileName = restImg.getRestFileName();
		String restId = restImg.getRestId();
		String restUuid = restImg.getRestUuid();
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("restFileName", restFileName);
		map.put("restUuid", restUuid);
		map.put("restId", restId);
		
		session.insert("restaurantMapper.insertImgList", map);
		
	}
	//식당 restId 가져오기(식당이미지fk사용)(9502개)
	@Override
	public List<String> selectRestId() throws Exception {
		return session.selectList("restaurantMapper.selectRestId");
	}

	//식당 Api
	@Override
	public void insertApi(List<RestaurantData> data, ArrayList<String> fcltyNmList) throws Exception {
		
		//식당이름 초성으로 변경
		List<String> fcltyNmChosung = new ArrayList<String>();
		for (String fcltyNm : fcltyNmList) {
			fcltyNmChosung.add(session.selectOne("restaurantMapper.chosung", fcltyNm));
		}
		System.out.println("chosung 식당이름 결과 = " + fcltyNmChosung.toString());
		
		//초성이름 data 리스트에 추가
		for (int i = 0; i < data.size(); i++) {
			data.get(i).setChosung(fcltyNmChosung.get(i));
		}
		System.out.println("data 결과 = " + data.toString());
		
		//식당 API 삽입
		for (RestaurantData restaurantData : data) {
			session.insert("restaurantMapper.insertApi", restaurantData);
		}
	}

	

	
	
	

	

	


}
