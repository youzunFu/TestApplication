package nkfust.edu.testapplication;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainFragmentActivity extends AppCompatActivity implements TopSectionFragment.TopSectionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fragment);

    }


    //This is called top fragment button to pass message from topfragment_txt
    @Override
    public void createMeme(String top) {
        BottomPictureFragment bottomFragment = (BottomPictureFragment) getSupportFragmentManager().findFragmentById(R.id.fragment2);
        bottomFragment.setMemeText(top);
    }


}
