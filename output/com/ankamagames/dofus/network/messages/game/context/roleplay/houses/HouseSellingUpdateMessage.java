package com.ankamagames.dofus.network.messages.game.context.roleplay.houses;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class HouseSellingUpdateMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int houseId = 0;
  public int instanceId = 0;
  public boolean secondHand = false;
  public Number realPrice = 0;
  public String buyerName = "";
  public static final int protocolId = 6727;

  public void serialize(ICustomDataOutput param1) {
    if (this.houseId < 0) {
      throw new Exception("Forbidden value (" + this.houseId + ") on element houseId.");
    }
    param1.writeVarInt(this.houseId);
    if (this.instanceId < 0) {
      throw new Exception("Forbidden value (" + this.instanceId + ") on element instanceId.");
    }
    param1.writeInt(this.instanceId);
    param1.writeBoolean(this.secondHand);
    if (this.realPrice < 0 || this.realPrice > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.realPrice + ") on element realPrice.");
    }
    param1.writeVarLong(this.realPrice);
    param1.writeUTF(this.buyerName);
  }

  public void deserialize(ICustomDataInput param1) {
    this.houseId = param1.readVarUhInt();
    if (this.houseId < 0) {
      throw new Exception(
          "Forbidden value (" + this.houseId + ") on element of HouseInformations.houseId.");
    }

    this.instanceId = param1.readInt();
    if (this.instanceId < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.instanceId
              + ") on element of HouseInstanceInformations.instanceId.");
    }

    this.secondHand = param1.readBoolean();

    this.realPrice = param1.readVarUhLong();
    if (this.realPrice < 0 || this.realPrice > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value ("
              + this.realPrice
              + ") on element of HouseSellingUpdateMessage.realPrice.");
    }

    this.buyerName = param1.readUTF();
  }
}
