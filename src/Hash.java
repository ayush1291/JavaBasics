
public class Hash{

	public int SIZE;
	public Entity[] entity; 
	
	public Hash(int size) {
		entity = new Entity[size];
		SIZE=size;
	}

	public class Entity{
		public String key;
		public String value;
		public Entity next;
		
		public Entity(String key, String value) {
			this.key=key;
			this.value=value;
		}
	}
	
	public void put(String key, String value){
		int customeHashCode = customHashCode(key.hashCode());
		Entity newEntity = new Entity(key,value);
		if(entity[customeHashCode]!=null){
			Entity currentEntity = entity[customeHashCode];
			while(currentEntity.next!=null){
				if(currentEntity.key.equals(newEntity.key)){
					currentEntity.value=newEntity.value;
					break;
				}
				currentEntity.next=currentEntity;
			}
			if(currentEntity.next==null && !(currentEntity.key.equals(newEntity.key))){
				currentEntity=currentEntity.next;
			}
			
		}else{
			entity[customeHashCode]=newEntity;
		}
	}
	
	public int customHashCode(int hashCode){
		
		return hashCode%SIZE;
	}
	
}

