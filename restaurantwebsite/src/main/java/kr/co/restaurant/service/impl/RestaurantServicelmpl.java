package kr.co.restaurant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.restaurant.domain.CategoryDTO;
import kr.co.restaurant.domain.Criteria;
import kr.co.restaurant.domain.RestaurantDTO;
import kr.co.restaurant.domain.RestaurantImgDTO;
import kr.co.restaurant.persistence.IRestaurantDAO;
import kr.co.restaurant.service.IRestaurantService;

@Service
public class RestaurantServicelmpl implements IRestaurantService{
	@Autowired
	public IRestaurantDAO restDao;
	
	
	@Override
	public List<RestaurantDTO> listAll(CategoryDTO categoryDto, Criteria cri) throws Exception {
		
		return restDao.listAll(categoryDto, cri);
	}
	@Override
	public List<RestaurantDTO> foodListSwipe(List<String> ctgryTwoNm)throws Exception {
		
		return restDao.foodListSwipe(ctgryTwoNm);
	}

//	@Override
//	public List<RestaurantDTO> getListPaging(Criteria cri) throws Exception {
//		return restDao.getListPaging(cri);
//	}
	
	
	
	//식당 이미지 (9502개 삽입)
	@Override
	public void insertImgList(RestaurantImgDTO restImg) throws Exception {
		restDao.insertImgList(restImg);
	}
	@Override
	public List<String> selectRestId() throws Exception {
		return restDao.selectRestId();
	}
	

}
