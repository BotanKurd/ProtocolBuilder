package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.mount.MountClientData;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeStartOkMountMessage extends ExchangeStartOkMountWithOutPaddockMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public Vector<MountClientData> paddockedMountsDescription;
  private FuncTree _paddockedMountsDescriptiontree;
  public static final int protocolId = 5979;

  @Override
  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.stabledMountsDescription.length);
    int _loc2_ = 0;
    while (_loc2_ < this.stabledMountsDescription.length) {
      ((MountClientData) this.stabledMountsDescription[_loc2_]).serializeAs_(param1);
      _loc2_++;
    }

    param1.writeShort(this.paddockedMountsDescription.length);
    int _loc2_ = 0;
    while (_loc2_ < this.paddockedMountsDescription.length) {
      ((MountClientData) this.paddockedMountsDescription[_loc2_]).serializeAs_(param1);
      _loc2_++;
    }
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    MountClientData _loc4_ = null;
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
      _loc4_ = new MountClientData();
      _loc4_.deserialize(param1);
      this.paddockedMountsDescription.push(_loc4_);
      _loc3_++;
    }
  }
}
