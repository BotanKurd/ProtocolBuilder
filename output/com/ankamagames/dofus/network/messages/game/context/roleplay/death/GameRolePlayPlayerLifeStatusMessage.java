package com.ankamagames.dofus.network.messages.game.context.roleplay.death;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameRolePlayPlayerLifeStatusMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int state = 0;
  public int phenixMapId = 0;
  public static final int protocolId = 5996;

  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.state);
    if (this.phenixMapId < 0) {
      throw new Exception("Forbidden value (" + this.phenixMapId + ") on element phenixMapId.");
    }
    param1.writeInt(this.phenixMapId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.state = param1.readByte();
    if (this.state < 0) {
      throw new Exception("Forbidden value (" + this.state + ") on element of ContentPart.state.");
    }

    this.phenixMapId = param1.readInt();
    if (this.phenixMapId < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.phenixMapId
              + ") on element of GameRolePlayPlayerLifeStatusMessage.phenixMapId.");
    }
  }
}
