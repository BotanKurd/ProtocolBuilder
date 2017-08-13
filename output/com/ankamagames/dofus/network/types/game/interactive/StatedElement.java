package com.ankamagames.dofus.network.types.game.interactive;

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

public class StatedElement extends Object implements INetworkType {

    private int protocolId = 108;
    private int elementId = 0;
    private int elementCellId = 0;
    private int elementState = 0;
    private boolean onCurrentMap = false;


    public int getTypeId() {
         return 108;
    }

    public StatedElement initStatedElement(int param1,int  param2,int  param3,boolean  param4) {
         this.elementId = param1;
         this.elementCellId = param2;
         this.elementState = param3;
         this.onCurrentMap = param4;
         return this;
    }

    public void reset() {
         this.elementId = 0;
         this.elementCellId = 0;
         this.elementState = 0;
         this.onCurrentMap = false;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_StatedElement(param1);
    }

    public void serializeAs_StatedElement(ICustomDataOutput param1) {
         if(this.elementId < 0)
         {
            throw new Exception("Forbidden value (" + this.elementId + ") on element elementId.");
         }
         param1.writeInt(this.elementId);
         if(this.elementCellId < 0 || this.elementCellId > 559)
         {
            throw new Exception("Forbidden value (" + this.elementCellId + ") on element elementCellId.");
         }
         param1.writeVarShort(this.elementCellId);
         if(this.elementState < 0)
         {
            throw new Exception("Forbidden value (" + this.elementState + ") on element elementState.");
         }
         param1.writeVarInt(this.elementState);
         param1.writeBoolean(this.onCurrentMap);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_StatedElement(param1);
    }

    public void deserializeAs_StatedElement(ICustomDataInput param1) {
         this._elementIdFunc(param1);
         this._elementCellIdFunc(param1);
         this._elementStateFunc(param1);
         this._onCurrentMapFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_StatedElement(param1);
    }

    public void deserializeAsyncAs_StatedElement(FuncTree param1) {
         param1.addChild(this._elementIdFunc);
         param1.addChild(this._elementCellIdFunc);
         param1.addChild(this._elementStateFunc);
         param1.addChild(this._onCurrentMapFunc);
    }

    private void _elementIdFunc(ICustomDataInput param1) {
         this.elementId = param1.readInt();
         if(this.elementId < 0)
         {
            throw new Exception("Forbidden value (" + this.elementId + ") on element of StatedElement.elementId.");
         }
    }

    private void _elementCellIdFunc(ICustomDataInput param1) {
         this.elementCellId = param1.readVarUhShort();
         if(this.elementCellId < 0 || this.elementCellId > 559)
         {
            throw new Exception("Forbidden value (" + this.elementCellId + ") on element of StatedElement.elementCellId.");
         }
    }

    private void _elementStateFunc(ICustomDataInput param1) {
         this.elementState = param1.readVarUhInt();
         if(this.elementState < 0)
         {
            throw new Exception("Forbidden value (" + this.elementState + ") on element of StatedElement.elementState.");
         }
    }

    private void _onCurrentMapFunc(ICustomDataInput param1) {
         this.onCurrentMap = param1.readBoolean();
    }

}