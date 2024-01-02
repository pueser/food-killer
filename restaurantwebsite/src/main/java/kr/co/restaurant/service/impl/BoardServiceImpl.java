package kr.co.restaurant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.restaurant.domain.BoardDTO;
import kr.co.restaurant.persistence.IBoardDAO;
import kr.co.restaurant.service.IBoardService;

@Service
public class BoardServiceImpl implements IBoardService {
	@Autowired
	private IBoardDAO bDao;
	
	
	
	@Override
	public void regiater(BoardDTO bDto) throws Exception {
		bDao.create(bDto);
	}

	@Override
	public BoardDTO read(Integer bno) throws Exception {
		return bDao.read(bno);
	}

	@Override
	public boolean modify(BoardDTO bDto) throws Exception {
		return bDao.update(bDto) == 1;
	}

	@Override
	public boolean remove(Integer bno) throws Exception {
		return bDao.delete(bno) == 1;
	}

	@Override
	public List<BoardDTO> listAll() throws Exception {
		 return  bDao.listAll();
		 
	}

}















