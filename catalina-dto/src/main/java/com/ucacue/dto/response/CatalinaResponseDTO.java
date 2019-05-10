package com.ucacue.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CatalinaResponseDTO<T> {

	private boolean success;
	private T result;
	
	public CatalinaResponseDTO() {
		this.success = true;
	}
	
	public CatalinaResponseDTO(T result) {
		this.success = true;
	}
	
}