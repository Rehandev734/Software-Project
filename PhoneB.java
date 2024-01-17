package PhoneBook;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;
import java.util.Vector;


class MainMenu implements ActionListener{
	private JFrame f;
	private Label phlabel;
	private Label phlabel2;
	private Button insrtCnt;
	private Button viewCnt;
	private Button editCnt;
	private Button delCnt;
	private TextField[] l= {new TextField(null), new TextField(null)};
	 private File myFile;
;
	 private File f2;



	public MainMenu() {
		myFile=new File("Contacts.txt");
		f2=new File("Contacts1.txt");
		
	}
	
	//--------------------------Main Menu -------------------------------

	public void menu() {
		
		System.out.println("File myFile has: "+myFile.getName()+" ok\n");


		 f=new JFrame("Main Menu");
		 phlabel=new Label("PHONE BOOK");
		 phlabel2=new Label("-----------------------------------------------");
		 insrtCnt=new Button("Insert Contact");
		 viewCnt=new Button("View Contacts");
		 editCnt=new Button("Edit Contact");
		 delCnt=new Button("Delete Contact");
		
		phlabel.setBounds(250, 10, 180, 40);
		phlabel2.setBounds(200, 30, 180, 40);
		insrtCnt.setBounds(200, 100, 160, 20);
		viewCnt.setBounds(200, 140, 160, 20);
		editCnt.setBounds(200, 180, 160, 20);
		delCnt.setBounds(200, 220, 160, 20);
		
		insrtCnt.addActionListener(this);
		viewCnt.addActionListener(this);
		editCnt.addActionListener(this);
		delCnt.addActionListener(this);
		
		f.add(phlabel);
		f.add(phlabel2);
		f.add(insrtCnt);
		f.add(viewCnt);
		f.add(editCnt);
		f.add(delCnt);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setSize(700, 800);
		f.setLayout(null);
		f.setVisible(true);
		
	}
	
