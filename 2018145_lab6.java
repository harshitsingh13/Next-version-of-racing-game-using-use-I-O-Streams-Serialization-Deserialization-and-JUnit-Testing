package off;
import java.util.*;
import java.io.*;
/*abstract result{
	public String positive(String name,int t);
	public String negative(String name,int t,ArrayList<tile> tiles,int i);
	public void pingpong(String name,int t,ArrayList<tile> tiles);
	public void white(String name,int t);
}*/
class checking implements Serializable{
	private final String filename;
	private int t25;
	private int t50;
	private int t75;
	private int no;
	private int alltile;
	private int roll;
	private int tile;
	private int[] arr=new int[alltile];
	private String name;
	private int count1;
	private int count2;
	private int count3;
	private int count4;
	checking(int alltile,int roll,int tile,String name,int count1,int count2,int count3,int count4,int arr[],String filename){
		this.roll=roll;
		this.tile=tile;
		this.name=name;
		this.count1=count1;
		this.count2=count2;
		this.count3=count3;
		this.count4=count4;
		this.arr=arr;
		this.alltile=alltile;
		this.filename=filename;
	}
	public String getfile() {
		return filename;
	}
	public void setno(int no) {
		this.no=no;
	}
	public void setroll(int roll) {
		this.roll=roll;
	}
	public void settile(int tile) {
		this.tile=tile;
	}
	public void setname(String name) {
		this.name=name;
	}
	public void setcount1(int count1) {
		this.count1=count1;
	}
	public void setcount2(int count2) {
		this.count2=count2;
	}
	public void setcount3(int count3) {
		this.count3=count3;
	}
	public void setcount4(int count4) {
		this.count4=count4;
	}
	public void setalltile(int alltile) {
		this.alltile=alltile;
	}
	public void setarr(int arr[]) {
		this.arr=arr;
	}
	public int getroll() {
		return roll;
	}
	public int gettile() {
		return tile;
	}
	public String getname() {
		return name;
	}
	public int getcount2() {
		return count2;
	}
	public int getcount3() {
		return count3;
	}
	public int getcount4() {
		return count4;
	}
	public int getcount1() {
		return count1;
	}
	public int getalltile() {
		return alltile;
	}
	public int[] getarr() {
		return arr;
	}
	public int getno() {
		return no;
	}
	/////////////////////////////////////////////
	public void setc1(int alltile) {
		t25=(int)alltile/4;
	}
	public void setc2(int alltile) {
		t50=(int)alltile/2;
	}
	public void setc3(int alltile) {
		t75=(int)(3*alltile/4);
	}
	public int getc1() {
		return t25;
	}
	public int getc2() {
		return t50;
	}
	public int getc3() {
		return t75;
	}
}
class snakebiteexception extends Exception{
	public snakebiteexception(String message) {
		super(message);
	}
}
class cricketbiteexception extends Exception{
	public cricketbiteexception(String message) {
		super(message);
	}
}
class vulturebiteexception extends Exception{
	public vulturebiteexception(String message) {
		super(message);
	}
}
class trampolineexception extends Exception{
	public trampolineexception(String message) {
		super(message);
	}
}
class gamewinnerexception extends Exception{
	public gamewinnerexception(String message) {
		super(message);
	}
}
class tile implements Serializable{
	private int steps;
	private int no;
	private final int number;
	tile(int number,int no){
		this.no=no;
		this.number=number;
	}
	public void positive(String name,int t) {
		t=1;
		System.out.println(name+" MOVED TO TILE 1 AS IT CAN'T GO BACK FURTHER");	
	}
	public void positive(String name,int t,ArrayList<tile> arr,int i) {
		//t=t-arr.get(i).getsteps();
		System.out.println(name+" MOVED TO TILE-"+t);
	}
	public void setno(int no) {
		Random rand=new Random();
		no=rand.nextInt(no)+1;
		this.no=no;
	}
	public void setsteps(int steps) {
		Random rand=new Random();
		steps=rand.nextInt(10)+1;
		this.steps=steps;
	}
	public int getnumber() {
		return number;
	}
	public int getno() {
		
		return no;
	}
	public int getsteps() {
		
		return steps;
	}
}
class snake extends tile{
	snake(int number,int steps){
		super(number,steps);
	}
}
class vultures extends tile{
	vultures(int number,int steps){
		super(number,steps);
	}
}
class cricket extends tile{
	private int steps;
	cricket(int number,int steps){
		super(number,steps);
	}
}
class trampoline extends tile{
	trampoline(int number,int steps){
		super(number,steps);
	}
}
public class lab6 {
	static tile tl;
	
