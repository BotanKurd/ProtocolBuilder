package com.ankamagames.dofus.network.messages.game.guild.tax
{
   import com.ankamagames.jerakine.network.NetworkMessage;
   import com.ankamagames.jerakine.network.INetworkMessage;
   import com.ankamagames.jerakine.network.ICustomDataOutput;
   import flash.utils.ByteArray;
   import com.ankamagames.jerakine.network.CustomDataWrapper;
   import com.ankamagames.jerakine.network.ICustomDataInput;
   import com.ankamagames.jerakine.network.utils.FuncTree;
   
   [Trusted]
   public class GuildFightPlayersHelpersLeaveMessage extends NetworkMessage implements INetworkMessage
   {
      
      public static const protocolId:uint = 5719;
       
      private var _isInitialized:Boolean = false;
      
      public var fightId:uint = 0;
      
      public var playerId:Number = 0;
      
      public function GuildFightPlayersHelpersLeaveMessage()
      {
         super();
      }
      
      override public function get isInitialized() : Boolean
      {
         return this._isInitialized;
      }
      
      override public function getMessageId() : uint
      {
         return 5719;
      }
      
      public function initGuildFightPlayersHelpersLeaveMessage(param1:uint = 0, param2:Number = 0) : GuildFightPlayersHelpersLeaveMessage
      {
         this.fightId = param1;
         this.playerId = param2;
         this._isInitialized = true;
         return this;
      }
      
      override public function reset() : void
      {
         this.fightId = 0;
         this.playerId = 0;
         this._isInitialized = false;
      }
      
      override public function pack(param1:ICustomDataOutput) : void
      {
         var _loc2_:ByteArray = new ByteArray();
         this.serialize(new CustomDataWrapper(_loc2_));
         writePacket(param1,this.getMessageId(),_loc2_);
      }
      
      override public function unpack(param1:ICustomDataInput, param2:uint) : void
      {
         this.deserialize(param1);
      }
      
      override public function unpackAsync(param1:ICustomDataInput, param2:uint) : FuncTree
      {
         var _loc3_:FuncTree = new FuncTree();
         _loc3_.setRoot(param1);
         this.deserializeAsync(_loc3_);
         return _loc3_;
      }
      
      public function serialize(param1:ICustomDataOutput) : void
      {
         this.serializeAs_GuildFightPlayersHelpersLeaveMessage(param1);
      }
      
      public function serializeAs_GuildFightPlayersHelpersLeaveMessage(param1:ICustomDataOutput) : void
      {
         if(this.fightId < 0)
         {
            throw new Error("Forbidden value (" + this.fightId + ") on element fightId.");
         }
         param1.writeInt(this.fightId);
         if(this.playerId < 0 || this.playerId > 9.007199254740992E15)
         {
            throw new Error("Forbidden value (" + this.playerId + ") on element playerId.");
         }
         param1.writeVarLong(this.playerId);
      }
      
      public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_GuildFightPlayersHelpersLeaveMessage(param1);
      }
      
      public function deserializeAs_GuildFightPlayersHelpersLeaveMessage(param1:ICustomDataInput) : void
      {
         this._fightIdFunc(param1);
         this._playerIdFunc(param1);
      }
      
      public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_GuildFightPlayersHelpersLeaveMessage(param1);
      }
      
      public function deserializeAsyncAs_GuildFightPlayersHelpersLeaveMessage(param1:FuncTree) : void
      {
         param1.addChild(this._fightIdFunc);
         param1.addChild(this._playerIdFunc);
      }
      
      private function _fightIdFunc(param1:ICustomDataInput) : void
      {
         this.fightId = param1.readInt();
         if(this.fightId < 0)
         {
            throw new Error("Forbidden value (" + this.fightId + ") on element of GuildFightPlayersHelpersLeaveMessage.fightId.");
         }
      }
      
      private function _playerIdFunc(param1:ICustomDataInput) : void
      {
         this.playerId = param1.readVarUhLong();
         if(this.playerId < 0 || this.playerId > 9.007199254740992E15)
         {
            throw new Error("Forbidden value (" + this.playerId + ") on element of GuildFightPlayersHelpersLeaveMessage.playerId.");
         }
      }
   }
}
