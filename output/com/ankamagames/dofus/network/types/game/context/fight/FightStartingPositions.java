package package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class FightStartingPositions extends Object implements INetworkType {

    private int protocolId = 513;
    private Vector.<uint> positionsForChallengers = ;
    private Vector.<uint> positionsForDefenders = ;
    private FuncTree _positionsForChallengerstree = ;
    private FuncTree _positionsForDefenderstree = ;
    private int _loc2_ = 0;
    private int _loc3_ = 0;
    private int _loc7_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc4_ = param1.readUnsignedShort();
    private int _loc5_ = 0;
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public int getTypeId() {
         return 513;
    }

    public FightStartingPositions initFightStartingPositions(Vector.<uint> param1,Vector.<uint>  param2) {
         this.positionsForChallengers = param1;
         this.positionsForDefenders = param2;
         return this;
    }

    public void reset() {
         this.positionsForChallengers = new Vector.<uint>();
         this.positionsForDefenders = new Vector.<uint>();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_FightStartingPositions(param1);
    }

    public void serializeAs_FightStartingPositions(ICustomDataOutput param1) {
         param1.writeShort(this.positionsForChallengers.length);
         int _loc2_ = 0;
         while(_loc2_ < this.positionsForChallengers.length)
            if(this.positionsForChallengers[_loc2_] < 0 || this.positionsForChallengers[_loc2_] > 559)
               throw new Exception("Forbidden value (" + this.positionsForChallengers[_loc2_] + ") on element 1 (starting at 1) of positionsForChallengers.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_FightStartingPositions(param1);
    }

    public void deserializeAs_FightStartingPositions(ICustomDataInput param1) {
         int _loc6_ = 0;
         int _loc7_ = 0;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc6_ = param1.readVarUhShort();
            if(_loc6_ < 0 || _loc6_ > 559)
               throw new Exception("Forbidden value (" + _loc6_ + ") on elements of positionsForChallengers.");
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_FightStartingPositions(param1);
    }

    public void deserializeAsyncAs_FightStartingPositions(FuncTree param1) {
         this._positionsForChallengerstree = param1.addChild(this._positionsForChallengerstreeFunc);
         this._positionsForDefenderstree = param1.addChild(this._positionsForDefenderstreeFunc);
    }

    private void _positionsForChallengerstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._positionsForChallengerstree.addChild(this._positionsForChallengersFunc);
            _loc3_++;
    }

    private void _positionsForChallengersFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarUhShort();
         if(_loc2_ < 0 || _loc2_ > 559)
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of positionsForChallengers.");
    }

    private void _positionsForDefenderstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._positionsForDefenderstree.addChild(this._positionsForDefendersFunc);
            _loc3_++;
    }

    private void _positionsForDefendersFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarUhShort();
         if(_loc2_ < 0 || _loc2_ > 559)
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of positionsForDefenders.");
    }

}