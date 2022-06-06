package com.example.heremistartup;

import android.annotation.SuppressLint;
import android.icu.util.Calendar;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {

    LinearLayout linear_notif, linear_essential,linear_doctors;
    LoadingDia loadingDia;
    RecyclerView notifrecy;
    NotifAdapter notifAdapter = new NotifAdapter();
    List<modelReminderRes> allrem = new ArrayList<>();
    List<modelTimeRes> timeToday = new ArrayList<>();
    List<modelTimeRes> allTime = new ArrayList<>();
    List<modelReminderRes> allremToday = new ArrayList<>();
    ArrayList<modelLogRes> allData = new ArrayList<>();
    LoadData loadData;
    SwipeRefreshLayout swipeRefreshLayout;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public HomeFragment(LoadingDia loadingDia) {
        this.loadingDia = loadingDia;
    }

    public HomeFragment() {
        // Required empty public constructor

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }


    private void getEssentials() {
        final View essential = getLayoutInflater().inflate(R.layout.layout_essentials, null, false);

        linear_essential.addView(essential );


    }
    private void getEssentials2() {
        final View essential = getLayoutInflater().inflate(R.layout.layout_essentials2, null, false);

        linear_essential.addView(essential );


    }
    private void getEssentials3() {
        final View essential = getLayoutInflater().inflate(R.layout.layout_essentials3, null, false);

        linear_essential.addView(essential );


    }
    private void getDoctors() {
        final View doctors = getLayoutInflater().inflate(R.layout.layout_doctors, null, false);


        linear_doctors.addView(doctors );


    }

//    private int getToday() {
//
//        Calendar calendar = Calendar.getInstance();
//        int day = calendar.get(Calendar.DAY_OF_WEEK);
//        int index = 0;
//
//        switch (day) {
//            case Calendar.MONDAY:
//                index = 3;
//                break;
//            case Calendar.TUESDAY:
//                index = 4;
//                break;
//            case Calendar.WEDNESDAY:
//                index = 5;
//                break;
//            case Calendar.THURSDAY:
//                index = 6;
//                break;
//            case Calendar.FRIDAY:
//                index = 7;
//                break;
//            case Calendar.SATURDAY:
//                index = 8;
//                break;
//            case Calendar.SUNDAY:
//                index = 9;
//                break;
//
//        }
//        return index;
//    }
//    public void getremToday(int day){
//
//        for(int i=0; i<allrem.size();i++){
//            switch (day){
//                case 3:
//                    if (allrem.get(i).isMon())
//                        allremToday.add(allrem.get(i));
//
//                    break;
//                case 4:
//                    if (allrem.get(i).isTue())
//                        allremToday.add(allrem.get(i));
//                    break;
//                case 5:
//                    if (allrem.get(i).isWed())
//                        allremToday.add(allrem.get(i));
//                    break;
//                case 6:
//                    if (allrem.get(i).isThu())
//                        allremToday.add(allrem.get(i));
//                    break;
//                case 7:
//                    if (allrem.get(i).isFri())
//                        allremToday.add(allrem.get(i));
//                    break;
//                case 8:
//                    if (allrem.get(i).isSat())
//                        allremToday.add(allrem.get(i));
//                    break;
//                case 9:
//                    if (allrem.get(i).isSun())
//                        allremToday.add(allrem.get(i));
//                    break;
//
//            }
//        }
//    }
//    public void notiftoday(int rem){
//            timeToday.clear();
//        for (int i = 0; i<LoadData.timeResToday.size();i++){
//            if(LoadData.timeResToday.get(i).getRem_id()==rem){
//                timeToday.add(LoadData.timeResToday.get(i));
//            }
//        }
//
//
//
//    }
//    public void initData(){
//
//        loadData = new LoadData();
//
//        loadData.datainit(notifAdapter);
//        loadData.getTimeforToday(notifAdapter);
//
//        allrem = LoadData.allrems;
//
//
//        getremToday(getToday());
//        System.out.println("ALL rem size "+ allremToday.size());
//
//        for(int i =0; i<allremToday.size();i++){
//            notiftoday(allremToday.get(i).getRem_id());
//            System.out.println(timeToday.size()+" tt");
//            for (int o = 0; o<timeToday.size();o++){
//                modelLogRes log = new modelLogRes();
//                log.setRemID(allremToday.get(i).getRem_id());
//                log.setMedID(allremToday.get(i).getMed_id());
//                log.setDateCreated(LocalDate.now()+"");
//                log.setTime(timeToday.get(o).getTime());
//                log.setDay(LocalDate.now().getDayOfWeek().name());
//                log.setTimeID(allremToday.get(i).getRem_id());
//                log.setMed_name(allremToday.get(i).getMed_name());
//                log.setMed_dose(allremToday.get(i).getDose());
//
//                allData.add(log);
//            }
//        }
//        System.out.println(allData.size()+"size");
//        initializeNotifView();
//    }


    @SuppressLint("NotifyDataSetChanged")
    private void initializeNotifView() {
        notifAdapter = new NotifAdapter(getContext(),LoadData.allData);

        LoadData data = new LoadData(notifAdapter);

        notifrecy.setAdapter(notifAdapter);


        notifAdapter.notifyDataSetChanged();

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View parent = inflater.inflate(R.layout.fragment_home, container, false);
        linear_essential = parent.findViewById(R.id.essentials_list);
        linear_doctors = parent.findViewById(R.id.contact_doctors);
        notifrecy = parent.findViewById(R.id.notification_layout);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        initializeNotifView();
        notifrecy.setLayoutManager(layoutManager);

        swipeRefreshLayout = parent.findViewById(R.id.swipeyyHome);
        //initData();
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onRefresh() {
                notifAdapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        getEssentials();
        getEssentials2();
        getEssentials3();
        getEssentials();
        getEssentials2();
        getDoctors();
        getDoctors();
        getDoctors();
        loadingDia.dismissDialog();

        return parent;
    }


}