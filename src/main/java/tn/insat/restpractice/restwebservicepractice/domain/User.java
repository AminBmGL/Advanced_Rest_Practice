package tn.insat.restpractice.restwebservicepractice.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(value="User Details", description="Contains all details of a user")
public class User {

	@Id
	@GeneratedValue
	private Integer id;

	@Size(min=2,message="Name should have 2 carachters at least")
	@ApiModelProperty(notes = "Name should have atleast 2 characters")
	private String name;

	@Past
	@ApiModelProperty(notes = "Birth Date should be in the Past") 
	private Date birthDate;
	
	@OneToMany(mappedBy="user")
	private List<Post> posts;


	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	protected User() {
	}

	public User(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
	

	
	
}
