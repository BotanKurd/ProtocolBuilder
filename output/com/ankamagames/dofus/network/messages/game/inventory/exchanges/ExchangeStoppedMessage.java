package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeStoppedMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Number id = 0;
  public static final int protocolId = 6589;

  public void serialize(ICustomDataOutput param1) {
    if (this.id < 0 || this.id > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.id + ") on element id.");
    }
    param1.writeVarLong(this.id);
  }

  public void deserialize(ICustomDataInput param1) {
    this.id = param1.readUTF();
  }
}
