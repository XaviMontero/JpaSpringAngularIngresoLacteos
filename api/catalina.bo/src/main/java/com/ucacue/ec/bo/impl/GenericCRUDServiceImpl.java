package com.ucacue.ec.bo.impl;

 import com.ucacue.ec.bo.GenericCRUDService;
 import com.ucacue.ec.persistence.repository.BaseRepository;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
 import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public abstract class GenericCRUDServiceImpl<DOMAIN, DTO> implements GenericCRUDService<DOMAIN, DTO> {

	@Autowired
	private BaseRepository<DOMAIN, Long> repository;

	@Override
	public void saveOrUpdate(DTO dtoObject) {
		DOMAIN domainObject = mapTo(dtoObject);
		repository.save(domainObject);
	}
	
	@Override
	public List<DTO> findAll(DTO dtoObject) {
		DOMAIN domainObject = mapTo(dtoObject);
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues().withIgnorePaths("id");
		List<DOMAIN> lstObjs = repository.findAll(Example.of(domainObject, matcher));
		return lstObjs.stream()
				.map(obj -> build(obj))
				.collect(Collectors.toList());
	}

	@Override
	public abstract DOMAIN mapTo(DTO domainObject);

	@Override
	public DOMAIN getfindObject(String user) {

		DOMAIN T  = repository.findObject(user);
		if (T!=null){
			return  T;
		}else {
			return null;
		}

	}

	@Override
	public DTO login(String user, String password) {
		try{
		DOMAIN T = repository.findLogin(user,password);

		if (T!=null){
			DTO S = build(T);
			return  S;
		}else {
			return null;
		}
		}catch (NullPointerException ex){
			return null;
		}

	}

}