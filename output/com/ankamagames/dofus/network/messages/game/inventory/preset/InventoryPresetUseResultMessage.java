package com.ankamagames.dofus.network.messages.game.inventory.preset;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class InventoryPresetUseResultMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int presetId = 0;
  public int code = 3;
  public Vector<uint> unlinkedPosition;
  private FuncTree _unlinkedPositiontree;
  public static final int protocolId = 6163;

  public void serialize(ICustomDataOutput param1) {
    if (this.presetId < 0) {
      throw new Exception("Forbidden value (" + this.presetId + ") on element presetId.");
    }
    param1.writeByte(this.presetId);
    param1.writeByte(this.code);
    param1.writeShort(this.unlinkedPosition.length);
    int _loc2_ = 0;
    while (_loc2_ < this.unlinkedPosition.length) {
      param1.writeByte(this.unlinkedPosition[_loc2_]);
      _loc2_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    int _loc4_ = 0;
    this.presetId = param1.readByte();
    if (this.presetId < 0) {
      throw new Exception(
          "Forbidden value (" + this.presetId + ") on element of ShortcutObjectPreset.presetId.");
    }

    this.code = param1.readByte();
    if (this.code < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.code
              + ") on element of InventoryPresetUseResultMessage.code.");
    }

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = param1.readUnsignedByte();
      if (_loc4_ < 0 || _loc4_ > 255) {
        throw new Exception("Forbidden value (" + _loc4_ + ") on elements of unlinkedPosition.");
      }
      this.unlinkedPosition.push(_loc4_);
      _loc3_++;
    }
  }
}
