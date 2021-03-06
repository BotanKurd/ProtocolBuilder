package com.ankamagames.dofus.network.messages.security;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class CheckIntegrityMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Vector<Integer> data;
  private FuncTree _datatree;
  public static final int protocolId = 6372;

  public void serialize(ICustomDataOutput param1) {
    param1.writeVarInt(this.data.length);
    int _loc2_ = 0;
    while (_loc2_ < this.data.length) {
      param1.writeByte(this.data[_loc2_]);
      _loc2_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    Object _loc4_ = 0;
    int _loc2_ = param1.readVarInt();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = param1.readByte();
      this.data.push(_loc4_);
      _loc3_++;
    }
  }
}
