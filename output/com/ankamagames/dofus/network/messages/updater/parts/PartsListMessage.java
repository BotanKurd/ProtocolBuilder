package com.ankamagames.dofus.network.messages.updater.parts;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.updater.ContentPart;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PartsListMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Vector<ContentPart> parts;
  private FuncTree _partstree;
  public static final int protocolId = 1502;

  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.parts.length);
    int _loc2_ = 0;
    while (_loc2_ < this.parts.length) {
      ((ContentPart) this.parts[_loc2_]).serializeAs_(param1);
      _loc2_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    ContentPart _loc4_ = null;
    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = new ContentPart();
      _loc4_.deserialize(param1);
      this.parts.push(_loc4_);
      _loc3_++;
    }
  }
}
