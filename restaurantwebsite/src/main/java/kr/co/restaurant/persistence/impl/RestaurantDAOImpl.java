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
import kr.co.restaurant.persistence.IRestaurantDAO;
import lombok.extern.log4j.Log4j;

@Log4j
@Repository
public class RestaurantDAOImpl implements IRestaurantDAO {
	
	@Autowired
	public SqlSession session;
	
	
	//식당 카테고리 list출력
	@Override
	public List<RestaurantDTO> listAll(CategoryDTO categoryDto, Criteria cri) throws Exception {
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
		
		map.put("amount", cri.getAmount());
		map.put("pageNum", cri.getPageNum());
		
		System.out.println("categoryDto == " + categoryDto.toString());
		return session.selectList("restaurantMapper.listAll", map);
	}
	
	//메인 페이지 식당 Swipe출력
	@Override
	public List<RestaurantDTO> foodListSwipe(List<String> ctgryTwoNm)throws Exception{
		return session.selectList("restaurantMapper.foodListSwife", ctgryTwoNm);
	}	
	
	@Override
	public List<RestaurantDTO> explain(CategoryDTO categoryDto) throws Exception {
		
		return session.selectList("restaurantMapper.explain", categoryDto);
	}

	
	//식당리스트 페이징처리
//	@Override
//	public List<RestaurantDTO> getListPaging(Criteria cri) throws Exception {
//		return session.selectList("restaurantMapper.getListPaging", cri);
//	}
	
	
	
	//식당이미지 DB 저장(9502개)
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

	

	


}
