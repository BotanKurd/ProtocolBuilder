package package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class FightTeamMemberTaxCollectorInformations extends FightTeamMemberInformations implements INetworkType {

    private int protocolId = 177;
    private int firstNameId = 0;
    private int lastNameId = 0;
    private int level = 0;
    private int guildId = 0;
    private int uid = 0;


    public int getTypeId() {
         return 177;
    }

    public FightTeamMemberTaxCollectorInformations initFightTeamMemberTaxCollectorInformations(Number param1,int  param2,int  param3,int  param4,int  param5,int  param6) {
         super.initFightTeamMemberInformations(param1);
         this.firstNameId = param2;
         this.lastNameId = param3;
         this.level = param4;
         this.guildId = param5;
         this.uid = param6;
         return this;
    }

    public void reset() {
         super.reset();
         this.firstNameId = 0;
         this.lastNameId = 0;
         this.level = 0;
         this.guildId = 0;
         this.uid = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_FightTeamMemberTaxCollectorInformations(param1);
    }

    public void serializeAs_FightTeamMemberTaxCollectorInformations(ICustomDataOutput param1) {
         super.serializeAs_FightTeamMemberInformations(param1);
         if(this.firstNameId < 0)
            throw new Exception("Forbidden value (" + this.firstNameId + ") on element firstNameId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_FightTeamMemberTaxCollectorInformations(param1);
    }

    public void deserializeAs_FightTeamMemberTaxCollectorInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this._firstNameIdFunc(param1);
         this._lastNameIdFunc(param1);
         this._levelFunc(param1);
         this._guildIdFunc(param1);
         this._uidFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_FightTeamMemberTaxCollectorInformations(param1);
    }

    public void deserializeAsyncAs_FightTeamMemberTaxCollectorInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._firstNameIdFunc);
         param1.addChild(this._lastNameIdFunc);
         param1.addChild(this._levelFunc);
         param1.addChild(this._guildIdFunc);
         param1.addChild(this._uidFunc);
    }

    private void _firstNameIdFunc(ICustomDataInput param1) {
         this.firstNameId = param1.readVarUhShort();
         if(this.firstNameId < 0)
            throw new Exception("Forbidden value (" + this.firstNameId + ") on element of FightTeamMemberTaxCollectorInformations.firstNameId.");
    }

    private void _lastNameIdFunc(ICustomDataInput param1) {
         this.lastNameId = param1.readVarUhShort();
         if(this.lastNameId < 0)
            throw new Exception("Forbidden value (" + this.lastNameId + ") on element of FightTeamMemberTaxCollectorInformations.lastNameId.");
    }

    private void _levelFunc(ICustomDataInput param1) {
         this.level = param1.readUnsignedByte();
         if(this.level < 1 || this.level > 200)
            throw new Exception("Forbidden value (" + this.level + ") on element of FightTeamMemberTaxCollectorInformations.level.");
    }

    private void _guildIdFunc(ICustomDataInput param1) {
         this.guildId = param1.readVarUhInt();
         if(this.guildId < 0)
            throw new Exception("Forbidden value (" + this.guildId + ") on element of FightTeamMemberTaxCollectorInformations.guildId.");
    }

    private void _uidFunc(ICustomDataInput param1) {
         this.uid = param1.readVarUhInt();
         if(this.uid < 0)
            throw new Exception("Forbidden value (" + this.uid + ") on element of FightTeamMemberTaxCollectorInformations.uid.");
    }

}