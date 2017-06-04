package com.brynhagen.entity.converter;

import java.io.IOException;
import java.util.List;

import org.joda.time.tz.ZoneInfoProvider;

import com.brynhagen.entity.Encounter;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * Created by Jonathan on 2017-05-24.
 */
public class JSONEncounterDeserializer
	extends JsonDeserializer<List<Encounter>>
{

	@Override
	public List<Encounter> deserialize(JsonParser jsonParser,
		DeserializationContext deserializationContext)
		throws IOException, JsonProcessingException
	{
		System.out.println("jsonParser = " + jsonParser);
		System.out.println("deserializationContext = " + deserializationContext);
		System.out.println("TESTING HERE::::::::::::::::::::::::::::::::::");
		return null;
	}
}
