package com.brynhagen.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.brynhagen.entity.converter.IdToSpecialisationSerializer;
import com.brynhagen.enums.PlayerClass;
import com.brynhagen.enums.Specialisation;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Created by Jonathan on 2017-05-25.
 */
@Entity
@Table(name="ranking")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ranking
{
	public enum DIFFICULTY
	{
		LFR(1, "Looking For Raid"),
		FLEX(2, "Flex"),
		NORMAL(3, "Normal"),
		HEROIC(4, "Heroic"),
		MYTHIC(5, "Mythic"),
		CHALLENGE_MODE(10, "Challenge Mode");

		private final String name;
		private final int id;

		DIFFICULTY(int id, String name)
		{
			this.id = id;
			this.name = name;
		}

		public static DIFFICULTY getForId(int id)
		{
			for(DIFFICULTY e : values()) {
				if(e.id == id)
				{
					return e;
				}
			}

			return null;
		}

		@JsonCreator
		public static DIFFICULTY forValue(String value)
		{
			return getForId(Integer.valueOf(value));
		}

		@Override
		public String toString()
		{
			return name;
		}
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "fight_id")
	//private Fight fight;

	@Column(name = "player_class")
	@Enumerated(EnumType.STRING)
	@JsonProperty("class")
	private PlayerClass playerClass;

	@Column
	@Enumerated(EnumType.STRING)
	private Specialisation spec;

	@Column
	private int rank;

	@Column(name = "out_of")
	private int outOf;

	@Column
	private int duration;

	@Column
	@JsonProperty("itemLevel")
	private int ilvl;

	@Column(name = "start_time")
	private long startTime;

	@Column
	@Enumerated(EnumType.STRING)
	private DIFFICULTY difficulty;

	@OneToOne
	@JoinColumn(name="zone_id")
	@JsonIgnore
	private Zone zone;

	@OneToOne
	@JoinColumn(name="encounter_id")
	@JsonIgnore
	private Encounter encounter;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	//public Fight getFight()
	//{
	//	return fight;
	//}

	//public void setFight(Fight fight)
	//{
	//	this.fight = fight;
	//}

	public Zone getZone()
	{
		return zone;
	}

	public void setZone(Zone zone)
	{
		this.zone = zone;
	}

	public Encounter getEncounter()
	{
		return encounter;
	}

	public void setEncounter(Encounter encounter)
	{
		this.encounter = encounter;
	}

	public PlayerClass getPlayerClass()
	{
		return playerClass;
	}

	public void setPlayerClass(PlayerClass playerClass)
	{
		this.playerClass = playerClass;
	}

	public Specialisation getSpec()
	{
		return spec;
	}

	public void setSpec(Specialisation spec)
	{
		this.spec = spec;
	}

	public int getRank()
	{
		return rank;
	}

	public void setRank(int rank)
	{
		this.rank = rank;
	}

	public int getOutOf()
	{
		return outOf;
	}

	public void setOutOf(int outOf)
	{
		this.outOf = outOf;
	}

	public int getDuration()
	{
		return duration;
	}

	public void setDuration(int duration)
	{
		this.duration = duration;
	}

	public int getIlvl()
	{
		return ilvl;
	}

	public void setIlvl(int ilvl)
	{
		this.ilvl = ilvl;
	}

	public long getStartTime()
	{
		return startTime;
	}

	public void setStartTime(long startTime)
	{
		this.startTime = startTime;
	}

	public DIFFICULTY getDifficulty()
	{
		return difficulty;
	}

	public void setDifficulty(DIFFICULTY difficulty)
	{
		this.difficulty = difficulty;
	}

	@Override
	public String toString()
	{
		return "Ranking{" + "id=" + id + ", playerClass=" + playerClass
			+ ", spec=" + spec + ", rank=" + rank + ", outOf=" + outOf
			+ ", duration=" + duration + ", ilvl=" + ilvl + ", startTime="
			+ startTime + ", difficulty=" + difficulty + ", zone=" + zone
			+ ", encounter=" + encounter + '}';
	}
}
