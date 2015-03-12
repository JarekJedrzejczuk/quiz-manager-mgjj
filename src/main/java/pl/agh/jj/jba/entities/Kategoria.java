package pl.agh.jj.jba.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table (name="kategoira")
public class Kategoria {
	@Id
	@GeneratedValue
	private Integer kategoria_id;
	
	@ManyToOne
	@JoinColumn(name = "quiz_id")
	private Quiz quiz;
	
	@ManyToMany
	@JoinTable
	private List<User> users;
	
	
	public Integer getKategoria_id() {
		return kategoria_id;
	}

	public void setKategoria_id(Integer kategoria_id) {
		this.kategoria_id = kategoria_id;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> user) {
		this.users = user;
	}	
	
}
