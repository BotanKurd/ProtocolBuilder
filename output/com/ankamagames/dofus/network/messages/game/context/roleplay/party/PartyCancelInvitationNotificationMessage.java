package package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class PartyCancelInvitationNotificationMessage extends AbstractPartyEventMessage implements INetworkMessage {

    private int protocolId = 6251;
    private boolean _isInitialized = false;
    private Number cancelerId = 0;
    private Number guestId = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6251;
    }

    public PartyCancelInvitationNotificationMessage initPartyCancelInvitationNotificationMessage(int param1,Number  param2,Number  param3) {
         super.initAbstractPartyEventMessage(param1);
         this.cancelerId = param2;
         this.guestId = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.cancelerId = 0;
         this.guestId = 0;
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
         this.serializeAs_PartyCancelInvitationNotificationMessage(param1);
    }

    public void serializeAs_PartyCancelInvitationNotificationMessage(ICustomDataOutput param1) {
         super.serializeAs_AbstractPartyEventMessage(param1);
         if(this.cancelerId < 0 || this.cancelerId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.cancelerId + ") on element cancelerId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PartyCancelInvitationNotificationMessage(param1);
    }

    public void deserializeAs_PartyCancelInvitationNotificationMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._cancelerIdFunc(param1);
         this._guestIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PartyCancelInvitationNotificationMessage(param1);
    }

    public void deserializeAsyncAs_PartyCancelInvitationNotificationMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._cancelerIdFunc);
         param1.addChild(this._guestIdFunc);
    }

    private void _cancelerIdFunc(ICustomDataInput param1) {
         this.cancelerId = param1.readVarUhLong();
         if(this.cancelerId < 0 || this.cancelerId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.cancelerId + ") on element of PartyCancelInvitationNotificationMessage.cancelerId.");
    }

    private void _guestIdFunc(ICustomDataInput param1) {
         this.guestId = param1.readVarUhLong();
         if(this.guestId < 0 || this.guestId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.guestId + ") on element of PartyCancelInvitationNotificationMessage.guestId.");
    }

}