	//--------------------------action performed function Main Menu -------------------------------
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==insrtCnt) {
			addContact();
			
		}
		else if(e.getSource()==viewCnt) {
			viewContacts();
		}
		else if(e.getSource()==editCnt) {
			editContact();
		}
		else if(e.getSource()==delCnt) {
			deleteContact();
		}
	}
	
	
	//--------------------------add Contact interface -------------------------------
	
	public void addContact() {
		JFrame a=new JFrame("Insert New Contact");
		Label phlabel=new Label("PHONE BOOK");
		Label phlabel2=new Label("-----------------------------------------------");
		Label insrtCnt=new Label("Insert Contact");
		Label cntName=new Label("Name");
		Label cntPhone=new Label("Phone");
		TextField nameField=new TextField();
		TextField phoneField=new TextField();
		Button addCnt=new Button("Add to Contacts");
		Button menu=new Button("Main Menu");
		//Button delCnt=new Button("Delete Contact");
		
		phlabel.setBounds(250, 10, 180, 40);
		phlabel2.setBounds(200, 30, 180, 40);
		insrtCnt.setBounds(200, 80, 160, 40);
		cntName.setBounds(200, 140, 60, 20);
		cntPhone.setBounds(200, 180, 60, 20);
		nameField.setBounds(265, 140, 200, 25);
		phoneField.setBounds(265, 180, 200, 25);
		addCnt.setBounds(200, 230, 160, 20);
		menu.setBounds(200, 270, 160, 20);

		
		//insrtCnt.addActionListener(this);
		addCnt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	try {
            	if(e.getSource()==addCnt) {
            		String nam=nameField.getText();
            		String ph=phoneField.getText();
            		
            		if(nameField.getText().isEmpty()||phoneField.getText().isEmpty()) {
            			JOptionPane.showMessageDialog(a, "Please Enter Data in the Field !");
            		}else {
            			//createFile();
            			addToFile(nam, ph);
            		
            		JOptionPane.showMessageDialog(a, "Contact Added Successfully !");
            		nameField.setText(null);
            		phoneField.setText(null);
            		}
            		
            	}
            	}catch(Exception x) {
            		JOptionPane.showMessageDialog(a, x);
            	}
            	
               	}
            });
		menu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(e.getSource()==menu) {
            		menu();
            	}
               	}
            });
		//delCnt.addActionListener(this);
		
		a.add(phlabel);
		a.add(phlabel2);
		a.add(insrtCnt);
		a.add(cntName);
		a.add(cntPhone);
		a.add(nameField);
		a.add(phoneField);
		a.add(addCnt);
		a.add(menu);
		a.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		a.setSize(700, 800);
		a.setLayout(null);
		a.setVisible(true);
	}
	
	
	//--------------------------View all Contacts interface -------------------------------
	
	public void viewContacts() {
		JFrame v=new JFrame("View All Contacts");
		Label phlabel=new Label("PHONE BOOK");
		Label phlabel2=new Label("-----------------------------------------------");
		Label viewCnt=new Label("All Contacts");
		Label cntName=new Label("Name");
		Label cntPhone=new Label("Phone");
		//TextField searchField=new TextField();
		//TextField phoneField=new TextField();
		//Button searchCnt=new Button("Search by Name");
		Button menu=new Button("Main Menu");
		//Button delCnt=new Button("Delete Contact");
		

		
		phlabel.setBounds(250, 10, 180, 40);
		phlabel2.setBounds(200, 30, 180, 40);
		viewCnt.setBounds(200, 120, 160, 40);
		cntName.setBounds(200, 160, 60, 20);
		cntPhone.setBounds(300, 160, 60, 20);
		//----searchField.setBounds(200, 140, 200, 25);
		//phoneField.setBounds(265, 180, 200, 25);
		//----searchCnt.setBounds(410, 140, 120, 20);
		menu.setBounds(200, 80, 160, 20);


		menu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(e.getSource()==menu) {
            		menu();
            	}
               	}
            });
		//delCnt.addActionListener(this);
		
		v.add(phlabel);
		v.add(phlabel2);
		v.add(viewCnt);
		v.add(cntName);
		v.add(cntPhone);
		//v.add(searchField);
		//v.add(searchCnt);
		v.add(menu);
		v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		v.setSize(700, 800);
		v.setLayout(null);
		v.setVisible(true);
		readFromFile(v);

	}
	
	
	//--------------------------edit Contact interface -------------------------------
	
	public void editContact() {
		JFrame ed=new JFrame("Edit Existing Contact");
		Label phlabel=new Label("PHONE BOOK");
		Label phlabel2=new Label("-----------------------------------------------");
		Label editCnt=new Label("Edit Contact");
		Label cntName=new Label("Name");
		Label cntPhone=new Label("Phone");
		TextField searchField=new TextField();
		Button searchCnt=new Button("Search by Name");
		
		Label oldPhone=new Label("Old Phone");
		TextField phoneField=new TextField();
		Label newName=new Label("New Name");
		Label newPhone=new Label("New Phone");
		TextField newNameField=new TextField();
		TextField newPhField=new TextField();
		Button changeCnt=new Button("Update Contact");
		Button menu=new Button("Main Menu");
		//Button delCnt=new Button("Delete Contact");
		
		phlabel.setBounds(250, 10, 180, 40);
		phlabel2.setBounds(200, 30, 180, 40);
		editCnt.setBounds(200, 70, 160, 40);
		cntName.setBounds(200, 330, 60, 20);
		cntPhone.setBounds(300, 330, 60, 20);
		searchField.setBounds(200, 110, 200, 25);
		//phoneField.setBounds(265, 180, 200, 25);
		searchCnt.setBounds(410, 110, 120, 20);
		
		oldPhone.setBounds(200, 160, 120, 20);
		phoneField.setBounds(320, 160, 200, 25);
		newName.setBounds(200, 200, 100, 20);
		newPhone.setBounds(200, 240, 100, 20);
		newNameField.setBounds(320, 200, 200, 25);
		newPhField.setBounds(320, 240, 200, 25);
		changeCnt.setBounds(200, 280, 100, 20);

		menu.setBounds(350, 280, 100, 20);

		
		//insrtCnt.addActionListener(this);
		searchCnt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(e.getSource()==searchCnt) {
            		String nam=searchField.getText();
            		if(searchField.getText().isEmpty()) {
            			JOptionPane.showMessageDialog(ed, "Please Enter Data in the Field !");
            		}else {
            			searchFromFile(nam, ed);
            		
            		}
            		searchField.setText(null);
            	}
               	}
            });
		changeCnt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(e.getSource()==changeCnt) {
            		String oPh=phoneField.getText();
            		String nNam=newNameField.getText();
            		String nPh=newPhField.getText();
            		
            		if(phoneField.getText().isEmpty()||newPhField.getText().isEmpty()||newNameField.getText().isEmpty()) {
            			JOptionPane.showMessageDialog(ed, "Please Enter Data in the Field !");
            		}else {
            			
            			editInFile(oPh,nNam,nPh,ed);
            		
            		JOptionPane.showMessageDialog(ed, "Contact Updated Successfully !");
            		phoneField.setText(null);
            		newNameField.setText(null);
            		newPhField.setText(null);
            		}
            		
            		
            		
            	}
               	}
            });
		menu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(e.getSource()==menu) {
            		menu();
            	}
               	}
            });
		//delCnt.addActionListener(this);
		
		ed.add(phlabel);
		ed.add(phlabel2);
		ed.add(editCnt);
		ed.add(cntName);
		ed.add(cntPhone);
		ed.add(searchField);
		//v.add(phoneField);
		ed.add(searchCnt);
		ed.add(oldPhone);
		ed.add(phoneField);
		ed.add(newName);
		ed.add(newPhone);
		ed.add(newNameField);
		ed.add(newPhField);
		ed.add(changeCnt);
		ed.add(menu);
		ed.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		ed.setSize(700, 800);
		ed.setLayout(null);
		ed.setVisible(true);
	}
	
	
	//--------------------------delete Contact interface -------------------------------
	
	public void deleteContact() {
		JFrame del=new JFrame("Delete Existing Contact");
		Label phlabel=new Label("PHONE BOOK");
		Label phlabel2=new Label("-----------------------------------------------");
		Label editCnt=new Label("Delete Contact");
		Label cntName=new Label("Name");
		Label cntPhone=new Label("Phone");
		TextField searchField=new TextField();
		Button searchCnt=new Button("Search by Name");
		
		Label delPhone=new Label("Enter Phone");
		TextField phoneField=new TextField();
		
		Button deleteCnt=new Button("Delete Contact");
		Button menu=new Button("Main Menu");
		//Button delCnt=new Button("Delete Contact");
		
		phlabel.setBounds(250, 10, 180, 40);
		phlabel2.setBounds(200, 30, 180, 40);
		editCnt.setBounds(200, 80, 160, 40);
		cntName.setBounds(200, 320, 60, 20);
		cntPhone.setBounds(300, 320, 60, 20);
		searchField.setBounds(200, 140, 200, 25);
		//phoneField.setBounds(265, 180, 200, 25);
		searchCnt.setBounds(410, 140, 120, 20);
		
		delPhone.setBounds(200, 180, 120, 20);
		phoneField.setBounds(410, 180, 200, 25);
		deleteCnt.setBounds(200, 240, 100, 20);

		menu.setBounds(200, 280, 160, 20);

		
		//insrtCnt.addActionListener(this);
		searchCnt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(e.getSource()==searchCnt) {
            		String nam=searchField.getText();
            		
            		if(searchField.getText().isEmpty()) {
            			JOptionPane.showMessageDialog(del, "Please Enter Data in the Field !");
            		}else {
            			searchFromFile(nam, del);
            		
            	/*	Label l=new Label("Contact Details !");
            		l.setBounds(200, 450, 250, 25);
            		del.add(l);*/
            		}
            		
            		searchField.setText(null);

            	}
               	}
            });
		deleteCnt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(e.getSource()==deleteCnt) {
            		String ph=phoneField.getText();
            		
            		if(phoneField.getText().isEmpty()) {
            			JOptionPane.showMessageDialog(del, "Please Enter Data in the Field !");
            		}else {
            			deleteInFile(ph,del);
            			/*if(myFile.delete()) {
            				System.out.println("File Deleted "+myFile.getName());
            			}
            			f2.renameTo(myFile);*/
            			
            			JOptionPane.showMessageDialog(del, "Contact Deleted Successfully !");
            			//myFile=f2;
            			System.out.println("File myFile has: "+myFile.getName()+" ok\n");

            		phoneField.setText(null);
            		}
            		
            	}
               	}
            });
		menu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(e.getSource()==menu) {
            		menu();
            	}
               	}
            });
		//delCnt.addActionListener(this);
		
		del.add(phlabel);
		del.add(phlabel2);
		del.add(editCnt);
		del.add(cntName);
		del.add(cntPhone);
		del.add(searchField);
		//v.add(phoneField);
		del.add(searchCnt);
		del.add(delPhone);
		del.add(phoneField);
		del.add(deleteCnt);
		del.add(menu);
		del.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		del.setSize(700, 800);
		del.setLayout(null);
		del.setVisible(true);
	}

	
	//--------------------------Creating a New File Function-------------------------------

	public void createFile() {
		// myFile=new File("Contacts.txt");
		try {

			myFile.createNewFile();
			}catch(IOException ie){
				ie.printStackTrace();
			}
		}
		
	
	//--------------------------Adding Data to a File Function-------------------------------

	public void addToFile(String n, String p) {
			try {
				
				BufferedWriter addFile=new BufferedWriter(new FileWriter(myFile, true));

				addFile.write(n+","+p+"\n");
				addFile.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	   
	//--------------------------Fetching Data From a File Function-------------------------------

	      public void readFromFile(JFrame temp) {
	    	  try {
		    	  BufferedReader read=new BufferedReader(new FileReader(myFile));
		    	  
				Object[] fulLine=read.lines().toArray();
				int y=200;

				for(int i=0;i<fulLine.length;i++) {
					String row=fulLine[i].toString().trim();
					String[] lin=row.split(",");
					Label[] la= {new Label(lin[0]), new Label(lin[1])};
					
            		la[0].setBounds(200, y, 80, 25);
            		la[1].setBounds(300, y, 250, 25);
            		

            		temp.add(la[0]);
            		temp.add(la[1]);
            		y=y+40;
            		
            		
				//	System.out.println(lin);	
					
				}
				
				try {
					read.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				//myFile.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	  
	    	  
	      }
	     
	      
	  	//--------------------------Searching Data From a File Function-------------------------------

	      public void searchFromFile(String srch, JFrame temp) {
	    	  try {
		    	  BufferedReader read=new BufferedReader(new FileReader(myFile));
		    	  
		    	  for(int i=0;i<l.length;i++) {
		    			  l[i].setEditable(false);
		    	  l[i].setText("");
		    	  }

				
				Object[] fulLine=read.lines().toArray();
				int y=360;
				for(int i=0;i<fulLine.length;i++) {
					String dt=fulLine[i].toString().trim();
					String lin[]=dt.split(",");
					
					if(lin[0].equals(srch)) {
						for(int no=0;no<l.length;no++) {
						l[no].setText(lin[no]);
												
	            		l[0].setBounds(200, y, 80, 25);
	            		l[1].setBounds(300, y, 150, 25);
	            		
	            		temp.add(l[no]);
						}
	            		y=y+40;
						
						//System.out.println("Nam: "+nam+" Phone: "+phn);	
					}
					
				}
        		try {
					read.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JOptionPane.showMessageDialog(temp, e);
			}	    	  	  
	      }
	      
	      
	      	      
		  	//--------------------------Deleting Data From a File Function-------------------------------

	      public void deleteInFile(String p, JFrame temp) {

	    	  try {
	    		 

		    	  BufferedReader read=new BufferedReader(new FileReader(myFile));
		    	  BufferedWriter write=new BufferedWriter(new FileWriter(f2, true));

		    	  for(int i=0;i<l.length;i++) {
		    			  l[i].setEditable(false);
		    	  l[i].setText("");
		    	  }

				
				Object[] fulLine=read.lines().toArray();
				for(int i=0;i<fulLine.length;i++) {
					String dt=fulLine[i].toString().trim();
					String lin[]=dt.split(",");
					
					if(lin[1].equals(p)) {
			
					}
					else {
						write.write(lin[0]+","+lin[1]+"\n");
					}
				}
				
				

				read.close();
		    	  write.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	    	 // myFile=f2;
	    	  
	    	  try {
					myFile.delete();
				f2.createNewFile();
				File tempFile=new File("Contacts.txt");
				f2.renameTo(tempFile);
				f2.delete();				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      
	      }

	      
		  	//--------------------------Update Data In a File Function-------------------------------

	      public void editInFile(String op,String nn,String np, JFrame temp) {

		    	  try {
		    		 

			    	  BufferedReader read=new BufferedReader(new FileReader(myFile));
			    	  BufferedWriter write=new BufferedWriter(new FileWriter(f2, true));

			    	  for(int i=0;i<l.length;i++) {
			    			  l[i].setEditable(false);
			    	  l[i].setText("");
			    	  }

					
					Object[] fulLine=read.lines().toArray();
					for(int i=0;i<fulLine.length;i++) {
						String dt=fulLine[i].toString().trim();
						String lin[]=dt.split(",");
						
						if(lin[1].equals(op)) {
							write.write(nn+","+np+"\n");

							//System.out.println("Nam: "+nam+" Phone: "+phn);	
						}
						else {
							write.write(lin[0]+","+lin[1]+"\n");
						}
					}
					
					

					read.close();
			    	  write.close();

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
		    	 // myFile=f2;
		    	  
		    	  try {
						myFile.delete();
					f2.createNewFile();
					File tempFile=new File("Contacts.txt");
					f2.renameTo(tempFile);
					f2.delete();				
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		      
		      }
	      

	      
	      
		
		
	}





	//--------------------------Main Class-------------------------------


public class PhoneB {
	
	
    public PhoneB() {
    	MainMenu m=new MainMenu();    	
    	m.createFile();
    	m.menu();
    }


    public static void main(String[] args) {
        new PhoneB();
           
    }

	
}
