package com.brynhagen.enums;

import java.util.EnumSet;

import com.brynhagen.entity.Ranking;
import com.brynhagen.entity.converter.IdGettable;
import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Created by Jonathan on 2017-05-21.
 */
public enum PlayerClass
{
    DEATH_KNIGHT(1, "Death Knight",
            EnumSet.of(
                    Specialisation.BLOOD_DK,
                    Specialisation.FROST_DK,
                    Specialisation.UNHOLY_DK)
    ),
    DRUID(2, "Druid",
            EnumSet.of(
                    Specialisation.BALANCE_DRUID,
                    Specialisation.FERAL_DRUID,
                    Specialisation.GUARDIAN_DRUID,
                    Specialisation.RESTORATION_DRUID)
    ),
    HUNTER(3, "Hunter",
            EnumSet.of(
                    Specialisation.BEAST_MASTERY_HUNTER,
                    Specialisation.MARKSMANSHIP_HUNTER,
                    Specialisation.SURVIVAL_HUNTER)
    ),
    MAGE(4, "Mage",
            EnumSet.of(
                    Specialisation.ARCANE_MAGE,
                    Specialisation.FIRE_MAGE,
                    Specialisation.FROST_MAGE)
    ),
    MONK(5, "Monk",
            EnumSet.of(
                    Specialisation.BREWMASTER_MONK,
                    Specialisation.MISTWEAVER_MONK,
                    Specialisation.WINDWALKER_MONK)
    ),
    PALADIN(6, "Paladin",
            EnumSet.of(
                    Specialisation.HOLY_PALADIN,
                    Specialisation.PROTECTION_PALADIN,
                    Specialisation.RETRIBUTION_PALADIN)
    ),
    PRIEST(7, "Priest",
            EnumSet.of(
                    Specialisation.DISCIPLINE_PRIEST,
                    Specialisation.HOLY_PRIEST,
                    Specialisation.SHADOW_PRIEST)
    ),
    ROGUE(8, "Rogue",
            EnumSet.of(
                    Specialisation.ASSASSINATION_ROGUE,
                    Specialisation.COMBAT_ROGUE,
                    Specialisation.OUTLAW_ROGUE,
                    Specialisation.OUTLAW_ROGUE)
    ),
    SHAMAN(9, "Shaman",
            EnumSet.of(
                    Specialisation.ELEMENTAL_SHAMAN,
                    Specialisation.ENHANCEMENT_SHAMAN,
                    Specialisation.RESTORATION_SHAMAN)
    ),
    WARLOCK(10, "Warlock",
            EnumSet.of(
                    Specialisation.AFFLICTION_WARLOCK,
                    Specialisation.DEMONOLOGY_WARLOCK,
                    Specialisation.DESTRUCTION_WARLOCK)
    ),
    WARRIOR(11, "Warrior",
            EnumSet.of(
                    Specialisation.ARMS_WARRIOR,
                    Specialisation.FURY_WARRIOR,
                    Specialisation.PROTECTION_WARRIOR,
                    Specialisation.GLADIATOR_WARRIOR)
    ),
    DEMON_HUNTER(12, "Demon Hunter",
            EnumSet.of(
                    Specialisation.HAVOC_DEMON_HUNTER,
                    Specialisation.VENGEANCE_DEMON_HUNTER)
    );


    private final EnumSet specs;
    private int id;
    private String name;

    PlayerClass(int id, String name, EnumSet specs)
    {
        this.id = id;
        this.name = name;
        this.specs = specs;
    }

    public static PlayerClass getForId(int id)
    {
        for(PlayerClass e : values()) {
            if(e.id == id)
            {
                return e;
            }
        }

        return null;
    }

    public Specialisation getSpecForInt(int id)
    {
        for(Object spec : specs.toArray())
        {
            if(((Specialisation)spec).getId() == id)
            {
                return (Specialisation)spec;
            }
        }
        return null;
    }

    @JsonCreator
    public static PlayerClass forValue(String value)
    {
        return getForId(Integer.valueOf(value));
    }

    @Override
    public String toString()
    {
        return name;
    }

    public int getId()
    {
        return id;
    }
}
