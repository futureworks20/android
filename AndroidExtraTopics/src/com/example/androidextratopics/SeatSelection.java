package com.example.androidextratopics;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.GridView;

public class SeatSelection extends Activity{
	GridView gridView;
	int rowno;
	Spinner spinner ;
	String[] arr= new String[5];
	CustomAdapter adapter;
	int l2,l22,l23;
	boolean status = false;
	ArrayList<String> arrayList = new ArrayList<String>();
	ArrayList<String> arrayList_db = new ArrayList<String>();
	Button button;
	Databasee databasee;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.seatgridview);
		 gridView = (GridView)findViewById(R.id.grid);
		 spinner = (Spinner)findViewById(R.id.spinner);
		 button = (Button)findViewById(R.id.button1);
		 databasee = new Databasee(SeatSelection.this);
		 List<Variables> list = databasee.getAllContacts();
		 for(int i=0 ; i<list.size();i++)
		 {
			 Variables variables = list.get(i);
			 System.out.println(variables.getName());
			 arrayList_db.add(variables.getName());
		 }
		 System.out.println(arrayList_db);
		 button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				System.out.println(arrayList);
				for(int i=0 ; i<arrayList.size();i++)
				{
				databasee.addContact( new Variables(1, arrayList.get(i)));
				
				}
			}
		});
		 
		 for(int i=0;i<5;i++)
		 {
			 arr[i]=String.valueOf(i+1);
			 
		 }
		 spinner.setAdapter(new ArrayAdapter<String>(getApplicationContext(), R.layout.spinner_text,R.id.text,arr));
		 adapter = new CustomAdapter();
		 spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				String value = arr[arg2];
				Log.e("Spinner", "DONE");
				if(value.equals("1"))
				{
					
					
					l2 = 1;
					l22=1;
					l23 = 1;
				}
				else	if(value.equals("2"))
				{
					
					l2 = 2;
					l22 = 2;
					l23 = 2;
				}
				else if(value.equals("3"))
				{
					
					l2 = 3;
					l22 = 3;
					l23 = 3;
				}
				else if(value.equals("4"))
				{
					
					l2 = 4;
					l22 = 4;
					l23 = 4;
				}
				else if(value.equals("5"))
				{
					
					l2 = 5;
					l22 = 5;
					l23 = 5;
				}
				
				adapter.notifyDataSetChanged();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		gridView.setAdapter(adapter);
	}
