package com.ucacue.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CatalinaResponseDTO {

	private boolean success;

	
	public CatalinaResponseDTO() {
		this.success = true;
	}

	
}