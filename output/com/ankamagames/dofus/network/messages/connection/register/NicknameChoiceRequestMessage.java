package com.ankamagames.dofus.network.messages.connection.register;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class NicknameChoiceRequestMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public String nickname = "";
  public static final int protocolId = 5639;

  public void serialize(ICustomDataOutput param1) {
    param1.writeUTF(this.nickname);
  }

  public void deserialize(ICustomDataInput param1) {
    this.nickname = param1.readUTF();
  }
}
