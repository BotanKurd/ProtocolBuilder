package com.ankamagames.dofus.network.messages.game.character.choice;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.character.choice.RemodelingInformation;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class CharacterSelectionWithRemodelMessage extends CharacterSelectionMessage implements INetworkMessage {

    private int protocolId = 6549;
    private boolean _isInitialized = false;
    private RemodelingInformation remodel;
    private FuncTree _remodeltree;


    public void serialize(ICustomDataOutput param1) {
         if(this.id < 0 || this.id > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element id.");
         }
         param1.writeVarLong(this.id);
         this.remodel.serializeAs_RemodelingInformation(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.id = param1.readVarUhLong();
         if(this.id < 0 || this.id > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element of CharacterSelectionMessage.id.");
         }
         this.remodel = new RemodelingInformation();
         this.remodel.deserialize(param1);
    }

}