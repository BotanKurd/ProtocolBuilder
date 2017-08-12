package data.messages.game.guild
{
   import com.ankamagames.jerakine.network.NetworkMessage;
   import com.ankamagames.jerakine.network.INetworkMessage;
   import com.ankamagames.dofus.network.types.game.paddock.PaddockContentInformations;
   import com.ankamagames.jerakine.network.ICustomDataOutput;
   import flash.utils.ByteArray;
   import com.ankamagames.jerakine.network.CustomDataWrapper;
   import com.ankamagames.jerakine.network.ICustomDataInput;
   import com.ankamagames.jerakine.network.utils.FuncTree;
   
   [Trusted]
   public class GuildInformationsPaddocksMessage extends NetworkMessage implements INetworkMessage
   {
      
      public static const protocolId:uint = 5959;
       
      private var _isInitialized:Boolean = false;
      
      public var nbPaddockMax:uint = 0;
      
      public var paddocksInformations:Vector.<PaddockContentInformations>;
      
      private var _paddocksInformationstree:FuncTree;
      
      public function GuildInformationsPaddocksMessage()
      {
         this.paddocksInformations = new Vector.<PaddockContentInformations>();
         super();
      }
      
      override public function get isInitialized() : Boolean
      {
         return this._isInitialized;
      }
      
      override public function getMessageId() : uint
      {
         return 5959;
      }
      
      public function initGuildInformationsPaddocksMessage(param1:uint = 0, param2:Vector.<PaddockContentInformations> = null) : GuildInformationsPaddocksMessage
      {
         this.nbPaddockMax = param1;
         this.paddocksInformations = param2;
         this._isInitialized = true;
         return this;
      }
      
      override public function reset() : void
      {
         this.nbPaddockMax = 0;
         this.paddocksInformations = new Vector.<PaddockContentInformations>();
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
         this.serializeAs_GuildInformationsPaddocksMessage(param1);
      }
      
      public function serializeAs_GuildInformationsPaddocksMessage(param1:ICustomDataOutput) : void
      {
         if(this.nbPaddockMax < 0)
         {
            throw new Error("Forbidden value (" + this.nbPaddockMax + ") on element nbPaddockMax.");
         }
         param1.writeByte(this.nbPaddockMax);
         param1.writeShort(this.paddocksInformations.length);
         var _loc2_:uint = 0;
         while(_loc2_ < this.paddocksInformations.length)
         {
            (this.paddocksInformations[_loc2_] as PaddockContentInformations).serializeAs_PaddockContentInformations(param1);
            _loc2_++;
         }
      }
      
      public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_GuildInformationsPaddocksMessage(param1);
      }
      
      public function deserializeAs_GuildInformationsPaddocksMessage(param1:ICustomDataInput) : void
      {
         var _loc4_:PaddockContentInformations = null;
         this._nbPaddockMaxFunc(param1);
         var _loc2_:uint = param1.readUnsignedShort();
         var _loc3_:uint = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new PaddockContentInformations();
            _loc4_.deserialize(param1);
            this.paddocksInformations.push(_loc4_);
            _loc3_++;
         }
      }
      
      public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_GuildInformationsPaddocksMessage(param1);
      }
      
      public function deserializeAsyncAs_GuildInformationsPaddocksMessage(param1:FuncTree) : void
      {
         param1.addChild(this._nbPaddockMaxFunc);
         this._paddocksInformationstree = param1.addChild(this._paddocksInformationstreeFunc);
      }
      
      private function _nbPaddockMaxFunc(param1:ICustomDataInput) : void
      {
         this.nbPaddockMax = param1.readByte();
         if(this.nbPaddockMax < 0)
         {
            throw new Error("Forbidden value (" + this.nbPaddockMax + ") on element of GuildInformationsPaddocksMessage.nbPaddockMax.");
         }
      }
      
      private function _paddocksInformationstreeFunc(param1:ICustomDataInput) : void
      {
         var _loc2_:uint = param1.readUnsignedShort();
         var _loc3_:uint = 0;
         while(_loc3_ < _loc2_)
         {
            this._paddocksInformationstree.addChild(this._paddocksInformationsFunc);
            _loc3_++;
         }
      }
      
      private function _paddocksInformationsFunc(param1:ICustomDataInput) : void
      {
         var _loc2_:PaddockContentInformations = new PaddockContentInformations();
         _loc2_.deserialize(param1);
         this.paddocksInformations.push(_loc2_);
      }
   }
}
