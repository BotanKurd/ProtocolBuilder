package com.ankamagames.dofus.network.messages.game.character.choice
{
   import com.ankamagames.jerakine.network.NetworkMessage;
   import com.ankamagames.jerakine.network.INetworkMessage;
   import com.ankamagames.dofus.network.types.game.character.choice.CharacterBaseInformations;
   import com.ankamagames.jerakine.network.ICustomDataOutput;
   import flash.utils.ByteArray;
   import com.ankamagames.jerakine.network.CustomDataWrapper;
   import com.ankamagames.jerakine.network.ICustomDataInput;
   import com.ankamagames.jerakine.network.utils.FuncTree;
   import com.ankamagames.dofus.network.ProtocolTypeManager;
   
   [Trusted]
   public class BasicCharactersListMessage extends NetworkMessage implements INetworkMessage
   {
      
      public static const protocolId:uint = 6475;
       
      private var _isInitialized:Boolean = false;
      
      public var characters:Vector.<CharacterBaseInformations>;
      
      private var _characterstree:FuncTree;
      
      public function BasicCharactersListMessage()
      {
         this.characters = new Vector.<CharacterBaseInformations>();
         super();
      }
      
      override public function get isInitialized() : Boolean
      {
         return this._isInitialized;
      }
      
      override public function getMessageId() : uint
      {
         return 6475;
      }
      
      public function initBasicCharactersListMessage(param1:Vector.<CharacterBaseInformations> = null) : BasicCharactersListMessage
      {
         this.characters = param1;
         this._isInitialized = true;
         return this;
      }
      
      override public function reset() : void
      {
         this.characters = new Vector.<CharacterBaseInformations>();
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
         this.serializeAs_BasicCharactersListMessage(param1);
      }
      
      public function serializeAs_BasicCharactersListMessage(param1:ICustomDataOutput) : void
      {
         param1.writeShort(this.characters.length);
         var _loc2_:uint = 0;
         while(_loc2_ < this.characters.length)
         {
            param1.writeShort((this.characters[_loc2_] as CharacterBaseInformations).getTypeId());
            (this.characters[_loc2_] as CharacterBaseInformations).serialize(param1);
            _loc2_++;
         }
      }
      
      public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_BasicCharactersListMessage(param1);
      }
      
      public function deserializeAs_BasicCharactersListMessage(param1:ICustomDataInput) : void
      {
         var _loc4_:uint = 0;
         var _loc5_:CharacterBaseInformations = null;
         var _loc2_:uint = param1.readUnsignedShort();
         var _loc3_:uint = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readUnsignedShort();
            _loc5_ = ProtocolTypeManager.getInstance(CharacterBaseInformations,_loc4_);
            _loc5_.deserialize(param1);
            this.characters.push(_loc5_);
            _loc3_++;
         }
      }
      
      public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_BasicCharactersListMessage(param1);
      }
      
      public function deserializeAsyncAs_BasicCharactersListMessage(param1:FuncTree) : void
      {
         this._characterstree = param1.addChild(this._characterstreeFunc);
      }
      
      private function _characterstreeFunc(param1:ICustomDataInput) : void
      {
         var _loc2_:uint = param1.readUnsignedShort();
         var _loc3_:uint = 0;
         while(_loc3_ < _loc2_)
         {
            this._characterstree.addChild(this._charactersFunc);
            _loc3_++;
         }
      }
      
      private function _charactersFunc(param1:ICustomDataInput) : void
      {
         var _loc2_:uint = param1.readUnsignedShort();
         var _loc3_:CharacterBaseInformations = ProtocolTypeManager.getInstance(CharacterBaseInformations,_loc2_);
         _loc3_.deserialize(param1);
         this.characters.push(_loc3_);
      }
   }
}
