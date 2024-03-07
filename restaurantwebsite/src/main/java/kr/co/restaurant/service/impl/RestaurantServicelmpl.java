package kr.co.restaurant.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.restaurant.domain.CategoryDTO;
import kr.co.restaurant.domain.Criteria;
import kr.co.restaurant.domain.RestaurantDTO;
import kr.co.restaurant.domain.RestaurantImgDTO;
import kr.co.restaurant.domain.RestaurantSearchDTO;
import kr.co.restaurant.domain.API.RestaurantData;
import kr.co.restaurant.persistence.IRestaurantDAO;
import kr.co.restaurant.service.IRestaurantService;

@Service
public class RestaurantServicelmpl implements IRestaurantService{
	@Autowired
	public IRestaurantDAO restDao;
	
	
	@Override
	public List<RestaurantDTO> listAll(CategoryDTO categoryDto, Criteria cri, RestaurantSearchDTO restSearchDto) throws Exception {
		
		return restDao.listAll(categoryDto, cri, restSearchDto);
	}
	//식당 카테고리 총 갯수
	@Override
	public int restTotalCnt(CategoryDTO categoryDto, RestaurantSearchDTO restSearchDto) throws Exception {
		return restDao.restTotalCnt(categoryDto, restSearchDto);
	}
	//메인 페이지 식당Swipe
	@Override
	public List<RestaurantDTO> foodListSwipe(List<String> ctgryTwoNm)throws Exception {
		
		return restDao.foodListSwipe(ctgryTwoNm);
	}
	//detailpage
	@Override
	public RestaurantDTO detailPage(String restId) throws Exception {
		return restDao.detailPage(restId);
	}
	//이미지 url
	@Override
	public String detailPageImgUrl(String restId) throws Exception {
		return restDao.detailPageImgUrl(restId);
	}
	
	//식당 이미지
	@Override
	public void insertImgList(RestaurantImgDTO restImg) throws Exception {
		restDao.insertImgList(restImg);
	}
	//식당 아이디 select
	@Override
	public List<String> selectRestId() throws Exception {
		return restDao.selectRestId();
	}
	
	//식당 Api
	@Override
	public void insertApi(List<RestaurantData> data, ArrayList<String> fcltyNmList) throws Exception {
		restDao.insertApi(data, fcltyNmList);
		
	}
	
	
	
	
}
