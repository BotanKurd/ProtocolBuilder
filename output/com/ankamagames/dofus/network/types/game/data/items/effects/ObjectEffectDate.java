package com.ankamagames.dofus.network.types.game.data.items.effects;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ObjectEffectDate extends ObjectEffect implements INetworkType {

  public int year = 0;
  public int month = 0;
  public int day = 0;
  public int hour = 0;
  public int minute = 0;
  public static final int protocolId = 72;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.actionId < 0) {
      throw new Exception("Forbidden value (" + this.actionId + ") on element actionId.");
    }
    param1.writeVarShort(this.actionId);

    if (this.year < 0) {
      throw new Exception("Forbidden value (" + this.year + ") on element year.");
    }
    param1.writeVarShort(this.year);
    if (this.month < 0) {
      throw new Exception("Forbidden value (" + this.month + ") on element month.");
    }
    param1.writeByte(this.month);
    if (this.day < 0) {
      throw new Exception("Forbidden value (" + this.day + ") on element day.");
    }
    param1.writeByte(this.day);
    if (this.hour < 0) {
      throw new Exception("Forbidden value (" + this.hour + ") on element hour.");
    }
    param1.writeByte(this.hour);
    if (this.minute < 0) {
      throw new Exception("Forbidden value (" + this.minute + ") on element minute.");
    }
    param1.writeByte(this.minute);
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    this.uid = param1.readUTF();

    this.figure = param1.readVarUhShort();
    if (this.figure < 0) {
      throw new Exception(
          "Forbidden value (" + this.figure + ") on element of KrosmasterFigure.figure.");
    }

    this.pedestal = param1.readVarUhShort();
    if (this.pedestal < 0) {
      throw new Exception(
          "Forbidden value (" + this.pedestal + ") on element of KrosmasterFigure.pedestal.");
    }

    this.bound = param1.readBoolean();

    this.year = param1.readVarUhShort();
    if (this.year < 0) {
      throw new Exception(
          "Forbidden value (" + this.year + ") on element of ObjectEffectDate.year.");
    }

    this.month = param1.readByte();
    if (this.month < 0) {
      throw new Exception(
          "Forbidden value (" + this.month + ") on element of ObjectEffectDate.month.");
    }

    this.day = param1.readByte();
    if (this.day < 0) {
      throw new Exception("Forbidden value (" + this.day + ") on element of ObjectEffectDate.day.");
    }

    this.hour = param1.readByte();
    if (this.hour < 0) {
      throw new Exception(
          "Forbidden value (" + this.hour + ") on element of ObjectEffectDate.hour.");
    }

    this.minute = param1.readByte();
    if (this.minute < 0) {
      throw new Exception(
          "Forbidden value (" + this.minute + ") on element of ObjectEffectDate.minute.");
    }
  }
}
