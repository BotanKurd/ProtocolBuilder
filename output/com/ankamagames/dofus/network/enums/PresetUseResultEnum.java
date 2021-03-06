package com.ankamagames.dofus.network.enums;

public enum PresetUseResultEnum {
  PRESET_USE_OK(1),
  PRESET_USE_OK_PARTIAL(2),
  PRESET_USE_ERR_UNKNOWN(3),
  PRESET_USE_ERR_CRITERION(4),
  PRESET_USE_ERR_BAD_PRESET_ID(5),
  PRESET_USE_ERR_COOLDOWN(6);
  private final int value;

  public PresetUseResultEnum(int value) {
    this.value = value;
  }

  public int value() {
    return this.value;
  }

  public PresetUseResultEnum get(int value) {
    return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
  }
}
