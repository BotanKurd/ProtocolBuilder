package com.ankamagames.dofus.network.messages.game.startup;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class StartupActionsObjetAttributionMessage extends NetworkMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public int actionId = 0;
  public Number characterId = 0;
  public static final int protocolId = 1303;

  public void serialize(ICustomDataOutput param1) {
    if (this.actionId < 0) {
      throw new Exception("Forbidden value (" + this.actionId + ") on element actionId.");
    }
    param1.writeInt(this.actionId);
    if (this.characterId < 0 || this.characterId > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.characterId + ") on element characterId.");
    }
    param1.writeVarLong(this.characterId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.actionId = param1.readVarUhShort();
    if (this.actionId < 0) {
      throw new Exception(
          "Forbidden value (" + this.actionId + ") on element of ObjectEffect.actionId.");
    }

    this.characterId = param1.readVarUhLong();
    if (this.characterId < 0 || this.characterId > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value ("
              + this.characterId
              + ") on element of StartupActionsObjetAttributionMessage.characterId.");
    }
  }
}
