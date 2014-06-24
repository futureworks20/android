package com.example.androidextratopics;

import java.util.ArrayList;
import java.util.List;

import com.example.androidextratopics.SeatSelection.CustomAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class NewSeatSelection extends Activity implements OnClickListener{

	private CheckBox[] chk;
	Databasee databasee;
	String[] arr = new String[5];
	Spinner spinner;
	boolean status = false,showprevious=false;
	int l2,l22,l23;
	int rowno;
	ArrayList<String> arrayList = new ArrayList<String>();
	ArrayList<String> arrayList_db = new ArrayList<String>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.searchh);
LinearLayout ll=(LinearLayout)findViewById(R.id.ll);
spinner = (Spinner)findViewById(R.id.spinner);
databasee = new Databasee(NewSeatSelection.this);
List<Variables> list = databasee.getAllContacts();
for(int i=0 ; i<list.size();i++)
{
	 Variables variables = list.get(i);
	 System.out.println(variables.getName());
	 arrayList_db.add(variables.getName());
}

for(int i=0;i<5;i++)
{
	 arr[i]=String.valueOf(i+1);
	 
}
spinner.setAdapter(new ArrayAdapter<String>(getApplicationContext(), R.layout.spinner_text,R.id.text,arr));

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
		
		for(int i=0;i<50;i++)
		{
		chk[i].setChecked(false);	
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
});
 chk=new CheckBox[50];

