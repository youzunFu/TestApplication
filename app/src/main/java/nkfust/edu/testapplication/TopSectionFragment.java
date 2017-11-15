package nkfust.edu.testapplication;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class TopSectionFragment extends Fragment {

    private EditText topEd,bottomEd;

    TopSectionListener activityCommander;

    public interface TopSectionListener {
        public void createMeme(String top,String bottom);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            activityCommander = (TopSectionListener) context;
        }catch (ClassCastException e ){
            throw new ClassCastException(context.toString());
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.top_section_fragment, container,false);
        topEd = (EditText) view.findViewById(R.id.TopTextInput);
        bottomEd = (EditText) view.findViewById(R.id.BottomTextInput);
       final Button DankBtn = (Button) view.findViewById(R.id.fragment_btn);

        DankBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DankBtnClick(view);
            }
        });
        return view;
    }

    void DankBtnClick(View v){


    }
}
