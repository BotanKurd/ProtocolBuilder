package package com.ankamagames.dofus.network.messages.game.context.roleplay.npc;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.BasicGuildInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class TaxCollectorDialogQuestionBasicMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5619;
    private boolean _isInitialized = false;
    private BasicGuildInformations guildInfo = ;
    private FuncTree _guildInfotree = ;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5619;
    }

    public TaxCollectorDialogQuestionBasicMessage initTaxCollectorDialogQuestionBasicMessage(BasicGuildInformations param1) {
         this.guildInfo = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.guildInfo = new BasicGuildInformations();
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
         this.serializeAs_TaxCollectorDialogQuestionBasicMessage(param1);
    }

    public void serializeAs_TaxCollectorDialogQuestionBasicMessage(ICustomDataOutput param1) {
         this.guildInfo.serializeAs_BasicGuildInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_TaxCollectorDialogQuestionBasicMessage(param1);
    }

    public void deserializeAs_TaxCollectorDialogQuestionBasicMessage(ICustomDataInput param1) {
         this.guildInfo = new BasicGuildInformations();
         this.guildInfo.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_TaxCollectorDialogQuestionBasicMessage(param1);
    }

    public void deserializeAsyncAs_TaxCollectorDialogQuestionBasicMessage(FuncTree param1) {
         this._guildInfotree = param1.addChild(this._guildInfotreeFunc);
    }

    private void _guildInfotreeFunc(ICustomDataInput param1) {
         this.guildInfo = new BasicGuildInformations();
         this.guildInfo.deserializeAsync(this._guildInfotree);
    }

}