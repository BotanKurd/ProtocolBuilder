package com.ankamagames.dofus.network.enums;

public enum AlignmentSideEnum {
  ALIGNMENT_UNKNOWN(-2),
  ALIGNMENT_WITHOUT(-1),
  ALIGNMENT_NEUTRAL(0),
  ALIGNMENT_ANGEL(1),
  ALIGNMENT_EVIL(2),
  ALIGNMENT_MERCENARY(3);
  private final int value;

  public AlignmentSideEnum(int value) {
    this.value = value;
  }

  public int value() {
    return this.value;
  }

  public AlignmentSideEnum get(int value) {
    return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
  }
}
