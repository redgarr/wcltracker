package com.brynhagen.entity.converter;

import java.io.IOException;

import javax.persistence.Id;

import com.brynhagen.entity.Ranking;
import com.brynhagen.enums.PlayerClass;
import com.brynhagen.enums.Specialisation;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * Created by Jonathan on 2017-06-04.
 */
public class IdToSpecialisationSerializer
	extends JsonDeserializer<Specialisation>
{

	
	
	@Override
	public Specialisation deserialize(JsonParser p, DeserializationContext ctxt)
		throws IOException, JsonProcessingException
	{
		System.out.println("getKnownPropertyNames() = " + getKnownPropertyNames());
		return null;

	}
}
