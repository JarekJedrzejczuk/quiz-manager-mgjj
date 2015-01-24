package pl.agh.jj.jba.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Podejscie {
	@Id
	@GeneratedValue
	private Integer podejscie_id;
	private Integer kategoria_uczestnikow_id;
	private Integer wynik;
	private Date data_wykonania;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "quiz_id")
	private Quiz quiz;
	
	public Quiz getQuiz() {
		return quiz;
	}
	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}
		
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getPodejscie_id() {
		return podejscie_id;
	}
	public void setPodejscie_id(Integer podejscie_id) {
		this.podejscie_id = podejscie_id;
	}
	public Integer getKategoria_uczestnikow_id() {
		return kategoria_uczestnikow_id;
	}
	public void setKategoria_uczestnikow_id(Integer kategoria_uczestnikow_id) {
		this.kategoria_uczestnikow_id = kategoria_uczestnikow_id;
	}
	public Integer getWynik() {
		return wynik;
	}
	public void setWynik(Integer wynik) {
		this.wynik = wynik;
	}
	public Date getData_wykonania() {
		return data_wykonania;
	}
	public void setData_wykonania(Date data_wykonania) {
		this.data_wykonania = data_wykonania;
	}
	
	
}
