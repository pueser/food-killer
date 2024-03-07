package kr.co.restaurant.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.co.restaurant.domain.CategoryDTO;
import kr.co.restaurant.domain.Criteria;
import kr.co.restaurant.domain.RestaurantDTO;
import kr.co.restaurant.domain.RestaurantImgDTO;
import kr.co.restaurant.domain.RestaurantSearchDTO;
import kr.co.restaurant.domain.API.RestaurantData;


public interface IRestaurantDAO {
	public List<RestaurantDTO> listAll(CategoryDTO categoryDto, Criteria cri, RestaurantSearchDTO restSearchDto) throws Exception;
	//식당 카테고리 총 갯수
	public int restTotalCnt(CategoryDTO categoryDto, RestaurantSearchDTO restSearchDto) throws Exception;
	//메인 페이지 식당Swipe
	public List<RestaurantDTO> foodListSwipe(List<String> ctgryTwoNm)throws Exception;
	//detailPage
	public RestaurantDTO detailPage(String restId)throws Exception;
	//이미지 url
	public String detailPageImgUrl(String restId)throws Exception;
	//식당 Api
	public void insertApi(List<RestaurantData> data, ArrayList<String> fcltyNmList)throws Exception;
	//식당 이미지
	public void insertImgList(RestaurantImgDTO restImg)throws Exception;
	public List<String> selectRestId() throws Exception;

}
