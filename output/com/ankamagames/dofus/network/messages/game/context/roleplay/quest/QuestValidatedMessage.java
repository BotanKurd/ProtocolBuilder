package package com.ankamagames.dofus.network.messages.game.context.roleplay.quest;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class QuestValidatedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6097;
    private boolean _isInitialized = false;
    private int questId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6097;
    }

    public QuestValidatedMessage initQuestValidatedMessage(int param1) {
         this.questId = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.questId = 0;
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
         this.serializeAs_QuestValidatedMessage(param1);
    }

    public void serializeAs_QuestValidatedMessage(ICustomDataOutput param1) {
         if(this.questId < 0)
            throw new Exception("Forbidden value (" + this.questId + ") on element questId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_QuestValidatedMessage(param1);
    }

    public void deserializeAs_QuestValidatedMessage(ICustomDataInput param1) {
         this._questIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_QuestValidatedMessage(param1);
    }

    public void deserializeAsyncAs_QuestValidatedMessage(FuncTree param1) {
         param1.addChild(this._questIdFunc);
    }

    private void _questIdFunc(ICustomDataInput param1) {
         this.questId = param1.readVarUhShort();
         if(this.questId < 0)
            throw new Exception("Forbidden value (" + this.questId + ") on element of QuestValidatedMessage.questId.");
    }

}