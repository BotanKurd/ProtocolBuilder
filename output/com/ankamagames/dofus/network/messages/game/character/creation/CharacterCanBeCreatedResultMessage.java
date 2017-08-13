package com.ankamagames.dofus.network.messages.game.character.creation;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class CharacterCanBeCreatedResultMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6733;
    private boolean _isInitialized = false;
    private boolean yesYouCan = false;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6733;
    }

    public CharacterCanBeCreatedResultMessage initCharacterCanBeCreatedResultMessage(boolean param1) {
         this.yesYouCan = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.yesYouCan = false;
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
         this.serializeAs_CharacterCanBeCreatedResultMessage(param1);
    }

    public void serializeAs_CharacterCanBeCreatedResultMessage(ICustomDataOutput param1) {
         param1.writeBoolean(this.yesYouCan);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_CharacterCanBeCreatedResultMessage(param1);
    }

    public void deserializeAs_CharacterCanBeCreatedResultMessage(ICustomDataInput param1) {
         this._yesYouCanFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_CharacterCanBeCreatedResultMessage(param1);
    }

    public void deserializeAsyncAs_CharacterCanBeCreatedResultMessage(FuncTree param1) {
         param1.addChild(this._yesYouCanFunc);
    }

    private void _yesYouCanFunc(ICustomDataInput param1) {
         this.yesYouCan = param1.readBoolean();
    }

}