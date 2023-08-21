package com.blog.app.payloads;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	
	private Long id;
	@NotEmpty
	@Size(min=4 ,message ="username must be atlest 4 charachters")
	private String name;
	@Email(message="email address is not valid")
	private String email;
	@NotEmpty
	@Size(min=8,max=10,message="Minimum eight and maximum 10 characters, at least one uppercase letter, one lowercase letter, one number and one special character:")
//	@Pattern(regexp = "^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[^\\w\\d\\s:])([^\\s]){8,10}$")
	private String password;
	@NotEmpty
	private String about;
}
