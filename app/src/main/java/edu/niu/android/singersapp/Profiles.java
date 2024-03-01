/************************************************************************
 *                                                                      *
 *      Class Name: Profiles.java                                       *
 *      Purpose: This class is to have setters and getters methods      *
 *               that sets the values for the age, name, born, height   *
 *               and the hometown information. It also sets an enlarged *
 *               image of the singer. We get the textviews and buttons  *
 *               id from the activity_data.xml and we set it with the   *
 *               singers detail got from the message passed by the      *
 *               getIntent(), which is used to call the constructor with*
 *               for a specific person.                                 *
 ************************************************************************/

package edu.niu.android.singersapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Profiles extends AppCompatActivity {
    private String Name,Role,Born,Height;
    private int Age,Image;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        int j = Integer.parseInt(message);
        setProfile(j);
    }
    public Profiles(){
        super();
    }
    public Profiles(String N,int A,String R,String B,String H,int I){
        this.Name = N;
        this.Age = A;
        this.Role = R;
        this.Born = B;
        this.Height = H;
        this.Image = I;
        setName(N);
        setAge(A);
        setRole(R);
        setBorn(B);
        setHeight(H);
        setImage(I);

    }
    public void setName(String N){
        Name = N;
    }
    public void setAge(int A){
        Age = A;
    }
    public void setRole(String R){
        Role = R;
    }
    public void setBorn(String B){
        Born = B;
    }
    public void setHeight(String H){
        Height = H;
    }
    public void setImage(int I){
        Image = I;
    }

    //getter functions for all the data members
    public String getName()
    {
        return Name;
    }
    public int getAge()
    {
        return Age;
    }
    public String getRole()
    {
        return Role;
    }
    public String getBorn()
    {
        return Born;
    }
    public String getHeight()
    {
        return Height;
    }
    public int getImage()
    {
        return Image;
    }
    public void setProfile(int j) {
        final ImageView imageView = (ImageView) findViewById(R.id.image_view);
        imageView.setImageResource(MainActivity.arr.get(j).getImage());
        final TextView textViewName = (TextView) findViewById(R.id.text_view_name);
        textViewName.setText(MainActivity.arr.get(j).getName());
        final TextView textViewAge = (TextView) findViewById(R.id.text_view_age);
        textViewAge.setText("Age : " +Integer.toString(MainActivity.arr.get(j).getAge()));
        final TextView textViewRole = (TextView) findViewById(R.id.text_view_role);
        textViewRole.setText("Hometown : " + MainActivity.arr.get(j).getRole());
        final TextView textViewBorn = (TextView) findViewById(R.id.text_view_born);
        textViewBorn.setText("Born : " + MainActivity.arr.get(j).getBorn());
        final TextView textViewHeight = (TextView) findViewById(R.id.text_view_height);
        textViewHeight.setText("Height : "+ MainActivity.arr.get(j).getHeight());
    }
    public void exit(){
        this.finish();
    }

}
