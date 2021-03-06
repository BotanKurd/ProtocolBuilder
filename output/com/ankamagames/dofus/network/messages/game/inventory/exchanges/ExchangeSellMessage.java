package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeSellMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int objectToSellId = 0;
  public int quantity = 0;
  public static final int protocolId = 5778;

  public void serialize(ICustomDataOutput param1) {
    if (this.objectToSellId < 0) {
      throw new Exception(
          "Forbidden value (" + this.objectToSellId + ") on element objectToSellId.");
    }
    param1.writeVarInt(this.objectToSellId);
    if (this.quantity < 0) {
      throw new Exception("Forbidden value (" + this.quantity + ") on element quantity.");
    }
    param1.writeVarInt(this.quantity);
  }

  public void deserialize(ICustomDataInput param1) {
    this.objectToSellId = param1.readVarUhInt();
    if (this.objectToSellId < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.objectToSellId
              + ") on element of ExchangeSellMessage.objectToSellId.");
    }

    this.quantity = param1.readVarUhInt();
    if (this.quantity < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.quantity
              + ") on element of ObjectItemToSellInHumanVendorShop.quantity.");
    }
  }
}
