package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.party.PartyInvitationMemberInformations;
import com.ankamagames.dofus.network.types.game.context.roleplay.party.PartyGuestInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class PartyInvitationDetailsMessage extends AbstractPartyMessage implements INetworkMessage {

    private int protocolId = 6263;
    private boolean _isInitialized = false;
    private int partyType = 0;
    private String partyName = "";
    private Number fromId = 0;
    private String fromName = "";
    private Number leaderId = 0;
    private Vector<PartyInvitationMemberInformations> members;
    private Vector<PartyGuestInformations> guests;
    private FuncTree _memberstree;
    private FuncTree _gueststree;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6263;
    }

    public PartyInvitationDetailsMessage initPartyInvitationDetailsMessage(int param1,int  param2,String  param3,Number  param4,String  param5,Number  param6,Vector<PartyInvitationMemberInformations>  param7,Vector<PartyGuestInformations>  param8) {
         super.initAbstractPartyMessage(param1);
         this.partyType = param2;
         this.partyName = param3;
         this.fromId = param4;
         this.fromName = param5;
         this.leaderId = param6;
         this.members = param7;
         this.guests = param8;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.partyType = 0;
         this.partyName = "";
         this.fromId = 0;
         this.fromName = "";
         this.leaderId = 0;
         this.members = new Vector.<PartyInvitationMemberInformations>();
         this.guests = new Vector.<PartyGuestInformations>();
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
         this.serializeAs_PartyInvitationDetailsMessage(param1);
    }

    public void serializeAs_PartyInvitationDetailsMessage(ICustomDataOutput param1) {
         super.serializeAs_AbstractPartyMessage(param1);
         param1.writeByte(this.partyType);
         param1.writeUTF(this.partyName);
         if(this.fromId < 0 || this.fromId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.fromId + ") on element fromId.");
         }
         param1.writeVarLong(this.fromId);
         param1.writeUTF(this.fromName);
         if(this.leaderId < 0 || this.leaderId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.leaderId + ") on element leaderId.");
         }
         param1.writeVarLong(this.leaderId);
         param1.writeShort(this.members.length);
         int _loc2_ = 0;
         while(_loc2_ < this.members.length)
         {
            (this.members[_loc2_] as PartyInvitationMemberInformations).serializeAs_PartyInvitationMemberInformations(param1);
            _loc2_++;
         }
         param1.writeShort(this.guests.length);
         int _loc3_ = 0;
         while(_loc3_ < this.guests.length)
         {
            (this.guests[_loc3_] as PartyGuestInformations).serializeAs_PartyGuestInformations(param1);
            _loc3_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PartyInvitationDetailsMessage(param1);
    }

    public void deserializeAs_PartyInvitationDetailsMessage(ICustomDataInput param1) {
         PartyInvitationMemberInformations _loc6_ = null;
         PartyGuestInformations _loc7_ = null;
         super.deserialize(param1);
         this._partyTypeFunc(param1);
         this._partyNameFunc(param1);
         this._fromIdFunc(param1);
         this._fromNameFunc(param1);
         this._leaderIdFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc6_ = new PartyInvitationMemberInformations();
            _loc6_.deserialize(param1);
            this.members.push(_loc6_);
            _loc3_++;
         }
         int _loc4_ = param1.readUnsignedShort();
         int _loc5_ = 0;
         while(_loc5_ < _loc4_)
         {
            _loc7_ = new PartyGuestInformations();
            _loc7_.deserialize(param1);
            this.guests.push(_loc7_);
            _loc5_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PartyInvitationDetailsMessage(param1);
    }

    public void deserializeAsyncAs_PartyInvitationDetailsMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._partyTypeFunc);
         param1.addChild(this._partyNameFunc);
         param1.addChild(this._fromIdFunc);
         param1.addChild(this._fromNameFunc);
         param1.addChild(this._leaderIdFunc);
         this._memberstree = param1.addChild(this._memberstreeFunc);
         this._gueststree = param1.addChild(this._gueststreeFunc);
    }

    private void _partyTypeFunc(ICustomDataInput param1) {
         this.partyType = param1.readByte();
         if(this.partyType < 0)
         {
            throw new Exception("Forbidden value (" + this.partyType + ") on element of PartyInvitationDetailsMessage.partyType.");
         }
    }

    private void _partyNameFunc(ICustomDataInput param1) {
         this.partyName = param1.readUTF();
    }

    private void _fromIdFunc(ICustomDataInput param1) {
         this.fromId = param1.readVarUhLong();
         if(this.fromId < 0 || this.fromId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.fromId + ") on element of PartyInvitationDetailsMessage.fromId.");
         }
    }

    private void _fromNameFunc(ICustomDataInput param1) {
         this.fromName = param1.readUTF();
    }

    private void _leaderIdFunc(ICustomDataInput param1) {
         this.leaderId = param1.readVarUhLong();
         if(this.leaderId < 0 || this.leaderId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.leaderId + ") on element of PartyInvitationDetailsMessage.leaderId.");
         }
    }

    private void _memberstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._memberstree.addChild(this._membersFunc);
            _loc3_++;
         }
    }

    private void _membersFunc(ICustomDataInput param1) {
         PartyInvitationMemberInformations _loc2_ = new PartyInvitationMemberInformations();
         _loc2_.deserialize(param1);
         this.members.push(_loc2_);
    }

    private void _gueststreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._gueststree.addChild(this._guestsFunc);
            _loc3_++;
         }
    }

    private void _guestsFunc(ICustomDataInput param1) {
         PartyGuestInformations _loc2_ = new PartyGuestInformations();
         _loc2_.deserialize(param1);
         this.guests.push(_loc2_);
    }

}