package com.ankamagames.dofus.network.messages.game.initialization;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class CharacterCapabilitiesMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6339;
    private boolean _isInitialized = false;
    private int guildEmblemSymbolCategories = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6339;
    }

    public CharacterCapabilitiesMessage initCharacterCapabilitiesMessage(int param1) {
         this.guildEmblemSymbolCategories = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.guildEmblemSymbolCategories = 0;
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
         this.serializeAs_CharacterCapabilitiesMessage(param1);
    }

    public void serializeAs_CharacterCapabilitiesMessage(ICustomDataOutput param1) {
         if(this.guildEmblemSymbolCategories < 0)
         {
            throw new Exception("Forbidden value (" + this.guildEmblemSymbolCategories + ") on element guildEmblemSymbolCategories.");
         }
         param1.writeVarInt(this.guildEmblemSymbolCategories);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_CharacterCapabilitiesMessage(param1);
    }

    public void deserializeAs_CharacterCapabilitiesMessage(ICustomDataInput param1) {
         this._guildEmblemSymbolCategoriesFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_CharacterCapabilitiesMessage(param1);
    }

    public void deserializeAsyncAs_CharacterCapabilitiesMessage(FuncTree param1) {
         param1.addChild(this._guildEmblemSymbolCategoriesFunc);
    }

    private void _guildEmblemSymbolCategoriesFunc(ICustomDataInput param1) {
         this.guildEmblemSymbolCategories = param1.readVarUhInt();
         if(this.guildEmblemSymbolCategories < 0)
         {
            throw new Exception("Forbidden value (" + this.guildEmblemSymbolCategories + ") on element of CharacterCapabilitiesMessage.guildEmblemSymbolCategories.");
         }
    }

}