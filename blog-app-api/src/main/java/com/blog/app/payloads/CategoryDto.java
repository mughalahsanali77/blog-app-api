package com.blog.app.payloads;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
	private Long categoryId;
	@NotEmpty
	@Size(min=4 ,message ="Category Title must be atlest 4 charachters")
	private String categoryTitle;
	@NotEmpty
	@Size(min=10,message = "Minimum size of discription must be 10")
	private String categoryDiscription;

}
