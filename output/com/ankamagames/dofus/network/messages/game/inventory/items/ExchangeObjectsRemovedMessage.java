package com.ankamagames.dofus.network.messages.game.inventory.items;

import java.lang.Exception;
import com.ankamagames.dofus.network.messages.game.inventory.exchanges.ExchangeObjectMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeObjectsRemovedMessage extends ExchangeObjectMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public Vector<uint> objectUID;
  private FuncTree _objectUIDtree;
  public static final int protocolId = 6532;

  @Override
  public void serialize(ICustomDataOutput param1) {
    param1.writeBoolean(this.remote);

    param1.writeShort(this.objectUID.length);
    int _loc2_ = 0;
    while (_loc2_ < this.objectUID.length) {
      if (this.objectUID[_loc2_] < 0) {
        throw new Exception(
            "Forbidden value ("
                + this.objectUID[_loc2_]
                + ") on element 1 (starting at 1) of objectUID.");
      }
      param1.writeVarInt(this.objectUID[_loc2_]);
      _loc2_++;
    }
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    int _loc4_ = 0;
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
      _loc4_ = param1.readVarUhInt();
      if (_loc4_ < 0) {
        throw new Exception("Forbidden value (" + _loc4_ + ") on elements of objectUID.");
      }
      this.objectUID.push(_loc4_);
      _loc3_++;
    }
  }
}
