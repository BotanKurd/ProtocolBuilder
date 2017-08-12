package data.types.game.character.characteristic
{
   import com.ankamagames.jerakine.network.INetworkType;
   import com.ankamagames.dofus.network.types.game.character.alignment.ActorExtendedAlignmentInformations;
   import com.ankamagames.jerakine.network.ICustomDataOutput;
   import com.ankamagames.jerakine.network.ICustomDataInput;
   import com.ankamagames.jerakine.network.utils.FuncTree;
   
   public class CharacterCharacteristicsInformations extends Object implements INetworkType
   {
      
      public static const protocolId:uint = 8;
       
      public var experience:Number = 0;
      
      public var experienceLevelFloor:Number = 0;
      
      public var experienceNextLevelFloor:Number = 0;
      
      public var experienceBonusLimit:Number = 0;
      
      public var kamas:Number = 0;
      
      public var statsPoints:uint = 0;
      
      public var additionnalPoints:uint = 0;
      
      public var spellsPoints:uint = 0;
      
      public var alignmentInfos:ActorExtendedAlignmentInformations;
      
      public var lifePoints:uint = 0;
      
      public var maxLifePoints:uint = 0;
      
      public var energyPoints:uint = 0;
      
      public var maxEnergyPoints:uint = 0;
      
      public var actionPointsCurrent:int = 0;
      
      public var movementPointsCurrent:int = 0;
      
      public var initiative:CharacterBaseCharacteristic;
      
      public var prospecting:CharacterBaseCharacteristic;
      
      public var actionPoints:CharacterBaseCharacteristic;
      
      public var movementPoints:CharacterBaseCharacteristic;
      
      public var strength:CharacterBaseCharacteristic;
      
      public var vitality:CharacterBaseCharacteristic;
      
      public var wisdom:CharacterBaseCharacteristic;
      
      public var chance:CharacterBaseCharacteristic;
      
      public var agility:CharacterBaseCharacteristic;
      
      public var intelligence:CharacterBaseCharacteristic;
      
      public var range:CharacterBaseCharacteristic;
      
      public var summonableCreaturesBoost:CharacterBaseCharacteristic;
      
      public var reflect:CharacterBaseCharacteristic;
      
      public var criticalHit:CharacterBaseCharacteristic;
      
      public var criticalHitWeapon:uint = 0;
      
      public var criticalMiss:CharacterBaseCharacteristic;
      
      public var healBonus:CharacterBaseCharacteristic;
      
      public var allDamagesBonus:CharacterBaseCharacteristic;
      
      public var weaponDamagesBonusPercent:CharacterBaseCharacteristic;
      
      public var damagesBonusPercent:CharacterBaseCharacteristic;
      
      public var trapBonus:CharacterBaseCharacteristic;
      
      public var trapBonusPercent:CharacterBaseCharacteristic;
      
      public var glyphBonusPercent:CharacterBaseCharacteristic;
      
      public var runeBonusPercent:CharacterBaseCharacteristic;
      
      public var permanentDamagePercent:CharacterBaseCharacteristic;
      
      public var tackleBlock:CharacterBaseCharacteristic;
      
      public var tackleEvade:CharacterBaseCharacteristic;
      
      public var PAAttack:CharacterBaseCharacteristic;
      
      public var PMAttack:CharacterBaseCharacteristic;
      
      public var pushDamageBonus:CharacterBaseCharacteristic;
      
      public var criticalDamageBonus:CharacterBaseCharacteristic;
      
      public var neutralDamageBonus:CharacterBaseCharacteristic;
      
      public var earthDamageBonus:CharacterBaseCharacteristic;
      
      public var waterDamageBonus:CharacterBaseCharacteristic;
      
      public var airDamageBonus:CharacterBaseCharacteristic;
      
      public var fireDamageBonus:CharacterBaseCharacteristic;
      
      public var dodgePALostProbability:CharacterBaseCharacteristic;
      
      public var dodgePMLostProbability:CharacterBaseCharacteristic;
      
      public var neutralElementResistPercent:CharacterBaseCharacteristic;
      
      public var earthElementResistPercent:CharacterBaseCharacteristic;
      
      public var waterElementResistPercent:CharacterBaseCharacteristic;
      
      public var airElementResistPercent:CharacterBaseCharacteristic;
      
      public var fireElementResistPercent:CharacterBaseCharacteristic;
      
      public var neutralElementReduction:CharacterBaseCharacteristic;
      
      public var earthElementReduction:CharacterBaseCharacteristic;
      
      public var waterElementReduction:CharacterBaseCharacteristic;
      
      public var airElementReduction:CharacterBaseCharacteristic;
      
      public var fireElementReduction:CharacterBaseCharacteristic;
      
      public var pushDamageReduction:CharacterBaseCharacteristic;
      
      public var criticalDamageReduction:CharacterBaseCharacteristic;
      
      public var pvpNeutralElementResistPercent:CharacterBaseCharacteristic;
      
      public var pvpEarthElementResistPercent:CharacterBaseCharacteristic;
      
      public var pvpWaterElementResistPercent:CharacterBaseCharacteristic;
      
      public var pvpAirElementResistPercent:CharacterBaseCharacteristic;
      
      public var pvpFireElementResistPercent:CharacterBaseCharacteristic;
      
      public var pvpNeutralElementReduction:CharacterBaseCharacteristic;
      
      public var pvpEarthElementReduction:CharacterBaseCharacteristic;
      
      public var pvpWaterElementReduction:CharacterBaseCharacteristic;
      
      public var pvpAirElementReduction:CharacterBaseCharacteristic;
      
      public var pvpFireElementReduction:CharacterBaseCharacteristic;
      
      public var meleeDamageDonePercent:CharacterBaseCharacteristic;
      
      public var meleeDamageReceivedPercent:CharacterBaseCharacteristic;
      
      public var rangedDamageDonePercent:CharacterBaseCharacteristic;
      
      public var rangedDamageReceivedPercent:CharacterBaseCharacteristic;
      
      public var weaponDamageDonePercent:CharacterBaseCharacteristic;
      
      public var weaponDamageReceivedPercent:CharacterBaseCharacteristic;
      
      public var spellDamageDonePercent:CharacterBaseCharacteristic;
      
      public var spellDamageReceivedPercent:CharacterBaseCharacteristic;
      
      public var spellModifications:Vector.<CharacterSpellModification>;
      
      public var probationTime:uint = 0;
      
      private var _alignmentInfostree:FuncTree;
      
      private var _initiativetree:FuncTree;
      
      private var _prospectingtree:FuncTree;
      
      private var _actionPointstree:FuncTree;
      
      private var _movementPointstree:FuncTree;
      
      private var _strengthtree:FuncTree;
      
      private var _vitalitytree:FuncTree;
      
      private var _wisdomtree:FuncTree;
      
      private var _chancetree:FuncTree;
      
      private var _agilitytree:FuncTree;
      
      private var _intelligencetree:FuncTree;
      
      private var _rangetree:FuncTree;
      
      private var _summonableCreaturesBoosttree:FuncTree;
      
      private var _reflecttree:FuncTree;
      
      private var _criticalHittree:FuncTree;
      
      private var _criticalMisstree:FuncTree;
      
      private var _healBonustree:FuncTree;
      
      private var _allDamagesBonustree:FuncTree;
      
      private var _weaponDamagesBonusPercenttree:FuncTree;
      
      private var _damagesBonusPercenttree:FuncTree;
      
      private var _trapBonustree:FuncTree;
      
      private var _trapBonusPercenttree:FuncTree;
      
      private var _glyphBonusPercenttree:FuncTree;
      
      private var _runeBonusPercenttree:FuncTree;
      
      private var _permanentDamagePercenttree:FuncTree;
      
      private var _tackleBlocktree:FuncTree;
      
      private var _tackleEvadetree:FuncTree;
      
      private var _PAAttacktree:FuncTree;
      
      private var _PMAttacktree:FuncTree;
      
      private var _pushDamageBonustree:FuncTree;
      
      private var _criticalDamageBonustree:FuncTree;
      
      private var _neutralDamageBonustree:FuncTree;
      
      private var _earthDamageBonustree:FuncTree;
      
      private var _waterDamageBonustree:FuncTree;
      
      private var _airDamageBonustree:FuncTree;
      
      private var _fireDamageBonustree:FuncTree;
      
      private var _dodgePALostProbabilitytree:FuncTree;
      
      private var _dodgePMLostProbabilitytree:FuncTree;
      
      private var _neutralElementResistPercenttree:FuncTree;
      
      private var _earthElementResistPercenttree:FuncTree;
      
      private var _waterElementResistPercenttree:FuncTree;
      
      private var _airElementResistPercenttree:FuncTree;
      
      private var _fireElementResistPercenttree:FuncTree;
      
      private var _neutralElementReductiontree:FuncTree;
      
      private var _earthElementReductiontree:FuncTree;
      
      private var _waterElementReductiontree:FuncTree;
      
      private var _airElementReductiontree:FuncTree;
      
      private var _fireElementReductiontree:FuncTree;
      
      private var _pushDamageReductiontree:FuncTree;
      
      private var _criticalDamageReductiontree:FuncTree;
      
      private var _pvpNeutralElementResistPercenttree:FuncTree;
      
      private var _pvpEarthElementResistPercenttree:FuncTree;
      
      private var _pvpWaterElementResistPercenttree:FuncTree;
      
      private var _pvpAirElementResistPercenttree:FuncTree;
      
      private var _pvpFireElementResistPercenttree:FuncTree;
      
      private var _pvpNeutralElementReductiontree:FuncTree;
      
      private var _pvpEarthElementReductiontree:FuncTree;
      
      private var _pvpWaterElementReductiontree:FuncTree;
      
      private var _pvpAirElementReductiontree:FuncTree;
      
      private var _pvpFireElementReductiontree:FuncTree;
      
      private var _meleeDamageDonePercenttree:FuncTree;
      
      private var _meleeDamageReceivedPercenttree:FuncTree;
      
      private var _rangedDamageDonePercenttree:FuncTree;
      
      private var _rangedDamageReceivedPercenttree:FuncTree;
      
      private var _weaponDamageDonePercenttree:FuncTree;
      
      private var _weaponDamageReceivedPercenttree:FuncTree;
      
      private var _spellDamageDonePercenttree:FuncTree;
      
      private var _spellDamageReceivedPercenttree:FuncTree;
      
      private var _spellModificationstree:FuncTree;
      
      public function CharacterCharacteristicsInformations()
      {
         this.alignmentInfos = new ActorExtendedAlignmentInformations();
         this.initiative = new CharacterBaseCharacteristic();
         this.prospecting = new CharacterBaseCharacteristic();
         this.actionPoints = new CharacterBaseCharacteristic();
         this.movementPoints = new CharacterBaseCharacteristic();
         this.strength = new CharacterBaseCharacteristic();
         this.vitality = new CharacterBaseCharacteristic();
         this.wisdom = new CharacterBaseCharacteristic();
         this.chance = new CharacterBaseCharacteristic();
         this.agility = new CharacterBaseCharacteristic();
         this.intelligence = new CharacterBaseCharacteristic();
         this.range = new CharacterBaseCharacteristic();
         this.summonableCreaturesBoost = new CharacterBaseCharacteristic();
         this.reflect = new CharacterBaseCharacteristic();
         this.criticalHit = new CharacterBaseCharacteristic();
         this.criticalMiss = new CharacterBaseCharacteristic();
         this.healBonus = new CharacterBaseCharacteristic();
         this.allDamagesBonus = new CharacterBaseCharacteristic();
         this.weaponDamagesBonusPercent = new CharacterBaseCharacteristic();
         this.damagesBonusPercent = new CharacterBaseCharacteristic();
         this.trapBonus = new CharacterBaseCharacteristic();
         this.trapBonusPercent = new CharacterBaseCharacteristic();
         this.glyphBonusPercent = new CharacterBaseCharacteristic();
         this.runeBonusPercent = new CharacterBaseCharacteristic();
         this.permanentDamagePercent = new CharacterBaseCharacteristic();
         this.tackleBlock = new CharacterBaseCharacteristic();
         this.tackleEvade = new CharacterBaseCharacteristic();
         this.PAAttack = new CharacterBaseCharacteristic();
         this.PMAttack = new CharacterBaseCharacteristic();
         this.pushDamageBonus = new CharacterBaseCharacteristic();
         this.criticalDamageBonus = new CharacterBaseCharacteristic();
         this.neutralDamageBonus = new CharacterBaseCharacteristic();
         this.earthDamageBonus = new CharacterBaseCharacteristic();
         this.waterDamageBonus = new CharacterBaseCharacteristic();
         this.airDamageBonus = new CharacterBaseCharacteristic();
         this.fireDamageBonus = new CharacterBaseCharacteristic();
         this.dodgePALostProbability = new CharacterBaseCharacteristic();
         this.dodgePMLostProbability = new CharacterBaseCharacteristic();
         this.neutralElementResistPercent = new CharacterBaseCharacteristic();
         this.earthElementResistPercent = new CharacterBaseCharacteristic();
         this.waterElementResistPercent = new CharacterBaseCharacteristic();
         this.airElementResistPercent = new CharacterBaseCharacteristic();
         this.fireElementResistPercent = new CharacterBaseCharacteristic();
         this.neutralElementReduction = new CharacterBaseCharacteristic();
         this.earthElementReduction = new CharacterBaseCharacteristic();
         this.waterElementReduction = new CharacterBaseCharacteristic();
         this.airElementReduction = new CharacterBaseCharacteristic();
         this.fireElementReduction = new CharacterBaseCharacteristic();
         this.pushDamageReduction = new CharacterBaseCharacteristic();
         this.criticalDamageReduction = new CharacterBaseCharacteristic();
         this.pvpNeutralElementResistPercent = new CharacterBaseCharacteristic();
         this.pvpEarthElementResistPercent = new CharacterBaseCharacteristic();
         this.pvpWaterElementResistPercent = new CharacterBaseCharacteristic();
         this.pvpAirElementResistPercent = new CharacterBaseCharacteristic();
         this.pvpFireElementResistPercent = new CharacterBaseCharacteristic();
         this.pvpNeutralElementReduction = new CharacterBaseCharacteristic();
         this.pvpEarthElementReduction = new CharacterBaseCharacteristic();
         this.pvpWaterElementReduction = new CharacterBaseCharacteristic();
         this.pvpAirElementReduction = new CharacterBaseCharacteristic();
         this.pvpFireElementReduction = new CharacterBaseCharacteristic();
         this.meleeDamageDonePercent = new CharacterBaseCharacteristic();
         this.meleeDamageReceivedPercent = new CharacterBaseCharacteristic();
         this.rangedDamageDonePercent = new CharacterBaseCharacteristic();
         this.rangedDamageReceivedPercent = new CharacterBaseCharacteristic();
         this.weaponDamageDonePercent = new CharacterBaseCharacteristic();
         this.weaponDamageReceivedPercent = new CharacterBaseCharacteristic();
         this.spellDamageDonePercent = new CharacterBaseCharacteristic();
         this.spellDamageReceivedPercent = new CharacterBaseCharacteristic();
         this.spellModifications = new Vector.<CharacterSpellModification>();
         super();
      }
      
      public function getTypeId() : uint
      {
         return 8;
      }
      
      public function initCharacterCharacteristicsInformations(param1:Number = 0, param2:Number = 0, param3:Number = 0, param4:Number = 0, param5:Number = 0, param6:uint = 0, param7:uint = 0, param8:uint = 0, param9:ActorExtendedAlignmentInformations = null, param10:uint = 0, param11:uint = 0, param12:uint = 0, param13:uint = 0, param14:int = 0, param15:int = 0, param16:CharacterBaseCharacteristic = null, param17:CharacterBaseCharacteristic = null, param18:CharacterBaseCharacteristic = null, param19:CharacterBaseCharacteristic = null, param20:CharacterBaseCharacteristic = null, param21:CharacterBaseCharacteristic = null, param22:CharacterBaseCharacteristic = null, param23:CharacterBaseCharacteristic = null, param24:CharacterBaseCharacteristic = null, param25:CharacterBaseCharacteristic = null, param26:CharacterBaseCharacteristic = null, param27:CharacterBaseCharacteristic = null, param28:CharacterBaseCharacteristic = null, param29:CharacterBaseCharacteristic = null, param30:uint = 0, param31:CharacterBaseCharacteristic = null, param32:CharacterBaseCharacteristic = null, param33:CharacterBaseCharacteristic = null, param34:CharacterBaseCharacteristic = null, param35:CharacterBaseCharacteristic = null, param36:CharacterBaseCharacteristic = null, param37:CharacterBaseCharacteristic = null, param38:CharacterBaseCharacteristic = null, param39:CharacterBaseCharacteristic = null, param40:CharacterBaseCharacteristic = null, param41:CharacterBaseCharacteristic = null, param42:CharacterBaseCharacteristic = null, param43:CharacterBaseCharacteristic = null, param44:CharacterBaseCharacteristic = null, param45:CharacterBaseCharacteristic = null, param46:CharacterBaseCharacteristic = null, param47:CharacterBaseCharacteristic = null, param48:CharacterBaseCharacteristic = null, param49:CharacterBaseCharacteristic = null, param50:CharacterBaseCharacteristic = null, param51:CharacterBaseCharacteristic = null, param52:CharacterBaseCharacteristic = null, param53:CharacterBaseCharacteristic = null, param54:CharacterBaseCharacteristic = null, param55:CharacterBaseCharacteristic = null, param56:CharacterBaseCharacteristic = null, param57:CharacterBaseCharacteristic = null, param58:CharacterBaseCharacteristic = null, param59:CharacterBaseCharacteristic = null, param60:CharacterBaseCharacteristic = null, param61:CharacterBaseCharacteristic = null, param62:CharacterBaseCharacteristic = null, param63:CharacterBaseCharacteristic = null, param64:CharacterBaseCharacteristic = null, param65:CharacterBaseCharacteristic = null, param66:CharacterBaseCharacteristic = null, param67:CharacterBaseCharacteristic = null, param68:CharacterBaseCharacteristic = null, param69:CharacterBaseCharacteristic = null, param70:CharacterBaseCharacteristic = null, param71:CharacterBaseCharacteristic = null, param72:CharacterBaseCharacteristic = null, param73:CharacterBaseCharacteristic = null, param74:CharacterBaseCharacteristic = null, param75:CharacterBaseCharacteristic = null, param76:CharacterBaseCharacteristic = null, param77:CharacterBaseCharacteristic = null, param78:CharacterBaseCharacteristic = null, param79:CharacterBaseCharacteristic = null, param80:CharacterBaseCharacteristic = null, param81:CharacterBaseCharacteristic = null, param82:CharacterBaseCharacteristic = null, param83:CharacterBaseCharacteristic = null, param84:Vector.<CharacterSpellModification> = null, param85:uint = 0) : CharacterCharacteristicsInformations
      {
         this.experience = param1;
         this.experienceLevelFloor = param2;
         this.experienceNextLevelFloor = param3;
         this.experienceBonusLimit = param4;
         this.kamas = param5;
         this.statsPoints = param6;
         this.additionnalPoints = param7;
         this.spellsPoints = param8;
         this.alignmentInfos = param9;
         this.lifePoints = param10;
         this.maxLifePoints = param11;
         this.energyPoints = param12;
         this.maxEnergyPoints = param13;
         this.actionPointsCurrent = param14;
         this.movementPointsCurrent = param15;
         this.initiative = param16;
         this.prospecting = param17;
         this.actionPoints = param18;
         this.movementPoints = param19;
         this.strength = param20;
         this.vitality = param21;
         this.wisdom = param22;
         this.chance = param23;
         this.agility = param24;
         this.intelligence = param25;
         this.range = param26;
         this.summonableCreaturesBoost = param27;
         this.reflect = param28;
         this.criticalHit = param29;
         this.criticalHitWeapon = param30;
         this.criticalMiss = param31;
         this.healBonus = param32;
         this.allDamagesBonus = param33;
         this.weaponDamagesBonusPercent = param34;
         this.damagesBonusPercent = param35;
         this.trapBonus = param36;
         this.trapBonusPercent = param37;
         this.glyphBonusPercent = param38;
         this.runeBonusPercent = param39;
         this.permanentDamagePercent = param40;
         this.tackleBlock = param41;
         this.tackleEvade = param42;
         this.PAAttack = param43;
         this.PMAttack = param44;
         this.pushDamageBonus = param45;
         this.criticalDamageBonus = param46;
         this.neutralDamageBonus = param47;
         this.earthDamageBonus = param48;
         this.waterDamageBonus = param49;
         this.airDamageBonus = param50;
         this.fireDamageBonus = param51;
         this.dodgePALostProbability = param52;
         this.dodgePMLostProbability = param53;
         this.neutralElementResistPercent = param54;
         this.earthElementResistPercent = param55;
         this.waterElementResistPercent = param56;
         this.airElementResistPercent = param57;
         this.fireElementResistPercent = param58;
         this.neutralElementReduction = param59;
         this.earthElementReduction = param60;
         this.waterElementReduction = param61;
         this.airElementReduction = param62;
         this.fireElementReduction = param63;
         this.pushDamageReduction = param64;
         this.criticalDamageReduction = param65;
         this.pvpNeutralElementResistPercent = param66;
         this.pvpEarthElementResistPercent = param67;
         this.pvpWaterElementResistPercent = param68;
         this.pvpAirElementResistPercent = param69;
         this.pvpFireElementResistPercent = param70;
         this.pvpNeutralElementReduction = param71;
         this.pvpEarthElementReduction = param72;
         this.pvpWaterElementReduction = param73;
         this.pvpAirElementReduction = param74;
         this.pvpFireElementReduction = param75;
         this.meleeDamageDonePercent = param76;
         this.meleeDamageReceivedPercent = param77;
         this.rangedDamageDonePercent = param78;
         this.rangedDamageReceivedPercent = param79;
         this.weaponDamageDonePercent = param80;
         this.weaponDamageReceivedPercent = param81;
         this.spellDamageDonePercent = param82;
         this.spellDamageReceivedPercent = param83;
         this.spellModifications = param84;
         this.probationTime = param85;
         return this;
      }
      
      public function reset() : void
      {
         this.experience = 0;
         this.experienceLevelFloor = 0;
         this.experienceNextLevelFloor = 0;
         this.experienceBonusLimit = 0;
         this.kamas = 0;
         this.statsPoints = 0;
         this.additionnalPoints = 0;
         this.spellsPoints = 0;
         this.alignmentInfos = new ActorExtendedAlignmentInformations();
         this.maxLifePoints = 0;
         this.energyPoints = 0;
         this.maxEnergyPoints = 0;
         this.actionPointsCurrent = 0;
         this.movementPointsCurrent = 0;
         this.initiative = new CharacterBaseCharacteristic();
         this.criticalMiss = new CharacterBaseCharacteristic();
         this.probationTime = 0;
      }
      
      public function serialize(param1:ICustomDataOutput) : void
      {
         this.serializeAs_CharacterCharacteristicsInformations(param1);
      }
      
      public function serializeAs_CharacterCharacteristicsInformations(param1:ICustomDataOutput) : void
      {
         if(this.experience < 0 || this.experience > 9.007199254740992E15)
         {
            throw new Error("Forbidden value (" + this.experience + ") on element experience.");
         }
         param1.writeVarLong(this.experience);
         if(this.experienceLevelFloor < 0 || this.experienceLevelFloor > 9.007199254740992E15)
         {
            throw new Error("Forbidden value (" + this.experienceLevelFloor + ") on element experienceLevelFloor.");
         }
         param1.writeVarLong(this.experienceLevelFloor);
         if(this.experienceNextLevelFloor < 0 || this.experienceNextLevelFloor > 9.007199254740992E15)
         {
            throw new Error("Forbidden value (" + this.experienceNextLevelFloor + ") on element experienceNextLevelFloor.");
         }
         param1.writeVarLong(this.experienceNextLevelFloor);
         if(this.experienceBonusLimit < 0 || this.experienceBonusLimit > 9.007199254740992E15)
         {
            throw new Error("Forbidden value (" + this.experienceBonusLimit + ") on element experienceBonusLimit.");
         }
         param1.writeVarLong(this.experienceBonusLimit);
         if(this.kamas < 0 || this.kamas > 9.007199254740992E15)
         {
            throw new Error("Forbidden value (" + this.kamas + ") on element kamas.");
         }
         param1.writeVarLong(this.kamas);
         if(this.statsPoints < 0)
         {
            throw new Error("Forbidden value (" + this.statsPoints + ") on element statsPoints.");
         }
         param1.writeVarShort(this.statsPoints);
         if(this.additionnalPoints < 0)
         {
            throw new Error("Forbidden value (" + this.additionnalPoints + ") on element additionnalPoints.");
         }
         param1.writeVarShort(this.additionnalPoints);
         if(this.spellsPoints < 0)
         {
            throw new Error("Forbidden value (" + this.spellsPoints + ") on element spellsPoints.");
         }
         param1.writeVarShort(this.spellsPoints);
         this.alignmentInfos.serializeAs_ActorExtendedAlignmentInformations(param1);
         if(this.lifePoints < 0)
         {
            throw new Error("Forbidden value (" + this.lifePoints + ") on element lifePoints.");
         }
         param1.writeVarInt(this.lifePoints);
         if(this.maxLifePoints < 0)
         {
            throw new Error("Forbidden value (" + this.maxLifePoints + ") on element maxLifePoints.");
         }
         param1.writeVarInt(this.maxLifePoints);
         if(this.energyPoints < 0)
         {
            throw new Error("Forbidden value (" + this.energyPoints + ") on element energyPoints.");
         }
         param1.writeVarShort(this.energyPoints);
         if(this.maxEnergyPoints < 0)
         {
            throw new Error("Forbidden value (" + this.maxEnergyPoints + ") on element maxEnergyPoints.");
         }
         param1.writeVarShort(this.maxEnergyPoints);
         param1.writeVarShort(this.actionPointsCurrent);
         param1.writeVarShort(this.movementPointsCurrent);
         this.initiative.serializeAs_CharacterBaseCharacteristic(param1);
         this.prospecting.serializeAs_CharacterBaseCharacteristic(param1);
         this.actionPoints.serializeAs_CharacterBaseCharacteristic(param1);
         this.movementPoints.serializeAs_CharacterBaseCharacteristic(param1);
         this.strength.serializeAs_CharacterBaseCharacteristic(param1);
         this.vitality.serializeAs_CharacterBaseCharacteristic(param1);
         this.wisdom.serializeAs_CharacterBaseCharacteristic(param1);
         this.chance.serializeAs_CharacterBaseCharacteristic(param1);
         this.agility.serializeAs_CharacterBaseCharacteristic(param1);
         this.intelligence.serializeAs_CharacterBaseCharacteristic(param1);
         this.range.serializeAs_CharacterBaseCharacteristic(param1);
         this.summonableCreaturesBoost.serializeAs_CharacterBaseCharacteristic(param1);
         this.reflect.serializeAs_CharacterBaseCharacteristic(param1);
         this.criticalHit.serializeAs_CharacterBaseCharacteristic(param1);
         if(this.criticalHitWeapon < 0)
         {
            throw new Error("Forbidden value (" + this.criticalHitWeapon + ") on element criticalHitWeapon.");
         }
         param1.writeVarShort(this.criticalHitWeapon);
         this.criticalMiss.serializeAs_CharacterBaseCharacteristic(param1);
         this.healBonus.serializeAs_CharacterBaseCharacteristic(param1);
         this.allDamagesBonus.serializeAs_CharacterBaseCharacteristic(param1);
         this.weaponDamagesBonusPercent.serializeAs_CharacterBaseCharacteristic(param1);
         this.damagesBonusPercent.serializeAs_CharacterBaseCharacteristic(param1);
         this.trapBonus.serializeAs_CharacterBaseCharacteristic(param1);
         this.trapBonusPercent.serializeAs_CharacterBaseCharacteristic(param1);
         this.glyphBonusPercent.serializeAs_CharacterBaseCharacteristic(param1);
         this.runeBonusPercent.serializeAs_CharacterBaseCharacteristic(param1);
         this.permanentDamagePercent.serializeAs_CharacterBaseCharacteristic(param1);
         this.tackleBlock.serializeAs_CharacterBaseCharacteristic(param1);
         this.tackleEvade.serializeAs_CharacterBaseCharacteristic(param1);
         this.PAAttack.serializeAs_CharacterBaseCharacteristic(param1);
         this.PMAttack.serializeAs_CharacterBaseCharacteristic(param1);
         this.pushDamageBonus.serializeAs_CharacterBaseCharacteristic(param1);
         this.criticalDamageBonus.serializeAs_CharacterBaseCharacteristic(param1);
         this.neutralDamageBonus.serializeAs_CharacterBaseCharacteristic(param1);
         this.earthDamageBonus.serializeAs_CharacterBaseCharacteristic(param1);
         this.waterDamageBonus.serializeAs_CharacterBaseCharacteristic(param1);
         this.airDamageBonus.serializeAs_CharacterBaseCharacteristic(param1);
         this.fireDamageBonus.serializeAs_CharacterBaseCharacteristic(param1);
         this.dodgePALostProbability.serializeAs_CharacterBaseCharacteristic(param1);
         this.dodgePMLostProbability.serializeAs_CharacterBaseCharacteristic(param1);
         this.neutralElementResistPercent.serializeAs_CharacterBaseCharacteristic(param1);
         this.earthElementResistPercent.serializeAs_CharacterBaseCharacteristic(param1);
         this.waterElementResistPercent.serializeAs_CharacterBaseCharacteristic(param1);
         this.airElementResistPercent.serializeAs_CharacterBaseCharacteristic(param1);
         this.fireElementResistPercent.serializeAs_CharacterBaseCharacteristic(param1);
         this.neutralElementReduction.serializeAs_CharacterBaseCharacteristic(param1);
         this.earthElementReduction.serializeAs_CharacterBaseCharacteristic(param1);
         this.waterElementReduction.serializeAs_CharacterBaseCharacteristic(param1);
         this.airElementReduction.serializeAs_CharacterBaseCharacteristic(param1);
         this.fireElementReduction.serializeAs_CharacterBaseCharacteristic(param1);
         this.pushDamageReduction.serializeAs_CharacterBaseCharacteristic(param1);
         this.criticalDamageReduction.serializeAs_CharacterBaseCharacteristic(param1);
         this.pvpNeutralElementResistPercent.serializeAs_CharacterBaseCharacteristic(param1);
         this.pvpEarthElementResistPercent.serializeAs_CharacterBaseCharacteristic(param1);
         this.pvpWaterElementResistPercent.serializeAs_CharacterBaseCharacteristic(param1);
         this.pvpAirElementResistPercent.serializeAs_CharacterBaseCharacteristic(param1);
         this.pvpFireElementResistPercent.serializeAs_CharacterBaseCharacteristic(param1);
         this.pvpNeutralElementReduction.serializeAs_CharacterBaseCharacteristic(param1);
         this.pvpEarthElementReduction.serializeAs_CharacterBaseCharacteristic(param1);
         this.pvpWaterElementReduction.serializeAs_CharacterBaseCharacteristic(param1);
         this.pvpAirElementReduction.serializeAs_CharacterBaseCharacteristic(param1);
         this.pvpFireElementReduction.serializeAs_CharacterBaseCharacteristic(param1);
         this.meleeDamageDonePercent.serializeAs_CharacterBaseCharacteristic(param1);
         this.meleeDamageReceivedPercent.serializeAs_CharacterBaseCharacteristic(param1);
         this.rangedDamageDonePercent.serializeAs_CharacterBaseCharacteristic(param1);
         this.rangedDamageReceivedPercent.serializeAs_CharacterBaseCharacteristic(param1);
         this.weaponDamageDonePercent.serializeAs_CharacterBaseCharacteristic(param1);
         this.weaponDamageReceivedPercent.serializeAs_CharacterBaseCharacteristic(param1);
         this.spellDamageDonePercent.serializeAs_CharacterBaseCharacteristic(param1);
         this.spellDamageReceivedPercent.serializeAs_CharacterBaseCharacteristic(param1);
         param1.writeShort(this.spellModifications.length);
         var _loc2_:uint = 0;
         while(_loc2_ < this.spellModifications.length)
         {
            (this.spellModifications[_loc2_] as CharacterSpellModification).serializeAs_CharacterSpellModification(param1);
            _loc2_++;
         }
         if(this.probationTime < 0)
         {
            throw new Error("Forbidden value (" + this.probationTime + ") on element probationTime.");
         }
         param1.writeInt(this.probationTime);
      }
      
      public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_CharacterCharacteristicsInformations(param1);
      }
      
      public function deserializeAs_CharacterCharacteristicsInformations(param1:ICustomDataInput) : void
      {
         var _loc4_:CharacterSpellModification = null;
         this._experienceFunc(param1);
         this._experienceLevelFloorFunc(param1);
         this._experienceNextLevelFloorFunc(param1);
         this._experienceBonusLimitFunc(param1);
         this._kamasFunc(param1);
         this._statsPointsFunc(param1);
         this._additionnalPointsFunc(param1);
         this._spellsPointsFunc(param1);
         this.alignmentInfos = new ActorExtendedAlignmentInformations();
         this.alignmentInfos.deserialize(param1);
         this._lifePointsFunc(param1);
         this._maxLifePointsFunc(param1);
         this._energyPointsFunc(param1);
         this._maxEnergyPointsFunc(param1);
         this._actionPointsCurrentFunc(param1);
         this._movementPointsCurrentFunc(param1);
         this.initiative = new CharacterBaseCharacteristic();
         this.initiative.deserialize(param1);
         this.prospecting = new CharacterBaseCharacteristic();
         this.prospecting.deserialize(param1);
         this.actionPoints = new CharacterBaseCharacteristic();
         this.actionPoints.deserialize(param1);
         this.movementPoints = new CharacterBaseCharacteristic();
         this.movementPoints.deserialize(param1);
         this.strength = new CharacterBaseCharacteristic();
         this.strength.deserialize(param1);
         this.vitality = new CharacterBaseCharacteristic();
         this.vitality.deserialize(param1);
         this.wisdom = new CharacterBaseCharacteristic();
         this.wisdom.deserialize(param1);
         this.chance = new CharacterBaseCharacteristic();
         this.chance.deserialize(param1);
         this.agility = new CharacterBaseCharacteristic();
         this.agility.deserialize(param1);
         this.intelligence = new CharacterBaseCharacteristic();
         this.intelligence.deserialize(param1);
         this.range = new CharacterBaseCharacteristic();
         this.range.deserialize(param1);
         this.summonableCreaturesBoost = new CharacterBaseCharacteristic();
         this.summonableCreaturesBoost.deserialize(param1);
         this.reflect = new CharacterBaseCharacteristic();
         this.reflect.deserialize(param1);
         this.criticalHit = new CharacterBaseCharacteristic();
         this.criticalHit.deserialize(param1);
         this._criticalHitWeaponFunc(param1);
         this.criticalMiss = new CharacterBaseCharacteristic();
         this.criticalMiss.deserialize(param1);
         this.healBonus = new CharacterBaseCharacteristic();
         this.healBonus.deserialize(param1);
         this.allDamagesBonus = new CharacterBaseCharacteristic();
         this.allDamagesBonus.deserialize(param1);
         this.weaponDamagesBonusPercent = new CharacterBaseCharacteristic();
         this.weaponDamagesBonusPercent.deserialize(param1);
         this.damagesBonusPercent = new CharacterBaseCharacteristic();
         this.damagesBonusPercent.deserialize(param1);
         this.trapBonus = new CharacterBaseCharacteristic();
         this.trapBonus.deserialize(param1);
         this.trapBonusPercent = new CharacterBaseCharacteristic();
         this.trapBonusPercent.deserialize(param1);
         this.glyphBonusPercent = new CharacterBaseCharacteristic();
         this.glyphBonusPercent.deserialize(param1);
         this.runeBonusPercent = new CharacterBaseCharacteristic();
         this.runeBonusPercent.deserialize(param1);
         this.permanentDamagePercent = new CharacterBaseCharacteristic();
         this.permanentDamagePercent.deserialize(param1);
         this.tackleBlock = new CharacterBaseCharacteristic();
         this.tackleBlock.deserialize(param1);
         this.tackleEvade = new CharacterBaseCharacteristic();
         this.tackleEvade.deserialize(param1);
         this.PAAttack = new CharacterBaseCharacteristic();
         this.PAAttack.deserialize(param1);
         this.PMAttack = new CharacterBaseCharacteristic();
         this.PMAttack.deserialize(param1);
         this.pushDamageBonus = new CharacterBaseCharacteristic();
         this.pushDamageBonus.deserialize(param1);
         this.criticalDamageBonus = new CharacterBaseCharacteristic();
         this.criticalDamageBonus.deserialize(param1);
         this.neutralDamageBonus = new CharacterBaseCharacteristic();
         this.neutralDamageBonus.deserialize(param1);
         this.earthDamageBonus = new CharacterBaseCharacteristic();
         this.earthDamageBonus.deserialize(param1);
         this.waterDamageBonus = new CharacterBaseCharacteristic();
         this.waterDamageBonus.deserialize(param1);
         this.airDamageBonus = new CharacterBaseCharacteristic();
         this.airDamageBonus.deserialize(param1);
         this.fireDamageBonus = new CharacterBaseCharacteristic();
         this.fireDamageBonus.deserialize(param1);
         this.dodgePALostProbability = new CharacterBaseCharacteristic();
         this.dodgePALostProbability.deserialize(param1);
         this.dodgePMLostProbability = new CharacterBaseCharacteristic();
         this.dodgePMLostProbability.deserialize(param1);
         this.neutralElementResistPercent = new CharacterBaseCharacteristic();
         this.neutralElementResistPercent.deserialize(param1);
         this.earthElementResistPercent = new CharacterBaseCharacteristic();
         this.earthElementResistPercent.deserialize(param1);
         this.waterElementResistPercent = new CharacterBaseCharacteristic();
         this.waterElementResistPercent.deserialize(param1);
         this.airElementResistPercent = new CharacterBaseCharacteristic();
         this.airElementResistPercent.deserialize(param1);
         this.fireElementResistPercent = new CharacterBaseCharacteristic();
         this.fireElementResistPercent.deserialize(param1);
         this.neutralElementReduction = new CharacterBaseCharacteristic();
         this.neutralElementReduction.deserialize(param1);
         this.earthElementReduction = new CharacterBaseCharacteristic();
         this.earthElementReduction.deserialize(param1);
         this.waterElementReduction = new CharacterBaseCharacteristic();
         this.waterElementReduction.deserialize(param1);
         this.airElementReduction = new CharacterBaseCharacteristic();
         this.airElementReduction.deserialize(param1);
         this.fireElementReduction = new CharacterBaseCharacteristic();
         this.fireElementReduction.deserialize(param1);
         this.pushDamageReduction = new CharacterBaseCharacteristic();
         this.pushDamageReduction.deserialize(param1);
         this.criticalDamageReduction = new CharacterBaseCharacteristic();
         this.criticalDamageReduction.deserialize(param1);
         this.pvpNeutralElementResistPercent = new CharacterBaseCharacteristic();
         this.pvpNeutralElementResistPercent.deserialize(param1);
         this.pvpEarthElementResistPercent = new CharacterBaseCharacteristic();
         this.pvpEarthElementResistPercent.deserialize(param1);
         this.pvpWaterElementResistPercent = new CharacterBaseCharacteristic();
         this.pvpWaterElementResistPercent.deserialize(param1);
         this.pvpAirElementResistPercent = new CharacterBaseCharacteristic();
         this.pvpAirElementResistPercent.deserialize(param1);
         this.pvpFireElementResistPercent = new CharacterBaseCharacteristic();
         this.pvpFireElementResistPercent.deserialize(param1);
         this.pvpNeutralElementReduction = new CharacterBaseCharacteristic();
         this.pvpNeutralElementReduction.deserialize(param1);
         this.pvpEarthElementReduction = new CharacterBaseCharacteristic();
         this.pvpEarthElementReduction.deserialize(param1);
         this.pvpWaterElementReduction = new CharacterBaseCharacteristic();
         this.pvpWaterElementReduction.deserialize(param1);
         this.pvpAirElementReduction = new CharacterBaseCharacteristic();
         this.pvpAirElementReduction.deserialize(param1);
         this.pvpFireElementReduction = new CharacterBaseCharacteristic();
         this.pvpFireElementReduction.deserialize(param1);
         this.meleeDamageDonePercent = new CharacterBaseCharacteristic();
         this.meleeDamageDonePercent.deserialize(param1);
         this.meleeDamageReceivedPercent = new CharacterBaseCharacteristic();
         this.meleeDamageReceivedPercent.deserialize(param1);
         this.rangedDamageDonePercent = new CharacterBaseCharacteristic();
         this.rangedDamageDonePercent.deserialize(param1);
         this.rangedDamageReceivedPercent = new CharacterBaseCharacteristic();
         this.rangedDamageReceivedPercent.deserialize(param1);
         this.weaponDamageDonePercent = new CharacterBaseCharacteristic();
         this.weaponDamageDonePercent.deserialize(param1);
         this.weaponDamageReceivedPercent = new CharacterBaseCharacteristic();
         this.weaponDamageReceivedPercent.deserialize(param1);
         this.spellDamageDonePercent = new CharacterBaseCharacteristic();
         this.spellDamageDonePercent.deserialize(param1);
         this.spellDamageReceivedPercent = new CharacterBaseCharacteristic();
         this.spellDamageReceivedPercent.deserialize(param1);
         var _loc2_:uint = param1.readUnsignedShort();
         var _loc3_:uint = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new CharacterSpellModification();
            _loc4_.deserialize(param1);
            this.spellModifications.push(_loc4_);
            _loc3_++;
         }
         this._probationTimeFunc(param1);
      }
      
      public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_CharacterCharacteristicsInformations(param1);
      }
      
      public function deserializeAsyncAs_CharacterCharacteristicsInformations(param1:FuncTree) : void
      {
         param1.addChild(this._experienceFunc);
         param1.addChild(this._experienceLevelFloorFunc);
         param1.addChild(this._experienceNextLevelFloorFunc);
         param1.addChild(this._experienceBonusLimitFunc);
         param1.addChild(this._kamasFunc);
         param1.addChild(this._statsPointsFunc);
         param1.addChild(this._additionnalPointsFunc);
         param1.addChild(this._spellsPointsFunc);
         this._alignmentInfostree = param1.addChild(this._alignmentInfostreeFunc);
         param1.addChild(this._lifePointsFunc);
         param1.addChild(this._maxLifePointsFunc);
         param1.addChild(this._energyPointsFunc);
         param1.addChild(this._maxEnergyPointsFunc);
         param1.addChild(this._actionPointsCurrentFunc);
         param1.addChild(this._movementPointsCurrentFunc);
         this._initiativetree = param1.addChild(this._initiativetreeFunc);
         this._prospectingtree = param1.addChild(this._prospectingtreeFunc);
         this._actionPointstree = param1.addChild(this._actionPointstreeFunc);
         this._movementPointstree = param1.addChild(this._movementPointstreeFunc);
         this._strengthtree = param1.addChild(this._strengthtreeFunc);
         this._vitalitytree = param1.addChild(this._vitalitytreeFunc);
         this._wisdomtree = param1.addChild(this._wisdomtreeFunc);
         this._chancetree = param1.addChild(this._chancetreeFunc);
         this._agilitytree = param1.addChild(this._agilitytreeFunc);
         this._intelligencetree = param1.addChild(this._intelligencetreeFunc);
         this._rangetree = param1.addChild(this._rangetreeFunc);
         this._summonableCreaturesBoosttree = param1.addChild(this._summonableCreaturesBoosttreeFunc);
         this._reflecttree = param1.addChild(this._reflecttreeFunc);
         this._criticalHittree = param1.addChild(this._criticalHittreeFunc);
         param1.addChild(this._criticalHitWeaponFunc);
         this._criticalMisstree = param1.addChild(this._criticalMisstreeFunc);
         this._healBonustree = param1.addChild(this._healBonustreeFunc);
         this._allDamagesBonustree = param1.addChild(this._allDamagesBonustreeFunc);
         this._weaponDamagesBonusPercenttree = param1.addChild(this._weaponDamagesBonusPercenttreeFunc);
         this._damagesBonusPercenttree = param1.addChild(this._damagesBonusPercenttreeFunc);
         this._trapBonustree = param1.addChild(this._trapBonustreeFunc);
         this._trapBonusPercenttree = param1.addChild(this._trapBonusPercenttreeFunc);
         this._glyphBonusPercenttree = param1.addChild(this._glyphBonusPercenttreeFunc);
         this._runeBonusPercenttree = param1.addChild(this._runeBonusPercenttreeFunc);
         this._permanentDamagePercenttree = param1.addChild(this._permanentDamagePercenttreeFunc);
         this._tackleBlocktree = param1.addChild(this._tackleBlocktreeFunc);
         this._tackleEvadetree = param1.addChild(this._tackleEvadetreeFunc);
         this._PAAttacktree = param1.addChild(this._PAAttacktreeFunc);
         this._PMAttacktree = param1.addChild(this._PMAttacktreeFunc);
         this._pushDamageBonustree = param1.addChild(this._pushDamageBonustreeFunc);
         this._criticalDamageBonustree = param1.addChild(this._criticalDamageBonustreeFunc);
         this._neutralDamageBonustree = param1.addChild(this._neutralDamageBonustreeFunc);
         this._earthDamageBonustree = param1.addChild(this._earthDamageBonustreeFunc);
         this._waterDamageBonustree = param1.addChild(this._waterDamageBonustreeFunc);
         this._airDamageBonustree = param1.addChild(this._airDamageBonustreeFunc);
         this._fireDamageBonustree = param1.addChild(this._fireDamageBonustreeFunc);
         this._dodgePALostProbabilitytree = param1.addChild(this._dodgePALostProbabilitytreeFunc);
         this._dodgePMLostProbabilitytree = param1.addChild(this._dodgePMLostProbabilitytreeFunc);
         this._neutralElementResistPercenttree = param1.addChild(this._neutralElementResistPercenttreeFunc);
         this._earthElementResistPercenttree = param1.addChild(this._earthElementResistPercenttreeFunc);
         this._waterElementResistPercenttree = param1.addChild(this._waterElementResistPercenttreeFunc);
         this._airElementResistPercenttree = param1.addChild(this._airElementResistPercenttreeFunc);
         this._fireElementResistPercenttree = param1.addChild(this._fireElementResistPercenttreeFunc);
         this._neutralElementReductiontree = param1.addChild(this._neutralElementReductiontreeFunc);
         this._earthElementReductiontree = param1.addChild(this._earthElementReductiontreeFunc);
         this._waterElementReductiontree = param1.addChild(this._waterElementReductiontreeFunc);
         this._airElementReductiontree = param1.addChild(this._airElementReductiontreeFunc);
         this._fireElementReductiontree = param1.addChild(this._fireElementReductiontreeFunc);
         this._pushDamageReductiontree = param1.addChild(this._pushDamageReductiontreeFunc);
         this._criticalDamageReductiontree = param1.addChild(this._criticalDamageReductiontreeFunc);
         this._pvpNeutralElementResistPercenttree = param1.addChild(this._pvpNeutralElementResistPercenttreeFunc);
         this._pvpEarthElementResistPercenttree = param1.addChild(this._pvpEarthElementResistPercenttreeFunc);
         this._pvpWaterElementResistPercenttree = param1.addChild(this._pvpWaterElementResistPercenttreeFunc);
         this._pvpAirElementResistPercenttree = param1.addChild(this._pvpAirElementResistPercenttreeFunc);
         this._pvpFireElementResistPercenttree = param1.addChild(this._pvpFireElementResistPercenttreeFunc);
         this._pvpNeutralElementReductiontree = param1.addChild(this._pvpNeutralElementReductiontreeFunc);
         this._pvpEarthElementReductiontree = param1.addChild(this._pvpEarthElementReductiontreeFunc);
         this._pvpWaterElementReductiontree = param1.addChild(this._pvpWaterElementReductiontreeFunc);
         this._pvpAirElementReductiontree = param1.addChild(this._pvpAirElementReductiontreeFunc);
         this._pvpFireElementReductiontree = param1.addChild(this._pvpFireElementReductiontreeFunc);
         this._meleeDamageDonePercenttree = param1.addChild(this._meleeDamageDonePercenttreeFunc);
         this._meleeDamageReceivedPercenttree = param1.addChild(this._meleeDamageReceivedPercenttreeFunc);
         this._rangedDamageDonePercenttree = param1.addChild(this._rangedDamageDonePercenttreeFunc);
         this._rangedDamageReceivedPercenttree = param1.addChild(this._rangedDamageReceivedPercenttreeFunc);
         this._weaponDamageDonePercenttree = param1.addChild(this._weaponDamageDonePercenttreeFunc);
         this._weaponDamageReceivedPercenttree = param1.addChild(this._weaponDamageReceivedPercenttreeFunc);
         this._spellDamageDonePercenttree = param1.addChild(this._spellDamageDonePercenttreeFunc);
         this._spellDamageReceivedPercenttree = param1.addChild(this._spellDamageReceivedPercenttreeFunc);
         this._spellModificationstree = param1.addChild(this._spellModificationstreeFunc);
         param1.addChild(this._probationTimeFunc);
      }
      
      private function _experienceFunc(param1:ICustomDataInput) : void
      {
         this.experience = param1.readVarUhLong();
         if(this.experience < 0 || this.experience > 9.007199254740992E15)
         {
            throw new Error("Forbidden value (" + this.experience + ") on element of CharacterCharacteristicsInformations.experience.");
         }
      }
      
      private function _experienceLevelFloorFunc(param1:ICustomDataInput) : void
      {
         this.experienceLevelFloor = param1.readVarUhLong();
         if(this.experienceLevelFloor < 0 || this.experienceLevelFloor > 9.007199254740992E15)
         {
            throw new Error("Forbidden value (" + this.experienceLevelFloor + ") on element of CharacterCharacteristicsInformations.experienceLevelFloor.");
         }
      }
      
      private function _experienceNextLevelFloorFunc(param1:ICustomDataInput) : void
      {
         this.experienceNextLevelFloor = param1.readVarUhLong();
         if(this.experienceNextLevelFloor < 0 || this.experienceNextLevelFloor > 9.007199254740992E15)
         {
            throw new Error("Forbidden value (" + this.experienceNextLevelFloor + ") on element of CharacterCharacteristicsInformations.experienceNextLevelFloor.");
         }
      }
      
      private function _experienceBonusLimitFunc(param1:ICustomDataInput) : void
      {
         this.experienceBonusLimit = param1.readVarUhLong();
         if(this.experienceBonusLimit < 0 || this.experienceBonusLimit > 9.007199254740992E15)
         {
            throw new Error("Forbidden value (" + this.experienceBonusLimit + ") on element of CharacterCharacteristicsInformations.experienceBonusLimit.");
         }
      }
      
      private function _kamasFunc(param1:ICustomDataInput) : void
      {
         this.kamas = param1.readVarUhLong();
         if(this.kamas < 0 || this.kamas > 9.007199254740992E15)
         {
            throw new Error("Forbidden value (" + this.kamas + ") on element of CharacterCharacteristicsInformations.kamas.");
         }
      }
      
      private function _statsPointsFunc(param1:ICustomDataInput) : void
      {
         this.statsPoints = param1.readVarUhShort();
         if(this.statsPoints < 0)
         {
            throw new Error("Forbidden value (" + this.statsPoints + ") on element of CharacterCharacteristicsInformations.statsPoints.");
         }
      }
      
      private function _additionnalPointsFunc(param1:ICustomDataInput) : void
      {
         this.additionnalPoints = param1.readVarUhShort();
         if(this.additionnalPoints < 0)
         {
            throw new Error("Forbidden value (" + this.additionnalPoints + ") on element of CharacterCharacteristicsInformations.additionnalPoints.");
         }
      }
      
      private function _spellsPointsFunc(param1:ICustomDataInput) : void
      {
         this.spellsPoints = param1.readVarUhShort();
         if(this.spellsPoints < 0)
         {
            throw new Error("Forbidden value (" + this.spellsPoints + ") on element of CharacterCharacteristicsInformations.spellsPoints.");
         }
      }
      
      private function _alignmentInfostreeFunc(param1:ICustomDataInput) : void
      {
         this.alignmentInfos = new ActorExtendedAlignmentInformations();
         this.alignmentInfos.deserializeAsync(this._alignmentInfostree);
      }
      
      private function _lifePointsFunc(param1:ICustomDataInput) : void
      {
         this.lifePoints = param1.readVarUhInt();
         if(this.lifePoints < 0)
         {
            throw new Error("Forbidden value (" + this.lifePoints + ") on element of CharacterCharacteristicsInformations.lifePoints.");
         }
      }
      
      private function _maxLifePointsFunc(param1:ICustomDataInput) : void
      {
         this.maxLifePoints = param1.readVarUhInt();
         if(this.maxLifePoints < 0)
         {
            throw new Error("Forbidden value (" + this.maxLifePoints + ") on element of CharacterCharacteristicsInformations.maxLifePoints.");
         }
      }
      
      private function _energyPointsFunc(param1:ICustomDataInput) : void
      {
         this.energyPoints = param1.readVarUhShort();
         if(this.energyPoints < 0)
         {
            throw new Error("Forbidden value (" + this.energyPoints + ") on element of CharacterCharacteristicsInformations.energyPoints.");
         }
      }
      
      private function _maxEnergyPointsFunc(param1:ICustomDataInput) : void
      {
         this.maxEnergyPoints = param1.readVarUhShort();
         if(this.maxEnergyPoints < 0)
         {
            throw new Error("Forbidden value (" + this.maxEnergyPoints + ") on element of CharacterCharacteristicsInformations.maxEnergyPoints.");
         }
      }
      
      private function _actionPointsCurrentFunc(param1:ICustomDataInput) : void
      {
         this.actionPointsCurrent = param1.readVarShort();
      }
      
      private function _movementPointsCurrentFunc(param1:ICustomDataInput) : void
      {
         this.movementPointsCurrent = param1.readVarShort();
      }
      
      private function _initiativetreeFunc(param1:ICustomDataInput) : void
      {
         this.initiative = new CharacterBaseCharacteristic();
         this.initiative.deserializeAsync(this._initiativetree);
      }
      
      private function _prospectingtreeFunc(param1:ICustomDataInput) : void
      {
         this.prospecting = new CharacterBaseCharacteristic();
         this.prospecting.deserializeAsync(this._prospectingtree);
      }
      
      private function _actionPointstreeFunc(param1:ICustomDataInput) : void
      {
         this.actionPoints = new CharacterBaseCharacteristic();
         this.actionPoints.deserializeAsync(this._actionPointstree);
      }
      
      private function _movementPointstreeFunc(param1:ICustomDataInput) : void
      {
         this.movementPoints = new CharacterBaseCharacteristic();
         this.movementPoints.deserializeAsync(this._movementPointstree);
      }
      
      private function _strengthtreeFunc(param1:ICustomDataInput) : void
      {
         this.strength = new CharacterBaseCharacteristic();
         this.strength.deserializeAsync(this._strengthtree);
      }
      
      private function _vitalitytreeFunc(param1:ICustomDataInput) : void
      {
         this.vitality = new CharacterBaseCharacteristic();
         this.vitality.deserializeAsync(this._vitalitytree);
      }
      
      private function _wisdomtreeFunc(param1:ICustomDataInput) : void
      {
         this.wisdom = new CharacterBaseCharacteristic();
         this.wisdom.deserializeAsync(this._wisdomtree);
      }
      
      private function _chancetreeFunc(param1:ICustomDataInput) : void
      {
         this.chance = new CharacterBaseCharacteristic();
         this.chance.deserializeAsync(this._chancetree);
      }
      
      private function _agilitytreeFunc(param1:ICustomDataInput) : void
      {
         this.agility = new CharacterBaseCharacteristic();
         this.agility.deserializeAsync(this._agilitytree);
      }
      
      private function _intelligencetreeFunc(param1:ICustomDataInput) : void
      {
         this.intelligence = new CharacterBaseCharacteristic();
         this.intelligence.deserializeAsync(this._intelligencetree);
      }
      
      private function _rangetreeFunc(param1:ICustomDataInput) : void
      {
         this.range = new CharacterBaseCharacteristic();
         this.range.deserializeAsync(this._rangetree);
      }
      
      private function _summonableCreaturesBoosttreeFunc(param1:ICustomDataInput) : void
      {
         this.summonableCreaturesBoost = new CharacterBaseCharacteristic();
         this.summonableCreaturesBoost.deserializeAsync(this._summonableCreaturesBoosttree);
      }
      
      private function _reflecttreeFunc(param1:ICustomDataInput) : void
      {
         this.reflect = new CharacterBaseCharacteristic();
         this.reflect.deserializeAsync(this._reflecttree);
      }
      
      private function _criticalHittreeFunc(param1:ICustomDataInput) : void
      {
         this.criticalHit = new CharacterBaseCharacteristic();
         this.criticalHit.deserializeAsync(this._criticalHittree);
      }
      
      private function _criticalHitWeaponFunc(param1:ICustomDataInput) : void
      {
         this.criticalHitWeapon = param1.readVarUhShort();
         if(this.criticalHitWeapon < 0)
         {
            throw new Error("Forbidden value (" + this.criticalHitWeapon + ") on element of CharacterCharacteristicsInformations.criticalHitWeapon.");
         }
      }
      
      private function _criticalMisstreeFunc(param1:ICustomDataInput) : void
      {
         this.criticalMiss = new CharacterBaseCharacteristic();
         this.criticalMiss.deserializeAsync(this._criticalMisstree);
      }
      
      private function _healBonustreeFunc(param1:ICustomDataInput) : void
      {
         this.healBonus = new CharacterBaseCharacteristic();
         this.healBonus.deserializeAsync(this._healBonustree);
      }
      
      private function _allDamagesBonustreeFunc(param1:ICustomDataInput) : void
      {
         this.allDamagesBonus = new CharacterBaseCharacteristic();
         this.allDamagesBonus.deserializeAsync(this._allDamagesBonustree);
      }
      
      private function _weaponDamagesBonusPercenttreeFunc(param1:ICustomDataInput) : void
      {
         this.weaponDamagesBonusPercent = new CharacterBaseCharacteristic();
         this.weaponDamagesBonusPercent.deserializeAsync(this._weaponDamagesBonusPercenttree);
      }
      
      private function _damagesBonusPercenttreeFunc(param1:ICustomDataInput) : void
      {
         this.damagesBonusPercent = new CharacterBaseCharacteristic();
         this.damagesBonusPercent.deserializeAsync(this._damagesBonusPercenttree);
      }
      
      private function _trapBonustreeFunc(param1:ICustomDataInput) : void
      {
         this.trapBonus = new CharacterBaseCharacteristic();
         this.trapBonus.deserializeAsync(this._trapBonustree);
      }
      
      private function _trapBonusPercenttreeFunc(param1:ICustomDataInput) : void
      {
         this.trapBonusPercent = new CharacterBaseCharacteristic();
         this.trapBonusPercent.deserializeAsync(this._trapBonusPercenttree);
      }
      
      private function _glyphBonusPercenttreeFunc(param1:ICustomDataInput) : void
      {
         this.glyphBonusPercent = new CharacterBaseCharacteristic();
         this.glyphBonusPercent.deserializeAsync(this._glyphBonusPercenttree);
      }
      
      private function _runeBonusPercenttreeFunc(param1:ICustomDataInput) : void
      {
         this.runeBonusPercent = new CharacterBaseCharacteristic();
         this.runeBonusPercent.deserializeAsync(this._runeBonusPercenttree);
      }
      
      private function _permanentDamagePercenttreeFunc(param1:ICustomDataInput) : void
      {
         this.permanentDamagePercent = new CharacterBaseCharacteristic();
         this.permanentDamagePercent.deserializeAsync(this._permanentDamagePercenttree);
      }
      
      private function _tackleBlocktreeFunc(param1:ICustomDataInput) : void
      {
         this.tackleBlock = new CharacterBaseCharacteristic();
         this.tackleBlock.deserializeAsync(this._tackleBlocktree);
      }
      
      private function _tackleEvadetreeFunc(param1:ICustomDataInput) : void
      {
         this.tackleEvade = new CharacterBaseCharacteristic();
         this.tackleEvade.deserializeAsync(this._tackleEvadetree);
      }
      
      private function _PAAttacktreeFunc(param1:ICustomDataInput) : void
      {
         this.PAAttack = new CharacterBaseCharacteristic();
         this.PAAttack.deserializeAsync(this._PAAttacktree);
      }
      
      private function _PMAttacktreeFunc(param1:ICustomDataInput) : void
      {
         this.PMAttack = new CharacterBaseCharacteristic();
         this.PMAttack.deserializeAsync(this._PMAttacktree);
      }
      
      private function _pushDamageBonustreeFunc(param1:ICustomDataInput) : void
      {
         this.pushDamageBonus = new CharacterBaseCharacteristic();
         this.pushDamageBonus.deserializeAsync(this._pushDamageBonustree);
      }
      
      private function _criticalDamageBonustreeFunc(param1:ICustomDataInput) : void
      {
         this.criticalDamageBonus = new CharacterBaseCharacteristic();
         this.criticalDamageBonus.deserializeAsync(this._criticalDamageBonustree);
      }
      
      private function _neutralDamageBonustreeFunc(param1:ICustomDataInput) : void
      {
         this.neutralDamageBonus = new CharacterBaseCharacteristic();
         this.neutralDamageBonus.deserializeAsync(this._neutralDamageBonustree);
      }
      
      private function _earthDamageBonustreeFunc(param1:ICustomDataInput) : void
      {
         this.earthDamageBonus = new CharacterBaseCharacteristic();
         this.earthDamageBonus.deserializeAsync(this._earthDamageBonustree);
      }
      
      private function _waterDamageBonustreeFunc(param1:ICustomDataInput) : void
      {
         this.waterDamageBonus = new CharacterBaseCharacteristic();
         this.waterDamageBonus.deserializeAsync(this._waterDamageBonustree);
      }
      
      private function _airDamageBonustreeFunc(param1:ICustomDataInput) : void
      {
         this.airDamageBonus = new CharacterBaseCharacteristic();
         this.airDamageBonus.deserializeAsync(this._airDamageBonustree);
      }
      
      private function _fireDamageBonustreeFunc(param1:ICustomDataInput) : void
      {
         this.fireDamageBonus = new CharacterBaseCharacteristic();
         this.fireDamageBonus.deserializeAsync(this._fireDamageBonustree);
      }
      
      private function _dodgePALostProbabilitytreeFunc(param1:ICustomDataInput) : void
      {
         this.dodgePALostProbability = new CharacterBaseCharacteristic();
         this.dodgePALostProbability.deserializeAsync(this._dodgePALostProbabilitytree);
      }
      
      private function _dodgePMLostProbabilitytreeFunc(param1:ICustomDataInput) : void
      {
         this.dodgePMLostProbability = new CharacterBaseCharacteristic();
         this.dodgePMLostProbability.deserializeAsync(this._dodgePMLostProbabilitytree);
      }
      
      private function _neutralElementResistPercenttreeFunc(param1:ICustomDataInput) : void
      {
         this.neutralElementResistPercent = new CharacterBaseCharacteristic();
         this.neutralElementResistPercent.deserializeAsync(this._neutralElementResistPercenttree);
      }
      
      private function _earthElementResistPercenttreeFunc(param1:ICustomDataInput) : void
      {
         this.earthElementResistPercent = new CharacterBaseCharacteristic();
         this.earthElementResistPercent.deserializeAsync(this._earthElementResistPercenttree);
      }
      
      private function _waterElementResistPercenttreeFunc(param1:ICustomDataInput) : void
      {
         this.waterElementResistPercent = new CharacterBaseCharacteristic();
         this.waterElementResistPercent.deserializeAsync(this._waterElementResistPercenttree);
      }
      
      private function _airElementResistPercenttreeFunc(param1:ICustomDataInput) : void
      {
         this.airElementResistPercent = new CharacterBaseCharacteristic();
         this.airElementResistPercent.deserializeAsync(this._airElementResistPercenttree);
      }
      
      private function _fireElementResistPercenttreeFunc(param1:ICustomDataInput) : void
      {
         this.fireElementResistPercent = new CharacterBaseCharacteristic();
         this.fireElementResistPercent.deserializeAsync(this._fireElementResistPercenttree);
      }
      
      private function _neutralElementReductiontreeFunc(param1:ICustomDataInput) : void
      {
         this.neutralElementReduction = new CharacterBaseCharacteristic();
         this.neutralElementReduction.deserializeAsync(this._neutralElementReductiontree);
      }
      
      private function _earthElementReductiontreeFunc(param1:ICustomDataInput) : void
      {
         this.earthElementReduction = new CharacterBaseCharacteristic();
         this.earthElementReduction.deserializeAsync(this._earthElementReductiontree);
      }
      
      private function _waterElementReductiontreeFunc(param1:ICustomDataInput) : void
      {
         this.waterElementReduction = new CharacterBaseCharacteristic();
         this.waterElementReduction.deserializeAsync(this._waterElementReductiontree);
      }
      
      private function _airElementReductiontreeFunc(param1:ICustomDataInput) : void
      {
         this.airElementReduction = new CharacterBaseCharacteristic();
         this.airElementReduction.deserializeAsync(this._airElementReductiontree);
      }
      
      private function _fireElementReductiontreeFunc(param1:ICustomDataInput) : void
      {
         this.fireElementReduction = new CharacterBaseCharacteristic();
         this.fireElementReduction.deserializeAsync(this._fireElementReductiontree);
      }
      
      private function _pushDamageReductiontreeFunc(param1:ICustomDataInput) : void
      {
         this.pushDamageReduction = new CharacterBaseCharacteristic();
         this.pushDamageReduction.deserializeAsync(this._pushDamageReductiontree);
      }
      
      private function _criticalDamageReductiontreeFunc(param1:ICustomDataInput) : void
      {
         this.criticalDamageReduction = new CharacterBaseCharacteristic();
         this.criticalDamageReduction.deserializeAsync(this._criticalDamageReductiontree);
      }
      
      private function _pvpNeutralElementResistPercenttreeFunc(param1:ICustomDataInput) : void
      {
         this.pvpNeutralElementResistPercent = new CharacterBaseCharacteristic();
         this.pvpNeutralElementResistPercent.deserializeAsync(this._pvpNeutralElementResistPercenttree);
      }
      
      private function _pvpEarthElementResistPercenttreeFunc(param1:ICustomDataInput) : void
      {
         this.pvpEarthElementResistPercent = new CharacterBaseCharacteristic();
         this.pvpEarthElementResistPercent.deserializeAsync(this._pvpEarthElementResistPercenttree);
      }
      
      private function _pvpWaterElementResistPercenttreeFunc(param1:ICustomDataInput) : void
      {
         this.pvpWaterElementResistPercent = new CharacterBaseCharacteristic();
         this.pvpWaterElementResistPercent.deserializeAsync(this._pvpWaterElementResistPercenttree);
      }
      
      private function _pvpAirElementResistPercenttreeFunc(param1:ICustomDataInput) : void
      {
         this.pvpAirElementResistPercent = new CharacterBaseCharacteristic();
         this.pvpAirElementResistPercent.deserializeAsync(this._pvpAirElementResistPercenttree);
      }
      
      private function _pvpFireElementResistPercenttreeFunc(param1:ICustomDataInput) : void
      {
         this.pvpFireElementResistPercent = new CharacterBaseCharacteristic();
         this.pvpFireElementResistPercent.deserializeAsync(this._pvpFireElementResistPercenttree);
      }
      
      private function _pvpNeutralElementReductiontreeFunc(param1:ICustomDataInput) : void
      {
         this.pvpNeutralElementReduction = new CharacterBaseCharacteristic();
         this.pvpNeutralElementReduction.deserializeAsync(this._pvpNeutralElementReductiontree);
      }
      
      private function _pvpEarthElementReductiontreeFunc(param1:ICustomDataInput) : void
      {
         this.pvpEarthElementReduction = new CharacterBaseCharacteristic();
         this.pvpEarthElementReduction.deserializeAsync(this._pvpEarthElementReductiontree);
      }
      
      private function _pvpWaterElementReductiontreeFunc(param1:ICustomDataInput) : void
      {
         this.pvpWaterElementReduction = new CharacterBaseCharacteristic();
         this.pvpWaterElementReduction.deserializeAsync(this._pvpWaterElementReductiontree);
      }
      
      private function _pvpAirElementReductiontreeFunc(param1:ICustomDataInput) : void
      {
         this.pvpAirElementReduction = new CharacterBaseCharacteristic();
         this.pvpAirElementReduction.deserializeAsync(this._pvpAirElementReductiontree);
      }
      
      private function _pvpFireElementReductiontreeFunc(param1:ICustomDataInput) : void
      {
         this.pvpFireElementReduction = new CharacterBaseCharacteristic();
         this.pvpFireElementReduction.deserializeAsync(this._pvpFireElementReductiontree);
      }
      
      private function _meleeDamageDonePercenttreeFunc(param1:ICustomDataInput) : void
      {
         this.meleeDamageDonePercent = new CharacterBaseCharacteristic();
         this.meleeDamageDonePercent.deserializeAsync(this._meleeDamageDonePercenttree);
      }
      
      private function _meleeDamageReceivedPercenttreeFunc(param1:ICustomDataInput) : void
      {
         this.meleeDamageReceivedPercent = new CharacterBaseCharacteristic();
         this.meleeDamageReceivedPercent.deserializeAsync(this._meleeDamageReceivedPercenttree);
      }
      
      private function _rangedDamageDonePercenttreeFunc(param1:ICustomDataInput) : void
      {
         this.rangedDamageDonePercent = new CharacterBaseCharacteristic();
         this.rangedDamageDonePercent.deserializeAsync(this._rangedDamageDonePercenttree);
      }
      
      private function _rangedDamageReceivedPercenttreeFunc(param1:ICustomDataInput) : void
      {
         this.rangedDamageReceivedPercent = new CharacterBaseCharacteristic();
         this.rangedDamageReceivedPercent.deserializeAsync(this._rangedDamageReceivedPercenttree);
      }
      
      private function _weaponDamageDonePercenttreeFunc(param1:ICustomDataInput) : void
      {
         this.weaponDamageDonePercent = new CharacterBaseCharacteristic();
         this.weaponDamageDonePercent.deserializeAsync(this._weaponDamageDonePercenttree);
      }
      
      private function _weaponDamageReceivedPercenttreeFunc(param1:ICustomDataInput) : void
      {
         this.weaponDamageReceivedPercent = new CharacterBaseCharacteristic();
         this.weaponDamageReceivedPercent.deserializeAsync(this._weaponDamageReceivedPercenttree);
      }
      
      private function _spellDamageDonePercenttreeFunc(param1:ICustomDataInput) : void
      {
         this.spellDamageDonePercent = new CharacterBaseCharacteristic();
         this.spellDamageDonePercent.deserializeAsync(this._spellDamageDonePercenttree);
      }
      
      private function _spellDamageReceivedPercenttreeFunc(param1:ICustomDataInput) : void
      {
         this.spellDamageReceivedPercent = new CharacterBaseCharacteristic();
         this.spellDamageReceivedPercent.deserializeAsync(this._spellDamageReceivedPercenttree);
      }
      
      private function _spellModificationstreeFunc(param1:ICustomDataInput) : void
      {
         var _loc2_:uint = param1.readUnsignedShort();
         var _loc3_:uint = 0;
         while(_loc3_ < _loc2_)
         {
            this._spellModificationstree.addChild(this._spellModificationsFunc);
            _loc3_++;
         }
      }
      
      private function _spellModificationsFunc(param1:ICustomDataInput) : void
      {
         var _loc2_:CharacterSpellModification = new CharacterSpellModification();
         _loc2_.deserialize(param1);
         this.spellModifications.push(_loc2_);
      }
      
      private function _probationTimeFunc(param1:ICustomDataInput) : void
      {
         this.probationTime = param1.readInt();
         if(this.probationTime < 0)
         {
            throw new Error("Forbidden value (" + this.probationTime + ") on element of CharacterCharacteristicsInformations.probationTime.");
         }
      }
   }
}
