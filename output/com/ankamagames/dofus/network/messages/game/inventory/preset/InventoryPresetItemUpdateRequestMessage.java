package com.ankamagames.dofus.network.messages.game.inventory.preset;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class InventoryPresetItemUpdateRequestMessage extends NetworkMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public int presetId = 0;
  public int position = 63;
  public int objUid = 0;
  public static final int protocolId = 6210;

  public void serialize(ICustomDataOutput param1) {
    if (this.presetId < 0) {
      throw new Exception("Forbidden value (" + this.presetId + ") on element presetId.");
    }
    param1.writeByte(this.presetId);
    param1.writeByte(this.position);
    if (this.objUid < 0) {
      throw new Exception("Forbidden value (" + this.objUid + ") on element objUid.");
    }
    param1.writeVarInt(this.objUid);
  }

  public void deserialize(ICustomDataInput param1) {
    this.presetId = param1.readByte();
    if (this.presetId < 0) {
      throw new Exception(
          "Forbidden value (" + this.presetId + ") on element of ShortcutObjectPreset.presetId.");
    }

    this.position = param1.readUnsignedByte();
    if (this.position < 0 || this.position > 255) {
      throw new Exception(
          "Forbidden value (" + this.position + ") on element of PresetItem.position.");
    }

    this.objUid = param1.readVarUhInt();
    if (this.objUid < 0) {
      throw new Exception("Forbidden value (" + this.objUid + ") on element of PresetItem.objUid.");
    }
  }
}