class CustomAdapter extends BaseAdapter
{
	int loopstarts,loopend;
	int a;
	public CustomAdapter()
	{
		
	}
	public CustomAdapter(int loopstarts, int loopend)
	{
		this.loopstarts = loopstarts;
		this.loopend = loopend;
		Log.e("TAg", "adapter"+loopend);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 50;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
		 View rowview = inflater.inflate(R.layout.seat_chk, null);
		//final CheckBox checkBox = (CheckBox)rowview.findViewById(R.id.checkBox1);
		 CheckBox checkBox = new CheckBox(SeatSelection.this);
		//checkBox.setChecked(false);
		
		checkBox.setTag(position);
		
		checkBox.setId(position);
		
		checkBox.setClickable(false);
		//gridView.addView(checkBox);
		 if(arrayList_db.size() > 0)
		 {
		for(int i =0; i<arrayList_db.size();i++)
		{
			int idd = Integer.parseInt(arrayList_db.get(i));
			CheckBox c = (CheckBox) gridView.findViewById(idd);
            c.setChecked(true); 
		}
		 }
		rowview.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				a = position;
				if(l2<=0)
				{
					adapter.notifyDataSetChanged();
					
					arrayList.clear();
					l2 = l23;   
					l22 = l2;
					Log.e("TAG STATUS  ??????????????????? " ,status+"   >>>  "+a);
				}
				
				if(position ==0 || position ==1 || position ==2 || position ==3 || position ==4 )
				{
					rowno = 1;
					
				}
				else if(position ==5 || position ==6 || position ==7 || position ==8 || position ==9 )
				{
					rowno = 2;
				}
				else if(position ==10 || position ==11 || position ==12 || position ==13 || position ==14 )
				{
					rowno = 3;
				}
				else if(position ==15 || position ==16 || position ==17 || position ==18 || position ==19 )
				{
					rowno = 4;
				}
				else if(position ==20 || position ==21 || position ==22 || position ==23 || position ==24 )
				{
					rowno = 5;
				}
				
				else if(position ==25 || position ==26 || position ==27 || position ==28 || position ==29 )		
				{
					rowno = 6;
				}
				else if(position ==30 || position ==31 || position ==32 || position ==33 || position ==34 )
				{
					
					rowno = 7;
				}
				else if(position ==35 || position ==36 || position ==37 || position ==38 || position ==39 )
				{
					rowno = 8;
				}
				else if(position ==40 || position ==41 || position ==42 || position ==43 || position ==44 )
				{
					rowno = 9;
				}
				else if(position ==45 || position ==46 || position ==47 || position ==48 || position ==49 )
				{
					rowno = 10;
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				if(rowno == 1)
				{
					
					for(int i=a;i<a+l2;i++)
					{
						if(i < 5)
						{
						CheckBox c = (CheckBox) findViewById(i);
						
			              c.setChecked(true);  
			              arrayList.add(c.getId()+"");
			              l22 = l22-1;
			              Log.e("TAG AFTER SELCTION NEED ", l22+"  More check boxes to check"+" >>>>>>   "+c.getId());
			              if(l22 > 0)
			              {
			              status = true;
			              }
			              else
			              {
			            	  status = false;
			              }
						}

					}
					if(!status)
					{
						Log.e("@@@@@@@@@@@@@@", "########");
					for(int i=a+l2;i<40;i++)
					{
						CheckBox c = (CheckBox) gridView.findViewById(i);
			              c.setChecked(false);  
						
					}
					}
					l2 = l22; 
				}
				else	if(rowno == 2)
				{
					for(int i=position;i<position+l2;i++)
					{
						Log.e("TAG_FFFF", i+"");
						if(i >4 && i<10)
						{
							
						CheckBox c = (CheckBox) gridView.findViewById(i);
			              c.setChecked(true); 
			              arrayList.add(c.getId()+"");
			              l22 = l22-1;
			              Log.e("TAG AFTER SELCTION NEED ", l22+"  More check boxes to check");
			              if(l22 > 0)
			              {
			              status = true;
			              }
			              
						}
						else
						{
							CheckBox c = (CheckBox) gridView.findViewById(i);
				              c.setChecked(false); 	
						} 
						
					}
				
					
					if(!status)
					{
						for(int i=0;i<5;i++)
						{
							CheckBox c = (CheckBox) gridView.findViewById(i);
				              c.setChecked(false);  
							
						}
					for(int i=position+l2;i<50;i++)
					{
						CheckBox c = (CheckBox) gridView.findViewById(i);
			              c.setChecked(false);  
						
					}
					}
					l2 = l22; 
				}
				
				else	if(rowno == 3)
				{
					for(int i=position;i<position+l2;i++)
					{
						
						
						if(i>9 && i<15)
						{
						CheckBox c = (CheckBox) gridView.findViewById(i);
			              c.setChecked(true);  
			              arrayList.add(c.getId()+"");
			              l22 = l22-1;
			              Log.e("TAG AFTER SELCTION NEED ", l22+"  More check boxes to check");
			              if(l22 > 0)
			              {
			              status = true;
			              }
//			              else
//			              {
//			            	  status = false;
//			              }
						}
						
							else
							{
								CheckBox c = (CheckBox) gridView.findViewById(i);
					              c.setChecked(false); 	
							} 
						
					}
					
					if(!status)
					{
						for(int i=0;i<10;i++)
						{
							CheckBox c = (CheckBox) gridView.findViewById(i);
				              c.setChecked(false);  
							
						}
					for(int i=position+l2;i<50;i++)
					{
						CheckBox c = (CheckBox) gridView.findViewById(i);
			              c.setChecked(false);  
						
					}
					}
					l2 = l22; 
				}
				else	if(rowno == 4)
				{
					for(int i=position;i<position+l2;i++)
					{
						if(i> 14 && i<20)
						{
						CheckBox c = (CheckBox) gridView.findViewById(i);
			              c.setChecked(true);
			              arrayList.add(c.getId()+"");
			              l22 = l22-1;
			              Log.e("TAG AFTER SELCTION NEED ", l22+"  More check boxes to check");
			              if(l22 > 0)
			              {
			              status = true;
			              }
//			              else
//			              {
//			            	  status = false;
//			              }
						}
						else
						{
							CheckBox c = (CheckBox) gridView.findViewById(i);
				              c.setChecked(false); 	
						} 
					}
					
					if(!status)
					{
					for(int i=position+l2;i<50;i++)
					{
						CheckBox c = (CheckBox) gridView.findViewById(i);
			              c.setChecked(false);  
						
					}
					for(int i=0;i<15;i++)
					{
						CheckBox c = (CheckBox) gridView.findViewById(i);
			              c.setChecked(false);  
						
					}
					}
					l2 = l22; 
				}
				
				
				else	if(rowno == 5)
				{
					for(int i=position;i<position+l2;i++)
					{
						if(i >19 && i<25)
						{
						CheckBox c = (CheckBox) gridView.findViewById(i);
			              c.setChecked(true);  
			              arrayList.add(c.getId()+"");
			              l22 = l22-1;
			              Log.e("TAG AFTER SELCTION NEED ", l22+"  More check boxes to check");
			              if(l22 > 0)
			              {
			              status = true;
			              }
//			              else
//			              {
//			            	  status = false;
//			              }
						}
						else
						{
							CheckBox c = (CheckBox) gridView.findViewById(i);
				              c.setChecked(false); 	
						} 
						
					}
					
					if(!status)
					{
					for(int i=position+l2;i<50;i++)
					{
						CheckBox c = (CheckBox) gridView.findViewById(i);
			              c.setChecked(false);  
						
					}
					for(int i=0;i<20;i++)
					{
						CheckBox c = (CheckBox) gridView.findViewById(i);
			              c.setChecked(false);  
						
					}
					}
					l2 = l22; 
				}
				
					
				
				
				
				else	if(rowno == 6)
				{
					for(int i=position;i<position+l2;i++)
					{
						if(i>24 && i<30)
						{
						CheckBox c = (CheckBox) gridView.findViewById(i);
			              c.setChecked(true); 
			              arrayList.add(c.getId()+"");
			              l22 = l22-1;
			              Log.e("TAG AFTER SELCTION NEED ", l22+"  More check boxes to check");
			              if(l22 > 0)
			              {
			              status = true;
			              }
//			              else
//			              {
//			            	  status = false;
//			              }
						}
						else
						{
							CheckBox c = (CheckBox) gridView.findViewById(i);
				              c.setChecked(false); 	
						} 
					}
					
					if(!status)
					{
						for(int i=0;i<25;i++)
						{
							CheckBox c = (CheckBox) gridView.findViewById(i);
				              c.setChecked(false);  
							
						}
					for(int i=position+l2;i<50;i++)
					{
						CheckBox c = (CheckBox) gridView.findViewById(i);
			              c.setChecked(false);  
						
					}
					}
					l2 = l22; 
				}
				
				
				else	if(rowno == 7)
				{
					
					for(int i=position;i<position+l2;i++)
					{
						if(i>29 && i <35)
						{
						CheckBox c = (CheckBox) gridView.findViewById(i);
			              c.setChecked(true);  
			              arrayList.add(c.getId()+"");
			              l22 = l22-1;
			              Log.e("TAG AFTER SELCTION NEED ", l22+"  More check boxes to check");
			              if(l22 > 0)
			              {
			              status = true;
			              }
//			              else
//			              {
//			            	  status = false;
//			              }
						}
						else
						{
							CheckBox c = (CheckBox) gridView.findViewById(i);
				              c.setChecked(false); 	
						} 
					}
					
					if(!status)
					{
					for(int i=position+l2;i<50;i++)
					{
						CheckBox c = (CheckBox) gridView.findViewById(i);
			              c.setChecked(false);  
						
					}
					for(int i=0;i<30;i++)
					{
						CheckBox c = (CheckBox) gridView.findViewById(i);
			              c.setChecked(false);  
						
					}
					}
					l2 = l22; 
				}
				
				else	if(rowno == 8)
				{
					for(int i=position;i<position+l2;i++)
					{
						if(i> 34 && i<40)
						{
						CheckBox c = (CheckBox) gridView.findViewById(i);
			              c.setChecked(true); 
			              arrayList.add(c.getId()+"");
			              l22 = l22-1;
			              Log.e("TAG AFTER SELCTION NEED ", l22+"  More check boxes to check");
			              if(l22 > 0)
			              {
			              status = true;
			              }
//			              else
//			              {
//			            	  status = false;
//			              }
						}
						else
						{
							CheckBox c = (CheckBox) gridView.findViewById(i);
				              c.setChecked(false); 	
						} 
					}
					
					if(!status)
					{
					for(int i=position+l2;i<50;i++)
					{
						CheckBox c = (CheckBox) gridView.findViewById(i);
			              c.setChecked(false);  
						
					}
					for(int i=0;i<35;i++)
					{
						CheckBox c = (CheckBox) gridView.findViewById(i);
			              c.setChecked(false);  
						
					}
					}
					l2 = l22; 
				}
				
				
				else	if(rowno == 9)
				{
					for(int i=position;i<position+l2;i++)
					{
						if(i>39 && i<45)
						{
						CheckBox c = (CheckBox) gridView.findViewById(i);
			              c.setChecked(true);  
			              arrayList.add(c.getId()+"");
			              l22 = l22-1;
			              Log.e("TAG AFTER SELCTION NEED ", l22+"  More check boxes to check");
			              if(l22 > 0)
			              {
			              status = true;
			              }
//			              else
//			              {
//			            	  status = false;
//			              }
						}
						else
						{
							CheckBox c = (CheckBox) gridView.findViewById(i);
				              c.setChecked(false); 	
						} 
						
					}
					
					if(!status)
					{
						for(int i=0;i<40;i++)
						{
							CheckBox c = (CheckBox) gridView.findViewById(i);
				              c.setChecked(false);  
							
						}
					for(int i=position+l2;i<50;i++)
					{
						CheckBox c = (CheckBox) gridView.findViewById(i);
			              c.setChecked(false);  
						
					}
					}
					l2 = l22; 
				}
				
				else	if(rowno == 10)
				{
					for(int i=position;i<position+l2;i++)
					{
						if(i>44 && i<50)
						{
						CheckBox c = (CheckBox) gridView.findViewById(i);
			              c.setChecked(true);  
			              arrayList.add(c.getId()+"");
			              l22 = l22-1;
			              Log.e("TAG AFTER SELCTION NEED ", l22+"  More check boxes to check");
			              if(l22 > 0)
			              {
			              status = true;
			              }
//			              else
//			              {
//			            	  status = false;
//			              }
						}

					}
					if(!status)
					{
					for(int i=0;i<45;i++)
					{
						CheckBox c = (CheckBox) gridView.findViewById(i);
			              c.setChecked(false);  
						
					}
					}
					l2 = l22; 
				}  
				
			
				}
		});
		return rowview;  
	}
	

	}
}
