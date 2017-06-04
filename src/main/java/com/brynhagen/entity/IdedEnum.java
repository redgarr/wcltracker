package com.brynhagen.entity;

/**
 * Created by Jonathan on 2017-06-04.
 */
public enum IdedEnum
{
	;

	private int id;

	IdedEnum(int id)
	{
		this.id = id;
	}

	public int getId()
	{
		return id;
	}
}
