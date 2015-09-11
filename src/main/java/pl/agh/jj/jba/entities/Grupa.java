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
@Table(name="grupa")
public class Grupa {
	@Id
	@GeneratedValue
	private Integer grupa_id;
	private String nazwa;
	private String opis;
	
	@ManyToOne
	@JoinColumn(name = "kategoria_id")
	private Kategoria kategoria;
	
	@ManyToMany
	@JoinTable
	private List<User> users;

	public Integer getGrupa_id() {
		return grupa_id;
	}

	public void setGrupa_id(Integer grupa_id) {
		this.grupa_id = grupa_id;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Kategoria getKategoria() {
		return kategoria;
	}

	public void setKategoria(Kategoria kategoria) {
		this.kategoria = kategoria;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
}
