package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.ObjectItemToSell;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeShopStockStartedMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Vector<ObjectItemToSell> objectsInfos;
  private FuncTree _objectsInfostree;
  public static final int protocolId = 5910;

  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.objectsInfos.length);
    int _loc2_ = 0;
    while (_loc2_ < this.objectsInfos.length) {
      ((ObjectItemToSell) this.objectsInfos[_loc2_]).serializeAs_(param1);
      _loc2_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    ObjectItemToSell _loc4_ = null;
    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = new ObjectItemToSell();
      _loc4_.deserialize(param1);
      this.objectsInfos.push(_loc4_);
      _loc3_++;
    }
  }
}
