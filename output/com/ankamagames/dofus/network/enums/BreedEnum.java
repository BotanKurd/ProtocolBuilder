package com.ankamagames.dofus.network.enums;

public enum BreedEnum {
  UNDEFINED(0),
  FECA(1),
  OSAMODAS(2),
  ENUTROF(3),
  SRAM(4),
  XELOR(5),
  ECAFLIP(6),
  ENIRIPSA(7),
  IOP(8),
  CRA(9),
  SADIDA(10),
  SACRIEUR(11),
  PANDAWA(12),
  ROUBLARD(13),
  ZOBAL(14),
  STEAMER(15),
  ELIOTROPE(16),
  HUPPERMAGE(17),
  OUGINAK(18),
  SUMMONED(-1),
  MONSTER(-2),
  MONSTER_GROUP(-3),
  NPC(-4),
  HUMAN_VENDOR(-5),
  TAX_COLLECTOR(-6),
  MUTANT(-7),
  MUTANT_IN_DUNGEON(-8),
  MOUNT_OUTSIDE(-9),
  PRISM(-10),
  INCARNATION(-11);
  private final int value;

  public BreedEnum(int value) {
    this.value = value;
  }

  public int value() {
    return this.value;
  }

  public BreedEnum get(int value) {
    return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
  }
}
