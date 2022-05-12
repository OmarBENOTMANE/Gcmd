package org.backend.gcmd.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDTO {

	private String code;
	private String message;
	private int status;
	private LocalDateTime dateTime;

	private Boolean deleted = false;

}