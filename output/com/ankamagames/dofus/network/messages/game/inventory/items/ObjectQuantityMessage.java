package com.ankamagames.dofus.network.messages.game.inventory.items;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ObjectQuantityMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int objectUID = 0;
  public int quantity = 0;
  public static final int protocolId = 3023;

  public void serialize(ICustomDataOutput param1) {
    if (this.objectUID < 0) {
      throw new Exception("Forbidden value (" + this.objectUID + ") on element objectUID.");
    }
    param1.writeVarInt(this.objectUID);
    if (this.quantity < 0) {
      throw new Exception("Forbidden value (" + this.quantity + ") on element quantity.");
    }
    param1.writeVarInt(this.quantity);
  }

  public void deserialize(ICustomDataInput param1) {
    this.objectUID = param1.readVarUhInt();
    if (this.objectUID < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.objectUID
              + ") on element of ObjectItemToSellInHumanVendorShop.objectUID.");
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
