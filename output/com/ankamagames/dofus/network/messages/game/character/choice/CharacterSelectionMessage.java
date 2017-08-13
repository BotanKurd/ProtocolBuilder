package package com.ankamagames.dofus.network.messages.game.character.choice;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class CharacterSelectionMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 152;
    private boolean _isInitialized = false;
    private Number id = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 152;
    }

    public CharacterSelectionMessage initCharacterSelectionMessage(Number param1) {
         this.id = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.id = 0;
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
         this.serializeAs_CharacterSelectionMessage(param1);
    }

    public void serializeAs_CharacterSelectionMessage(ICustomDataOutput param1) {
         if(this.id < 0 || this.id > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.id + ") on element id.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_CharacterSelectionMessage(param1);
    }

    public void deserializeAs_CharacterSelectionMessage(ICustomDataInput param1) {
         this._idFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_CharacterSelectionMessage(param1);
    }

    public void deserializeAsyncAs_CharacterSelectionMessage(FuncTree param1) {
         param1.addChild(this._idFunc);
    }

    private void _idFunc(ICustomDataInput param1) {
         this.id = param1.readVarUhLong();
         if(this.id < 0 || this.id > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.id + ") on element of CharacterSelectionMessage.id.");
    }

}