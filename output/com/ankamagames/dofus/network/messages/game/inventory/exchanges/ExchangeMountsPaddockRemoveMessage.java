package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeMountsPaddockRemoveMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Vector<Integer> mountsId;
  private FuncTree _mountsIdtree;
  public static final int protocolId = 6559;

  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.mountsId.length);
    int _loc2_ = 0;
    while (_loc2_ < this.mountsId.length) {
      param1.writeVarInt(this.mountsId[_loc2_]);
      _loc2_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    Object _loc4_ = 0;
    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = param1.readVarInt();
      this.mountsId.push(_loc4_);
      _loc3_++;
    }
  }
}
