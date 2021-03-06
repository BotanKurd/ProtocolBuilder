package com.ankamagames.dofus.network.enums;

public enum CharacterCreationResultEnum {
  OK(0),
  ERR_NO_REASON(1),
  ERR_INVALID_NAME(2),
  ERR_NAME_ALREADY_EXISTS(3),
  ERR_TOO_MANY_CHARACTERS(4),
  ERR_NOT_ALLOWED(5),
  ERR_NEW_PLAYER_NOT_ALLOWED(6),
  ERR_RESTRICED_ZONE(7),
  ERR_INCONSISTENT_COMMUNITY(8);
  private final int value;

  public CharacterCreationResultEnum(int value) {
    this.value = value;
  }

  public int value() {
    return this.value;
  }

  public CharacterCreationResultEnum get(int value) {
    return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
  }
}
