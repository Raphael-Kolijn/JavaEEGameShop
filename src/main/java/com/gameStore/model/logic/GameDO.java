package com.gameStore.model.logic;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "GameDO")//TODO: name = ?
public class GameDO implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="identity")
	private Integer id;
    @Column(name="name")
	private String name;
    @Column(name="price")
	private Integer price;


	public GameDO() {
	}

	public GameDO(String Name, Integer Price) {
		this.name = Name;
		this.price = Price;
	}

	public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }



	public String getName() {
		return name;
	}

	public Integer getPrice() {
		return price;
	}
}