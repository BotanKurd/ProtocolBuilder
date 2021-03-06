package com.ankamagames.dofus.network.messages.game.dialog;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class LeaveDialogMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int dialogType = 0;
  public static final int protocolId = 5502;

  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.dialogType);
  }

  public void deserialize(ICustomDataInput param1) {
    this.dialogType = param1.readByte();
    if (this.dialogType < 0) {
      throw new Exception(
          "Forbidden value (" + this.dialogType + ") on element of PauseDialogMessage.dialogType.");
    }
  }
}
