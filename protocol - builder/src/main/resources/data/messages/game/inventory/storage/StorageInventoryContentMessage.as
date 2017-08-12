package data.messages.game.inventory.storage
{
   import com.ankamagames.dofus.network.messages.game.inventory.items.InventoryContentMessage;
   import com.ankamagames.jerakine.network.INetworkMessage;
   import com.ankamagames.dofus.network.types.game.data.items.ObjectItem;
   import com.ankamagames.jerakine.network.ICustomDataOutput;
   import flash.utils.ByteArray;
   import com.ankamagames.jerakine.network.CustomDataWrapper;
   import com.ankamagames.jerakine.network.ICustomDataInput;
   import com.ankamagames.jerakine.network.utils.FuncTree;
   
   [Trusted]
   public class StorageInventoryContentMessage extends InventoryContentMessage implements INetworkMessage
   {
      
      public static const protocolId:uint = 5646;
       
      private var _isInitialized:Boolean = false;
      
      public function StorageInventoryContentMessage()
      {
         super();
      }
      
      override public function get isInitialized() : Boolean
      {
         return super.isInitialized && this._isInitialized;
      }
      
      override public function getMessageId() : uint
      {
         return 5646;
      }
      
      public function initStorageInventoryContentMessage(param1:Vector.<ObjectItem> = null, param2:Number = 0) : StorageInventoryContentMessage
      {
         super.initInventoryContentMessage(param1,param2);
         this._isInitialized = true;
         return this;
      }
      
      override public function reset() : void
      {
         super.reset();
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
      
      override public function serialize(param1:ICustomDataOutput) : void
      {
         this.serializeAs_StorageInventoryContentMessage(param1);
      }
      
      public function serializeAs_StorageInventoryContentMessage(param1:ICustomDataOutput) : void
      {
         super.serializeAs_InventoryContentMessage(param1);
      }
      
      override public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_StorageInventoryContentMessage(param1);
      }
      
      public function deserializeAs_StorageInventoryContentMessage(param1:ICustomDataInput) : void
      {
         super.deserialize(param1);
      }
      
      override public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_StorageInventoryContentMessage(param1);
      }
      
      public function deserializeAsyncAs_StorageInventoryContentMessage(param1:FuncTree) : void
      {
         super.deserializeAsync(param1);
      }
   }
}
