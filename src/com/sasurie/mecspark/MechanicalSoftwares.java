package com.sasurie.mecspark;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MechanicalSoftwares extends ListActivity {
    String classes[] = {"AutoCADD","CREO","ANSYS","CATIA","SolidWorks"};
    
    
    @Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
       setListAdapter(new ArrayAdapter<String>(MechanicalSoftwares.this, android.R.layout.simple_expandable_list_item_1, classes));
		
	}
	

    @Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		
		getListView().setBackgroundResource(R.drawable.softwareback);
		getListView().setCacheColorHint(android.R.color.transparent);
		String cheese = classes[position];
	try{
	Class ourClass =Class.forName("com.sasurie.mecspark." + cheese);
	Intent ourIntent=new Intent(MechanicalSoftwares.this,ourClass);
	startActivity(ourIntent);
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}

    }
}
