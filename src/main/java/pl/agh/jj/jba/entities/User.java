package pl.agh.jj.jba.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import pl.agh.jj.jba.annotation.UniqueUsername;



@Entity
@Table(name="uzytkownik")
public class User {

	@Id
	@GeneratedValue
	@Column(name="uzytkownik_id")
	private Integer id;
	
	
	@Column(name="login",unique=true)
	@UniqueUsername(message="Nazwa u�ytkownika ju� istnieje")
	@Size(min=3,message="Login musi zawiera� conajmniej 3 znaki")
	private String name;
	@Size(min=1,message="Z�y adres email")
	@Email(message="Z�y adres email")
	private String email;
	
	@Column(name="haslo")
//	@Size(min=3,message="haslo musi zawierac conajmniej 3 znaki")
	private String password;
	
	private Integer iduzytkownik=1;
	@Size(min=1, message="wpisz nazwisko")
	private String nazwisko;
	@Size(min=1, message="wpisz imie")
	private String imie;
	private String instytucja;
	@Size(min=11,max=11, message="PESEL musi zawiera� 11 cyfr")
	private String pesel;
	private String typ;
	private String extrainfo;
	
	
	private boolean enabled;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinTable
	private List<Podejscie> podejscia;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable
	private List<Role> roles;	
	
	@ManyToMany(mappedBy="users")
	private List<Kategoria> kategorie;	
	
	public List<Kategoria> getKategorie() {
		return kategorie;
	}

	public void setKategorie(List<Kategoria> kategorie) {
		this.kategorie = kategorie;
	}

	public boolean hasRole(Role role){
		return roles.contains(role);
	}
	
	public List<Podejscie> getPodejscia() {
		return podejscia;
	}

	public void setPodejscia(List<Podejscie> podejscia) {
		this.podejscia = podejscia;
	}

	public Integer getIduzytkownik() {
		return iduzytkownik;
	}

	public void setIduzytkownik(Integer iduzytkownik) {
		this.iduzytkownik = iduzytkownik;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getInstytucja() {
		return instytucja;
	}

	public void setInstytucja(String instytucja) {
		this.instytucja = instytucja;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}

	public String getExtrainfo() {
		return extrainfo;
	}

	public void setExtrainfo(String extrainfo) {
		this.extrainfo = extrainfo;
	}
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
