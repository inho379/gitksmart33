package kr.or.ksmart.ksmart_mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ksmart.ksmart_mybatis.mapper.Goodsmapper;
import kr.or.ksmart.ksmart_mybatis.vo.Goods;
import kr.or.ksmart.ksmart_mybatis.vo.Member;

@Service
public class GoodsService {
	
	@Autowired
	private Goodsmapper goodsmapper;
	public List<Goods> getGoodsList(){
		List<Goods> list=goodsmapper.getGoodsList();
		
		return goodsmapper.getGoodsList();		
	}
}
