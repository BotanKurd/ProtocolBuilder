package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PartyPledgeLoyaltyRequestMessage extends AbstractPartyMessage implements INetworkMessage {

    private int protocolId = 6269;
    private boolean _isInitialized = false;
    private boolean loyal = false;


    public void serialize(ICustomDataOutput param1) {
         if(this.partyId < 0)
         {
            throw new Exception("Forbidden value (" + this.partyId + ") on element partyId.");
         }
         param1.writeVarInt(this.partyId);
         param1.writeBoolean(this.loyal);
    }

    public void deserialize(ICustomDataInput param1) {
         this.partyId = param1.readVarUhInt();
         if(this.partyId < 0)
         {
            throw new Exception("Forbidden value (" + this.partyId + ") on element of AbstractPartyMessage.partyId.");
         }
         this.loyal = param1.readBoolean();
    }

}