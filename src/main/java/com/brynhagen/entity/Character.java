package com.brynhagen.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * A character in a fight.
 *
 * Created by Jonathan on 2017-05-25.
 */
@Entity
@Table(name="player_character")
public class Character
{
	@Id
	private int id;

	@OneToOne
	@JoinColumn(name="ranking_id")
	private Ranking ranking;

	@OneToOne
	@JoinColumn(name="player_id")
	private Player player;

	@OneToOne
	@JoinColumn(name="fight_id")
	private Fight fight;

	public Character()
	{
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public Ranking getRanking()
	{
		return ranking;
	}

	public void setRanking(Ranking ranking)
	{
		this.ranking = ranking;
	}

	public Player getPlayer()
	{
		return player;
	}

	public void setPlayer(Player player)
	{
		this.player = player;
	}

	public Fight getFight()
	{
		return fight;
	}

	public void setFight(Fight fight)
	{
		this.fight = fight;
	}
}
