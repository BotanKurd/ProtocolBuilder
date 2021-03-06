package com.ankamagames.dofus.network.enums;

public enum DialogTypeEnum {
  DIALOG_BOOK(0),
  DIALOG_DIALOG(1),
  DIALOG_LOCKABLE(2),
  DIALOG_PURCHASABLE(3),
  DIALOG_GUILD_INVITATION(4),
  DIALOG_GUILD_CREATE(5),
  DIALOG_GUILD_RENAME(6),
  DIALOG_MARRIAGE(7),
  DIALOG_DUNGEON_MEETING(8),
  DIALOG_SPELL_FORGET(9),
  DIALOG_TELEPORTER(10),
  DIALOG_EXCHANGE(11),
  DIALOG_ALLIANCE_INVITATION(12),
  DIALOG_ALLIANCE_CREATE(13),
  DIALOG_ALLIANCE_RENAME(14),
  DIALOG_HAVENBAG_MEETING(15);
  private final int value;

  public DialogTypeEnum(int value) {
    this.value = value;
  }

  public int value() {
    return this.value;
  }

  public DialogTypeEnum get(int value) {
    return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
  }
}
