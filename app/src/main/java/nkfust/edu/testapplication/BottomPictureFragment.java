package nkfust.edu.testapplication;


//import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.v4.app.Fragment;
import org.w3c.dom.Text;

/**
 * Created by RED on 2017/11/15.
 */

public class BottomPictureFragment extends Fragment {
    private TextView toptxt;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate (R.layout.bottom_picture_fragment,container,false);
        toptxt = (TextView) view.findViewById(R.id.fragm_toptxt);
        return view;
    }
    public void setMemeText(String top){
        toptxt.setText(top);
    }
}
