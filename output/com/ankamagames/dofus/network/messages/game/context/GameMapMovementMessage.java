package com.ankamagames.dofus.network.messages.game.context;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameMapMovementMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Vector<uint> keyMovements;
  public int forcedDirection = 0;
  public Number actorId = 0;
  private FuncTree _keyMovementstree;
  public static final int protocolId = 951;

  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.keyMovements.length);
    int _loc2_ = 0;
    while (_loc2_ < this.keyMovements.length) {
      if (this.keyMovements[_loc2_] < 0) {
        throw new Exception(
            "Forbidden value ("
                + this.keyMovements[_loc2_]
                + ") on element 1 (starting at 1) of keyMovements.");
      }
      param1.writeShort(this.keyMovements[_loc2_]);
      _loc2_++;
    }
    param1.writeShort(this.forcedDirection);
    if (this.actorId < -9.007199254740992E15 || this.actorId > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.actorId + ") on element actorId.");
    }
    param1.writeDouble(this.actorId);
  }

  public void deserialize(ICustomDataInput param1) {
    int _loc4_ = 0;
    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = param1.readShort();
      if (_loc4_ < 0) {
        throw new Exception("Forbidden value (" + _loc4_ + ") on elements of keyMovements.");
      }
      this.keyMovements.push(_loc4_);
      _loc3_++;
    }
    this.forcedDirection = param1.readShort();

    this.actorId = param1.readDouble();
    if (this.actorId < -9.007199254740992E15 || this.actorId > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value ("
              + this.actorId
              + ") on element of SetCharacterRestrictionsMessage.actorId.");
    }
  }
}
