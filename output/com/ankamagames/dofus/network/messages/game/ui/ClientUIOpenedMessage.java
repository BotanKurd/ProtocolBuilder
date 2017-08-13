package package com.ankamagames.dofus.network.messages.game.ui;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ClientUIOpenedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6459;
    private boolean _isInitialized = false;
    private int type = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6459;
    }

    public ClientUIOpenedMessage initClientUIOpenedMessage(int param1) {
         this.type = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.type = 0;
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
         this.serializeAs_ClientUIOpenedMessage(param1);
    }

    public void serializeAs_ClientUIOpenedMessage(ICustomDataOutput param1) {
         param1.writeByte(this.type);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ClientUIOpenedMessage(param1);
    }

    public void deserializeAs_ClientUIOpenedMessage(ICustomDataInput param1) {
         this._typeFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ClientUIOpenedMessage(param1);
    }

    public void deserializeAsyncAs_ClientUIOpenedMessage(FuncTree param1) {
         param1.addChild(this._typeFunc);
    }

    private void _typeFunc(ICustomDataInput param1) {
         this.type = param1.readByte();
         if(this.type < 0)
            throw new Exception("Forbidden value (" + this.type + ") on element of ClientUIOpenedMessage.type.");
    }

}