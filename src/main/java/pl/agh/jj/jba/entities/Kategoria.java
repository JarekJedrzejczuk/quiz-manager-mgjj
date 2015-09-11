package pl.agh.jj.jba.entities;

import java.util.ArrayList;
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
@Table (name="kategoria")
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
	
	private String opis;
	private String nazwa;
	
	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
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
	public Boolean addUser(User u){
		Boolean wynik=!this.users.contains(u);
		if(wynik){
			wynik=true;
			this.users.add(u);
		}
		return wynik;
	}
	public Boolean removeUser(User u) {
		return this.users.remove(u);
	}
	public List<Integer> getUsersIds(){
		List<Integer> ids = new ArrayList<Integer>();
		for (User u: this.users){
			ids.add(u.getId());
		}
		return ids;
	}
	public Boolean containsUserByUserId(Integer user_id){
		if ((user_id==null)||(this.users==null)){
			return false;
		}
		return getUsersIds().contains(user_id);
	}

	public void setNullFields(Kategoria kTmp) {
		if (this.quiz==null)
			this.quiz=kTmp.getQuiz();
		if (this.users==null)
			this.users=kTmp.getUsers();
		if(this.nazwa==null)
			this.nazwa=kTmp.getNazwa();
		if(this.opis==null)
			this.opis=kTmp.getOpis();
		
	}
}
