package com.ankamagames.dofus.network.types.game.character.choice;

import java.lang.Exception;
import com.ankamagames.dofus.network.types.game.character.AbstractCharacterInformation;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AbstractCharacterToRefurbishInformation extends AbstractCharacterInformation
    implements INetworkType {

  public Vector<Integer> colors;
  public int cosmeticId = 0;
  private FuncTree _colorstree;
  public static final int protocolId = 475;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.id < 0 || this.id > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.id + ") on element id.");
    }
    param1.writeVarLong(this.id);

    param1.writeShort(this.colors.length);
    int _loc2_ = 0;
    while (_loc2_ < this.colors.length) {
      param1.writeInt(this.colors[_loc2_]);
      _loc2_++;
    }
    if (this.cosmeticId < 0) {
      throw new Exception("Forbidden value (" + this.cosmeticId + ") on element cosmeticId.");
    }
    param1.writeVarInt(this.cosmeticId);
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    Object _loc4_ = 0;
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

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = param1.readInt();
      this.colors.push(_loc4_);
      _loc3_++;
    }
    this.cosmeticId = param1.readVarUhShort();
    if (this.cosmeticId < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.cosmeticId
              + ") on element of RemodelingInformation.cosmeticId.");
    }
  }
}
