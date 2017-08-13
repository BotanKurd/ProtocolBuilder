package com.ankamagames.dofus.network.messages.game.inventory.preset;

import com.ankamagames.dofus.network.messages.game.inventory.AbstractPresetSaveResultMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class InventoryPresetSaveResultMessage extends AbstractPresetSaveResultMessage implements INetworkMessage {

    private int protocolId = 6170;
    private boolean _isInitialized = false;


    public void serialize(ICustomDataOutput param1) {
         if(this.presetId < 0)
         {
            throw new Exception("Forbidden value (" + this.presetId + ") on element presetId.");
         }
         param1.writeByte(this.presetId);
         param1.writeByte(this.code);
    }

    public void deserialize(ICustomDataInput param1) {
         this.presetId = param1.readByte();
         if(this.presetId < 0)
         {
            throw new Exception("Forbidden value (" + this.presetId + ") on element of AbstractPresetSaveResultMessage.presetId.");
         }
         this.code = param1.readByte();
         if(this.code < 0)
         {
            throw new Exception("Forbidden value (" + this.code + ") on element of AbstractPresetSaveResultMessage.code.");
         }
    }

}