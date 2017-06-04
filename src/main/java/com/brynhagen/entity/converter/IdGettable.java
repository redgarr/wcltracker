package com.brynhagen.entity.converter;

import com.brynhagen.entity.IdedEnum;

/**
 * Created by Jonathan on 2017-06-04.
 */
public interface IdGettable<T extends Enum<T>>
{
	public T getForId(int id);

}
