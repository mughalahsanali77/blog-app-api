package com.blog.app.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categoryId;
	@Column(name="title",length = 50, nullable = false)
	private String categoryTitle;
	@Column(name="description" ,length = 200)
	private String categoryDiscription;
	@OneToMany(mappedBy="category",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Post> posts;
}
