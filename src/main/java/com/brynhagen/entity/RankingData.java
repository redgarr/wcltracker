package com.brynhagen.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Jonathan on 2017-06-04.
 */
@Entity
@Table(name="ranking_data")
public class RankingData
{

	@Id
	private int id;

	@Column(name = "character_id")
	@JsonProperty(value = "character_id")
	private int characterId;

	@Column
	@JsonProperty(value = "character_name")
	private String characterName;

	@Column(name = "persecondamount")
	@JsonProperty(value = "persecondamount")
	private int perSecondAmount;

	@Column
	private String ilvl;

	@Column
	private long duration;

	@Column(name = "start_time")
	@JsonProperty(value = "start_time")
	private long startTime;

	@Column(name = "report_code")
	@JsonProperty(value = "report_code")
	private String reportCode;

	@Column(name = "report_fight")
	@JsonProperty(value = "report_fight")
	private int reportFight;

	@Column(name = "ranking_id")
	@JsonProperty(value = "ranking_id")
	private int rankingId;
	@Column

	private String guild;

	@Column
	private	int total;

	@Column
	private String rank;

	@Column
	private float percent;

	@Column
	private boolean exploit;

	@Column
	private boolean banned;

	@Column(name = "historical_count")
	@JsonProperty(value = "historical_count")
	private int historicalCount;

	@Column(name = "historical_percent")
	@JsonProperty(value = "historical_percent")
	private int historicalPercent;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "id")
	@JoinColumn()
	private List<Talent> talents;

	public RankingData()
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

	public int getCharacterId()
	{
		return characterId;
	}

	public void setCharacterId(int characterId)
	{
		this.characterId = characterId;
	}

	public String getCharacterName()
	{
		return characterName;
	}

	public void setCharacterName(String characterName)
	{
		this.characterName = characterName;
	}

	public int getPerSecondAmount()
	{
		return perSecondAmount;
	}

	public void setPerSecondAmount(int perSecondAmount)
	{
		this.perSecondAmount = perSecondAmount;
	}

	public String getIlvl()
	{
		return ilvl;
	}

	public void setIlvl(String ilvl)
	{
		this.ilvl = ilvl;
	}

	public long getDuration()
	{
		return duration;
	}

	public void setDuration(long duration)
	{
		this.duration = duration;
	}

	public long getStartTime()
	{
		return startTime;
	}

	public void setStartTime(long startTime)
	{
		this.startTime = startTime;
	}

	public String getReportCode()
	{
		return reportCode;
	}

	public void setReportCode(String reportCode)
	{
		this.reportCode = reportCode;
	}

	public int getReportFight()
	{
		return reportFight;
	}

	public void setReportFight(int reportFight)
	{
		this.reportFight = reportFight;
	}

	public int getRankingId()
	{
		return rankingId;
	}

	public void setRankingId(int rankingId)
	{
		this.rankingId = rankingId;
	}

	public String getGuild()
	{
		return guild;
	}

	public void setGuild(String guild)
	{
		this.guild = guild;
	}

	public int getTotal()
	{
		return total;
	}

	public void setTotal(int total)
	{
		this.total = total;
	}

	public String getRank()
	{
		return rank;
	}

	public void setRank(String rank)
	{
		this.rank = rank;
	}

	public float getPercent()
	{
		return percent;
	}

	public void setPercent(float percent)
	{
		this.percent = percent;
	}

	public boolean isExploit()
	{
		return exploit;
	}

	public void setExploit(boolean exploit)
	{
		this.exploit = exploit;
	}

	public boolean isBanned()
	{
		return banned;
	}

	public void setBanned(boolean banned)
	{
		this.banned = banned;
	}

	public int getHistoricalCount()
	{
		return historicalCount;
	}

	public void setHistoricalCount(int historicalCount)
	{
		this.historicalCount = historicalCount;
	}

	public int getHistoricalPercent()
	{
		return historicalPercent;
	}

	public void setHistoricalPercent(int historicalPercent)
	{
		this.historicalPercent = historicalPercent;
	}

	public List<Talent> getTalents()
	{
		return talents;
	}

	public void setTalents(List<Talent> talents)
	{
		this.talents = talents;
	}
}
