package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeShopStockMovementRemovedMessage extends NetworkMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public int objectId = 0;
  public static final int protocolId = 5907;

  public void serialize(ICustomDataOutput param1) {
    if (this.objectId < 0) {
      throw new Exception("Forbidden value (" + this.objectId + ") on element objectId.");
    }
    param1.writeVarInt(this.objectId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.objectId = param1.readVarUhInt();
    if (this.objectId < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.objectId
              + ") on element of ExchangeShopStockMovementRemovedMessage.objectId.");
    }
  }
}
