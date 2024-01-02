package kr.co.restaurant.persistence;

import java.util.List;
import java.util.Map;

import kr.co.restaurant.domain.CategoryDTO;
import kr.co.restaurant.domain.Criteria;
import kr.co.restaurant.domain.RestaurantDTO;
import kr.co.restaurant.domain.RestaurantImgDTO;


public interface IRestaurantDAO {
	public List<RestaurantDTO> listAll(CategoryDTO categoryDto, Criteria cri) throws Exception;
	public List<RestaurantDTO> foodListSwipe(List<String> ctgryTwoNm)throws Exception;
	//public List<RestaurantDTO> getListPaging(Criteria cri)throws Exception;
	public List<RestaurantDTO> explain(CategoryDTO categoryDto) throws Exception;
	//식당 이미지 (9502개 삽입)
	public void insertImgList(RestaurantImgDTO restImg)throws Exception;
	public List<String> selectRestId() throws Exception;

}
