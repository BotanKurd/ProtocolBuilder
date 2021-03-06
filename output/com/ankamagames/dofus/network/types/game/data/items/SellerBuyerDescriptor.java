package com.ankamagames.dofus.network.types.game.data.items;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class SellerBuyerDescriptor extends Object implements INetworkType {

  public Vector<uint> quantities;
  public Vector<uint> types;
  public Number taxPercentage = 0;
  public Number taxModificationPercentage = 0;
  public int maxItemLevel = 0;
  public int maxItemPerAccount = 0;
  public int npcContextualId = 0;
  public int unsoldDelay = 0;
  private FuncTree _quantitiestree;
  private FuncTree _typestree;
  public static final int protocolId = 121;

  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.quantities.length);
    int _loc2_ = 0;
    while (_loc2_ < this.quantities.length) {
      if (this.quantities[_loc2_] < 0) {
        throw new Exception(
            "Forbidden value ("
                + this.quantities[_loc2_]
                + ") on element 1 (starting at 1) of quantities.");
      }
      param1.writeVarInt(this.quantities[_loc2_]);
      _loc2_++;
    }
    param1.writeShort(this.types.length);
    int _loc3_ = 0;
    while (_loc3_ < this.types.length) {
      if (this.types[_loc3_] < 0) {
        throw new Exception(
            "Forbidden value (" + this.types[_loc3_] + ") on element 2 (starting at 1) of types.");
      }
      param1.writeVarInt(this.types[_loc3_]);
      _loc3_++;
    }
    param1.writeFloat(this.taxPercentage);
    param1.writeFloat(this.taxModificationPercentage);
    if (this.maxItemLevel < 0 || this.maxItemLevel > 255) {
      throw new Exception("Forbidden value (" + this.maxItemLevel + ") on element maxItemLevel.");
    }
    param1.writeByte(this.maxItemLevel);
    if (this.maxItemPerAccount < 0) {
      throw new Exception(
          "Forbidden value (" + this.maxItemPerAccount + ") on element maxItemPerAccount.");
    }
    param1.writeVarInt(this.maxItemPerAccount);
    param1.writeInt(this.npcContextualId);
    if (this.unsoldDelay < 0) {
      throw new Exception("Forbidden value (" + this.unsoldDelay + ") on element unsoldDelay.");
    }
    param1.writeVarShort(this.unsoldDelay);
  }

  public void deserialize(ICustomDataInput param1) {
    int _loc6_ = 0;
    int _loc7_ = 0;
    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc6_ = param1.readVarUhInt();
      if (_loc6_ < 0) {
        throw new Exception("Forbidden value (" + _loc6_ + ") on elements of quantities.");
      }
      this.quantities.push(_loc6_);
      _loc3_++;
    }
    int _loc4_ = param1.readUnsignedShort();
    int _loc5_ = 0;
    while (_loc5_ < _loc4_) {
      _loc7_ = param1.readVarUhInt();
      if (_loc7_ < 0) {
        throw new Exception("Forbidden value (" + _loc7_ + ") on elements of types.");
      }
      this.types.push(_loc7_);
      _loc5_++;
    }
    this.taxPercentage = param1.readFloat();

    this.taxModificationPercentage = param1.readFloat();

    this.maxItemLevel = param1.readUnsignedByte();
    if (this.maxItemLevel < 0 || this.maxItemLevel > 255) {
      throw new Exception(
          "Forbidden value ("
              + this.maxItemLevel
              + ") on element of SellerBuyerDescriptor.maxItemLevel.");
    }

    this.maxItemPerAccount = param1.readVarUhInt();
    if (this.maxItemPerAccount < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.maxItemPerAccount
              + ") on element of SellerBuyerDescriptor.maxItemPerAccount.");
    }

    this.npcContextualId = param1.readInt();

    this.unsoldDelay = param1.readVarUhShort();
    if (this.unsoldDelay < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.unsoldDelay
              + ") on element of SellerBuyerDescriptor.unsoldDelay.");
    }
  }
}
