package com.ankamagames.dofus.network.messages.common;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.INetworkDataContainerMessage;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class NetworkDataContainerMessage extends NetworkMessage
    implements INetworkMessage, INetworkDataContainerMessage {

  private ByteArray _content;
  private boolean _isInitialized = false;
  public static final int protocolId = 2;

  public void serialize(ICustomDataOutput param1) {
    param1.writeBytes(this.content);
    throw new Exception("Not implemented");
  }

  public void deserialize(ICustomDataInput param1) {
    int _loc2_ = param1.readVarInt();
    ByteArray _loc3_ = new ByteArray();
    param1.readBytes(_loc3_, 0, _loc2_);
    _loc3_.uncompress();
    this.content = _loc3_;
  }
}
