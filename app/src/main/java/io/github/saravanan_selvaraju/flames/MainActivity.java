package io.github.saravanan_selvaraju.flames;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText name,crush;
    TextView result;
    Button sumit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText)findViewById(R.id.name);
        crush=(EditText)findViewById(R.id.crush);
        result=(TextView)findViewById(R.id.result);
        sumit=(Button)findViewById(R.id.show);
        getWindow().setBackgroundDrawableResource(R.drawable.red);
        sumit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    flames();

            }
        });
    }
    void flames()
    {
        char nam[],cru[];
        nam=name.getText().toString().trim().toCharArray();
        cru=crush.getText().toString().trim().toCharArray();
        int naml=nam.length;
        int crul=cru.length,temp;
        String flames="flames",restr="";
        for(int i=0;i<naml;i++)
        {
            for(int j=0;j<crul;j++)
            {
                if(nam[i]==cru[j])
                {
                    nam[i]='*';
                    cru[j]='*';
                }
            }
        }
        String tem;
        int res=len(nam)+len(cru);
        if(res>0)
        {

            while(flames.length()!=1)
            {
                temp=res%flames.length();
                if(temp==0)
                {
                    tem=flames.substring(0,flames.length()-1);

                }else
                {
                    tem=flames.substring(temp)+flames.substring(0,temp-1);
                }
                flames=tem;
            }
        }
        switch(flames.charAt(0))
        {
            case 'f':restr="Friends\n👬";break;
            case 'l':restr="Love\n💘";break;
            case 'a':restr="Affection\n\uD83D\uDE0D";break;
            case 'm':restr="Marriage\n\uD83D\uDC91";break;
            case 'e':restr="Enemy\n\uD83D\uDE08";break;
            case 's':restr="Sister\n👧";break;

        }
        if(name.getText().toString().length()!=0 && crush.getText().toString().length()!=0 ) {
            result.setText(restr + "");
        }else
        {
            result.setText("Please Enter The Names");
        }
    }
    int len(char x[])
    {
        int r=0;
        for(int i=0;i<x.length;i++)
        {
            if(x[i]!='*')
            {
                r++;
            }
        }
        return r;
    }

    public void about(View view) {
        Intent browser=new Intent(Intent.ACTION_VIEW, Uri.parse("http://saravanan-selvaraju.github.io"));
        startActivity(browser);
    }

    public void clear(View view) {
        name.setText("");
        crush.setText("");
        result.setText("");
    }
}

