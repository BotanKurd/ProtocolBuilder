package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.mount.MountClientData;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeMountsStableAddMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Vector<MountClientData> mountDescription;
  private FuncTree _mountDescriptiontree;
  public static final int protocolId = 6555;

  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.mountDescription.length);
    int _loc2_ = 0;
    while (_loc2_ < this.mountDescription.length) {
      ((MountClientData) this.mountDescription[_loc2_]).serializeAs_(param1);
      _loc2_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    MountClientData _loc4_ = null;
    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = new MountClientData();
      _loc4_.deserialize(param1);
      this.mountDescription.push(_loc4_);
      _loc3_++;
    }
  }
}
