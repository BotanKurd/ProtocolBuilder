package com.ankamagames.dofus.network.types.game.guild.tax;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.character.CharacterMinimalPlusLookInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class TaxCollectorFightersInformation extends Object implements INetworkType {

  public int collectorId = 0;
  public Vector<CharacterMinimalPlusLookInformations> allyCharactersInformations;
  public Vector<CharacterMinimalPlusLookInformations> enemyCharactersInformations;
  private FuncTree _allyCharactersInformationstree;
  private FuncTree _enemyCharactersInformationstree;
  public static final int protocolId = 169;

  public void serialize(ICustomDataOutput param1) {
    param1.writeInt(this.collectorId);
    param1.writeShort(this.allyCharactersInformations.length);
    int _loc2_ = 0;
    while (_loc2_ < this.allyCharactersInformations.length) {
      param1.writeShort(
          ((CharacterMinimalPlusLookInformations) (this.allyCharactersInformations[_loc2_]))
              .getTypeId());
      ((CharacterMinimalPlusLookInformations) this.allyCharactersInformations[_loc2_])
          .serialize(param1);
      _loc2_++;
    }
    param1.writeShort(this.enemyCharactersInformations.length);
    int _loc3_ = 0;
    while (_loc3_ < this.enemyCharactersInformations.length) {
      param1.writeShort(
          ((CharacterMinimalPlusLookInformations) (this.enemyCharactersInformations[_loc3_]))
              .getTypeId());
      ((CharacterMinimalPlusLookInformations) this.enemyCharactersInformations[_loc3_])
          .serialize(param1);
      _loc3_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    int _loc6_ = 0;
    CharacterMinimalPlusLookInformations _loc7_ = null;
    int _loc8_ = 0;
    CharacterMinimalPlusLookInformations _loc9_ = null;
    this.collectorId = param1.readInt();

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc6_ = param1.readUnsignedShort();
      _loc7_ = ProtocolTypeManager.getInstance(CharacterMinimalPlusLookInformations, _loc6_);
      _loc7_.deserialize(param1);
      this.allyCharactersInformations.push(_loc7_);
      _loc3_++;
    }
    int _loc4_ = param1.readUnsignedShort();
    int _loc5_ = 0;
    while (_loc5_ < _loc4_) {
      _loc8_ = param1.readUnsignedShort();
      _loc9_ = ProtocolTypeManager.getInstance(CharacterMinimalPlusLookInformations, _loc8_);
      _loc9_.deserialize(param1);
      this.enemyCharactersInformations.push(_loc9_);
      _loc5_++;
    }
  }
}
