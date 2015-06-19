package pl.agh.jj.jba.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="kategoria_uczestnikow")
public class Kategoria_uczestnikow {
	@Id
	@GeneratedValue
	Integer kategoria_uczestnikow_id;
}
