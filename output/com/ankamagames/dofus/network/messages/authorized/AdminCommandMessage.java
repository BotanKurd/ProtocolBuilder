package package com.ankamagames.dofus.network.messages.authorized;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AdminCommandMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 76;
    private boolean _isInitialized = false;
    private String content = "";


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 76;
    }

    public AdminCommandMessage initAdminCommandMessage(String param1) {
         this.content = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.content = "";
         this._isInitialized = false;
    }

    public void pack(ICustomDataOutput param1) {
         ByteArray _loc2_ = new ByteArray();
         this.serialize(new CustomDataWrapper(_loc2_));
         writePacket(param1,this.getMessageId(),_loc2_);
    }

    public void unpack(ICustomDataInput param1,int  param2) {
         this.deserialize(param1);
    }

    public FuncTree unpackAsync(ICustomDataInput param1,int  param2) {
         FuncTree _loc3_ = new FuncTree();
         _loc3_.setRoot(param1);
         this.deserializeAsync(_loc3_);
         return _loc3_;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_AdminCommandMessage(param1);
    }

    public void serializeAs_AdminCommandMessage(ICustomDataOutput param1) {
         param1.writeUTF(this.content);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AdminCommandMessage(param1);
    }

    public void deserializeAs_AdminCommandMessage(ICustomDataInput param1) {
         this._contentFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_AdminCommandMessage(param1);
    }

    public void deserializeAsyncAs_AdminCommandMessage(FuncTree param1) {
         param1.addChild(this._contentFunc);
    }

    private void _contentFunc(ICustomDataInput param1) {
         this.content = param1.readUTF();
    }

}