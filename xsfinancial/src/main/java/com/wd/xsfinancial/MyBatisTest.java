package com.wd.xsfinancial;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.wd.xsfinancial.idao.CategoryMapper;
import com.wd.xsfinancial.idao.model.Category;


@Component
public class MyBatisTest {
	
	@Inject 
	private CategoryMapper  mapper;
	@PostConstruct
	public void test(){
		
	Category categy =	mapper.selectByPrimaryKey(1);
	//List<Category> records = mapper.getAll();
	//System.out.println("total count = "+records.size());

	}
	
	

}
