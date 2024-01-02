package kr.co.restaurant.persistence;

import java.util.List;

import kr.co.restaurant.domain.BoardDTO;

public interface IBoardDAO {

	public void create(BoardDTO bDto) throws Exception;
	public BoardDTO read(Integer bno) throws Exception;
	public int update(BoardDTO bDto) throws Exception;
	public int delete(Integer bno) throws Exception;
	public List<BoardDTO> listAll() throws Exception;
}
