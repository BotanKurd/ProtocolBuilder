package package com.ankamagames.dofus.network.messages.security;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class RawDataMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6253;
    private boolean _isInitialized = false;
    private ByteArray content = ;
    private int _loc2_ = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6253;
    }

    public RawDataMessage initRawDataMessage(ByteArray param1) {
         this.content = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.content = new ByteArray();
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
         this.serializeAs_RawDataMessage(param1);
    }

    public void serializeAs_RawDataMessage(ICustomDataOutput param1) {
         param1.writeVarInt(this.content.length);
         int _loc2_ = 0;
         while(_loc2_ < this.content.length)
            param1.writeByte(this.content[_loc2_]);
            _loc2_++;
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_RawDataMessage(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_RawDataMessage(param1);
    }

    public void deserializeAs_RawDataMessage(ICustomDataInput param1) {
         int _loc2_ = param1.readVarInt();
         param1.readBytes(this.content,0,_loc2_);
    }

    public void deserializeAsyncAs_RawDataMessage(FuncTree param1) {
         param1.addChild(this.deserializeAs_RawDataMessage);
    }

}