package com.ucacue.ec.bo;

import java.util.List;

public interface GenericCRUDService<DOMAIN, DTO> {

	public void saveOrUpdate(DTO dtoObject);

	public List<DTO> findAll(DTO dtoObject);

	/**
	 * Allows to map a serializable object to a domain object
	 * @param dtoObject
	 * @return
	 */
	public DOMAIN mapTo(DTO dtoObject);
	
	/**
	 * Allows to serialize a domain object
	 * @param domainObject
	 * @return
	 */
	public DTO build(DOMAIN domainObject);

	public DOMAIN getfindObject (String user);

	public DTO login (String user , String password);



}