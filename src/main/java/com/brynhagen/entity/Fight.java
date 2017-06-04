package com.brynhagen.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * An instance of an encounter.
 *
 * Created by Jonathan on 2017-05-25.
 */
@Entity
@Table(name="fight")
public class Fight
{
	@Id
	private int id;

	@OneToMany
	@JoinColumn(name="character_id")
	private List<Character> characterList;

	@OneToOne
	@JoinColumn(name="zone_id")
	private Zone zone;


	@OneToOne
	@JoinColumn(name="encounter_id")
	private Encounter encounter;

	public Fight()
	{
	}

	public Zone getZone()
	{
		return zone;
	}

	public void setZone(Zone zone)
	{
		this.zone = zone;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public List<Character> getCharacterList()
	{
		return characterList;
	}

	public void setCharacterList(List<Character> characterList)
	{
		this.characterList = characterList;
	}

	public Encounter getEncounter()
	{
		return encounter;
	}

	public void setEncounter(Encounter encounter)
	{
		this.encounter = encounter;
	}
}

