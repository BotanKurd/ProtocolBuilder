package package com.ankamagames.dofus.network.messages.game.context;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameContextCreateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 200;
    private boolean _isInitialized = false;
    private int context = 1;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 200;
    }

    public GameContextCreateMessage initGameContextCreateMessage(int param1) {
         this.context = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.context = 1;
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
         this.serializeAs_GameContextCreateMessage(param1);
    }

    public void serializeAs_GameContextCreateMessage(ICustomDataOutput param1) {
         param1.writeByte(this.context);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameContextCreateMessage(param1);
    }

    public void deserializeAs_GameContextCreateMessage(ICustomDataInput param1) {
         this._contextFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameContextCreateMessage(param1);
    }

    public void deserializeAsyncAs_GameContextCreateMessage(FuncTree param1) {
         param1.addChild(this._contextFunc);
    }

    private void _contextFunc(ICustomDataInput param1) {
         this.context = param1.readByte();
         if(this.context < 0)
            throw new Exception("Forbidden value (" + this.context + ") on element of GameContextCreateMessage.context.");
    }

}