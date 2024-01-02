package kr.co.restaurant;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.restaurant.persistence.IBoardDAO;
import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")
@Log4j
public class IBoardDAOTest {
	@Autowired
	private IBoardDAO bDao;
	
//	@Test
//	public void testCreate() throws Exception {
//		
//		BoardDTO bDto = new BoardDTO();
//		bDto.setTitle("�깉濡쒖슫 湲��쓣 �벑濡앺빀�땲�떎.");
//		bDto.setContent("�깉濡쒖슫 湲��쓣 �벑濡앺빀�땲�떎.");
//		bDto.setWriter("user03");
//		
//		bDao.create(bDto);
//	}

//@Test
//public void testRead() throws Exception {
//	log.info(bDao.read(4).toString());
//}

//@Test
//public void testUpdate() throws Exception {
//	BoardDTO bDto = new BoardDTO();
//	bDto.setBno(5);
//	bDto.setTitle("�닔�젙�맂 湲��엯�땲�떎.");
//	bDto.setContent("�닔�젙�맂 湲��엯�땲�떎.");
//	log.info("testUpdate................................" + bDao.update(bDto));
//	bDao.update(bDto);
//}


	@Test
	public void testDelete() throws Exception {
	bDao.delete(9);
	log.info("dlete........................................" + bDao.delete(2));
	}
	
//	@Test
//	public void testListAll() throws Exception {
//		
//		log.info("listAll......................" + bDao.listAll());
//	}
}