int ttl=0;
		for(int i=0;i<10;i++)
		{
			
			LinearLayout ll1=new LinearLayout(this);
			
			ll.addView(ll1);
			ll1.getLayoutParams().height=70;
			ll1.getLayoutParams().width=LayoutParams.FILL_PARENT;
			ll1.setWeightSum(5);
			for(int j=0;j<5;j++)
			{
			chk[ttl]=new CheckBox(this);
			chk[ttl].setId(ttl);
			
			
			ll1.addView(chk[ttl]);
			
				chk[ttl].setOnClickListener(this);  
				ttl++;
			}
			
			
			
		}
		
		
		 if(arrayList_db.size() > 0)
		 {
		for(int i =0; i<arrayList_db.size();i++)
		{
			int idd = Integer.parseInt(arrayList_db.get(i));
			//CheckBox c = (CheckBox) findViewById(idd);
            chk[idd].setChecked(true); 
		}
		 }
		
		
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(!status)
		{
		for(int i=0;i<50;i++)
		{
		chk[i].setChecked(false);	
		}
	 l22=l23;
	 l2 = l23;
	 
		status=false;
		}

		
		
		
		  
		chk[v.getId()].setChecked(false);
		
		if(v.getId() ==0 || v.getId() ==1 || v.getId() ==2 || v.getId() ==3 || v.getId() ==4 )
		{
			rowno = 1;
			
		}
		else if(v.getId() ==5 || v.getId() ==6 || v.getId() ==7 || v.getId() ==8 || v.getId() ==9 )
		{
			rowno = 2;
		}
		else if(v.getId() ==10 || v.getId() ==11 || v.getId() ==12 || v.getId() ==13 || v.getId() ==14 )
		{
			rowno = 3;
		}
		else if(v.getId() ==15 || v.getId() ==16 || v.getId() ==17 || v.getId() ==18 || v.getId() ==19 )
		{
			rowno = 4;
		}
		else if(v.getId() ==20 || v.getId() ==21 || v.getId() ==22 || v.getId() ==23 || v.getId() ==24 )
		{
			rowno = 5;
		}
		
		else if(v.getId() ==25 || v.getId() ==26 || v.getId() ==27 || v.getId() ==28 || v.getId() ==29 )		
		{
			rowno = 6;
		}
		else if(v.getId() ==30 || v.getId() ==31 || v.getId() ==32 || v.getId() ==33 || v.getId() ==34 )
		{
			
			rowno = 7;
		}
		else if(v.getId() ==35 || v.getId() ==36 || v.getId() ==37 || v.getId() ==38 || v.getId() ==39 )
		{
			rowno = 8;
		}
		else if(v.getId() ==40 || v.getId() ==41 || v.getId() ==42 || v.getId() ==43 || v.getId() ==44 )
		{
			rowno = 9;
		}
		else if(v.getId() ==45 || v.getId() ==46 || v.getId() ==47 || v.getId() ==48 || v.getId() ==49 )
		{
			rowno = 10;
		}
		
		
		
		
		
		
		
		
		
		
	int	a = v.getId();
		
		int position = a;
		
		if(rowno == 1)
		{
			
			for(int i=a;i<a+l2;i++)
			{
				if(i < 5)
				{
				
				
				chk[i].setChecked(true);  
	              arrayList.add(chk[i].getId()+"");
	              l22 = l22-1;
	              
	              if(l22 > 0)
	              {
	              status = true;
	              showprevious = true;
	              }
	              else
	              {
	            	  status = false;
	              }
				}

			}
			if(!status && !showprevious)
			{
				Log.e("@@@@@@@@@@@@@@", "########");
			for(int i=a+l2;i<40;i++)
			{
				//CheckBox c = (CheckBox) gridView.findViewById(i);
	              chk[i].setChecked(false);  
				
			}
			}
			l2 = l22; 
		}
		else	if(rowno == 2)
		{
			for(int i=v.getId();i<a+l2;i++)
			{
				Log.e("TAG_FFFF", i+"");
				if(i >4 && i<10)
				{
					
				
	              chk[i].setChecked(true); 
	              arrayList.add(chk[i].getId()+"");
	              l22 = l22-1;
	              Log.e("TAG AFTER SELCTION NEED ", l22+"  More check boxes to check");
	              if(l22 > 0)
	              {
	              status = true;
	              showprevious = true;
	              }
	              else
	              {
	            	  status = false;
	              }
				}
				else
				{
					
					chk[i].setChecked(false); 	
				} 
				
			}
		  
			
			if(!status && !showprevious)
			{
				for(int i=0;i<5;i++)
				{
					
					chk[i].setChecked(false);  
					
				}
			for(int i=a+l2;i<50;i++)
			{
				
				chk[i].setChecked(false);  
				
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
				
					chk[i].setChecked(true);  
	              arrayList.add(chk[i].getId()+"");
	              l22 = l22-1;
	              Log.e("TAG AFTER SELCTION NEED ", l22+"  More check boxes to check");
	              if(l22 > 0)
	              {
	              status = true;
	              showprevious = true;
	              }
	              else
	              {
	            	  status = false;
	              }
				}
				
					else
					{
						
						chk[i].setChecked(false); 	
					} 
				
			}
			
			if(!status && !showprevious)
			{
				for(int i=0;i<10;i++)
				{
					
					chk[i].setChecked(false);  
					
				}
			for(int i=position+l2;i<50;i++)
			{
				
				chk[i].setChecked(false);  
				
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
				
					chk[i].setChecked(true);
	              arrayList.add(chk[i].getId()+"");
	              l22 = l22-1;
	              Log.e("TAG AFTER SELCTION NEED ", l22+"  More check boxes to check");
	              if(l22 > 0)
	              {
	              status = true;
	              showprevious = true;
	              }
	              else
	              {
	            	  status = false;
	              }
				}
				else
				{
					
					chk[i].setChecked(false); 	
				} 
			}
			
			if(!status && !showprevious)
			{
			for(int i=position+l2;i<50;i++)
			{
				
				chk[i].setChecked(false);  
				
			}
			for(int i=0;i<15;i++)
			{
				
				chk[i].setChecked(false);  
				
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
				
					chk[i].setChecked(true);  
	              arrayList.add(chk[i].getId()+"");
	              l22 = l22-1;
	              Log.e("TAG AFTER SELCTION NEED ", l22+"  More check boxes to check");
	              if(l22 > 0)
	              {
	              status = true;
	              showprevious = true;
	              }
	              else
	              {
	            	  status = false;
	              }
				}
				else
				{
					
					chk[i].setChecked(false); 	
				} 
				
			}
			
			if(!status && !showprevious)
			{
			for(int i=position+l2;i<50;i++)
			{
				
				chk[i].setChecked(false);  
				
			}
			for(int i=0;i<20;i++)
			{
				
				chk[i].setChecked(false);  
				
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
				
					chk[i].setChecked(true); 
	              arrayList.add(chk[i].getId()+"");
	              l22 = l22-1;
	              Log.e("TAG AFTER SELCTION NEED ", l22+"  More check boxes to check");
	              if(l22 > 0)
	              {
	              status = true;
	              showprevious = true;
	              }
	              else
	              {
	            	  status = false;
	              }
				}
				else
				{
					
					chk[i].setChecked(false); 	
				} 
			}
			
			if(!status && !showprevious)
			{
				for(int i=0;i<25;i++)
				{
					
					chk[i].setChecked(false);  
					
				}
			for(int i=position+l2;i<50;i++)
			{
				
				chk[i].setChecked(false);  
				
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
				
					chk[i].setChecked(true);  
	              arrayList.add(chk[i].getId()+"");
	              l22 = l22-1;
	              Log.e("TAG AFTER SELCTION NEED ", l22+"  More check boxes to check");
	              if(l22 > 0)
	              {
	              status = true;
	              showprevious = true;
	              }
	              else
	              {
	            	  status = false;
	              }
				}
				else
				{
					
					chk[i].setChecked(false); 	
				} 
			}
			
			if(!status && !showprevious)
			{
			for(int i=position+l2;i<50;i++)
			{
				
				chk[i].setChecked(false);  
				
			}
			for(int i=0;i<30;i++)
			{
				chk[i].setChecked(false);  
				
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
					chk[i].setChecked(true); 
	              arrayList.add(chk[i].getId()+"");
	              l22 = l22-1;
	              Log.e("TAG AFTER SELCTION NEED ", l22+"  More check boxes to check");
	              if(l22 > 0)
	              {
	              status = true;
	              showprevious = true;
	              }
	              else
	              {
	            	  status = false;
	              }
				}
				else
				{
					chk[i].setChecked(false); 	
				} 
			}
			
			if(!status && !showprevious)
			{
			for(int i=position+l2;i<50;i++)
			{
				chk[i].setChecked(false);  
				
			}
			for(int i=0;i<35;i++)
			{
				chk[i].setChecked(false);  
				
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
					chk[i].setChecked(true);  
	              arrayList.add(chk[i].getId()+"");
	              l22 = l22-1;
	              Log.e("TAG AFTER SELCTION NEED ", l22+"  More check boxes to check");
	              if(l22 > 0)
	              {
	              status = true;
	              showprevious = true;
	              }
	              else
	              {
	            	  status = false;
	              }
				}
				else
				{
					chk[i].setChecked(false); 	
				} 
				
			}
			
			if(!status && !showprevious)
			{
				for(int i=0;i<40;i++)
				{
					chk[i].setChecked(false);  
					
				}
			for(int i=position+l2;i<50;i++)
			{
				chk[i].setChecked(false);  
				
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
					chk[i].setChecked(true);  
	              arrayList.add(chk[i].getId()+"");
	              l22 = l22-1;
	              Log.e("TAG AFTER SELCTION NEED ", l22+"  More check boxes to check");
	              if(l22 > 0)
	              {
	              status = true;
	              showprevious = true;
	              }
	              else
	              {
	            	  status = false;
	              }
				}

			}
			if(!status && !showprevious)
			{
			for(int i=0;i<45;i++)
			{
				chk[i].setChecked(false);  
				
			}
			}
			l2 = l22; 
		}  
		
		
		
		
		
	}
}