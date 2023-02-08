package com.contraction.chartintegration;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    LineChart lineChart;

    LineData lineData1;
    LineData lineData2;

    LineDataSet lineDataSet1;
    LineDataSet lineDataSet2;

    ArrayList lineEntries1;
    ArrayList lineEntries2;

    String[] xDataL = {"Jan", "Feb" , "Mac" , "Apr"};
    String[] months = new String[] {
            " ","Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dec"
    };
     Button btnRoundChart;


    @SuppressLint({"NewApi", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lineChart = findViewById(R.id.lineChart);
        btnRoundChart = findViewById(R.id.btnRoundChart);
        getEntries();
        setGraphChageDesign();
        clickEvent();

        lineChart.getDescription().setEnabled(false);

        lineDataSet1 = new LineDataSet(lineEntries1, "Share Price");
        lineData1 = new LineData(lineDataSet1);
        //for smooth the line chart
        lineDataSet1.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        lineDataSet1.setValueTextColor(getColor(R.color.black));
        lineDataSet1.setValueTextColor(Color.parseColor("#2750A0FF"));
        lineDataSet1.setValueTextSize(10f);
        lineChart.getXAxis().setValueFormatter(new com.github.mikephil.charting.formatter.IndexAxisValueFormatter(months));
        lineDataSet1.setDrawFilled(true);
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.chart_one_bg);
        lineDataSet1.setFillDrawable(drawable);
        lineDataSet1.setCircleColor(Color.parseColor("#489EFB"));
        lineDataSet1.setColor(Color.parseColor("#489EFB"));



        lineDataSet2 = new LineDataSet(lineEntries2, "Share Price2");
        lineData2 = new LineData(lineDataSet2);
        //for smooth the line chart
        lineDataSet2.setMode(LineDataSet.Mode.CUBIC_BEZIER);

        //use for TextIndecator ex 10 and this "#0050A0FF" for tranperent
        lineDataSet2.setValueTextColor(Color.parseColor("#2DF8CB62"));
        lineDataSet2.setValueTextSize(10f);

        lineDataSet2.setDrawFilled(true);
        Drawable drawable2 = ContextCompat.getDrawable(this,R.drawable.chart_two_bg);
        lineDataSet2.setFillDrawable(drawable2);
        lineDataSet2.setCircleColor(Color.parseColor("#F5BC35"));
        lineDataSet2.setColor(Color.parseColor("#F5BC35"));


        /*String[] xAxis = new String[] {"0", "1", "2", "3", "4", "5", "6", "8", "9"};
        ArrayList<LineDataSet> lines = new ArrayList<LineDataSet> ();
        LineDataSet lDataSet1 = new LineDataSet(lineEntries1, "DataSet1");
        lDataSet1.setColor(Color.RED);
        lDataSet1.setCircleColor(Color.RED);
        lines.add(lDataSet1);
        lines.add(new LineDataSet(lineEntries2, "DataSet2"));
        lineChart.setData(new LineData(xAxis, lines));
*/

      /* // YAxis yAxis = lineChart.getYAxis();
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        lineChart.getAxisLeft().setDrawGridLines(false);
        lineChart.getXAxis().setDrawGridLines(false);
        lineChart.getAxisRight().setDrawGridLines(false);
        lineChart.getAxisRight().setEnabled(false);
*/

        lineChart.setData(lineData1);
        lineChart.setData(lineData2);


        List<ILineDataSet> lines = new ArrayList<ILineDataSet>();
        lines.add(lineDataSet1);
        lines.add(lineDataSet2);

        LineData data = new LineData(lines);
        lineChart.setData(data);
        lineChart.invalidate();

        //xAxisChart.setPosition(XAxis.XAxisPosition.BOTTOM);
        //lineChart.getRendererLeftYAxis().getGridClippingRect(xAxis);
    }

    private void clickEvent() {
        btnRoundChart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,RoundChartActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setGraphChageDesign() {
        //for set the XAxis in Bottom
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        //for Remove the Horizontal Grid
        lineChart.getAxisLeft().setDrawGridLines(false);
        // remove the Vertical Grid
        lineChart.getXAxis().setDrawGridLines(false);

        //lineChart.getAxisRight().setDrawGridLines(false);
        //for remove right YAxis Number
        lineChart.getAxisRight().setEnabled(false);


        lineChart.setData(lineData2);
        //lineChart.setData(lineData1);
    }

    private void getEntries() {

        lineEntries1 = new ArrayList<>();
        lineEntries1.add(new Entry(1f,10f));
        lineEntries1.add(new Entry(2f,4f));
        lineEntries1.add(new Entry(3f,3f));
        lineEntries1.add(new Entry(4f,1f));
        lineEntries1.add(new Entry(5f,2f));
        lineEntries1.add(new Entry(6f,10f));
        lineEntries1.add(new Entry(7f,10f));
        lineEntries1.add(new Entry(8f,4f));
        lineEntries1.add(new Entry(9f,3f));
        lineEntries1.add(new Entry(10f,1f));
        lineEntries1.add(new Entry(11f,2f));
        lineEntries1.add(new Entry(12f, 2f));


        lineEntries2 = new ArrayList<>();
        lineEntries2.add(new Entry(1f, 2f));
        lineEntries2.add(new Entry(2f, 1f));
        lineEntries2.add(new Entry(3f, 3f));
        lineEntries2.add(new Entry(4f, 4f));
        lineEntries2.add(new Entry(5f, 10f));
        lineEntries2.add(new Entry(6f, 11f));
        lineEntries2.add(new Entry(7f, 2f));
        lineEntries2.add(new Entry(8f, 1f));
        lineEntries2.add(new Entry(9f, 3f));
        lineEntries2.add(new Entry(10f, 4f));
        lineEntries2.add(new Entry(11f, 10f));
        lineEntries2.add(new Entry(12f, 10f));



    }
}