	public static void main(String[] args) {
		ArrayList<checking> arr1=new ArrayList<checking>();
		Scanner s=new Scanner(System.in);
		Random rand = new Random();
		int q1=0;
		
		int arr[]= {};
		String filename=null;
		String name=null;
		int check=0;
		int t25=0;
		int t50=0;
		int t75=0;
		int v1=1;
		int v2=1;
		int v3=1;
		int count1=0;
		int count2=0;
		int count3=0;
		int count4=0;
		int tile=1;
		int roll=0;
		int cout=0;
		Boolean t1=true;
		Boolean t2=true;
		Boolean result=true;
		int snakebite=0;
		int cricketbite=0;
		int vulturebite=0;
		int trampolines=0;
		int race_track;
		ArrayList<tile> tiles=new ArrayList<tile>();
		ArrayList<tile> tile_str=new ArrayList<tile>();
		while(t1!=false) {
		Boolean done=false;
		result=true;
		System.out.println("1) FOR STARTING NEW GAME");
		System.out.println("2) FOR LOADING LAST GAME");
		int decision=s.nextInt();
		
		
		while(!done) {
		if(decision==1) {
			decision=0;
		System.out.println("ENTER TOTAL NO. OF TILES ON THE RACE TRACK(LENGTH)");
		q1=s.nextInt();
		v1=v2=v3=1;
		arr=new int[q1+1];
		t25=(int)q1/4;
		t50=(int)q1/2;
		t75=(int)(3*(q1/4));
		//arr[]=new int[q1];
		try {
		race_track=rand.nextInt(q1)+1;
		done=true;
		snake snake=new snake(1,race_track);
		tl=new tile(1,race_track);
		tile_str.add(tl);
		tiles.add(snake);
		tiles.get(0).setno(race_track);
		tiles.get(0).setsteps(10);
		done=true;
		cricket cricket= new cricket(2,race_track-tiles.get(0).getno());
		tl=new tile(2,race_track-tiles.get(0).getno());
		tile_str.add(tl);
		tiles.add(cricket);
		tiles.get(1).setno(race_track-tiles.get(0).getno());
		tiles.get(1).setsteps(10);
		done=true;
		vultures vultures=new vultures(3,race_track-tiles.get(0).getno()-tiles.get(1).getno());
		tl=new tile(3,race_track-tiles.get(0).getno()-tiles.get(1).getno());
		tile_str.add(tl);
		tiles.add(vultures);
		tiles.get(2).setno(race_track-tiles.get(0).getno()-tiles.get(1).getno());
		tiles.get(2).setsteps(10);
		done=true;
		trampoline trampoline=new trampoline(4,race_track-tiles.get(0).getno()-tiles.get(1).getno()-tiles.get(2).getno());
		tl=new tile(4,race_track-tiles.get(0).getno()-tiles.get(1).getno()-tiles.get(2).getno());
		tile_str.add(tl);
		tiles.add(trampoline);
		tiles.get(2).setno(race_track-tiles.get(0).getno()-tiles.get(1).getno()-tiles.get(2).getno());
		tiles.get(2).setsteps(10);
		done=true;
		int white_tiles=q1-(tiles.get(0).getno()+tiles.get(1).getno()+tiles.get(2).getno()+tiles.get(3).getno());
		done=true;
		}
		catch(IllegalArgumentException ill){
			System.out.println("INPUT NOT VERIFY");
			System.out.println("TRY AGAIN");
			t1=false;
			break;
		}
		System.out.println("SETTING UP THE RACE TRACK....");
		for(int i=1;i<=q1;i++) {
			int no=rand.nextInt(4)+1;
			if(no==1&&count1<tiles.get(0).getno()) {
				arr[i]=1;
				count1+=1;
			}
			else if(no==2&&count2<tiles.get(1).getno()) {
				arr[i]=2;
				count2+=1;
			}
			else if(no==3&&count3<tiles.get(2).getno()) {
				arr[i]=3;
				count3+=1;
			}
			else if(no==4&&count4<tiles.get(3).getno()) {
				arr[i]=4;
				count4+=1;
			}
			else {
				arr[i]=5;
			}
		}
		System.out.println("DANGER...THERE ARE "+tiles.get(0).getno()+", "+tiles.get(1).getno()+", "+tiles.get(2).getno()+", "+"SNAKES, CRICKET AND VULTURES RESPECTIVELY ON YOU TRACK!");
		System.out.println("DANGER...EACH SNAKE, CRICKET AND VULTURE CAN THROW YOU BACK BY "+tiles.get(0).getsteps()+", "+tiles.get(1).getsteps()+", "+tiles.get(2).getsteps()+", "+"NO. OF TILES RESPECTIVELY!");
		System.out.println("GOOD NEWS...THERE ARE "+tiles.get(3).getno()+" NUMBER OF TRAMPOLINES ON YOUR TRACK!");
		System.out.println("GOOD NEWS...EACH TRAMPOLINES CAN HELP YOU ADVANCED BY "+tiles.get(3).getsteps()+" NUMBER OF TILES");
		System.out.println("ENTER THE PLAYER NAME");
		name=s.next();
		System.out.println("STARTING THE GAME WITH "+name+" AT TILE-1");
		System.out.println("CONTROL TRANSFERRED TO COMPUTER FOR ROLLING THE DICE FOR "+name);
		System.out.println("HIT ENTER TO START THE  GAME");
		
		//System.out.println("GAME STARTED.................");
		
		}
		if(decision==2) {
			v1=v2=v3=1;
			System.out.println("ENTER THE PLAYER NAME");
			String nm=s.next();
			for(int i=0;i<arr1.size();i++) {
				if(arr1.get(i).getname().contentEquals(nm))
					filename=arr1.get(i).getfile();
			}
			 checking object1 = null; 
			  
		        // Deserialization 
		        try
		        {    
		            // Reading the object from a file 
		            FileInputStream file = new FileInputStream(filename); 
		            ObjectInputStream in = new ObjectInputStream(file); 
		              
		            // Method for deserialization of object 
		            object1 = (checking)in.readObject(); 
		              
		            in.close(); 
		            file.close(); 
		            
		            t25=object1.getc1();
		            t50=object1.getc2();
		            t75=object1.getc3();
		            roll=object1.getroll();
		            tile=object1.gettile();
		            arr=object1.getarr();
		            q1=object1.getalltile(); 
		            System.out.println("Object has been deserialized "); 
		           
		        } 
		          
		        catch(IOException ex) 
		        { 
		            System.out.println("IOException is caught"); 
		        } 
		          
		        catch(ClassNotFoundException ex) 
		        { 
		            System.out.println("ClassNotFoundException is caught"); 
		        } 
		        decision=0;
		  
		    } 
		//System.out.println("HIT ENTER TO START THE GAME");	
		
		if(result!=false) {
			System.out.println("GAME STARTED.................");
			t2=true;
			//v1=v2=v3=1;
			while(tile<q1&&t2!=false) {
				int dice=rand.nextInt(6)+1;
				roll+=1;
				if(q1-tile==dice) {
					try {
						throw new gamewinnerexception("EXCEPTION");
					}
					catch(gamewinnerexception e) {
						System.out.println("Caught");
						System.out.println(e.getMessage());
					}
					System.out.println("[ROLL-"+roll+"]: "+name+" ROLLED "+dice+" AT TILE-"+tile);
					System.out.println(name+" WINS THE RACE IN "+roll+" ROLLS");
					System.out.println("TOTAL SNAKEBITES:"+snakebite);
					System.out.println("TOTAL CRICKETBITES:"+cricketbite);
					System.out.println("TOTAL VULTUREBITES:"+vulturebite);
					System.out.println("TOTAL TRAMPOLINES:"+trampolines);
					t2=result=false;
					break;
				}
				else if(dice>q1-tile) {
					System.out.println("[ROLL-"+roll+"]: "+name+" ROLLED "+dice+" AT TILE-"+tile+", ");
				}
				else if(dice==6&&tile==1) {
					System.out.println("[ROLL-"+roll+"]: "+name+" ROLLED "+dice+" AT TILE-"+tile+", "+"YOU ARE OUT OF THE CAGE! YOU GET A FREE ROLL");
					tile=tile+1;
					cout=cout+1;
				}
				else if(dice!=6&&tile==1){
					System.out.println("[ROLL-"+roll+"]: "+name+" ROLLED "+dice+" AT TILE-"+tile+", OOPS YOU NEED 6 TO START");
				}
				else if(tile>1&&tile<q1) {
					if(cout==1) {
						tile=tile-1;
						cout=0;
					}
					if(q1-tile==dice) {
						try {
							throw new gamewinnerexception("EXCEPTION");
						}
						catch(gamewinnerexception e) {
							System.out.println("Caught");
							System.out.println(e.getMessage());
						}
						//System.out.println("[ROLL-"+roll+"]: "+name+" ROLLED "+dice+" AT TILE-"+tile);
						System.out.println(name+" WINS THE RACE IN "+roll+" ROLLS");
						System.out.println("TOTAL SNAKEBITES:"+snakebite);
						System.out.println("TOTAL CRICKETBITES:"+cricketbite);
						System.out.println("TOTAL VULTUREBITES:"+vulturebite);
						System.out.println("TOTAL TRAMPOLINES:"+trampolines);
						t2=result=false;
						break;
					}
					else if(tile<q1) {
						System.out.println("[ROLL-"+roll+"]: "+name+" ROLLED "+dice+" AT TILE-"+tile+", ");
					}
					tile+=dice;
					
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
					/*checking checking=new checking(q1,roll,tile,name,count1,count2,count3,count4,arr);
					String filename = "file.ser";
					// Serialization
					
					
			        try
			        {    
			            //Saving of object in a file 
			            FileOutputStream file = new FileOutputStream(filename); 
			            ObjectOutputStream out = new ObjectOutputStream(file); 
			              
			            // Method for serialization of object 
			            out.writeObject(checking); 
			              
			            out.close(); 
			            file.close(); 
			              
			            System.out.println("Object has been serialized"); 
			  
			        } 
			          
			        catch(IOException ex) 
			        { 
			            System.out.println("IOException is caught"); 
			        } */
					
					
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			        
			        
			        
			        
			        
			        
					
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
					System.out.print(" YOU LANDED ON TILE-"+tile+" ");
					if(tile>t25-1&&v1==1) {
						System.out.println("####CHECKPOINT FIRST####");
						System.out.println("1) CONTINUE");
						System.out.println("2) SAVE");
						int no=s.nextInt();
						v1=0;
						if(no==2) {
							check=1;
							
							System.out.println("ENTER FILENAME");
							String f=s.next();
							filename=f;
							checking checking=new checking(q1,roll,tile,name,count1,count2,count3,count4,arr,f);
							arr1.add(checking);
							// Serialization
							
							
					        try
					        {    
					            //Saving of object in a file 
					            FileOutputStream file = new FileOutputStream(filename); 
					            ObjectOutputStream out = new ObjectOutputStream(file); 
					              
					            // Method for serialization of object 
					            out.writeObject(checking); 
					              
					            out.close(); 
					            file.close(); 
					              
					            System.out.println("Object has been serialized"); 
					            
					        } 
					          
					        catch(IOException ex) 
					        { 
					            System.out.println("IOException is caught"); 
					        } 
					        finally {
								v1=0;
								t2=false;
								break;
							}
						}
					}
					else if(tile>t50-1&&v2==1) {
						System.out.println("####CHECKPOINT SECOND####");
						System.out.println("1) CONTINUE");
						System.out.println("2) SAVE");
						int no=s.nextInt();
						v2=0;
						if(no==2) {
							check=1;
							System.out.println("ENTER FILENAME");
							String f=s.next();
							filename=f;
							checking checking=new checking(q1,roll,tile,name,count1,count2,count3,count4,arr,f);
							arr1.add(checking);
							// Serialization
							
							
					        try
					        {    
					            //Saving of object in a file 
					            FileOutputStream file = new FileOutputStream(filename); 
					            ObjectOutputStream out = new ObjectOutputStream(file); 
					              
					            // Method for serialization of object 
					            out.writeObject(checking); 
					              
					            out.close(); 
					            file.close(); 
					              
					            System.out.println("Object has been serialized");
					           
					  
					        } 
					          
					        catch(IOException ex) 
					        { 
					            System.out.println("IOException is caught"); 
					        } 
							finally {
								v2=0;
								t2=false;
								break;
							}
						
							
						}
						
						//v2=0;
					}
					else if(tile>t75-1&&v3==1) {
						System.out.println("####CHECKPOINT THIRD####");
						System.out.println("1) CONTINUE");
						System.out.println("2) SAVE");
						int no=s.nextInt();
						v3=0;
						if(no==2) {
							check=1;
							
							
							System.out.println("ENTER FILENAME");
							String f=s.next();
							filename=f;
							checking checking=new checking(q1,roll,tile,name,count1,count2,count3,count4,arr,f);
							arr1.add(checking);
							// Serialization
							
							
					        try
					        {    
					            //Saving of object in a file 
					            FileOutputStream file = new FileOutputStream(filename); 
					            ObjectOutputStream out = new ObjectOutputStream(file); 
					              
					            // Method for serialization of object 
					            out.writeObject(checking); 
					              
					            out.close(); 
					            file.close(); 
					              
					            System.out.println("Object has been serialized"); 
					            
					  
					        } 
					          
					        catch(IOException ex) 
					        { 
					            System.out.println("IOException is caught"); 
					        } 
							
					        finally {
								v3=0;
								t2=false;
								break;
							}
						}
					}
					System.out.println(" TRYING TO SHAKE THE TILE-"+tile);
					if(arr[tile]==1) {
						snakebite+=1;
						try {
								throw new snakebiteexception("EXCEPTION");
							}
							catch(snakebiteexception e) {
								System.out.println("Caught");
								System.out.println(e.getMessage());
							}
						System.out.println("HISS....! I AM A SNAKE, YOU GO BACK "+tiles.get(0).getsteps()+" TILE");
						if(tile-tiles.get(0).getsteps()<1) {
							tile=1;
							//System.out.println(name+" MOVED TO TILE 1 AS IT CAN'T GO BACK FURTHER");
							tl.positive(name, tile);
							
							
						}
						else {
							tile=tile-tiles.get(0).getsteps();
							//System.out.println(name+" MOVED TO TILE-"+tile);
							tl.positive(name,tile,tiles,0);
							
						}
					}
					if(arr[tile]==2) {
						cricketbite+=1;
						try {
							throw new cricketbiteexception("EXCEPTION");
						}
						catch(cricketbiteexception e) {
							System.out.println("Caught");
							System.out.println(e.getMessage());
						}
						System.out.println("CHIRP....! I AM A CRICKET, YOU GO BACK "+tiles.get(1).getsteps()+" TILE");
						if(tile-tiles.get(1).getsteps()<1) {
							tile=1;
							//System.out.println(name+" MOVED TO TILE 1 AS IT CAN'T GO BACK FURTHER");
							tl.positive(name, tile);
						}
						else {
							tile=tile-tiles.get(1).getsteps();
							/*System.out.println(name+" MOVED TO TILE-"+tile);*/
							tl.positive(name,tile,tiles,1);
						}
					}
					if(arr[tile]==3) {
						vulturebite+=1;
						try {
							throw new vulturebiteexception("EXCEPTION");
						}
						catch(vulturebiteexception e) {
							System.out.println("Caught");
							System.out.println(e.getMessage());
						}
						System.out.println("YAPPING....! I AM A VULTURE, YOU GO BACK "+tiles.get(2).getsteps()+" TILE");
						if(tile-tiles.get(2).getsteps()<1) {
							tile=1;
							//System.out.println(name+" MOVED TO TILE 1 AS IT CAN'T GO BACK FURTHER");
							tl.positive(name, tile);
							
						}
						else {
							tile=tile-tiles.get(2).getsteps();
							//System.out.println(name+" MOVED TO TILE-"+tile);
							tl.positive(name,tile,tiles,2);
						}
					}
					if(arr[tile]==4) {
						trampolines+=1;
						try {
							throw new trampolineexception("EXCEPTION");
						}
						catch(trampolineexception e) {
							System.out.println("Caught");
							System.out.println(e.getMessage());
						}
						System.out.println("PINGPONG....! I AM A TRAMPOLINE, YOU ADVANCED "+tiles.get(3).getsteps()+" TILE");
							tile=tile+tiles.get(3).getsteps();
							System.out.println(name+" MOVED TO TILE-"+tile);
					}
					if(arr[tile]==5) {
						System.out.println("I AM A WHITE TILE ");
						System.out.println(name+" MOVED TO TILE-"+tile);
					}
				}
				
			}
		}
		}
		}
	}
	
}