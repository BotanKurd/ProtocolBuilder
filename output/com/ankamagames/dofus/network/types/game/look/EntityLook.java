package com.ankamagames.dofus.network.types.game.look;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class EntityLook extends Object implements INetworkType {

    private int protocolId = 55;
    private int bonesId = 0;
    private Vector<uint> skins;
    private Vector<int> indexedColors;
    private Vector<int> scales;
    private Vector<SubEntity> subentities;
    private FuncTree _skinstree;
    private FuncTree _indexedColorstree;
    private FuncTree _scalestree;
    private FuncTree _subentitiestree;


    public int getTypeId() {
         return 55;
    }

    public EntityLook initEntityLook(int param1,Vector<uint>  param2,Vector<int>  param3,Vector<int>  param4,Vector<SubEntity>  param5) {
         this.bonesId = param1;
         this.skins = param2;
         this.indexedColors = param3;
         this.scales = param4;
         this.subentities = param5;
         return this;
    }

    public void reset() {
         this.bonesId = 0;
         this.skins = new Vector.<uint>();
         this.indexedColors = new Vector.<int>();
         this.scales = new Vector.<int>();
         this.subentities = new Vector.<SubEntity>();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_EntityLook(param1);
    }

    public void serializeAs_EntityLook(ICustomDataOutput param1) {
         if(this.bonesId < 0)
         {
            throw new Exception("Forbidden value (" + this.bonesId + ") on element bonesId.");
         }
         param1.writeVarShort(this.bonesId);
         param1.writeShort(this.skins.length);
         int _loc2_ = 0;
         while(_loc2_ < this.skins.length)
         {
            if(this.skins[_loc2_] < 0)
            {
               throw new Exception("Forbidden value (" + this.skins[_loc2_] + ") on element 2 (starting at 1) of skins.");
            }
            param1.writeVarShort(this.skins[_loc2_]);
            _loc2_++;
         }
         param1.writeShort(this.indexedColors.length);
         int _loc3_ = 0;
         while(_loc3_ < this.indexedColors.length)
         {
            param1.writeInt(this.indexedColors[_loc3_]);
            _loc3_++;
         }
         param1.writeShort(this.scales.length);
         int _loc4_ = 0;
         while(_loc4_ < this.scales.length)
         {
            param1.writeVarShort(this.scales[_loc4_]);
            _loc4_++;
         }
         param1.writeShort(this.subentities.length);
         int _loc5_ = 0;
         while(_loc5_ < this.subentities.length)
         {
            (this.subentities[_loc5_] as SubEntity).serializeAs_SubEntity(param1);
            _loc5_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_EntityLook(param1);
    }

    public void deserializeAs_EntityLook(ICustomDataInput param1) {
         int _loc10_ = 0;
         * _loc11_ = 0;
         * _loc12_ = 0;
         SubEntity _loc13_ = null;
         this._bonesIdFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc10_ = param1.readVarUhShort();
            if(_loc10_ < 0)
            {
               throw new Exception("Forbidden value (" + _loc10_ + ") on elements of skins.");
            }
            this.skins.push(_loc10_);
            _loc3_++;
         }
         int _loc4_ = param1.readUnsignedShort();
         int _loc5_ = 0;
         while(_loc5_ < _loc4_)
         {
            _loc11_ = param1.readInt();
            this.indexedColors.push(_loc11_);
            _loc5_++;
         }
         int _loc6_ = param1.readUnsignedShort();
         int _loc7_ = 0;
         while(_loc7_ < _loc6_)
         {
            _loc12_ = param1.readVarShort();
            this.scales.push(_loc12_);
            _loc7_++;
         }
         int _loc8_ = param1.readUnsignedShort();
         int _loc9_ = 0;
         while(_loc9_ < _loc8_)
         {
            _loc13_ = new SubEntity();
            _loc13_.deserialize(param1);
            this.subentities.push(_loc13_);
            _loc9_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_EntityLook(param1);
    }

    public void deserializeAsyncAs_EntityLook(FuncTree param1) {
         param1.addChild(this._bonesIdFunc);
         this._skinstree = param1.addChild(this._skinstreeFunc);
         this._indexedColorstree = param1.addChild(this._indexedColorstreeFunc);
         this._scalestree = param1.addChild(this._scalestreeFunc);
         this._subentitiestree = param1.addChild(this._subentitiestreeFunc);
    }

    private void _bonesIdFunc(ICustomDataInput param1) {
         this.bonesId = param1.readVarUhShort();
         if(this.bonesId < 0)
         {
            throw new Exception("Forbidden value (" + this.bonesId + ") on element of EntityLook.bonesId.");
         }
    }

    private void _skinstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._skinstree.addChild(this._skinsFunc);
            _loc3_++;
         }
    }

    private void _skinsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarUhShort();
         if(_loc2_ < 0)
         {
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of skins.");
         }
         this.skins.push(_loc2_);
    }

    private void _indexedColorstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._indexedColorstree.addChild(this._indexedColorsFunc);
            _loc3_++;
         }
    }

    private void _indexedColorsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readInt();
         this.indexedColors.push(_loc2_);
    }

    private void _scalestreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._scalestree.addChild(this._scalesFunc);
            _loc3_++;
         }
    }

    private void _scalesFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarShort();
         this.scales.push(_loc2_);
    }

    private void _subentitiestreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._subentitiestree.addChild(this._subentitiesFunc);
            _loc3_++;
         }
    }

    private void _subentitiesFunc(ICustomDataInput param1) {
         SubEntity _loc2_ = new SubEntity();
         _loc2_.deserialize(param1);
         this.subentities.push(_loc2_);
    }

}