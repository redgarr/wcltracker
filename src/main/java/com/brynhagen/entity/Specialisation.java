package com.brynhagen.entity;

import com.sun.deploy.association.AssociationAlreadyRegisteredException;
import com.sun.org.apache.bcel.internal.generic.RET;
import jdk.nashorn.internal.codegen.LocalStateRestorationInfo;
import sun.security.provider.certpath.SunCertPathBuilder;

import java.security.ProtectionDomain;

/**
 * Created by Jonathan on 2017-05-21.
 */
public enum Specialisation
{
    //DK SPECS
    BLOOD_DK(1, "Blood"),
    FROST_DK(2, "Frost"),
    UNHOLY_DK(3, "Unholy"),

    //DRUID SPECS
    BALANCE_DRUID(1, "Balance"),
    FERAL_DRUID(2, "Feral"),
    GUARDIAN_DRUID(3, "Guardian"),
    RESTORATION_DRUID(4, "Restoration"),

    //HUNTER SPECS
    BEAST_MASTERY_HUNTER(1, "Beast Mastery"),
    MARKSMANSHIP_HUNTER(2, "Marksmanship"),
    SURVIVAL_HUNTER(3, "Survival"),

    //MAGE SPECS
    ARCANE_MAGE(1, "Arcane"),
    FIRE_MAGE(2, "Fire"),
    FROST_MAGE(3, "Frost"),

    //MONK SPECS
    BREWMASTER_MONK(1, "Brewmaster"),
    MISTWEAVER_MONK(2, "Mistweaver"),
    WINDWALKER_MONK(3, "Windwalker"),

    //Paladin
    HOLY_PALADIN(1, "Holy"),
    PROTECTION_PALADIN(2, "Protection"),
    RETRIBUTION_PALADIN(3, "Retribution"),

    //Priest
    DISCIPLINE_PRIEST(1, "Discipline"),
    HOLY_PRIEST(2, "Holy"),
    SHADOW_PRIEST(3, "Shadow"),

    //ROGUE SPECS
    ASSASSINATION_ROGUE(1, "Assassination"),
    COMBAT_ROGUE(2, "Combat"),
    SUBTLETY_ROGUE(3, "Subtlety"),
    OUTLAW_ROGUE(4, "Outlaw"),

    //SHAMAN SPECS
    ELEMENTAL_SHAMAN(1, "Elemental"),
    ENHANCEMENT_SHAMAN(2, "Enhancement"),
    RESTORATION_SHAMAN(3, "Restoration"),

    //WARLOCK SPECS
    AFFLICTION_WARLOCK(1, "Affliction"),
    DEMONOLOGY_WARLOCK(2, "Demonology"),
    DESTRUCTION_WARLOCK(3, "Destruction"),

    //WARRIOR SPECS
    ARMS_WARRIOR(1, "Arms"),
    FURY_WARRIOR(2, "Fury"),
    PROTECTION_WARRIOR(3, "Protection"),
    GLADIATOR_WARRIOR(4, "Gladiator"),

    //DEMONHUNTER SPECS
    HAVOC_DEMON_HUNTER(1, "Havoc"),
    VENGEANCE_DEMON_HUNTER(2, "Vengeance");


    private int id;
    private String name;

    Specialisation(int id, String name)
    {
        this.id = id;
        this.name = name;
    }


}
