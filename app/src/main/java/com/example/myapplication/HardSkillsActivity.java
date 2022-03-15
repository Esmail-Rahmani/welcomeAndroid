package com.example.myapplication;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Build;
import android.os.Bundle;

import com.google.android.flexbox.FlexboxLayout;
import com.google.android.material.button.MaterialButton;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myapplication.databinding.ActivityHardSkillsBinding;

import model.HardSkills;
import model.SubSkill;

public class HardSkillsActivity extends AppCompatActivity {

    private ActivityHardSkillsBinding binding;

    SubSkill subSkill[] = new SubSkill[3];
    HardSkills hardSkills[] = new HardSkills[2];

    @RequiresApi(api = Build.VERSION_CODES.P)
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHardSkillsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSkills();


        LinearLayout linearLayout = findViewById(R.id.hard_skill_linear_layout);
        for (int i=0 ; i< hardSkills.length;i++){
            LinearLayout LLH= new LinearLayout(this);

            LLH.setOrientation(LinearLayout.HORIZONTAL);
            TextView textView = new TextView(this);
            textView.setText(hardSkills[i].getName());
            textView.setTextSize(16);
            textView.setTextColor(getResources().getColor(R.color.primary_color));
            textView.setPadding(10,10,10,10);

            LLH.addView(textView);
            linearLayout.addView(LLH);
            FlexboxLayout flexboxLayout = new FlexboxLayout(this);
            for(int j=0 ; j< hardSkills[i].getSubSkills().length;j++){
                MaterialButton materialButton = new MaterialButton(this);
                int finalI = i;
                int finalJ = j;
                materialButton.setInsetTop(0);
                materialButton.setInsetBottom(0);
                materialButton.setOnClickListener(new View.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.P)
                    @Override
                    public void onClick(View view) {
                        hardSkills[finalI].getSubSkills()[finalJ].setSelected(!hardSkills[finalI].getSubSkills()[finalJ].isSelected());
                        setButtonColors(finalI, finalJ, materialButton);

                    }
                });
                setButtonColors(i, j, materialButton);
                flexboxLayout.addView(materialButton);
            }

            linearLayout.addView(flexboxLayout);



        }



    }


    @RequiresApi(api = Build.VERSION_CODES.P)
    @SuppressLint("RestrictedApi")
    private void setButtonColors(int i, int j, MaterialButton materialButton) {
        if(hardSkills[i].getSubSkills()[j].isSelected()){
            materialButton.setBackgroundResource(R.drawable.rounded_button);
            materialButton.setSupportBackgroundTintList(ContextCompat.getColorStateList(this, R.color.primary_color));
            materialButton.setPadding(10,10,10,10);
            materialButton.setText(hardSkills[i].getSubSkills()[j].getName());
            materialButton.setTextColor(getResources().getColor(R.color.white));
        }else{
            ShapeDrawable shapedrawable = new ShapeDrawable();
            RectShape r = new RectShape();
            shapedrawable.setShape(new RectShape());
            shapedrawable.getPaint().setColor(getResources().getColor(R.color.primary_color));
            shapedrawable.getPaint().setStrokeWidth(10f);
            shapedrawable.getPaint().setStyle(Paint.Style.STROKE);
            GradientDrawable shape = new GradientDrawable();
            shape.setShape(GradientDrawable.RECTANGLE);
            shape.setCornerRadii(new float[] { 30, 30, 30, 30, 30, 30, 30, 30 });
            shape.setColor(Color.TRANSPARENT);
            shape.setStroke(3, getResources().getColor(R.color.primary_color));
            materialButton.setBackgroundDrawable(shape);
            materialButton.setPadding(10,10,10,10);
            materialButton.setText(hardSkills[i].getSubSkills()[j].getName());
            materialButton.setTextColor(getResources().getColor(R.color.primary_color));
        }
    }

    private void setSkills() {
        subSkill[0] = new SubSkill("Excel",1,true );
        subSkill[1] = new SubSkill("EWINDOW",2,true );
        subSkill[2] = new SubSkill("WORD",3,true );
        hardSkills[0] = new HardSkills();
        hardSkills[1] = new HardSkills();
        hardSkills[0].setId(12);
        hardSkills[0].setName("Basic Skills");
        hardSkills[0].setSubSkills(subSkill);
        hardSkills[1].setId(13);
        hardSkills[1].setName("New  Skills");
        hardSkills[1].setSubSkills(subSkill);
    }
}