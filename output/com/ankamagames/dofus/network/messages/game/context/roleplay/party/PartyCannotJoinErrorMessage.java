package package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class PartyCannotJoinErrorMessage extends AbstractPartyMessage implements INetworkMessage {

    private int protocolId = 5583;
    private boolean _isInitialized = false;
    private int reason = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 5583;
    }

    public PartyCannotJoinErrorMessage initPartyCannotJoinErrorMessage(int param1,int  param2) {
         super.initAbstractPartyMessage(param1);
         this.reason = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.reason = 0;
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
         this.serializeAs_PartyCannotJoinErrorMessage(param1);
    }

    public void serializeAs_PartyCannotJoinErrorMessage(ICustomDataOutput param1) {
         super.serializeAs_AbstractPartyMessage(param1);
         param1.writeByte(this.reason);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PartyCannotJoinErrorMessage(param1);
    }

    public void deserializeAs_PartyCannotJoinErrorMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._reasonFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PartyCannotJoinErrorMessage(param1);
    }

    public void deserializeAsyncAs_PartyCannotJoinErrorMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._reasonFunc);
    }

    private void _reasonFunc(ICustomDataInput param1) {
         this.reason = param1.readByte();
         if(this.reason < 0)
            throw new Exception("Forbidden value (" + this.reason + ") on element of PartyCannotJoinErrorMessage.reason.");
    }

}