package com.ankamagames.dofus.network.messages.connection;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class IdentificationFailedMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int reason = 99;
  public static final int protocolId = 20;

  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.reason);
  }

  public void deserialize(ICustomDataInput param1) {
    this.reason = param1.readByte();
    if (this.reason < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.reason
              + ") on element of KrosmasterInventoryErrorMessage.reason.");
    }
  }
}
