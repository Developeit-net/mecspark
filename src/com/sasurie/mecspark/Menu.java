package com.sasurie.mecspark;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {
    String classes[] = {"MechDashboard","StudentsDatabaseEntry",
    		"MecsparkAlumni","MechanicalNews","MechsigmaFacebook","ExamResults","StudyMaterials","MechanicalSoftwares","PlacementQuestions","AutomobileMagazine","ISME","SasurieInstitution","Members","Features","Description"};
    
    
    @Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
       setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_expandable_list_item_1, classes));
		
	}
	

    @Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		
		getListView().setBackgroundResource(R.drawable.our);
		getListView().setCacheColorHint(android.R.color.transparent);
		String cheese = classes[position];
	try{
	Class ourClass =Class.forName("com.sasurie.mecspark." + cheese);
	Intent ourIntent=new Intent(Menu.this,ourClass);
	startActivity(ourIntent);
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}

    }
}
