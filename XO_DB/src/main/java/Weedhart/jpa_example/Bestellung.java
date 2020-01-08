package Weedhart.jpa_example;

import javax.persistence.*;


@Entity
public class Bestellung {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
}
