package kr.ac.yeonsung.seoj.mobile1project_1114_01;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.FitWindowsFrameLayout;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    GridView gridv;
    int[] imgIds = {R.drawable.ageofultron,R.drawable.blackpanther,R.drawable.blackw,
            R.drawable.captainmarble,R.drawable.civilwar,R.drawable.endwar,
            R.drawable.hulk,R.drawable.lagna,R.drawable.nowayhome,R.drawable.strange,
            R.drawable.wacanda,R.drawable.winter,
            R.drawable.ageofultron,R.drawable.blackpanther,R.drawable.blackw,
            R.drawable.captainmarble,R.drawable.civilwar,R.drawable.endwar,
            R.drawable.hulk,R.drawable.lagna,R.drawable.nowayhome,R.drawable.strange,
            R.drawable.wacanda,R.drawable.winter,
            R.drawable.ageofultron,R.drawable.blackpanther,R.drawable.blackw,
            R.drawable.captainmarble,R.drawable.civilwar,R.drawable.endwar,
            R.drawable.hulk,R.drawable.lagna,R.drawable.nowayhome,R.drawable.strange,
            R.drawable.wacanda,R.drawable.winter};
    String[] titles = {"에이지 오브 울트론", "블랙팬서", "블랙위도우", "캡틴 마블", " 시빌 워",
            "엔드 워", "헐크", "라그나로크", "스파이더맨 노웨이홈", "닥터스트레인지", "와칸다 포에버", "윈터 솔져",
            "에이지 오브 울트론", "블랙팬서", "블랙위도우", "캡틴 마블", " 시빌 워",
            "엔드 워", "헐크", "라그나로크", "스파이더맨 노웨이홈", "닥터스트레인지", "와칸다 포에버", "윈터 솔져",
            "에이지 오브 울트론", "블랙팬서", "블랙위도우", "캡틴 마블", " 시빌 워",
            "엔드 워", "헐크", "라그나로크", "스파이더맨 노웨이홈", "닥터스트레인지", "와칸다 포에버", "윈터 솔져"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridv = findViewById(R.id.gridv);
        GridAdapter adapter = new GridAdapter(this);
        gridv.setAdapter(adapter);
    }

    public class GridAdapter extends BaseAdapter{
        Context context;

        public GridAdapter(Context context) {

            this.context = context;
        }
        @Override
        public int getCount() {
            return imgIds.length; //항목의 개수
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ImageView imgv = new ImageView(context);
            imgv.setLayoutParams(new ViewGroup.LayoutParams(220,350));
            imgv.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imgv.setImageResource(imgIds[i]);
            final int index = i; //i값은 항목이 만들어질때마다 증가되므로 유지되는게 아님
            imgv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder dlg = new AlertDialog.Builder(context);
                    dlg.setTitle(titles[index]);
                    dlg.setIcon(R.drawable.movie);
                    View dlgview = View.inflate(context, R.layout.dialog, null);
                    ImageView dlgImgv = dlgview.findViewById(R.id.img_dlg); //반환받기
                    dlgImgv.setImageResource(imgIds[index]);
                    //내가 만약 두번째 인덱스 항목을 선택하면..? 이미지리소스2번이 나타남..?




                    dlg.setView(dlgview);
                    dlg.setNegativeButton("닫기",null);
                    dlg.show();
                }
            });
            return imgv;//항목의 개수만큼 반환 시킴
        }
    }
}