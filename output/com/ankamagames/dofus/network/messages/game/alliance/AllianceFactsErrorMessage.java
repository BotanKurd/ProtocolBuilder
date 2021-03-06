package com.ankamagames.dofus.network.messages.game.alliance;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AllianceFactsErrorMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int allianceId = 0;
  public static final int protocolId = 6423;

  public void serialize(ICustomDataOutput param1) {
    if (this.allianceId < 0) {
      throw new Exception("Forbidden value (" + this.allianceId + ") on element allianceId.");
    }
    param1.writeVarInt(this.allianceId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.allianceId = param1.readVarUhInt();
    if (this.allianceId < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.allianceId
              + ") on element of GuildInAllianceVersatileInformations.allianceId.");
    }
  }
}
