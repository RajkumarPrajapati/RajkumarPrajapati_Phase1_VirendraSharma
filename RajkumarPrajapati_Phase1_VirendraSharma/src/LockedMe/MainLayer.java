package LockedMe;
import java.io.File;
import java.util.Scanner;
public class MainLayer {
 
	 char choice, option;
	 Scanner sc = new Scanner(System.in);
	 String path = "files";
	 File folder = new File(path);
	
   void showApp() {
	   
	   while(true) {
		   
		   showOption();
		   
		 switch(choice) {
		 
		 case '1':{
			 displayFiles();
			 showOption();
			 break;
		 }
		 
		 case '2':{
			 fileOperation();
			 showOption();
			 break;
		 }
		 
		 case '3':{
			 System.out.println("Closing");
			 System.exit(0);
			 break;
		 }
		 
		 default :{
			 System.out.println(".......... Kindly Select Valid Option ..........\n\n");
			 showOption();
		 }
		  
		 
		 }
		        
	   }
   }
	   
	
   
   
   void showOption(){
		   
		   System.out.println("........ Select One From Below Options ........");
		   System.out.println("1.Display Files in Accending Order");
		   System.out.println("2.Make File Operation");
		   System.out.println("3.Close Application");
		   
		   System.out.println("............... Enter Your Option ..............");
		  System.out.print(">> "); choice = sc.next().charAt(0);
		  
		 
	   }
   
  //To Display All Files in Current Directory  
   void displayFiles() {
	   System.out.println("Display all files in current directory");
	   
	   try {
	   File[] filelist = folder.listFiles();
	   
	   if(filelist==null) {
		   System.out.println("No any file available in Current dir");
	   }
	   
	   else {
	   for(int i = 0;i<filelist.length;i++) {
		   if(filelist[i].isFile()) {
			   System.out.println(filelist[i].getName());
		   }
	   }
	   }
	   }catch(Exception e) {
		   System.out.println(e);
	   }
	   
   }
   
  void fileOperation(){
	   System.out.println("Running file operation");
	   operation();
	   
   }
  
  void appClose() {
	  System.out.println("close application");
  }
  
  
  void operation() {
	  
	  while(true) {
		  option();
		  
		  switch(option){
		  
		  case 'a':{
			  
			  addFile();
			  option();
			  break;
		  }
		  
		  case 'b':{
			  deleteFile();
			  option();
			  break;
		  }
		  
		  case 'c':{
			  
			  searchFile();
			  option();
			  break;
		  }
		  
		  case 'd':{
			  
			  System.out.println("''''''''''''' Welcome To Main Menu ''''''''''''\n");
			  showOption();
		  }
		  
		  default :{
			  System.out.println(".......... Kindly Select Valid Option .........\n");
			  option();
		  }
			  
		  }
		 }
	  
  }
  
  void option() {
	  System.out.println(".......... Select One From Below Operation ..........");
	   System.out.println("a.To Add a new file");
	   System.out.println("b.To Delete a file");
	   System.out.println("c.To Search file");
	   System.out.println("d.Go to Main Menu");
	   
	   System.out.println(".......... Enter Your Option ..........");
	   System.out.print(">>"); option = sc.next().charAt(0);
  }
  
  
  //To Add New File in Current Directory 
  void addFile() {
	  System.out.println("Enter File Name to Add file\n");
	  String filename = sc.next();
	  File addfile = new File(path+"/"+filename);
	  
	  try {
		 if(addfile.createNewFile())
			 System.out.println(" File "+filename+ " Created in "+path+" Directory");
		 else if(addfile.exists())
			 System.out.println(filename + "Already exist ");
		 else
			 System.out.println("File not  Add");
		 
	  }
	  catch(Exception e){
		  System.out.println(e);
	  }
	  
	  
  }
  
  //To Delete file form Current Directory
  void deleteFile() {
	  System.out.println("Enter file name to Delete\n");
	  String filename = sc.next();
	  File file = new File(path+"/"+filename);
	  if(file.delete())
		  System.out.println(file.getName()+" File has been deleted successfully");
	  else
		  System.out.println("Failed to delete file");
  }
  
  //To Search file with file name
  void searchFile() {
	 System.out.println("Enter File Name to Search\n"); 
	 String filename = sc.next();
	 File searchfile = new File(path+"/"+filename);
	 if(searchfile.exists())
		 System.out.println("File Found : "+filename);
	 else
		 System.out.println("File not found");
		 
	 
  }


}