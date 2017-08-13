package package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class PartyInvitationCancelledForGuestMessage extends AbstractPartyMessage implements INetworkMessage {

    private int protocolId = 6256;
    private boolean _isInitialized = false;
    private Number cancelerId = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6256;
    }

    public PartyInvitationCancelledForGuestMessage initPartyInvitationCancelledForGuestMessage(int param1,Number  param2) {
         super.initAbstractPartyMessage(param1);
         this.cancelerId = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.cancelerId = 0;
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
         this.serializeAs_PartyInvitationCancelledForGuestMessage(param1);
    }

    public void serializeAs_PartyInvitationCancelledForGuestMessage(ICustomDataOutput param1) {
         super.serializeAs_AbstractPartyMessage(param1);
         if(this.cancelerId < 0 || this.cancelerId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.cancelerId + ") on element cancelerId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PartyInvitationCancelledForGuestMessage(param1);
    }

    public void deserializeAs_PartyInvitationCancelledForGuestMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._cancelerIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PartyInvitationCancelledForGuestMessage(param1);
    }

    public void deserializeAsyncAs_PartyInvitationCancelledForGuestMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._cancelerIdFunc);
    }

    private void _cancelerIdFunc(ICustomDataInput param1) {
         this.cancelerId = param1.readVarUhLong();
         if(this.cancelerId < 0 || this.cancelerId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.cancelerId + ") on element of PartyInvitationCancelledForGuestMessage.cancelerId.");
    }

}