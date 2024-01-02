package kr.co.restaurant.service;

import java.util.List;

import kr.co.restaurant.domain.BoardDTO;

public interface IBoardService {

	public void regiater(BoardDTO bDto) throws Exception;
	public BoardDTO read(Integer bno) throws Exception;
	public boolean modify(BoardDTO bDto) throws Exception;
	public boolean remove(Integer bno) throws Exception;
	public List<BoardDTO> listAll() throws Exception;
}
