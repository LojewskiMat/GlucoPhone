package com.example.gosia.glucophone;

/**
 * Created by Gosia on 20.10.2017.
 */

import android.app.Activity;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.Toast;


import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.DataPointInterface;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.OnDataPointTapListener;
import com.jjoe64.graphview.series.Series;

import java.util.List;

/**
 * Created by malgosia on 09.04.17.
 */
public class Wykres extends Activity{

    LineGraphSeries<DataPoint> series;
    private DodajPomiar number;

    LineGraphSeries<DataPoint> series2;
    private DodajPomiar number2;

    LineGraphSeries<DataPoint> series3;
    LineGraphSeries<DataPoint> series4;


    //zmiana 2


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wykresy);

        number = new DodajPomiar();
        List<Double> list = number.getList();

        number2 = new DodajPomiar();
        List<Double> list2 = number2.getList();

        List<DodajPytanie> quesList;
        List<DodajPytanie> quesList2;



        DBHelper db = new DBHelper(this);
        quesList = db.getAllQuestions();

        DBHelper2 db2 = new DBHelper2(this);
        quesList2 = db2.getAllQuestions();


        double y,x, y2, x2;
        x=0;
        y=0;
        x2=0;
        y2=0;
        double poziom1=126;
        double poziom2 =140;

        GraphView graph = (GraphView) findViewById(R.id.graph);
        series = new LineGraphSeries<DataPoint>();
        series.setTitle("Wynik przed posiłkiem");

        series2 = new LineGraphSeries<DataPoint>();
        series2.setTitle("Wynik po posiłku");

        series3 = new LineGraphSeries<DataPoint>();
      series3.setTitle("Norma przed posiłkiem");

        series4 = new LineGraphSeries<DataPoint>();
      series4.setTitle("Norma po posiłku");

      /*  Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);
        paint.setColor(Color.RED);
        paint.setPathEffect(new DashPathEffect(new float[]{1, 1}, 5));
        series3.setCustomPaint(paint);
        series4.setCustomPaint(paint);*/




        for (int i =0; i<quesList.size(); i++){
            x += 1;

            String wynikStr = quesList.get(i).getANSWER2();
            double wynikDbl = Double.parseDouble(wynikStr);

            String dzienStr = quesList.get(i).getQUESTION();


            String godzinaStr = quesList.get(i).getANSWER();


            String osCzasu = String.valueOf(new StringBuilder().append(dzienStr).append(godzinaStr));
            double osDbl = Double.parseDouble(osCzasu);

            //
            // x=osDbl;


            y = wynikDbl;

            series.appendData(new DataPoint(x,y), true, quesList.size());

            series3.appendData(new DataPoint(x,poziom1), true, quesList.size());



        }
        graph.addSeries(series);
        graph.addSeries(series3);
        series3.setColor(Color.RED);



        for (int i =0; i<quesList2.size(); i++){
            x2 += 1;

            String wynikStr2 = quesList2.get(i).getANSWER2();
            double wynikDbl2 = Double.parseDouble(wynikStr2);

            String dzienStr2 = quesList2.get(i).getQUESTION();
            //double dzienDbl = Double.parseDouble(dzienStr);

            String godzinaStr2 = quesList2.get(i).getANSWER();
            //double godzinaDbl = Double.parseDouble(godzinaStr);

            String osCzasu2 = String.valueOf(new StringBuilder().append(dzienStr2).append(godzinaStr2));
            double osDbl2 = Double.parseDouble(osCzasu2);

            //
            // x=osDbl;


            y2 = wynikDbl2;
            series2.appendData(new DataPoint(x2,y2), true, quesList2.size());

            series4.appendData(new DataPoint(x2,poziom2), true, quesList2.size());



        }
        graph.addSeries(series2);
        series2.setColor(Color.rgb(92, 126, 0));

        graph.addSeries(series4);
       series4.setColor(Color.CYAN);

        series.setOnDataPointTapListener(new OnDataPointTapListener() {
            @Override
            public void onTap(Series series, DataPointInterface dataPointInterface) {
                Toast.makeText(Wykres.this, "Wartość: " + dataPointInterface, Toast.LENGTH_SHORT).show();

            }
        });

        series.setDrawDataPoints(true);
        series.setDataPointsRadius(10);



        series2.setOnDataPointTapListener(new OnDataPointTapListener() {
            @Override
            public void onTap(Series series, DataPointInterface dataPointInterface) {
                Toast.makeText(Wykres.this, "Wartość: " + dataPointInterface, Toast.LENGTH_SHORT).show();

            }
        });



        series2.setDrawDataPoints(true);
        series2.setDataPointsRadius(10);




        graph.getViewport().setScalable(true);
        graph.getViewport().setScalableY(true);

        graph.setTitle("Twoje wyniki" + "Jan Kowalski"); //zmiana imienia wg logowania?.... 
        graph.getLegendRenderer().setVisible(true);
        graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);




    }
}
