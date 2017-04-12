package com.example.appbar_tablayout.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.appbar_tablayout.R;
import com.example.appbar_tablayout.adapters.AuthorRecyclerAdapter;
import com.example.appbar_tablayout.beans.AuthorInfo;

/**
 * Created by ZZL on 2017/2/22
 * Email:mr_ziliang@163.com
 */

public class AuthorInfoFragment extends Fragment {

    public static AuthorInfoFragment newInstance(){
        AuthorInfoFragment authorInfoFragment=new AuthorInfoFragment();
        return authorInfoFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View  view=inflater.inflate(R.layout.author_fragment,container,false);
        RecyclerView recyclerView= (RecyclerView) view.findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new AuthorRecyclerAdapter(AuthorInfo.createTestData()));
        return view;
    }
}
